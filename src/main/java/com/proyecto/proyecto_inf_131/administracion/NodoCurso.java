package com.proyecto.proyecto_inf_131.administracion;

public class NodoCurso {
    private Curso item;
    private NodoCurso sig;

    public NodoCurso(Curso item) {
        this.item = item;
        this.sig = null;
    }

    public void setSig(NodoCurso sig) {
        this.sig = sig;
    }

    public Curso getItem() {
        return item;
    }

    public NodoCurso getSig() {
        return sig;
    }
}
