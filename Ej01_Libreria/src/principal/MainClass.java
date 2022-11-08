/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import entidades.Autor;
import entidades.ControladoraJpa;
import entidades.Editorial;
import entidades.Libro;
import persistencia.ControladoraPersistencia;

/**
 *
 * @author FT
 */
public class MainClass {

    public static void main(String[] args) {

        //ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        ControladoraJpa controlJpa = new ControladoraJpa();

        /*//AUTOR:
        Autor objetoAutor1 = new Autor("Luís Santillán");
        controlJpa.crearAutor(objetoAutor1);
        
        //EDITORIAL:
        Editorial objetoEditorial1 = new Editorial("Santillana");
        controlJpa.crearEditorial(objetoEditorial1);*/

        //LIBRO:
        /*Libro objetoLibro1 = new Libro(Long.MIN_VALUE, "El libro de Santillán", 1995, 500, 300, 200, true, objetoAutor1, objetoEditorial1);
        controlJpa.crearLibro(objetoLibro1);*/
        
        /*Autor objetoAutor2 = new Autor("Pelado Chiquito");
        controlJpa.crearAutor(objetoAutor2);
        
        Editorial objetoEditorial2 = new Editorial("Inti");
        controlJpa.crearEditorial(objetoEditorial2);
        
        Libro objetoLibro2 = new Libro(456L, "El chiquito de Fernando", 2020, 10, 2, 8, true, objetoAutor2, objetoEditorial2);
        controlJpa.crearLibro(objetoLibro2);*/
        
        controlJpa.eliminarLibro(Long.MIN_VALUE);
    }
}
