package com.proyecto.proyecto_inf_131.torneo;

public class Equipo {
    String nombre, nombreTorneo;
    ColaCompetidor integrantes;

    public Equipo( String nombre, String nombreTorneo ) {
        this.nombre = nombre;
        this.nombreTorneo = nombreTorneo;
        this.integrantes = new ColaCompetidor();
    }

    public void agregarIntegrante( Competidor item ){
        this.integrantes.agregar( item );
    }

    public void eliminarIntegrante( ){
        //agregar logica para eliminar un integrante
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public ColaCompetidor getIntegrantes() {
        return integrantes;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public void setNombreTorneo( String nombreTorneo ) {
        this.nombreTorneo = nombreTorneo;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", nombreTorneo='" + nombreTorneo + '\'' +
                '}';
    }
}
