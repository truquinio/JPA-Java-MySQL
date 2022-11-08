/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import entidades.Alumno;
import entidades.Controladora;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author FT
 */
public class MainClass {

    public static void main(String[] args) {

        Controladora control = new Controladora();

        //    Alumno objetoAlumno1 = new Alumno(15, "Lalo", "Landa", new Date());
        //    Alumno objetoAlumno2 = new Alumno(30, "Luisina", "Asadadas", new Date());
        //    Alumno objetoAlumno3 = new Alumno("AAA", "BBB", new Date());
        //    Alumno objetoAlumno4 = new Alumno("CCC", "DDD", new Date());
        //    control.crearAlumno(objetoAlumno3);
        //    control.crearAlumno(objetoAlumno4);
        
        /*
        control.eliminarAlumno(30);
        control.eliminarAlumno(51);
        control.eliminarAlumno(52);
        */
      
        //  Alumno objetoAlumno2 = new Alumno(30, "Luisina", "Asadadas", new Date());
        //  control.crearAlumno(objetoAlumno2);
        
        //  objetoAlumno2.setApellido("de Paula");
        //  control.editarAlumno(objetoAlumno2);
        
        //  Alumno objetoAlumno5 = new Alumno(22, "Fernando", "Chiquito", new Date());
        //  control.crearAlumno(objetoAlumno5);
        
        System.out.println("\n------------BÚSQUEDA INDIVIDUAL------------");
        
        Alumno objetoAlumno = control.traerAlumno(15);
        
        System.out.println("Alumno: " + objetoAlumno.toString());
        
        System.out.println("\n------------BÚSQUEDA DE TODOS------------");
        
        ArrayList<Alumno> listaAlumnos = control.traerListaAlumnos();
        
        for (Object alumnoForEach : listaAlumnos) {
            System.out.println("Alumno: " + alumnoForEach.toString());
        }
        System.out.println();
        
    }
}