/*
Entidad Editorial: La entidad editorial modela las editoriales que publican libros.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author FT
 */
@Entity
public class Editorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String nombre;
    private boolean alta;

    //CONSTR:
    public Editorial() {
    }

    public Editorial(String nombre, boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    public Editorial(int id, String nombre, boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }
    
    //GyS:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editorial)) {
            return false;
        }
        Editorial other = (Editorial) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    //ToString:
    @Override
    public String toString() {
        return "Editorial || Id: " + id + " | Nombre: " + nombre + " | Alta: " + alta;
    }
    
    public void imprimirLindo() {
        System.out.printf("%5d %-20s %-10b\n", id, nombre, alta);
    }
}
