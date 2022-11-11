/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.ControladoraJpa;
import java.util.Scanner;

/**
 *
 * @author FT
 */
public class ServicioMenu {

    //ControladoraJpa controlJpa = new ControladoraJpa();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    int opcion = 20;

    ServicioMenuAutor servMenuAutor = new ServicioMenuAutor();
    ServicioMenuEditorial servMenuEditorial = new ServicioMenuEditorial();
    ServicioMenuLibro servMenuLibro = new ServicioMenuLibro();

    public void menuprincipal() {
        do {
            do {
                System.out.println("\nBIENVENID@ A LA LIBRERÍA:\n\nElija una opción:\n1. Autor\n2. Editorial\n3. Libro\n0. Salir");

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
                    servMenuAutor.menuAutor();
                    break;

                case 2:
                    servMenuEditorial.menuEditorial();
                    break;

                case 3:
                    servMenuLibro.menuLibro();
                    break;
            }
        } while (opcion != 0);
    }
}
