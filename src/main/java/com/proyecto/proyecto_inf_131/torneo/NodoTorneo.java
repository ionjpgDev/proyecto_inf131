package com.proyecto.proyecto_inf_131.torneo;

public class NodoTorneo {
    private Torneo item;
    private NodoTorneo sig;

    public NodoTorneo(Torneo item) {
        this.item = item;
        this.sig = null;
    }

    public void setSig(NodoTorneo sig) {
        this.sig = sig;
    }

    public Torneo getItem() {
        return item;
    }

    public NodoTorneo getSig() {
        return sig;
    }
}