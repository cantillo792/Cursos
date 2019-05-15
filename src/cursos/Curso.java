/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


abstract class Curso {
    protected String titulo;
    protected Calendar fechaInicio;
    protected Calendar fechaFinal;
    protected int numeroDias;
    protected double precio;
    protected ArrayList<Alumno> alumnos;
    protected ArrayList<Alumno> alumnosAptos;

    public Curso(String titulo, Calendar fechaInicio, Calendar fechaFinal, int numeroDias, double precio) {
        this.titulo = titulo;
        this.fechaInicio = Calendar.getInstance();
        this.fechaFinal = Calendar.getInstance();
        this.fechaInicio.set(fechaInicio.getTime().getYear(), fechaInicio.getTime().getMonth(), fechaInicio.getTime().getDay());
        this.fechaFinal.set(fechaFinal.getTime().getYear(), fechaFinal.getTime().getMonth(), fechaFinal.getTime().getDay());
        this.numeroDias = numeroDias;
        this.precio = precio;
        alumnos = new ArrayList<>();
        alumnosAptos = new ArrayList<>();
    }
    
    public boolean haTerminado(){
        Date fechaAhora = new Date();
        return fechaFinal.getTime().compareTo(fechaAhora) == 1 || fechaFinal.getTime().compareTo(fechaAhora) == 0;
    }
    abstract public boolean alumnoApto(Alumno alumno);
    public boolean matriculacion(Alumno alumno){
        if(alumno.getCredito() >= precio){
            alumno.decrementarCredito(precio);
            alumnos.add(alumno);
            return true;
        }else{
            return false;
        }
    }
    
    public void imprimirAptos(){
        System.out.println("Aptos: ");
        for(int i = 0; i < this.alumnosAptos.size(); i++){
            System.out.println("     -" + alumnosAptos.get(i).getNombre());
        }
    }
    
    void imprimirAlumnos(){
        System.out.println("Alumnos: ");
        for(int i = 0; i < this.alumnos.size(); i++){
            System.out.println("     - " + this.alumnos.get(i).getNombre() + " - DNI: " + this.alumnos.get(i).getDni());
        }
    }
   
    public void calificar(){
        for(int i = 0;i<alumnos.size();i++ ){
            if(alumnoApto(alumnos.get(i))){
                alumnosAptos.add(alumnos.get(i));
                alumnos.get(i).agregarCurso(this);
            }
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Curso obj=null;
        if(!vacio()){
            try{
                obj=(Curso)super.clone();
            }catch(CloneNotSupportedException ex){
                System.out.println("No se puede duplicar");
            }
        }else{
            System.out.println("No esta vacio");
        }
        return obj;
    }
    
    abstract public boolean vacio();

    public boolean registroAsistencia(int i, Alumno a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void subirNivel(Alumno a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
