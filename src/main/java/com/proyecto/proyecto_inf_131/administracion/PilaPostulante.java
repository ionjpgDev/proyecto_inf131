package com.proyecto.proyecto_inf_131.administracion;

public class PilaPostulante {
    private NodoPostulante pila;
    private int nroElement;

    public PilaPostulante() {
        this.pila = null;
        this.nroElement = 0;
    }

    public void mostrar(){
        PilaPostulante tmp = new PilaPostulante();

        while ( !this.isVacia() ){
            Postulante item = this.eliminar();
            System.out.println( item );

            tmp.agregar( item );
        }
        this.vaciar( tmp );

    }

    public void vaciar( PilaPostulante vac ){
        while ( !vac.isVacia() )
            this.agregar( vac.eliminar() );
    }

    public Postulante eliminar(){
        Postulante retornar = null;

        if ( !this.isVacia() ){
            NodoPostulante tmpNodo = this.pila;
            NodoPostulante antNodo = null;

            while ( tmpNodo.getSig() != null ){
                antNodo = tmpNodo;
                tmpNodo = tmpNodo.getSig();
            }

            retornar = tmpNodo.getItem();

            //eliminar ultimo elemento si antNodo sigue siendo null es el primer elemento
            if ( antNodo != null )
                antNodo.setSig( null );
            else
                this.pila = null;

            this.nroElement --;
        }else
            System.out.println("------PILA-VACIA--------");

        return retornar;
    }

    public void agregar( Postulante item ){
        NodoPostulante itemNodo = new NodoPostulante( item );

        if( this.isVacia() )
            this.pila = itemNodo;
        else{
            NodoPostulante tmp = this.pila;

            while ( tmp.getSig() != null )
                tmp = tmp.getSig();

            tmp.setSig( itemNodo );
        }

        this.nroElement ++;
    }

    public boolean isVacia(){
        return pila == null;
    }

    public int getNroElement() {
        return nroElement;
    }
}
