/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Alumno;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author FT
 */
public class ControladoraPersistencia {

    AlumnoJpaController alumnoJPA = new AlumnoJpaController();

    public void crearAlumno(Alumno alumno) {

        alumnoJPA.create(alumno);

    }

    public void eliminarAlumno(int id) {

        try {
            alumnoJPA.destroy(id);

        } catch (NonexistentEntityException excepcion) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    public void editarAlumno(Alumno alumno) {

        try {
            alumnoJPA.edit(alumno);

        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Alumno traerAlumno(int id) {
        
        return alumnoJPA.findAlumno(id);
    }
    
    public ArrayList<Alumno> traerListaAlumnos() {

        List<Alumno> listita = alumnoJPA.findAlumnoEntities();

        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>(listita);

        return listaAlumnos;
    }
}
