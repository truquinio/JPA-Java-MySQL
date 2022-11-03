/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
}
