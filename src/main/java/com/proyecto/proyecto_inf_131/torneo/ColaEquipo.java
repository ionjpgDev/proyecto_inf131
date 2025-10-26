package com.proyecto.proyecto_inf_131.torneo;

public class ColaEquipo {
    private NodoEquipo cola;

    public ColaEquipo() {
        this.cola = null;
    }

    public void mostrar(){
        ColaEquipo tmp = new ColaEquipo();
        Equipo item;

        while ( !this.isVacia() ){
            item = this.eliminar();

            System.out.println( item );

            tmp.agregar( item );
        }
        this.vaciar( tmp );

    }

    public void vaciar( ColaEquipo vac ){
        while ( !vac.isVacia() )
            this.agregar( vac.eliminar() );
    }

    public Equipo eliminar(){
        NodoEquipo tmpNodo;
        Equipo retornar = null;

        if ( !isVacia() ){
            tmpNodo = this.cola;
            retornar = tmpNodo.getItem();

            this.cola = this.cola.getSig();

            tmpNodo.setSig( null );
        }
        else System.out.println("--------------COLA-VACIA-----------");

        return retornar;
    }

    public void agregar( Equipo item ){
        NodoEquipo itemNodo = new NodoEquipo(item);
        NodoEquipo tmpNodo;

        if( this.isVacia() )
            this.cola = itemNodo;
        else {
            tmpNodo = this.cola;
            while ( tmpNodo.getSig() != null )
                tmpNodo = tmpNodo.getSig();

            tmpNodo.setSig( itemNodo );
        }
    }
    public boolean isVacia(){ return cola == null; }
}
