package com.proyecto.proyecto_inf_131.administracion;

import com.proyecto.proyecto_inf_131.Persona;

public class Postulante extends Persona {
    Requisitos requisitos;

    public Postulante( String nombres, String apellidos, String ci, String celular, String matriculaUniv, String correo, String facultad, String carrera, String primerIngreso, String horario, String tipoDeSeguro, String enfermedadDeBase, String nombreDeporte ) {
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
}
