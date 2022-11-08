/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import persistencia.ControladoraPersistencia;

/**
 *
 * @author FT
 */
public class ControladoraJpa {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

//AUTOR:
    public void crearAutor(Autor autor){
        
        controlPersis.crearAutor(autor);  
    }
    
    public void eliminarAutor(int id){
        
        controlPersis.eliminarAutor(id);
    }
    
    public void editarAutor(Autor autor){
        
        controlPersis.editarAutor(autor);
    }
    
    public Autor traerAutor(int id){

        return controlPersis.traerAutor(id);
    }
    
    public ArrayList<Autor> traerListaAutors(){
        
        return controlPersis.traerListaAutores();        
    }
    

//EDITORIAL:
    public void crearEditorial(Editorial editorial){
        
        controlPersis.crearEditorial(editorial);  
    }
    
    public void eliminarEditorial(int id){
        
        controlPersis.eliminarEditorial(id);
    }
    
    public void editarEditorial(Editorial editorial){
        
        controlPersis.editarEditorial(editorial);
    }
    
    public Editorial traerEditorial(int id){

        return controlPersis.traerEditorial(id);
    }
    
    public ArrayList<Editorial> traerListaEditorials(){
        
        return controlPersis.traerListaEditoriales();        
    }


//LIBRO:
    public void crearLibro(Libro libro){
        
        controlPersis.crearLibro(libro);  
    }
    
    public void eliminarLibro(Long isbn){
        
        controlPersis.eliminarLibro(isbn);
    }
    
    public void editarLibro(Libro libro){
        
        controlPersis.editarLibro(libro);
    }
    
    public Libro traerLibro(Long isbn){

        return controlPersis.traerLibro(isbn);
    }
    
    public ArrayList<Libro> traerListaLibros(){
        
        return controlPersis.traerListaLibros();        
    }
}

