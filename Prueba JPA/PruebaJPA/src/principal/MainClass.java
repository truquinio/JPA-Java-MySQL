/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import entidades.Alumno;
import entidades.Controladora;
import java.util.Date;

/**
 *
 * @author FT
 */
public class MainClass {

    public static void main(String[] args) {

        Controladora control = new Controladora();

    //  Alumno objetoAlumno1 = new Alumno(15, "Lalo", "Landa", new Date());
    //  Alumno objetoAlumno2 = new Alumno(30, "Luicina", "Asadadas", new Date());*/
        Alumno objetoAlumno3 = new Alumno("AAA", "BBB", new Date());
        Alumno objetoAlumno4 = new Alumno("CCC", "DDD", new Date());

        control.crearAlumno(objetoAlumno3);
        control.crearAlumno(objetoAlumno4);
    }
}
