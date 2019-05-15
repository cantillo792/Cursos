/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import java.util.Calendar;

public class Cursos {
    public static void main(String[] args) {
        Alumno a = new Alumno("Pepe", "34678904");   
        Alumno b = new Alumno("Andrea", "17679456", 125);
        Calendar Inicio = Calendar.getInstance();
        Calendar Final = Calendar.getInstance();
        Inicio.set(2014, 5, 4);
        Final.set(2014, 5, 5);
        Curso curso = new CursoPresencial(20, 1, "Diseño de Bases de Datos", Inicio, Final, 1, 50);
        Inicio.set(2014, 5, 12);
        Final.set(2014, 5, 16);
        Curso curso2 = new CursoOnline("Administración de Bases de Datos", Inicio, Final, 5, 25, 4, curso);
        curso.matriculacion(a);
        curso.matriculacion(b);
        curso.registroAsistencia(1, a);
        curso.calificar();
        curso.imprimirAptos();
        
        curso2.matriculacion(a);
        curso2.matriculacion(b);
        curso2.imprimirAlumnos();
        
        curso2.subirNivel(a);
        curso2.calificar();
        curso2.imprimirAptos();
        
        
        curso.imprimirAlumnos();
        
    }
    
}
