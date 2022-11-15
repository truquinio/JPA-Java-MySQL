/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Cliente;
import entidades.ControladoraJpa;
import entidades.Libro;
import entidades.Prestamo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author FT
 */
public class ServicioMenuPrestamo {

    ControladoraJpa controlJpa = new ControladoraJpa();
    ServicioMenuLibro servMenuLibro = new ServicioMenuLibro();
    ServicioMenuCliente servMenuCliente = new ServicioMenuCliente();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void menuPrestamo() {

        System.out.println("Bienvenodo al sistema de Autor ");
        int opcion = 20;
        do {
            do {
                System.out.println("\nMENÚ PRÉSTAMO:\n\nElija una opción:\n1. Crear Prestamo \n2. Mostrar Prestamo por Id\n3. Editar Prestamo"
                        + "\n4. Dar de baja y/o Eliminar Prestamo\n5. Mostrar lista completa de Prestamos \n6. Finalizar un Prestamo"
                        + "(devolver un libro)\n7. Buscar todos los préstamos de un Cliente. \n0. Volver al menu principal");

                try {
                    opcion = 20; // se reinicia con una opcion diferente a una valida
                    opcion = Integer.parseInt(leer.next());
                    break;
                } catch (Exception ex) {
                    System.out.println("Error, ingrese un número ");
                }

            } while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5
                    && opcion != 6 && opcion != 7 && opcion != 0);

            switch (opcion) {
                case 1:
                    System.out.println("\nCrear préstamo:");
                    Prestamo objetoPrestamo = menuCrearPrestamo();

                    controlJpa.crearPrestamo(objetoPrestamo);
                    int diferencia = (int) ((objetoPrestamo.getFechaDevolucion().getTime() - objetoPrestamo.getFechaPrestamo().getTime()) / 1000 / 60 / 60 / 24);
                    System.out.println("El préstamo ha sido creado exitosamente y tiene una duración de "
                            + diferencia + " dias");

                    break;
                case 2:
                    System.out.println("Ingrese Id de préstamo: ");
                    int id = leer.nextInt();
                    
                    System.out.println(controlJpa.traerPrestamo(id));
                    break;
                    
                case 3:
                    System.out.println("\nEditar préstamo: ");
                    mostrarListaPrestamos();
                    
                    System.out.println("Seleccione Id del préstamo a editar: ");
                    int idPrestamo = leer.nextInt();
                    
                    Prestamo prestamoEdit = controlJpa.traerPrestamo(idPrestamo);
                    menuEditarPrestamo(prestamoEdit);
                    break;
                    
                case 4:
                    System.out.println("\nEliminar préstamo");
                    mostrarListaPrestamos();
                    
                    System.out.println("Seleccione el Id del prestamo: ");
                    int idPrestamo2 = leer.nextInt();
                    
                    Prestamo prestamoEdit2 = controlJpa.traerPrestamo(idPrestamo2);
                    controlJpa.eliminarPrestamo(idPrestamo2);
                    break;
                    
                case 5:
                    mostrarListaPrestamos();
                    break;
                    
                case 6:
                    System.out.println("Finalizar préstamo. ");
                    mostrarListaPrestamos();
                    
                    System.out.println("Ingrese Id de prestamo a finalizar: ");
                    int idFinPrestamo = leer.nextInt();
                    
                    Prestamo prestamoFin = controlJpa.traerPrestamo(idFinPrestamo);
                    prestamoFin.setCliente(null);
                    controlJpa.editarPrestamo(prestamoFin);
                    
                    System.out.println("Desea eliminar completamente el prestamo de la BD? s/n");
                    String respuestaFin = leer.next();
                    
                    if (respuestaFin.equalsIgnoreCase("s")) {
                        controlJpa.eliminarPrestamo(idFinPrestamo);
                    }
                    break;
                    
                case 7:
                    System.out.println("Ingres el nombre del cliente para ver sus prestamos: ");
                    String buscarNombreCliente = leer.next();
                    controlJpa.traerPrestamoPorCliente(buscarNombreCliente);
                    break;
                case 8:

                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);
    }

    //Submetodos
    public void mostrarListaPrestamos() {
        System.out.println("Lista total de autores: ");
        ArrayList<Prestamo> listaprestamos = controlJpa.traerListaPrestamos();
        
        System.out.printf("%-5s %-20s %-20s %-20s %-10s\n", "ID", "FECHA PRESTAMO", "FECHA DEVOLUCION",
                "LIBRO", "CLIENTE");
        
        for (Prestamo listapres : listaprestamos) {
            listapres.imprimirLindo();
        }
        System.out.println("------------------------------------");
    }

