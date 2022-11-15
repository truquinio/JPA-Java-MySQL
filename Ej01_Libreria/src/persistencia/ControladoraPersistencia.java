/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Autor;
import entidades.Cliente;
import entidades.Editorial;
import entidades.Libro;
import entidades.Prestamo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.exceptions.NonexistentEntityException;

/**
 *
 * @author FT
 */
public class ControladoraPersistencia {

    AutorJpaController autorJpa = new AutorJpaController();
    EditorialJpaController editorialJpa = new EditorialJpaController();
    LibroJpaController libroJpa = new LibroJpaController();
    PrestamoJpaController prestamoJpa = new PrestamoJpaController();
    ClienteJpaController clienteJpa = new ClienteJpaController();

    //AUTOR ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void crearAutor(Autor autor) {
        autorJpa.create(autor);
    }

    public void eliminarAutor(int id) {

        try {
            autorJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarAutor(Autor autor) {

        try {
            autorJpa.edit(autor);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Autor traerAutor(int id) {

        return autorJpa.findAutor(id);
    }

    public ArrayList<Autor> traerListaAutores() {
        List<Autor> listitaAutores = autorJpa.findAutorEntities();

        ArrayList<Autor> listaAutores = new ArrayList<Autor>(listitaAutores);

        return listaAutores;
    }

    //EDITORIAL ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void crearEditorial(Editorial editorial) {

        editorialJpa.create(editorial);

    }

    public void eliminarEditorial(int id) {

        try {
            editorialJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editarEditorial(Editorial editorial) {

        try {
            editorialJpa.edit(editorial);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Editorial traerEditorial(int id) {

        return editorialJpa.findEditorial(id);
    }

    public ArrayList<Editorial> traerListaEditoriales() {

        List<Editorial> listitaEditoriales = editorialJpa.findEditorialEntities();

        ArrayList<Editorial> listaEditoriales = new ArrayList<Editorial>(listitaEditoriales);

        return listaEditoriales;
    }

    //LIBRO ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void crearLibro(Libro libro) {

        libroJpa.create(libro);

    }

    public void eliminarLibro(Long isbn) {

        try {
            libroJpa.destroy(isbn);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarLibro(Libro libro) {

        try {
            libroJpa.edit(libro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Libro traerLibro(Long isbn) {

        return libroJpa.findLibro(isbn);
    }

    public ArrayList<Libro> traerListaLibros() {

        List<Libro> listitaLibros = libroJpa.findLibroEntities();

        ArrayList<Libro> listaLibros = new ArrayList<Libro>(listitaLibros);

        return listaLibros;
    }

    public void traerLibroPorTitulo(String titulo) {

        libroJpa.consutaLibroPorNombre(titulo);
    }

    //PRÉSTAMO +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void crearPrestamo(Prestamo prestamo) {
        prestamoJpa.create(prestamo);
    }

    public void eliminarPrestamo(int id) {
        try {
            prestamoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarPrestamo(Prestamo prestamo) {
        try {
            prestamoJpa.edit(prestamo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Prestamo traerPrestamo(int id) {
        return prestamoJpa.findPrestamo(id);
    }

    public ArrayList<Prestamo> traerListaPrestamos() {
        List<Prestamo> listap = prestamoJpa.findPrestamoEntities();
        ArrayList<Prestamo> listaPrestamo = new ArrayList<>(listap);
        return listaPrestamo;
    }
    
     public void traerPrestamoPorCliente(String cliente) {
        prestamoJpa.consultaPrestamoPorCliente(cliente);
    }
    
    //CLIENTE ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void crearCliente(Cliente cliente) {
        clienteJpa.create(cliente);
    }

    public void eliminarCliente(int id) {
        try {
            clienteJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarCliente(Cliente cliente) {
        try {
            clienteJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente traerCliente(int id) {
        return clienteJpa.findCliente(id);
    }

    public ArrayList<Cliente> traerListaClientes() {
        List<Cliente> lista = clienteJpa.findClienteEntities();
        ArrayList<Cliente> listaClientes = new ArrayList<>(lista);
        return listaClientes;
    }   
}