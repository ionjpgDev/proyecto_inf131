package com.proyecto.proyecto_inf_131.torneo;

public class PilaTorneo {
    private NodoTorneo pila;
    private int nroElement;

    public PilaTorneo() {
        this.pila = null;
        this.nroElement = 0;
    }

    public void mostrar(){
        PilaTorneo tmp = new PilaTorneo();

        while ( !this.isVacia() ){
            Torneo item = this.eliminar();
            System.out.println( item );

            tmp.agregar( item );
        }
        this.vaciar( tmp );

    }

    public void vaciar( PilaTorneo vac ){
        while ( !vac.isVacia() )
            this.agregar( vac.eliminar() );
    }

    public Torneo eliminar(){
        Torneo retornar = null;

        if ( !this.isVacia() ){
            NodoTorneo tmpNodo = this.pila;
            NodoTorneo antNodo = null;

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

    public void agregar( Torneo item ){
        NodoTorneo itemNodo = new NodoTorneo( item );

        if( this.isVacia() )
            this.pila = itemNodo;
        else{
            NodoTorneo tmp = this.pila;

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
