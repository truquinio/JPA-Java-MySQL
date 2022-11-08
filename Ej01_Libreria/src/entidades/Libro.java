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
import javax.persistence.OneToOne;

/**
 *
 * @author FT
 */
@Entity
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long isbn;
    
    @Basic
    private String titulo;
    private int anio;
    private int ejemplares;
    private int ejemplaresPrestados;
    private int ejemplaresRestantes;
    private boolean alta;
    
    @OneToOne
    private Autor autor;
    @OneToOne
    private Editorial editorial;
   
    //CONSTR:
    public Libro() {
    }
    public Libro(Long isbn, String titulo, int anio, int ejemplares, int ejemplaresPrestados, int ejemplaresRestantes, boolean alta, Autor autor, Editorial editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }
    
    //GyS:
    public Long getIsbn() {
        return isbn;
    }
    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public int getEjemplares() {
        return ejemplares;
    }
    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }
    public int getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }
    public void setEjemplaresPrestados(int ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }
    public int getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }
    public void setEjemplaresRestantes(int ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }
    public boolean isAlta() {
        return alta;
    }
    public void setAlta(boolean alta) {
        this.alta = alta;
    }
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public Editorial getEditorial() {
        return editorial;
    }
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the isbn fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    //ToString:
    @Override
    public String toString() {
        return "Libro | Isbn: " + isbn + " | Título: " + titulo + " | Año: " + anio + " | Ejemplares: " + ejemplares + " | Ejemplares Prestados: " + ejemplaresPrestados + " | Ejemplares Restantes: " + ejemplaresRestantes + " | Alta: " + alta + " | Autor: " + autor + " | Editorial: " + editorial;
    }
}