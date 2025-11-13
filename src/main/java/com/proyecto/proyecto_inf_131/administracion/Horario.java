package com.proyecto.proyecto_inf_131.administracion;

import java.util.Scanner;

public class Horario {
    private String turno;
    private String hora;

    public Horario( String turno, String hora ) {
        this.turno = turno;
        this.hora = hora;
    }

    public Horario( ) {
        Scanner leer= new Scanner( System.in );

        System.out.print("turno: ");
        this.turno = leer.nextLine();

        System.out.print("hora: ");
        this.hora = leer.nextLine();
    }

    public boolean igual( Horario item ){
        return this.turno.equals( item.getTurno() ) &&  this.hora.equals( item.getHora() );
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno( String turno ) {
        this.turno = turno;
    }

    public String getHora() {
        return hora;
    }

    public void setHora( String hora ) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "turno='" + turno + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}
