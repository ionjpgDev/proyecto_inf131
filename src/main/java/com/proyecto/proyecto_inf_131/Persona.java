package com.proyecto.proyecto_inf_131;


import java.util.Scanner;

public class Persona {
    protected String nombres, apellidos, ci;

    protected Persona(String nombres, String apellidos, String ci ) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ci = ci;
    }

    protected Persona() {
        Scanner leer = new Scanner( System.in );

        System.out.print("Nombres: ");
        this.nombres = leer.nextLine();

        System.out.print("Apellidos: ");
        this.apellidos = leer.nextLine();

        System.out.print("CI: ");
        this.ci = leer.nextLine();
    }

    public String getCi() {
        return ci;
    }

    public void setCi( String ci ) {
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
