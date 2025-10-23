package com.proyecto.proyecto_inf_131.administracion;

public class ColaInstructor {
    private NodoInstructor cola;

    public ColaInstructor() {
        this.cola = null;
    }

    public void mostrar(){
        ColaInstructor tmp = new ColaInstructor();
        Instructor item;

        while ( !this.isVacia() ){
            item = this.eliminar();

            System.out.println( item );

            tmp.agregar( item );
        }
        this.vaciar( tmp );

    }

    public void vaciar( ColaInstructor vac ){
        while ( !vac.isVacia() )
            this.agregar( vac.eliminar() );
    }

    public Instructor eliminar(){
        NodoInstructor tmpNodo;
        Instructor retornar = null;

        if ( !isVacia() ){
            tmpNodo = this.cola;
            retornar = tmpNodo.getItem();

            this.cola = this.cola.getSig();

            tmpNodo.setSig( null );
        }
        else System.out.println("--------------COLA-VACIA-----------");

        return retornar;
    }

    public void agregar( Instructor item ){
        NodoInstructor itemNodo = new NodoInstructor(item);
        NodoInstructor tmpNodo;

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
