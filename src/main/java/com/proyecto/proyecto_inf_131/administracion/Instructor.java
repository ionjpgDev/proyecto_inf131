package com.proyecto.proyecto_inf_131.administracion;

import com.proyecto.proyecto_inf_131.Persona;
import java.util.Arrays;

public class Instructor extends Persona {
    private String nombreDeporte;
    private String[] horario;

    public Instructor(String nombres, String apellidos, String nombreDeporte, String[] horario) {
        super(nombres, apellidos);
        this.nombreDeporte = nombreDeporte;
        this.horario = horario;
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
}
