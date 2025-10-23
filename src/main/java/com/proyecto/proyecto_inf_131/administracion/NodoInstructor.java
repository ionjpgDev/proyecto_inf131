package com.proyecto.proyecto_inf_131.administracion;

public class NodoInstructor {
    private Instructor item;
    private NodoInstructor sig;

    public Instructor getItem() {
        return item;
    }

    public NodoInstructor(Instructor item) {
        this.item = item;
        this.sig = null;
    }

    public NodoInstructor getSig() {
        return sig;
    }

    public void setSig(NodoInstructor sig) {
        this.sig = sig;
    }
}
