/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Cliente;
import entidades.ControladoraJpa;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FT
 */
public class ServicioMenuCliente {
    
ControladoraJpa controlJpa = new ControladoraJpa();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public void menuCliente(){

        int opcion = 20;
        
        do {
            do {
             System.out.println("\nMENÚ CLIENTES:\n\nElija una opción:\n1. Crear Cliente \n2. Mostrar "
                     + "Cliente por Id\n3. Editar Cliente"
                     + "\n4. Eliminar Cliente\n5. Mostrar lista completa de Clientes \n0. Volver al menu principal");
            try {
                opcion = 20; // se reinicia con una opcion diferente a una valida
                opcion=Integer.parseInt(leer.next());
                break;
                }catch(Exception ex) {
                    System.out.println("Error, ingrese un numero ");
            }    
        } while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5 && opcion!=0 );
       
            switch(opcion)
            {
                case 1:    
                    System.out.println("\nCrear cliente:");
                    System.out.println("Ingrese DNI del nuevo cliente: ");
                    long documento = leer.nextLong();
                    
                    System.out.println("Ingrese nombre del nuevo cliente: ");
                    String nombre = leer.next();
                    
                    System.out.println("Ingrese apellido del nuevo cliente: ");
                    String apellido = leer.next();
                    
                    System.out.println("Ingrese teléfono del nuevo cliente: ");
                    String telefono = leer.next();
                    
                    Cliente objetoCliente = new Cliente(documento, nombre, apellido, telefono);
                    controlJpa.crearCliente(objetoCliente);
                    break;
                    
                case 2:
                    mostrarListaClientes();
                    
                    System.out.println("\nIngrese id de cliente:");
                    int id = leer.nextInt();
                    System.out.println(controlJpa.traerCliente(id));
                    break;
                    
                case 3: 
                    System.out.println("\nEditar cliente: ");
                    mostrarListaClientes();
                    
                    System.out.println("Seleccione el Id del cliente a editar: ");
                    int idCliente= leer.nextInt();
                    
                    Cliente clienteEdit = controlJpa.traerCliente(idCliente);
                    menuEditarCliente(clienteEdit);
                break;
                
                case 4:
                    System.out.println("\nEliminar cliente");
                    mostrarListaClientes();
                    System.out.println("Seleccione Id del cliete: ");
                    int idcliente2= leer.nextInt();
                    Cliente clienteEdit2 = controlJpa.traerCliente(idcliente2);
                    controlJpa.eliminarAutor(idcliente2);
                    break;
                    
                case 5:
                    mostrarListaClientes();
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
    
    
    //Submetodos
    
    public void mostrarListaClientes(){
        System.out.println("\nLista total de autores:");
        ArrayList<Cliente>listaClientes = controlJpa.traerListaClientes();
        
        System.out.printf("%-5s%-10s %-10s %-10s %-10s\n", "ID","DOCUMENTO","NOMBRE", "APELLIDO","TELEFONO" );
        
        for (Cliente listaCliente : listaClientes) {
            listaCliente.imprimirLindo();
        }
       System.out.println("------------------");
    }
    
    private void menuEditarCliente(Cliente objetoCliente) {

        int opcion = 20;
        
        do {
            do {
             System.out.println("\nEDICIÓN DE CLIENTES:\n\nElija una opción:\n1. Editar documente \n2. Editar nombre\n3. Editar apellido"
                     + "\n4. Editar telefono \n0. Volver al menu principal");
             
            try {
                opcion = 20; // se reinicia con una opcion diferente a una valida
                opcion=Integer.parseInt(leer.next());
                break;
                
                }catch(Exception ex) {
                    System.out.println("Error, ingrese un numero ");
            }   
        } while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=0 );
        
            switch(opcion)
            {
                case 1:    
                    System.out.println("\nIngrese el DNI nuevo: ");
                    long documentoNuevo = leer.nextLong();
                    objetoCliente.setDocumento(documentoNuevo);
                    controlJpa.editarCliente(objetoCliente);
                    break;
                    
                case 2:  
                    System.out.println("\nIngrese el nuevo nombre del Cliente: ");
                    String nombreNuevo = leer.next();
                    objetoCliente.setNombre(nombreNuevo);
                    controlJpa.editarCliente(objetoCliente);
                break;
                
                case 3: 
                    System.out.println("\nIngrese el nuevo apellido: ");
                    String apellidoNuevo = leer.next();
                    objetoCliente.setApellido(apellidoNuevo);
                    controlJpa.editarCliente(objetoCliente);
                break;
                
                case 4:
                    System.out.println("\nIngrese el nuevo teléfono: ");
                    String telefonoNuevo = leer.next();
                    objetoCliente.setTelefono(telefonoNuevo);
                    controlJpa.editarCliente(objetoCliente);
                    break;
                    
                case 0: 
                    break;
            }
        } while (opcion != 0);
    }
}