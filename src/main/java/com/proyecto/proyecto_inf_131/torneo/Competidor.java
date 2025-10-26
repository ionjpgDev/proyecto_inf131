package com.proyecto.proyecto_inf_131.torneo;

import com.proyecto.proyecto_inf_131.Persona;

public class Competidor extends Persona {
    private String nombreEquipo;

    public Competidor( String nombres, String apellidos, String nombreEquipo ) {
        super( nombres, apellidos );
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo( String nombreEquipo ) {
        this.nombreEquipo = nombreEquipo;
    }

    @Override
    public String toString() {
        return "Competidor{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                '}';
    }
}
