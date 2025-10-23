package com.proyecto.proyecto_inf_131.administracion;

public class NodoPostulante {
    private Postulante item;
    private NodoPostulante sig;

    public NodoPostulante(Postulante item) {
        this.item = item;
        this.sig = null;
    }

    public Postulante getItem() {
        return item;
    }

    public void setItem(Postulante item) {
        this.item = item;
    }

    public NodoPostulante getSig() {
        return sig;
    }

    public void setSig(NodoPostulante sig) {
        this.sig = sig;
    }
}