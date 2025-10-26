package com.proyecto.proyecto_inf_131.torneo;

public class Torneo {
    private String nombreTorneo, inicio, fin, detalles;
    private ColaEquipo equipos;

    public Torneo( String nombreTorneo, String inicio, String fin, String detalles ) {
        this.nombreTorneo = nombreTorneo;
        this.inicio = inicio;
        this.fin = fin;
        this.detalles = detalles;
        this.equipos = new ColaEquipo();
    }

    public void inscribirEquipo( Equipo item ){
        this.equipos.agregar( item );
    }

    public void eliminarEquipo(  ){
        //agregar logica para eliminar un integrante
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public String getInicio() {
        return inicio;
    }

    public String getFin() {
        return fin;
    }

    public String getDetalles() {
        return detalles;
    }

    public ColaEquipo getEquipos() {
        return equipos;
    }

    public void setInicio( String inicio ) {
        this.inicio = inicio;
    }

    public void setFin( String fin ) {
        this.fin = fin;
    }

    public void setDetalles( String detalles ) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "\tTorneo{" +
                "nombreTorneo='" + nombreTorneo + '\'' +
                ", inicio='" + inicio + '\'' +
                ", fin='" + fin + '\'' +
                ", detalles='" + detalles + '\'' +
                '}';
    }
}
