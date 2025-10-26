package com.proyecto.proyecto_inf_131.torneo;

public class NodoCompetidor {
    private Competidor item;
    private NodoCompetidor sig;

    public NodoCompetidor(Competidor item) {
        this.item = item;
        this.sig = null;
    }

    public void setSig(NodoCompetidor sig) {
        this.sig = sig;
    }

    public Competidor getItem() {
        return item;
    }

    public NodoCompetidor getSig() {
        return sig;
    }
}
