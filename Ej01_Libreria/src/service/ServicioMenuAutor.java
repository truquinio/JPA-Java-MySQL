/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Autor;
import entidades.ControladoraJpa;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FT
 */
public class ServicioMenuAutor {

    ControladoraJpa controlJpa = new ControladoraJpa();

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    int opcion = 20;

    public void menuAutor() {
        do {
            do {
                System.out.println("Ingrese la operacion a realizar:\n1. Crear Autor \n2. Mostrar Autor\n3. Editar Autor\n4. Eliminar Autor\n0. Menú principal");

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
                    System.out.println("Ingrese nombre de autor:");
                    String nombreAutor = leer.next();

                    Autor objetoAutor = new Autor(nombreAutor, true);
                    controlJpa.crearAutor(objetoAutor);
                    break;

                case 2:
                    mostrarListaAutores();
                    
                    System.out.println("Buscar el id del autor:");
                    int id = leer.nextInt();

                    System.out.println(controlJpa.traerAutor(id));
                    break;

                case 3:
                    System.out.println("Editar autor: ");
                    mostrarListaAutores();
                    
                    System.out.println("Seleccione el Id del autor a editar:");
                    int idAutor1 = leer.nextInt();
                    
                    Autor objetoAutorEdit1 = controlJpa.traerAutor(idAutor1);
                    
                    System.out.println("Ingrese el nombre nuevo:");
                    String nombreNuevo = leer.next();
                    
                    objetoAutorEdit1.setNombre(nombreNuevo);
                    controlJpa.editarAutor(objetoAutorEdit1);
                    break;

                case 4:
                    System.out.println("Eliminar un Autor / Primero tenemos que dar de baja");
                    mostrarListaAutores();
                    
                    System.out.println("Seleccione el Id del autor a dar de baja:");
                    int idAutor2 = leer.nextInt();
                    
                    Autor objetoAutorEdit2 = controlJpa.traerAutor(idAutor2);
                    
                    objetoAutorEdit2.setAlta(false);
                    
                    controlJpa.editarAutor(objetoAutorEdit2);
                    controlJpa.eliminarAutor(idAutor2);
                    break;
                    
                case 5:
                    mostrarListaAutores();
                    
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);

    }

    //SubMetodos
    public void mostrarListaAutores() {
        System.out.println("\nLista total de autores: ");
        ArrayList<Autor> listaAutores = controlJpa.traerListaAutores();
        
        System.out.printf("%5s %-20s %-10s\n", "ID","NOMBRE", "ALTA");

        for (Autor listaautoresForEach : listaAutores) {
            listaautoresForEach.imprimirLindo();
        }
        System.out.println("------------------------------------");
    }
}