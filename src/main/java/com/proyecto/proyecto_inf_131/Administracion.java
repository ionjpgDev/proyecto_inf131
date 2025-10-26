package com.proyecto.proyecto_inf_131;

import com.proyecto.proyecto_inf_131.administracion.*;
import com.proyecto.proyecto_inf_131.torneo.*;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.yaml.snakeyaml.nodes.ScalarNode;

import java.util.Scanner;

public class Administracion {
    private PilaPostulante postulantes;
    private ColaInstructor instructores;
    private ColaCurso cursos;
    private PilaTorneo torneos;

    //atributos necesario o son de gestion
    private Scanner leer = new Scanner( System.in );
    private boolean v = true;

    public Administracion() {
        this.postulantes = new PilaPostulante();
        this.instructores = new ColaInstructor();
        this.cursos = new ColaCurso();
        this.torneos = new PilaTorneo();

        this.datosPrb();//borrar o comentar
        this.acciones();
    }

    private void datosPrb(){
        this.agregarPostulante( new Postulante( "pedro","escamoso","000001","sep" ) );
        this.agregarPostulante( new Postulante( "mario","bros","000002","sep" ) );
        this.agregarPostulante( new Postulante( "ay","miguel","000003","sep" ) );

        this.agregarInstructor( new Instructor( "freddy","mercury","fut",new String[]{"1","21"} ) );
        this.agregarInstructor( new Instructor( "mick","marciano","natacion",new String[]{"1","21"} ) );
        this.agregarInstructor( new Instructor( "axl","rosas","bas",new String[]{"1","21"} ) );

        this.crearCurso( new Curso( "fut", 21,"" ) );
        this.crearCurso( new Curso( "bas", 21,"" ) );
        this.crearCurso( new Curso( "natacion", 21,"" ) );

        this.crearTorneo( new Torneo( "torneo1","1-2-2","21-32-23","aaaa" ) );
        this.crearTorneo( new Torneo( "torneo2","1-2-3","1-2-3","baaa" ) );
        this.crearTorneo( new Torneo( "torneo3","1-4523-23","41-121-21","caaa" ) );
    }
    private void acciones(){//muestra de como funcionaria el sistema
        while ( v ) {
            System.out.print("-----ADMINISTRAR-----\n 0 -> salir\n 1 -> instructores\n 2 -> postulantes\n 3 -> cursos\n 4 -> torneos\n / $> ");
            switch ( leer.nextLine() ){
                case "0": System.out.println("luke soy tu padre"); v= false ;break;
                case "1": this.accionesInstructores( "/instructores"); break;
                case "2": this.accionesPostulantes("/postulantes"); break;
                case "3": this.accionesCursos( "/cursos" ); break;
                case "4": this.accionesTorneo("/torneo"); break;
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
                    System.out.print("nombres: ");
                    String nombres = leer.nextLine();

                    System.out.print("apellidos: ");
                    String apellidos = leer.nextLine();

                    System.out.print("deporte: ");
                    String deporte = leer.nextLine();

                    System.out.print("fin: ");
                    String[] horaio = leer.nextLine().split( "," );


                    this.agregarInstructor( new Instructor( nombres, apellidos, deporte, horaio  ) );
                    break;
                }
                default: break;
            }
        }

        v = true;
    }
    public void agregarInstructor( Instructor item ){
        this.instructores.agregar( item );
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
                    System.out.print("nombres: ");
                    String nombres = leer.nextLine();

                    System.out.print("apellidos: ");
                    String apellidos = leer.nextLine();

                    System.out.print("matricula: ");
                    String matricula = leer.nextLine();

                    System.out.print("seguro de salud: ");
                    String seguro = leer.nextLine();

                    this.agregarPostulante( new Postulante( nombres, apellidos, matricula, apellidos ) );
                    break;
                }
                default: break;
            }
        }

        v = true;
    }
    public void agregarPostulante( Postulante item ){
        this.postulantes.agregar( item );
    }
    public void mostrarPostulantes(){
        System.out.println("-----lista-De-Postulantes-a-las-escuelas-deportivas-UMSA------");
        this.postulantes.mostrar();
        System.out.println("--------------------------------------------------------------");
    }
    //FIN administracion del postulantes

    //INICIO administracion del torneo
    public void accionesTorneo( String ruta ){
        v = true;

        while( v ){
            System.out.print("-----TORNEO-----\n 0 -> salir\n 1 -> mostrar torneo\n 2 -> crear torneo\n "+ ruta +" $> ");
            switch ( leer.nextLine() ){
                case "0": v= false ;break;
                case "1": this.mostrarTorneos(); break;
                case "2":{
                    System.out.print("nombre torneo: ");
                    String nombre = leer.nextLine();

                    System.out.print("ini: ");
                    String ini = leer.nextLine();

                    System.out.print("fin: ");
                    String fin = leer.nextLine();

                    System.out.print("detalles: ");
                    String detalles = leer.nextLine();

                    this.crearTorneo( new Torneo( nombre, ini, fin, detalles ) );
                    break;
                }
                default: break;
            }
        }

        v = true;
    }
    public void crearTorneo( Torneo item ){
        this.torneos.agregar( item );
    }
    public void mostrarTorneos(){
        System.out.println("-----Lista-De-Torneos-----------------------------------------");
        this.torneos.mostrar();
        System.out.println("--------------------------------------------------------------");
    }
    //FIN administracion del torneo
}