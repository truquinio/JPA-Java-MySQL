/*
Main:

Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para
interactuar con el usuario. En esta clase se muestra el menú de opciones con las operaciones
disponibles que podrá realizar el usuario.


El objetivo de este ejercicio es el desarrollo de un sistema de guardado de libros en JAVA
utilizando una base de datos MySQL y JPA como framework de persistencia.

Creación de la Base de Datos MySQL: Lo primero que se debe hacer es crear la base de datos sobre 
el que operará el sistema de reservas de libros. Para ello, se debe abrir el IDE de base de datos 
que se está utilizando (Workbench) y ejecutar la siguiente sentencia:

CREATE DATABASE libreria;

De esta manera se habrá creado una base de datos vacía llamada librería.
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

        /*
        CREO un AUTOR:
        
        Autor objetoAutor = new Autor("Luís Santillán");
        controlJpa.crearAutor(objetoAutor);
        */
        
        /*
        CREO una EDITORIAL:
        
        Editorial objetoEditorial = new Editorial("Santillana");
        controlJpa.crearEditorial(objetoEditorial);
        */
        
        /*
        CREO un LIBRO LIBRO COMPLETO, con AUTOR + EDITORIAL:
        
        Libro objetoLibro = new Libro(Long.MIN_VALUE, "El libro de Santillán", 1995, 500, 300, 200, true, objetoAutor, objetoEditorial);
        controlJpa.crearLibro(objetoLibro);
        */
        
        /*
        ELIMINO de la tabla, el LIBRO con el isbn que tiene el VALOR MÍNIMO LONG:
        
        controlJpa.eliminarLibro(Long.MIN_VALUE);
        */
        
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        /*
        CREO otro LIBRO COMPLETO (isbn = manualmente), con AUTOR + EDITORIAL:
        
        Autor objetoAutor2 = new Autor("Pelado Chiquito");
        controlJpa.crearAutor(objetoAutor2);
        
        Editorial objetoEditorial2 = new Editorial("Inti");
        controlJpa.crearEditorial(objetoEditorial2);
        
        Libro objetoLibro2 = new Libro(456L, "El chiquito de Fernando", 2020, 10, 2, 8, true, objetoAutor2, objetoEditorial2);
        controlJpa.crearLibro(objetoLibro2);
        */
    }
}
