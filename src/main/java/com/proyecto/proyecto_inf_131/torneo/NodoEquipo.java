package com.proyecto.proyecto_inf_131.torneo;

public class NodoEquipo {
    private Equipo item;
    private NodoEquipo sig;

    public NodoEquipo(Equipo item) {
        this.item = item;
        this.sig = null;
    }

    public void setSig(NodoEquipo sig) {
        this.sig = sig;
    }

    public Equipo getItem() {
        return item;
    }

    public NodoEquipo getSig() {
        return sig;
    }
}
