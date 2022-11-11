/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.ControladoraJpa;
import entidades.Editorial;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FT
 */
public class ServicioMenuEditorial {
    
    ControladoraJpa controlJpa = new ControladoraJpa();

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    int opcion = 20;

    public void menuEditorial() {
        do {
            do {
                System.out.println("Ingrese la operacion a realizar:\n1. Crear Editorial\n2. Mostrar Editorial\n3. Editar Editorial\n4. Eliminar Editorial\n0. Menú principal");

                try {
                    opcion = 20; // se reinicia con una opcion diferente a una valida
                    opcion = Integer.parseInt(leer.next());
                    break;
                } catch (Exception ex) {
                    System.out.println("Error, ingrese un número");
                }

            } while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 0);

            switch (opcion) {

                case 1:
                    System.out.println("Crear una Editorial ingresando nombre:");
                    String nombre = leer.next();
                    
                    Editorial objetoEditorial = new Editorial(nombre, true);
                    controlJpa.crearEditorial(objetoEditorial);
                    break;

                case 2:
                    mostrarListaEditoriales();
                            
                    System.out.println("Ingrese id de la Editorial:");
                    int id = leer.nextInt();
                    
                    System.out.println(controlJpa.traerEditorial(id));
                    break;

                case 3:
                    System.out.println("Editar una Editorial: ");
                    mostrarListaEditoriales();
                    
                    System.out.println("Ingrese Id de la editorial a editar: ");
                    int idEditorial= leer.nextInt();
                    
                    Editorial editorialEdit = controlJpa.traerEditorial(idEditorial);
                    
                    System.out.println("Ingrese el nombre nuevo: ");
                    String nombreNuevo= leer.next();
                    
                    editorialEdit.setNombre(nombreNuevo);
                    controlJpa.editarEditorial(editorialEdit);
                    break;
            }
        } while (opcion != 0);
    }
//Submetodos
     public void mostrarListaEditoriales(){
        System.out.println("La lista total de autores es la siguiente: ");
        ArrayList<Editorial>listaEditoriales = controlJpa.traerListaEditoriales();
        
        System.out.printf("%5s %-20s %-10s\n", "ID","NOMBRE", "ALTA");
        
        for (Editorial listaEdi : listaEditoriales) {
            listaEdi.imprimirLindo();
        }
       System.out.println("------------------------------------");
    }
}