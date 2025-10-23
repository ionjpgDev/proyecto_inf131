package com.proyecto.proyecto_inf_131.administracion;

public class Postulante extends Persona {
    private String matriculaUniversitaria, seguroDeSalud;
    //formularioDeInscripcion, apto; nose si estos atributos van  o no aun

    public Postulante(String nombres, String apellidos, String matriculaUniversitaria, String seguroDeSalud) {
        super(nombres, apellidos);
        this.matriculaUniversitaria = matriculaUniversitaria;
        this.seguroDeSalud = seguroDeSalud;
    }

    @Override
    public String toString() {
        return "\tPostulante{" +
                "nombres='" + nombres + '\'' +
                "  apellidos='" + apellidos + '\'' +
                ", seguroDeSalud='" + seguroDeSalud + '\'' +
                ", matriculaUniversitaria='" + matriculaUniversitaria + '\'' +
                '}';
    }

    public String getMatriculaUniversitaria() {
        return matriculaUniversitaria;
    }

    public void setMatriculaUniversitaria(String matriculaUniversitaria) {
        this.matriculaUniversitaria = matriculaUniversitaria;
    }

    public String getSeguroDeSalud() {
        return seguroDeSalud;
    }

    public void setSeguroDeSalud(String seguroDeSalud) {
        this.seguroDeSalud = seguroDeSalud;
    }
}
