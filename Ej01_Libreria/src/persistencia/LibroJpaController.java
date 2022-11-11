/*
LibroServicio / LibroJpaController:

Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para
administrar libros (consulta, creación, modificación y eliminación).
 */
package persistencia;

import entidades.Libro;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import servicio.exceptions.NonexistentEntityException;

/**
 *
 * @author FT
 */
public class LibroJpaController implements Serializable {

    //CONSTR x defecto:
    public LibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    //CONSTR creado para poder instanciar y llamar a los métodos.-
    public LibroJpaController(){
        emf = Persistence.createEntityManagerFactory("Ej01_LibreriaPU");
    }
    
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

// MÉTODOS C.R.U.D.

    //CREAR:    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void create(Libro libro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //EDITAR:   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void edit(Libro libro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            libro = em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = libro.getIsbn();
                if (findLibro(id) == null) {
                    throw new NonexistentEntityException("The libro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //ELIMNINAR:    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void destroy(Long isbn) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libro;
            try {
                libro = em.getReference(Libro.class, isbn);
                libro.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libro with id " + isbn + " no longer exists.", enfe);
            }
            em.remove(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //ENCONTRAR ENTIDAD: +++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public List<Libro> findLibroEntities() {
        return findLibroEntities(true, -1, -1);
    }

    public List<Libro> findLibroEntities(int maxResults, int firstResult) {
        return findLibroEntities(false, maxResults, firstResult);
    }

    private List<Libro> findLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Libro.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    //ENCONTRAR:    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public Libro findLibro(Long isbn) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, isbn);
        } finally {
            em.close();
        }
    }

    //CONTAR:   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int getLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Libro> rt = cq.from(Libro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    //MÉTODOS AGREGADOS:
    
    //CONSULTAR POR NOMBRE:     ++++++++++++++++++++++++++++++++++++++++++++++++
    public void consutaLibroPorNombre(String titulo) {
        EntityManager em = getEntityManager();
        
        try {
            List<Libro> l = em.createQuery("SELECT a FROM Libro a "
                    + "WHERE a.titulo = :titulo").setParameter("titulo", titulo).getResultList();
            
            for (Libro libroForEach : l) {
                System.out.println(libroForEach);
            }
            
        } catch (Exception e) {
            System.out.println("Nombre no encontrado");
            System.out.println(e);
        }
    }
    
    //CONSULTAR POR AUTOR:      ++++++++++++++++++++++++++++++++++++++++++++++++
     public void consultaLibroPorAutor(String autor) {
         EntityManager em = getEntityManager();
         
        try {
            //List<Libro> libros = em.createQuery("SELECT a FROM Libro a Autor b"
            //  + " JOIN a.autor.nombre, b.nombre  = :autor").setParameter("autor", autor).getResultList();

            List<Libro> libros = em.createQuery("SELECT a FROM Libro a"
                    + " WHERE a.autor.nombre LIKE :autor").setParameter("autor", autor).getResultList();
            
            for (Libro libroForEach : libros) {
                System.out.println(libroForEach.toString());
                System.out.println("");
            }

        } catch (Exception e) {
            System.out.println("Nombre no encontrado");
            System.out.println(e);
        }
    }
}