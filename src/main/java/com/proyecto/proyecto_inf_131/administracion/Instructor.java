package com.proyecto.proyecto_inf_131.administracion;

import com.proyecto.proyecto_inf_131.Persona;
import java.util.Arrays;
import java.util.Scanner;

public class Instructor extends Persona {
    private String nombreDeporte;
    private String[] horario;

    public Instructor(String nombres, String apellidos, String ci, String nombreDeporte, String[] horario) {
        super(nombres, apellidos, ci );
        this.nombreDeporte = nombreDeporte;
        this.horario = horario;
    }

    public Instructor(){
        super();
        Scanner leer = new Scanner( System.in );

        System.out.print("deporte: ");
        this.nombreDeporte = leer.nextLine();

        System.out.print("horario: ");
        this.horario = leer.nextLine().split( "," );

    }

    @Override
    public String toString() {
        return "\tInstructor{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombreDeporte='" + nombreDeporte + '\'' +
                ", horario=" + Arrays.toString(horario) +
                '}';
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    public String[] getHorario() {
        return horario;
    }

    public void setHorario(String[] horario) {
        this.horario = horario;
    }

    public boolean horario( String horario ){
        boolean v = false;
        for ( String hrio: this.horario )
            if( hrio.equals( horario ) )
                v = true;

        return true;
    }
}
