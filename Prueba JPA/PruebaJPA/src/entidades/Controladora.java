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
public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearAlumno(Alumno alumno){
        
        controlPersis.crearAlumno(alumno);  
    }
    
    public void eliminarAlumno(int id){
        
        controlPersis.eliminarAlumno(id);
    }
    
    public void editarAlumno(Alumno alumno){
        
        controlPersis.editarAlumno(alumno);
    }
    
    public Alumno traerAlumno(int id){

        return controlPersis.traerAlumno(id);
    }
    
    public ArrayList<Alumno> traerListaAlumnos(){
        
        return controlPersis.traerListaAlumnos();        
    }
}
