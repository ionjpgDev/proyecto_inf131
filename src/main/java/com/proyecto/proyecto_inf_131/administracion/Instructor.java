package com.proyecto.proyecto_inf_131.administracion;

import com.proyecto.proyecto_inf_131.Persona;
import java.util.Arrays;
import java.util.Scanner;

public class Instructor extends Persona {
    private String nombreDeporte;
    private Horario horario;

    public Instructor(String nombres, String apellidos, String ci, String nombreDeporte, Horario horario) {
        super(nombres, apellidos, ci );
        this.nombreDeporte = nombreDeporte;
        this.horario = horario;
    }

    public Instructor(){
        super();
        Scanner leer = new Scanner( System.in );

        System.out.print("deporte: ");
        this.nombreDeporte = leer.nextLine();

        this.horario = new Horario();
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ci='" + ci + '\'' +
                '}';
    }

    public void mostrarTodo() {
        System.out.println( "Instructor{\n" +
                "\tnombres='" + nombres + '\n' +
                "\tapellidos='" + apellidos + '\n' +
                "\tci='" + ci + '\n' +
                "\tnombreDeporte='" + nombreDeporte + '\n' +
                "\thorario=" + horario.toString() +
                '}' );
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }


    public boolean horario( Horario horario ){
        return this.horario.igual( horario );
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario( Horario horario ) {
        this.horario = horario;
    }

    public boolean igual( Instructor item ){
        return this.ci.equals( item.getCi() );
    }
}
