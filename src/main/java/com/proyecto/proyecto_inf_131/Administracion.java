package com.proyecto.proyecto_inf_131;

import com.proyecto.proyecto_inf_131.administracion.*;
import org.apache.catalina.webresources.ClasspathURLStreamHandler;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.yaml.snakeyaml.nodes.ScalarNode;

import java.util.Scanner;

public class Administracion {
    private PilaPostulante postulantes;
    private ColaInstructor instructores;
    private ColaCurso cursos;

    //atributos necesario o son de gestion
    private Scanner leer = new Scanner( System.in );
    private boolean v = true;

    public Administracion() {
        this.postulantes = new PilaPostulante();
        this.instructores = new ColaInstructor();
        this.cursos = new ColaCurso();

        this.datosPrb();//borrar o comentar
        this.acciones();
    }

    private void datosPrb(){
        this.crearCurso( new Curso( "fut", 21,"horario1" ) );
        this.crearCurso( new Curso( "bas", 21,"" ) );
        this.crearCurso( new Curso( "natacion", 21,"horario" ) );

        this.agregarPostulante( new Postulante( "nom1","ape1","ci1","cel1","matri1","c@rreo","fal1","carr1","no","horario1","publico","no","fut" ) );
        this.agregarPostulante( new Postulante( "nom2","ape2","ci2","cel1","matri2","c@rreo","fal1","carr1","no","horario2","publico","no", "dep1" ) );
        this.agregarPostulante( new Postulante( "nom2","ape3","ci3","cel1","matri3","c@rreo","fal1","carr1","no","horario1","publico","no", "fut" ) );

        this.agregarInstructor( new Instructor( "freddy","mercury","", "fut",new String[]{"horario1","21"} ) );
        this.agregarInstructor( new Instructor( "mick","marciano","","natacion",new String[]{"1","21"} ) );
        this.agregarInstructor( new Instructor( "axl","rosas","","bas",new String[]{"1","21"} ) );

    }
    private void acciones(){//muestra de como funcionaria el sistema
        while ( v ) {
            System.out.print("-----ADMINISTRAR-----\n 0 -> salir\n 1 -> instructores\n 2 -> postulantes\n 3 -> cursos\n / $> ");
            switch ( leer.nextLine() ){
                case "0": System.out.println("luke soy tu padre"); v= false ;break;
                case "1": this.accionesInstructores( "/instructores"); break;
                case "2": this.accionesPostulantes("/postulantes"); break;
                case "3": this.accionesCursos( "/cursos" ); break;
                default: break;
            }

        }
    }

    //INICIO administracion del Cursos
    public void accionesCursos( String ruta ){
        v = true;

        while( v ){
            System.out.print("-----Cursos-----\n 0 -> salir\n 1 -> mostrar cursos\n 2 -> crear curso\n "+ ruta +" $> ");
            switch ( leer.nextLine() ){
                case "0": v= false ;break;
                case "1": this.mostrarCursos(); break;
                case "2":{
                    System.out.print("nombre: ");
                    String nombre = leer.nextLine();

                    System.out.print("cupos: ");
                    int cupos  = Integer.parseInt( leer.nextLine() );

                    System.out.print("horarios: ");
                    String horario = leer.nextLine();

                    this.crearCurso( new Curso( nombre, cupos, horario  ) );
                    break;
                }
                default: break;
            }
        }

        v = true;
    }
    public void crearCurso( Curso item ){
        this.cursos.agregar( item );
    }
    public void mostrarCursos(){
        System.out.println("-----lista-De-Cursos-de-las-escuelas-deportivas-UMSA----------");
        this.cursos.mostrar();
        System.out.println("--------------------------------------------------------------");
    }
    //FIN administracion del Cursos

    //INICIO administracion del Instructores
    public void accionesInstructores( String ruta ){
        v = true;

        while( v ){
            System.out.print("-----Instructores-----\n 0 -> salir\n 1 -> mostrar instructores\n 2 -> agregar instructor\n "+ ruta + " $> ");
            switch ( leer.nextLine() ){
                case "0": v= false ;break;
                case "1": this.mostrarInstructores(); break;
                case "2":{
                    Instructor item = new Instructor();

                    this.agregarInstructor( item );
                    break;
                }
                default: break;
            }
        }

        v = true;
    }
    public void agregarInstructor( Instructor item ){
        this.instructores.agregar( item );//lista general de instructores

        ColaCurso tmpCola = new ColaCurso();

        while ( !this.cursos.isVacia() ){
            Curso curso = this.cursos.eliminar();
            tmpCola.agregar(  curso );

            if ( curso.getNombreDeporte().equals( item.getNombreDeporte() ) && item.horario( curso.getHorario() ) )
                curso.setInstructor( item );

        }

        this.cursos.vaciar( tmpCola );
    }
    public void mostrarInstructores(){
        System.out.println("-----lista-De-Instructores-a-las-escuelas-deportivas-UMSA------");
        this.instructores.mostrar();
        System.out.println("--------------------------------------------------------------");
    }
    //FIN administracion del Instructores

    //INICIO administracion del postulantes
    public void accionesPostulantes( String ruta ){
        v = true;

        while( v ){
            System.out.print("-----Postulantes-----\n 0 -> salir\n 1 -> mostrar postulantes\n 2 -> agregar postulante\n "+ ruta +" $> ");
            switch ( leer.nextLine() ){
                case "0": v= false ;break;
                case "1": this.mostrarPostulantes(); break;
                case "2":{
                    Postulante item = new Postulante( );

                    this.agregarPostulante( item );
                    break;
                }
                default: break;
            }
        }

        v = true;
    }
    public void agregarPostulante( Postulante item ){
        this.postulantes.agregar( item );// lista general de todos los inscritos

        ColaCurso tmpCola = new ColaCurso();//agregar postulante a las listas de forma dinamica
        while ( ! this.cursos.isVacia() ){
            Curso curso = this.cursos.eliminar();
            tmpCola.agregar( curso );

            if( curso.getHorario().equals( item.getRequisitos().getHorario() )
                    && curso.getNombreDeporte().equals( item.getRequisitos().getNombreDeporte() ) )
                curso.inscribir( item );
        }

        this.cursos.vaciar( tmpCola );
    }
    public void mostrarPostulantes(){
        System.out.println("-----lista-De-Postulantes-a-las-escuelas-deportivas-UMSA------");
        this.postulantes.mostrar();
        System.out.println("--------------------------------------------------------------");
    }
    //FIN administracion del postulantes

}