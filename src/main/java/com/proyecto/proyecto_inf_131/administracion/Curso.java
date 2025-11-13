package com.proyecto.proyecto_inf_131.administracion;

import java.util.Scanner;

public class Curso {
    private String nombreDeporte;
    private Horario horario;
    private int cupos;
    private Instructor instructor;
    private PilaPostulante inscritos;

    public Curso( String nombre, int cupos, Horario horario ) {
        this.nombreDeporte = nombre;
        this.cupos = cupos;
        this.horario = horario;
        this.inscritos = new PilaPostulante();
        this.instructor = new Instructor( "", "","", "", new Horario( "","") ); //el instructor esta creado sin datos
    }

    public Curso(  ) {
        Scanner leer = new Scanner( System.in );

        System.out.print("Nombre de deporte: ");
        this.nombreDeporte = leer.nextLine();

        System.out.print("nro de cupos: ");
        this.cupos = Integer.parseInt( leer.nextLine() );

        this.horario = new Horario();

        this.inscritos = new PilaPostulante();
        this.instructor = new Instructor( "", "","", "", new Horario( "","") );
    }

    public int cuposDisponibles(){
        return this.cupos - inscritos.getNroElement();
    }

    public void mostrarInscritos() {
        System.out.println( "\t....................LISTA.DE.INSCRITOS........................." );
        this.inscritos.mostrar();
        System.out.println( "\t...............................................................\n" );
    }

    public void inscribir( Postulante item ) {
        if ( this.cuposDisponibles() <= 0)
            System.out.println("_____CUPOS__LLENOS_____");
        else
            this.inscritos.agregar( item );
    }

    public void darDeBaja( String ci ) {
        PilaPostulante tmp = new PilaPostulante();

        while ( ! this.inscritos.isVacia() ){
            Postulante item = this.inscritos.eliminar();

            if ( !item.getCi().equals( ci ) )
                tmp.agregar( item );
            else
                System.out.println("Eliminado");

        }

        this.inscritos.vaciar( tmp );
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor( Instructor instructor ) {
        this.instructor = instructor;
    }

    public void setInstructor( String nombres, String apellidos, String ci ) {
        this.instructor.setNombres( nombres );
        this.instructor.setApellidos( apellidos );
        this.instructor.setCi( ci );
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos( int cupos ) {
        this.cupos = cupos;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario( Horario horario ) {
        this.horario = horario;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte( String nombreDeporte ) {
        this.nombreDeporte = nombreDeporte;
    }

    public void mostrarTodo(){
        System.out.println(
                "Curso{\n" +
                "\tnombreDeporte: " + nombreDeporte + '\n' +
                "\tcupos: " + cupos + '\n' +
                "\tcupos disponibles: " + this.cuposDisponibles() + '\n' +
                "\tinstructor: " + instructor.getNombres() + " " + instructor.getApellidos()+ '\n' +
                "\thorario: " + horario + '\n' +
                '}'
        );
        this.mostrarInscritos();
    }

    @Override
    public String toString() {
        return "\tCurso{" +
                "nombreDeporte='" + nombreDeporte + '\'' +
                ", cupos=" + cupos +
                ", instructor=" + instructor.getNombres() + " " + instructor.getApellidos()+
                ", horario='" + horario + '\'' +
                '}';
    }
}