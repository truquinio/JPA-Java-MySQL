/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Alumno;

/**
 *
 * @author FT
 */
public class ControladoraPersistencia {
    
    AlumnoJpaController alumnoJPA = new AlumnoJpaController();

    public void crearAlumno(Alumno alumno) {
        
        alumnoJPA.create(alumno);
        
    }
}