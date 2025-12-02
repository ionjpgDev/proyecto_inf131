package com.proyecto.proyecto_inf_131.administracion;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class PanelPostulante {
    private Postulante usr = new Postulante("","","","","","","","","",new Horario("",""),"","","");

    public PanelPostulante(){}
    public PanelPostulante( PilaPostulante lista ){
        if( this.login( lista ) )
            acciones("/Perfil");
        else
            System.out.println("\t!!!!!!!!!!!NO login!!!!!!!!!!!");
    }
    public boolean login( PilaPostulante lista ){
        Scanner leer  = new Scanner( System.in );
        boolean v = false;

        System.out.print( "Nombres: " );
        usr.setNombres( leer.nextLine() );

        System.out.print( "Apellidos: " );
        usr.setApellidos( leer.nextLine() );

        System.out.print( "Ci: " );
        usr.setCi( leer.nextLine() );

        PilaPostulante tmp = new PilaPostulante();
        while ( ! lista.isVacia() ){
            Postulante itemPostulante = lista.eliminar();
            tmp.agregar( itemPostulante );

            if ( this.usr.igual( itemPostulante ) ) {
                this.usr = itemPostulante;
                v = true;
                break;
            }

        }
        lista.vaciar( tmp );

        return v;
    }
    public boolean login( String nombres, String apellidos, String ci, PilaPostulante lista ){
        boolean v = false;

        this.usr.setNombres( nombres );
        this.usr.setApellidos( apellidos );
        this.usr.setCi( ci );

        PilaPostulante tmp = new PilaPostulante();
        while ( ! lista.isVacia() ){
            Postulante itemPostulante = lista.eliminar();
            tmp.agregar( itemPostulante );

            if ( this.usr.igual( itemPostulante ) ) {
                this.usr = itemPostulante;
                v = true;
                break;
            }

        }
        lista.vaciar( tmp );

        return v;
    }
    public void acciones( String ruta ){
        Scanner leer = new Scanner( System.in );
        boolean v  = true;

        while ( v ){
            System.out.print( "----perfil----\n1 -> ver_perfil\n2 -> editar_datos_personales\n3 -> editar_formulario \n0 -> salir\n " + ruta + " $> " );
            switch ( leer.nextLine() ){
                case "0": v = false; break;
                case "1": this.verPerfil();break;
                case "2": this.editarDatosPersonales();break;
                case "3" : this.editarFormulario();break;
                default: break;
            }
        }

    }
    public void editarFormulario(){
        usr.setRequisitos();
    }
    public void editarDatosPersonales(){
        usr.editarDatos();
    }
    public void verPerfil(){
        usr.mostrarTodo();
    }

    public Postulante getUsr() {
        return usr;
    }
}
