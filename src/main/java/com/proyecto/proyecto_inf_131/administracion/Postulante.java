package com.proyecto.proyecto_inf_131.administracion;

import com.proyecto.proyecto_inf_131.Persona;

import java.util.Scanner;

public class Postulante extends Persona {
    Requisitos requisitos;
    int asistencia = 0;

    public Postulante( String nombres, String apellidos, String ci, String celular, String matriculaUniv, String correo, String facultad, String carrera, String primerIngreso, Horario horario, String tipoDeSeguro, String enfermedadDeBase, String nombreDeporte ) {
        super( nombres, apellidos, ci );
        this.requisitos = new Requisitos( celular, matriculaUniv, correo, facultad, carrera, primerIngreso, horario, tipoDeSeguro, enfermedadDeBase, nombreDeporte );
    }

    public Postulante() {
        super();
        this.requisitos = new Requisitos();
    }

    @Override
    public String toString() {
        return "\tPostulante{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ci='" + ci + '\'' +
                '}';
    }

    public Requisitos getRequisitos() {
        return requisitos;
    }

    public void mostrarTodo() {
        System.out.println(
                "Postulante{\n" +
                "\tnombres: " + nombres + '\n' +
                "\tapellidos: " + apellidos + '\n' +
                "\tci: " + ci + '\n' +
                "\tasistencias: " + asistencia + '\n' +
                 requisitos + '\n' + '}' );
    }

    public void setAsistencia( int max ) {
        if ( max > this.asistencia )
            this.asistencia ++;
    }
    
    public void setRequisitos(){
        Scanner leer = new Scanner( System.in );
        System.out.println( "si NO se quiere editar oprimir enter" );
        System.out.print( "Editar celular ( " + this.requisitos.getCelular() + " ): " );
        this.requisitos.setCelular( leer.nextLine() );

        System.out.print( "Editar matricula ( " + this.requisitos.getMatriculaUniv() + " ): " );
        this.requisitos.setMatriculaUniv( leer.nextLine() );
        
        System.out.print( "Editar Correo ( " + this.requisitos.getCorreo() + " ): " );
        this.requisitos.setCorreo( leer.nextLine() );

        System.out.print( "Editar Facultad ( " + this.requisitos.getFacultad() + " ): " );
        this.requisitos.setFacultad( leer.nextLine() );

        System.out.print( "Editar carrera ( " + this.requisitos.getCarrera() + " ): " );
        this.requisitos.setCarrera( leer.nextLine() );

        System.out.print( "Editar primerIngreso ( " + this.requisitos.getPrimerIngreso() + " ): " );
        this.requisitos.setPrimerIngreso( leer.nextLine() );

        System.out.println( "Editar Horario ( " + this.requisitos.getHorario() + " ): " );
        this.requisitos.setHorario( );

        System.out.print( "Editar Tipo de seguro ( " + this.requisitos.getTipoDeSeguro() + " ): " );
        this.requisitos.setTipoDeSeguro( leer.nextLine() );

        System.out.print( "Editar Enfermedad de base ( " + this.requisitos.getEnfermedadDeBase() + " ): " );
        this.requisitos.setEnfermedadDeBase( leer.nextLine() );

        System.out.print( "Editar nombre de deporte actual ( " + this.requisitos.getNombreDeporte() + " ): " );
        this.requisitos.setNombreDeporte( leer.nextLine() );
    }

}
