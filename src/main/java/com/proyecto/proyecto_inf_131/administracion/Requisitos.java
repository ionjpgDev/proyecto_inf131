package com.proyecto.proyecto_inf_131.administracion;

import java.util.Scanner;

public class Requisitos {
    private String celular, matriculaUniv,correo, facultad, carrera, primerIngreso, tipoDeSeguro, enfermedadDeBase, nombreDeporte;
    private Horario horario;

    public Requisitos( String celular, String matriculaUniv, String correo, String facultad, String carrera, String primerIngreso, Horario horario, String tipoDeSeguro, String enfermedadDeBase, String nombreDeporte ) {
        this.celular = celular;
        this.matriculaUniv = matriculaUniv;
        this.correo = correo;
        this.facultad = facultad;
        this.carrera = carrera;
        this.primerIngreso = primerIngreso;
        this.horario = horario;
        this.tipoDeSeguro = tipoDeSeguro;
        this.enfermedadDeBase = enfermedadDeBase;
        this.nombreDeporte = nombreDeporte;
    }

    public Requisitos() {
        Scanner leer = new Scanner( System.in );

        System.out.print("celular: ");
        this.celular = leer.nextLine();

        System.out.print("matricula universitaria: ");
        this.matriculaUniv = leer.nextLine();

        System.out.print("correo electronico: ");
        this.correo = leer.nextLine();

        System.out.print("facultad: ");
        this.facultad = leer.nextLine();

        System.out.print("carrera: ");
        this.carrera = leer.nextLine();

        System.out.print("es su primera inscripcion: ");
        this.primerIngreso = leer.nextLine();

        this.horario = new Horario();

        System.out.print("¿¿tiene seguro privado o publico??: ");
        this.tipoDeSeguro = leer.nextLine();

        System.out.print("¿Tiene alguna enfermedad de base?: ");
        this.enfermedadDeBase = leer.nextLine();

        System.out.print("Deporte: ");
        this.nombreDeporte = leer.nextLine();
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular( String celular ) {
        this.celular = celular;
    }

    public String getMatriculaUniv() {
        return matriculaUniv;
    }

    public void setMatriculaUniv( String matriculaUniv ) {
        this.matriculaUniv = matriculaUniv;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo( String correo ) {
        this.correo = correo;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad( String facultad ) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera( String carrera ) {
        this.carrera = carrera;
    }

    public String getPrimerIngreso() {
        return primerIngreso;
    }

    public void setPrimerIngreso( String primerIngreso ) {
        this.primerIngreso = primerIngreso;
    }

    public String getTipoDeSeguro() {
        return tipoDeSeguro;
    }

    public void setTipoDeSeguro( String tipoDeSeguro ) {
        this.tipoDeSeguro = tipoDeSeguro;
    }

    public String getEnfermedadDeBase() {
        return enfermedadDeBase;
    }

    public void setEnfermedadDeBase( String enfermedadDeBase ) {
        this.enfermedadDeBase = enfermedadDeBase;
    }



    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte( String nombreDeporte ) {
        this.nombreDeporte = nombreDeporte;
    }

    @Override
    public String toString() {
        return "Requisitos{\n" +
                "\tcelular: " + celular + '\n' +
                "\tmatriculaUniv: " + matriculaUniv + '\n' +
                "\tcorreo: " + correo + '\n' +
                "\tfacultad: " + facultad + '\n' +
                "\tcarrera: " + carrera + '\n' +
                "\tprimerIngreso: " + primerIngreso + '\n' +
                "\thorario: " + horario + '\n' +
                "\ttipoDeSeguro: " + tipoDeSeguro + '\n' +
                "\tenfermedadDeBase: " + enfermedadDeBase + '\n' +
                "\tnombreDeporte: " + nombreDeporte + '\n' +
                "\t}";
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario( Horario horario ) {
        this.horario = horario;
    }
}