    public Prestamo menuCrearPrestamo() {
        System.out.println("Fecha de prestamo fijada a fecha actual:");
        Date fechaPrestamo = new Date();
        int dia2, mes2, anio2;
        
        System.out.println("\nFecha devolución del prestamo:");
        System.out.print("Día: ");
        dia2 = leer.nextInt();
        System.out.print("Mes: ");
        mes2 = leer.nextInt();
        System.out.print("Año: ");
        anio2 = leer.nextInt() - 1900;
        Date fechaDevolucion = (new Date(anio2, mes2 - 1, dia2));
        servMenuLibro.mostrarListaLibros();
        
        System.out.println("\nSeleccione el ISBN del libro que quiere: ");
        long isbnprestamo = leer.nextLong();
        Libro libroPrestado = controlJpa.traerLibro(isbnprestamo);

        //ACA armo la logica para restar un libro y asinarlo a la BD
        libroPrestado.setEjemplaresPrestados(libroPrestado.getEjemplaresPrestados() + 1);
        libroPrestado.setEjemplaresRestantes(libroPrestado.getEjemplaresRestantes() - 1);
        controlJpa.editarLibro(libroPrestado);
        servMenuCliente.mostrarListaClientes();
        
        System.out.println("\nSeleccione el Id de cliente: ");
        int idClientePrestamo = leer.nextInt();
        Cliente clientePrestamo = controlJpa.traerCliente(idClientePrestamo);

        return new Prestamo(fechaPrestamo, fechaDevolucion, libroPrestado, clientePrestamo);
    }

    public void menuEditarPrestamo(Prestamo objetoPrestamo) {
        
        int opcion = 20;
        
        do {
            do {
                System.out.println("\nMENÚ PRÉSTAMO:\n\nElija una opción:\n1. Editar fecha de Prestamo \n2. Editar fecha de Devolucion\n3. Editar libro prestado"
                        + "\n4. Editar Cliente de prestamo \n0. Volver al menu principal");
                try {
                    opcion = 20; // se reinicia con una opcion diferente a una valida
                    opcion = Integer.parseInt(leer.next());
                    break;
                    
                } catch (Exception ex) {
                    System.out.println("Error, ingrese un número ");
                }
            } while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 0);
            switch (opcion) {
                case 1:
                    int dia1,
                     mes1,
                     anio1;
                    System.out.println("\nFecha nuevo de inicio del prestamo: ");
                    System.out.print("Día: ");
                    dia1 = leer.nextInt();
                    System.out.print("Mes: ");
                    mes1 = leer.nextInt();
                    System.out.print("Año: ");
                    anio1 = leer.nextInt() - 1900;
                    objetoPrestamo.setFechaPrestamo(new Date(anio1, mes1 - 1, dia1));
                    controlJpa.editarPrestamo(objetoPrestamo);
                    break;

                case 2:
                    int dia2,mes2,anio2;
                    
                    System.out.println("\nFecha nueva de devolución:");
                    System.out.print("Día: ");
                    dia2 = leer.nextInt();
                    System.out.print("Mes: ");
                    mes2 = leer.nextInt();
                    System.out.print("Año: ");
                    anio2 = leer.nextInt() - 1900;
                    
                    objetoPrestamo.setFechaDevolucion(new Date(anio2, mes2 - 1, dia2));
                    controlJpa.editarPrestamo(objetoPrestamo);
                    break;

                case 3:
                    servMenuLibro.mostrarListaLibros();
                    
                    System.out.println("\nIngrese ISBN de libro a prestar: ");
                    long isbnNuevo = leer.nextInt();
                    
                    Libro nuevoLibroPrestamo = controlJpa.traerLibro(isbnNuevo);
                    objetoPrestamo.setLibro(nuevoLibroPrestamo);
                    
                    controlJpa.editarPrestamo(objetoPrestamo);
                    break;

                case 4:
                    servMenuCliente.mostrarListaClientes();
                    
                    System.out.println("\nIngrese Id de cliente para el préstamo: ");
                    
                    int nuevoIdPrestamo = leer.nextInt();
                    Cliente nuevoClientePrestamo = controlJpa.traerCliente(nuevoIdPrestamo);
                    objetoPrestamo.setCliente(nuevoClientePrestamo);
                    controlJpa.editarPrestamo(objetoPrestamo);
                    break;
                    
                case 0:
                    break;
            }
        } while (opcion != 0);
    }
}
