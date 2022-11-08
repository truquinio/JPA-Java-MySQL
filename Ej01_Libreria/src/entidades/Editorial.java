/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    //CONSTR:
    public Editorial() {
    }

    public Editorial(String nombre) {
        this.nombre = nombre;
    }
    public Editorial(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //GyS:
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
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
        return "Editorial | id: " + id + " | Nombre: " + nombre;
    }
}