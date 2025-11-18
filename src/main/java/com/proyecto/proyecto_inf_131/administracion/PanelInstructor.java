package com.proyecto.proyecto_inf_131.administracion;

import com.proyecto.proyecto_inf_131.Persona;
import org.apache.catalina.webresources.ClasspathURLStreamHandler;

import java.util.Scanner;

public class PanelInstructor {
    private Instructor instructor = new Instructor("","","","",new Horario("","") );

    public PanelInstructor( ColaInstructor listaInstruc, ColaCurso listaCur ){
        if ( this.login( listaInstruc ) )
            this.acciones("/Panel_instrutor");
        else
            System.out.println( "NO login" );

    }

    private boolean login( ColaInstructor lista ){
        boolean v = false;
        Scanner leer = new Scanner( System.in );

        System.out.print( "Nombres: " );
        this.instructor.setNombres( leer.nextLine() );

        System.out.print( "Apellidos: " );
        this.instructor.setApellidos( leer.nextLine() );

        System.out.print( "ci: " );
        this.instructor.setCi( leer.nextLine() );

        ColaInstructor tmp = new ColaInstructor();
        while ( ! lista.isVacia() ){
            Instructor itemInstructor = lista.eliminar();
            tmp.agregar( itemInstructor );

            if ( itemInstructor.igual( this.instructor ) ) {
                this.instructor = itemInstructor;
                v = true;
                break;
            }
        }
        lista.vaciar( tmp );

        return v;
    }
    private void acciones( String ruta ){
        Scanner leer = new Scanner( System.in );
        boolean v = true;

        while ( v ){
            System.out.print("------Instruto-------\n1 -> calificar asistencia\n2 -> ver informacion Postulante\n3 -> mostrar cursos\n0 -> salir\n" + ruta + " $> ");
            switch ( leer.nextLine() ){
                case "0": v= false; break;
                case "1": this.instructor.calificarAsistencia(); break;
                case "2": this.instructor.verPostulante(); break;
                case "3": this.instructor.mostrarCursos(); break;
                default: break;
            }
        }
    }
}
