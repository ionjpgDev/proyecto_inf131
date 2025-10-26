package com.proyecto.proyecto_inf_131.torneo;

public class ColaCompetidor {
    private NodoCompetidor cola;

    public ColaCompetidor() {
        this.cola = null;
    }

    public void mostrar(){
        ColaCompetidor tmp = new ColaCompetidor();
        Competidor item;

        while ( !this.isVacia() ){
            item = this.eliminar();

            System.out.println( item );

            tmp.agregar( item );
        }
        this.vaciar( tmp );

    }

    public void vaciar( ColaCompetidor vac ){
        while ( !vac.isVacia() )
            this.agregar( vac.eliminar() );
    }

    public Competidor eliminar(){
        NodoCompetidor tmpNodo;
        Competidor retornar = null;

        if ( !isVacia() ){
            tmpNodo = this.cola;
            retornar = tmpNodo.getItem();

            this.cola = this.cola.getSig();

            tmpNodo.setSig( null );
        }
        else System.out.println("--------------COLA-VACIA-----------");

        return retornar;
    }

    public void agregar( Competidor item ){
        NodoCompetidor itemNodo = new NodoCompetidor(item);
        NodoCompetidor tmpNodo;

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