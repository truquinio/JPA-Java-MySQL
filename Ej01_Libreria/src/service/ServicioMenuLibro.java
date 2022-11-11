/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Autor;
import entidades.ControladoraJpa;
import entidades.Editorial;
import entidades.Libro;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FT
 */
public class ServicioMenuLibro {

    ControladoraJpa controlJpa = new ControladoraJpa();

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    ServicioMenuAutor servMenuAutor = new ServicioMenuAutor();
    ServicioMenuEditorial servMenuEditorial = new ServicioMenuEditorial();

    int opcion = 20;

    public void menuLibro() {
        do {
            do {
                System.out.println("\nElija una opción:\n1. Crear libro \n2. Mostrar libro\n3. Editar libro\n4. Eliminar libro\n0. Menú principal");

                try {
                    opcion = 20; // se reinicia con una opcion diferente a una valida
                    opcion = Integer.parseInt(leer.next());
                    break;
                } catch (Exception ex) {
                    System.out.println("Error, ingrese un numero ");
                }

            } while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 0);

            switch (opcion) {

                case 1:
                    System.out.println("\nCrear Libro:");
                    
                    Libro objetoLibro1 = crearLibroMenu();
                    
                    controlJpa.crearLibro(objetoLibro1);
                    
                    mostrarListaLibros();
                    break;

                case 2:
                    mostrarListaLibros();
                    
                    System.out.println("Ingrese ISBN del libro:");
                    long isbn = leer.nextLong();
                    
                    System.out.println(controlJpa.traerLibro(isbn));
                    break;

                case 3:
                    System.out.println("\nEditar libro:\n");
                    
                    mostrarListaLibros();
                    
                    System.out.println("\nIngrese el ISBN del libro a editar: ");
                    long isbn2 = leer.nextLong();
                    
                    Libro libroEdit = controlJpa.traerLibro(isbn2);
                    
                    menuEditarLibro(libroEdit);
                    break;

                case 4:
                    System.out.println("\nEliminar un Libro / Primero tenemos que dar de baja\n");
                    
                    mostrarListaLibros();
                    
                    System.out.println("\nIngrese ISBN del LIBRO a dar de baja:");
                    long isbnLibro = leer.nextInt();
                    
                    Libro libroEdit2 = controlJpa.traerLibro(isbnLibro);
                    libroEdit2.setAlta(false);
                    
                    controlJpa.editarLibro(libroEdit2);
                    controlJpa.eliminarLibro(isbnLibro);
                    break;
                
                case 5:
                    mostrarListaLibros();
                    break;

                case 6:
                    System.out.println("\nMostrar libro por título / Ingrese nombre del libro:");
                    String buscarPorNombre = leer.next();
                    
                    controlJpa.traerLibroPorTitulo(buscarPorNombre);
                    break;
                
                case 7:
                    System.out.println("Mostrar libros por nombre de autor: ");
                    break;
                
                case 8:
                    System.out.println("Mostrar libros por editorial");
                    break;
                
                case 0:
                    break;
            }
        } while (opcion != 0);
    }
        
    //CREAR LIBRO:  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public Libro crearLibroMenu() {
        System.out.println("Ingrese ISBN: ");
        long isbn = leer.nextLong();

        System.out.println("Ingrese nombre del libro:");
        String nombre = leer.next();

        System.out.println("Ingrese el año de publicación del libro:");
        int anio = leer.nextInt();

        System.out.println("Ingrese el total de ejemplares:");
        int ejemplaresTotal = leer.nextInt();

        System.out.println("Ingrese el total de ejemplares prestados:");
        int ejemplaresPrestados = leer.nextInt();

        int ejemplaresRestantes = (ejemplaresTotal - ejemplaresPrestados);
        
        servMenuAutor.mostrarListaAutores();
        
        System.out.println("\nSeleccione Id del autor:");
        int idAutor= leer.nextInt();
        
        Autor autorlibro = controlJpa.traerAutor(idAutor);
        
        servMenuEditorial.mostrarListaEditoriales();
        
        System.out.println("\nSeleccione el Id de la editorial del libro: ");
        int idEditorial= leer.nextInt();
        
        Editorial editorialLibro = controlJpa.traerEditorial(idEditorial);
        
        return  new Libro(isbn, nombre, anio, ejemplaresTotal, ejemplaresPrestados, ejemplaresRestantes, true, autorlibro, editorialLibro);
    }
    
    
    public void mostrarListaLibros(){
        System.out.println("\nLista total de Libros: ");
        ArrayList<Libro>listalibros = controlJpa.traerListaLibros();
        
        System.out.printf("%-5s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-10s\n", "ISBN","NOMBRE", "AÑO","TOTAL","PRESTADOS","RESTANTES","ALTA","AUTOR","EDITORIAL");
        
        for (Libro aux : listalibros) {
            aux.imprimirLindo();
        }
       System.out.println("------------------------------------");
    }

    private void menuEditarLibro(Libro libro) {
        System.out.println("\nEditar libro:");
        int opcion = 20;
        do {
            do {
             System.out.println("Elija una opción:\n1. Editar nombre \n2. Editar año\n3. Editar ejempleres totales"
                     + "\n4. editar ejempleres prestados\n5. Editar Autor\n6. Editar Editorial \n0. Volver al menu principal");
             
            try {
                opcion = 20; // se reinicia con una opcion diferente a una valida
                opcion=Integer.parseInt(leer.next());
                break;
                }catch(Exception ex) {
                    System.out.println("Error, ingrese un numero ");
            }
            
            
        } while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5 && opcion!=6 && opcion!=0 );
        
       
            switch(opcion)
            {
                case 1:    
                    System.out.println("Ingrese titulo nuevo:");
                    String nombreNuevo = leer.next();
                    
                    libro.setTitulo(nombreNuevo);
                    
                    controlJpa.editarLibro(libro);
                    break;
                    
                case 2:  
                    System.out.println("Ingrese nuevo año:");
                    int anioNuevo = leer.nextInt();
                    
                    libro.setAnio(anioNuevo);
                    
                    controlJpa.editarLibro(libro);
                break;
                
                case 3: 
                    System.out.println("Ingrese nueva cantidad de ejemplares:");
                    int ejempleresTotalesNuevos = leer.nextInt();
                    
                    libro.setEjemplares(ejempleresTotalesNuevos);
                    
                    controlJpa.editarLibro(libro);
                break;
                
                case 4:
                    System.out.println("Ingrese nueva cantidad de ejemplares prestados:");
                    int ejemplaresPrestadosNuevos = leer.nextInt();
                    
                    libro.setEjemplares(ejemplaresPrestadosNuevos);
                    
                    controlJpa.editarLibro(libro);
                    break;
                    
                case 5:
                    servMenuAutor.mostrarListaAutores();
                    System.out.println("\nSeleccione Id del nuevo autor del libro:");
                    int idAutor= leer.nextInt();
                    
                    Autor autorlibro = controlJpa.traerAutor(idAutor);
                    libro.setAutor(autorlibro);
                    
                    controlJpa.editarLibro(libro);
                    break;
                    
                case 6:
                    servMenuEditorial.mostrarListaEditoriales();
                    System.out.println("Seleccione el Id de la nueva editorial:");
                    int idEditorial= leer.nextInt();
                    
                    Editorial editorialLibro = controlJpa.traerEditorial(idEditorial);
                    
                    libro.setEditorial(editorialLibro);
                    controlJpa.editarEditorial(editorialLibro);
                    break;
                    
                case 0: 
                    break;
            }
        } while (opcion != 0);
    }
}