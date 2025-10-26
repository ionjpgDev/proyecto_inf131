package com.proyecto.proyecto_inf_131.administracion;

public class ColaCurso {
    private NodoCurso cola;

    public ColaCurso() {
        this.cola = null;
    }

    public void mostrar(){
            com.proyecto.proyecto_inf_131.administracion.ColaCurso tmp = new com.proyecto.proyecto_inf_131.administracion.ColaCurso();
            Curso item;

            while ( !this.isVacia() ){
                item = this.eliminar();

                System.out.println( item );

                tmp.agregar( item );
            }
            this.vaciar( tmp );

        }

        public void vaciar( com.proyecto.proyecto_inf_131.administracion.ColaCurso vac ){
            while ( !vac.isVacia() )
                this.agregar( vac.eliminar() );
        }

        public Curso eliminar(){
            NodoCurso tmpNodo;
            Curso retornar = null;

            if ( !isVacia() ){
                tmpNodo = this.cola;
                retornar = tmpNodo.getItem();

                this.cola = this.cola.getSig();

                tmpNodo.setSig( null );
            }
            else System.out.println("--------------COLA-VACIA-----------");

            return retornar;
        }

        public void agregar( Curso item ){
            NodoCurso itemNodo = new NodoCurso(item);
            NodoCurso tmpNodo;

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
