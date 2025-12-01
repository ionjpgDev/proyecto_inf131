package com.proyecto.proyecto_inf_131;

import com.proyecto.proyecto_inf_131.administracion.*;
import org.apache.catalina.webresources.ClasspathURLStreamHandler;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.util.comparator.InstanceComparator;
import org.yaml.snakeyaml.nodes.ScalarNode;

import java.sql.SQLOutput;
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
        //this.acciones();
    }

    private void datosPrb(){
        this.crearCurso( new Curso( "fut", 21,new Horario("tarde","15:00"),10 ) );
        this.crearCurso( new Curso( "bas", 21,new Horario("tarde","16:00"), 5 ) );
        this.crearCurso( new Curso( "natacion", 21,new Horario("noche","21:00"), 15 ) );

        this.agregarPostulante( new Postulante( "nom1","ape1","ci1","cel1","matri1","c@rreo","fal1","carr1","no",new Horario("tarde","16:00"),"publico","no","bas" ) );
        this.agregarPostulante( new Postulante( "nom2","ape2","ci2","cel1","matri2","c@rreo","fal1","carr1","no",new Horario("noche","21:00"),"publico","no", "natacion" ) );
        this.agregarPostulante( new Postulante( "nom3","ape3","ci3","cel1","matri3","c@rreo","fal1","carr1","no",new Horario("tarde","15:00"),"publico","no", "fut" ) );

        this.agregarInstructor( new Instructor( "freddy","mercury","123", "fut",new Horario("tarde","15:00") ) );
        this.agregarInstructor( new Instructor( "mick","marciano","124","natacion",new Horario("noche","21:00") ) );
        this.agregarInstructor( new Instructor( "axl","rosas","125","bas",new Horario("tarde","16:00") ) );

    }
    public void acciones(){//muestra de como funcionaria el sistema
        while ( v ) {
            System.out.print("-----ADMINISTRAR-----\n1 -> instructores\n2 -> postulantes\n3 -> cursos\n0 -> salir\n/ $> ");
            switch ( leer.nextLine() ){
                case "0": v= false ;break;
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
            System.out.print("-----Cursos-----\n 1 -> mostrar cursos\n 2 -> crear curso\n 3 -> ver curso\n 4 -> eliminar curso \n 0 -> salir\n"+ ruta +" $> ");
            switch ( leer.nextLine() ){
                case "0": v= false ;break;
                case "1": this.mostrarCursos(); break;
                case "2": this.crearCurso( new Curso() ); break;
                case "3": this.verCurso(); break;
                case "4": this.eliminarCurso(); break;
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
    private Curso buscarCurso(){
        Scanner leer = new Scanner( System.in );

        System.out.print("nombre de deporte: ");
        String nombreDeporte = leer.nextLine();
        Horario horario = new Horario();

        ColaCurso tmp = new ColaCurso();
        Curso devolver = null;

        while ( ! this.cursos.isVacia() ){
            Curso item = this.cursos.eliminar();
            tmp.agregar( item );

            if ( item.getHorario().igual( horario ) && item.getNombreDeporte().equals( nombreDeporte ) )
                devolver = item;
        }

        this.cursos.vaciar( tmp );

        return devolver;
    }
    private Curso buscarCurso( String nombreDeporte, Horario horario ){
        ColaCurso tmp = new ColaCurso();
        Curso devolver = null;

        while ( ! this.cursos.isVacia() ){
            Curso item = this.cursos.eliminar();
            tmp.agregar( item );

            if ( item.getHorario().igual( horario ) && item.getNombreDeporte().equals( nombreDeporte ) )
                devolver = item;
        }

        this.cursos.vaciar( tmp );

        return devolver;
    }
    public void verCurso( ){
        Curso item = this.buscarCurso();
        if ( item != null )
            item.mostrarTodo();
    }
    public void eliminarCurso(){
        Curso eliminar = this.buscarCurso();
        ColaCurso tmpCurso = new ColaCurso();

        while ( ! this.cursos.isVacia() && eliminar != null ){
            Curso item = this.cursos.eliminar();

            if ( eliminar != item ) // no agrega a la lista el curso a eliminar
                tmpCurso.agregar( item );
            else { //de cada lista de cursos que tienen los instructores elimina el curso seleccionado
                ColaInstructor tmpInstructor = new ColaInstructor();

                while( ! this.instructores.isVacia() ){
                    Instructor itemInstructor = this.instructores.eliminar();
                    tmpInstructor.agregar( itemInstructor );

                    ColaCurso tmpInstructorCursos = new ColaCurso();
                    while( ! itemInstructor.getCursos().isVacia() ){
                        Curso itemCurso = itemInstructor.getCursos().eliminar();

                        if ( eliminar != itemCurso ) // no agrega a la lista del instructor el elemento a eliminar
                            tmpInstructorCursos.agregar( itemCurso );
                    }
                    itemInstructor.getCursos().vaciar( tmpInstructorCursos );

                }
                this.instructores.vaciar( tmpInstructor );

            }
        }

        this.cursos.vaciar( tmpCurso );
    }
    public void eliminarCurso( String nombreDeporte, Horario horario ){
        Curso eliminar = this.buscarCurso( nombreDeporte, horario );
        ColaCurso tmpCurso = new ColaCurso();

        while ( ! this.cursos.isVacia() && eliminar != null ){
            Curso item = this.cursos.eliminar();

            if ( eliminar != item ) // no agrega a la lista el curso a eliminar
                tmpCurso.agregar( item );
            else { //de cada lista de cursos que tienen los instructores elimina el curso seleccionado
                ColaInstructor tmpInstructor = new ColaInstructor();

                while( ! this.instructores.isVacia() ){
                    Instructor itemInstructor = this.instructores.eliminar();
                    tmpInstructor.agregar( itemInstructor );

                    ColaCurso tmpInstructorCursos = new ColaCurso();
                    while( ! itemInstructor.getCursos().isVacia() ){
                        Curso itemCurso = itemInstructor.getCursos().eliminar();

                        if ( eliminar != itemCurso ) // no agrega a la lista del instructor el elemento a eliminar
                            tmpInstructorCursos.agregar( itemCurso );
                    }
                    itemInstructor.getCursos().vaciar( tmpInstructorCursos );

                }
                this.instructores.vaciar( tmpInstructor );

            }
        }

        this.cursos.vaciar( tmpCurso );
    }
    //FIN administracion del Cursos

    //INICIO administracion del Instructores
    public void accionesInstructores( String ruta ){
        v = true;

        while( v ){
            System.out.print("-----Instructores-----\n 1 -> mostrar instructores\n 2 -> agregar instructor\n 3 -> ver instructor\n 4 -> eliminar instructor\n 0 -> salir\n "+ ruta + " $> ");
            switch ( leer.nextLine() ){
                case "0": v= false ;break;
                case "1": this.mostrarInstructores(); break;
                case "2": this.agregarInstructor( new Instructor() ); break;
                case "3": this.verInstructor( ); break;
                case "4": this.eliminarInstructor( ); break;
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

            if ( curso.getNombreDeporte().equals( item.getNombreDeporte() )
                    && item.getHorario().igual( curso.getHorario() ) ){
                curso.setInstructor( item );
                item.agregarCurso( curso );//agrega Curso a la lista de cursos de Instructor
            }

        }

        this.cursos.vaciar( tmpCola );
    }
    public void mostrarInstructores(){
        System.out.println("-----lista-De-Instructores-a-las-escuelas-deportivas-UMSA------");
        this.instructores.mostrar();
        System.out.println("--------------------------------------------------------------");
    }
    public Instructor buscarInstructor(){
        Scanner leer = new Scanner( System.in );

        System.out.print("ci del instructor: ");
        String ci = leer.nextLine();

        Instructor devolver = null;
        ColaInstructor tmp = new ColaInstructor();

        while ( ! this.instructores.isVacia() ){
            Instructor item = this.instructores.eliminar();
            tmp.agregar( item );

            if ( item.getCi().equals( ci ) )
                devolver = item;
        }
        this.instructores.vaciar( tmp );

        return devolver;
    }
    public Instructor buscarInstructor( String ci ){
        Instructor devolver = null;
        ColaInstructor tmp = new ColaInstructor();

        while ( ! this.instructores.isVacia() ){
            Instructor item = this.instructores.eliminar();
            tmp.agregar( item );

            if ( item.getCi().equals( ci ) )
                devolver = item;
        }
        this.instructores.vaciar( tmp );

        return devolver;
    }
    public void verInstructor(){
        Instructor item = this.buscarInstructor();

        if( item != null )
            item.mostrarTodo();
    }
    public Instructor verInstructor( String ci ){
        Instructor item = this.buscarInstructor( ci );

        return item;
    }
    public void eliminarInstructor(){
        Instructor itemInstructor = this.buscarInstructor();
        ColaInstructor tmpIns = new ColaInstructor();

        while ( ! this.instructores.isVacia() && itemInstructor != null ){
            Instructor item = this.instructores.eliminar();

            if ( item != itemInstructor )
                tmpIns.agregar( item );
            else{
                ColaCurso tmpCur = new ColaCurso();

                while ( ! this.cursos.isVacia() ) {
                    Curso itemCurso = this.cursos.eliminar();
                    tmpCur.agregar( itemCurso );

                    if( itemCurso.getInstructor().igual( item ) )
                        itemCurso.setInstructor( "","","" );
                }

                this.cursos.vaciar( tmpCur );
            }
        }
        this.instructores.vaciar( tmpIns );
    }
    public void eliminarInstructor( String ci ){
        Instructor itemInstructor = this.buscarInstructor( ci );
        ColaInstructor tmpIns = new ColaInstructor();

        while ( ! this.instructores.isVacia() && itemInstructor != null ){
            Instructor item = this.instructores.eliminar();

            if ( item != itemInstructor )
                tmpIns.agregar( item );
            else{
                ColaCurso tmpCur = new ColaCurso();

                while ( ! this.cursos.isVacia() ) {
                    Curso itemCurso = this.cursos.eliminar();
                    tmpCur.agregar( itemCurso );

                    if( itemCurso.getInstructor().igual( item ) )
                        itemCurso.setInstructor( "","","" );
                }

                this.cursos.vaciar( tmpCur );
            }
        }
        this.instructores.vaciar( tmpIns );
    }
    //FIN administracion del Instructores

    //INICIO administracion del postulantes
    public void accionesPostulantes( String ruta ){
        v = true;

        while( v ){
            System.out.print("-----Postulantes-----\n 1 -> mostrar postulantes\n 2 -> agregar postulante\n 3 -> buscar postulante\n 4 -> eliminar postulante\n 0 -> salir\n"+ ruta +" $> ");
            switch ( leer.nextLine() ){
                case "0": v= false ;break;
                case "1": this.mostrarPostulantes(); break;
                case "2":{
                    Postulante item = new Postulante( );

                    this.agregarPostulante( item );
                    break;
                }
                case "3": this.buscarPostulante();break;
                case "4": this.eliminarPostulante();break;
                default: break;
            }
        }

        v = true;
    }
    public void agregarPostulante( Postulante item ){
        ColaCurso tmpCola = new ColaCurso();//agregar postulante a las listas de forma dinamica
        while ( ! this.cursos.isVacia() ){
            Curso curso = this.cursos.eliminar();
            tmpCola.agregar( curso );

            if( curso.getHorario().igual( item.getRequisitos().getHorario() )
                    && curso.getNombreDeporte().equals( item.getRequisitos().getNombreDeporte() ) ){

                if ( ! curso.inscribir( item ) )//si la condicion es true no agrego
                    this.postulantes.agregar( item );// lista general de todos los inscritos
            }

        }

        this.cursos.vaciar( tmpCola );


    }
    public void mostrarPostulantes(){
        System.out.println("-----lista-De-Postulantes-a-las-escuelas-deportivas-UMSA------");
        this.postulantes.mostrar();
        System.out.println("--------------------------------------------------------------");
    }
    public void inscribirPostulante( Postulante item ){
        this.postulantes.agregar( item );
    }
    private Postulante buscarPostulante(){
        Scanner leer = new Scanner( System.in );

        System.out.print("ingrese del CI del estudiante a buscar: ");
        String ci = leer.nextLine();

        PilaPostulante tmp = new PilaPostulante();
        Postulante devolver = null;

        while( !this.postulantes.isVacia() ){
            Postulante item = this.postulantes.eliminar();
            tmp.agregar( item );

            if ( item.getCi().equals( ci ) )
                devolver = item;
        }

        this.postulantes.vaciar( tmp );

        return devolver;
    }
    private Postulante buscarPostulante( String ci ){
        PilaPostulante tmp = new PilaPostulante();
        Postulante devolver = null;

        while( !this.postulantes.isVacia() ){
            Postulante item = this.postulantes.eliminar();
            tmp.agregar( item );

            if ( item.getCi().equals( ci ) )
                devolver = item;
        }

        this.postulantes.vaciar( tmp );

        return devolver;
    }
    public void verPostulante() {
        Postulante item = this.buscarPostulante();
        if( item != null )
            item.mostrarTodo();
    }
    public Postulante verPostulante( String ci ) {
        Postulante item = this.buscarPostulante( ci );
        return item ;
    }
    public void eliminarPostulante(){
        PilaPostulante tmpPostulate = new PilaPostulante();
        Postulante itemPostulante = this.buscarPostulante(); // ingresar por entrada estandar al postulante a eliminar

        while ( ! this.postulantes.isVacia() && itemPostulante != null ){
            Postulante item = this.postulantes.eliminar();

            if( itemPostulante != item ) // no agrega al postulante buscado
                tmpPostulate.agregar( itemPostulante );//lista general
            else{//buscar en los cursos al postulante
                ColaCurso tmpCcurso = new ColaCurso();

                while ( !this.cursos.isVacia() ){
                    Curso itemCurso = this.cursos.eliminar();
                    tmpCcurso.agregar( itemCurso );

                    itemCurso.darDeBaja( item.getCi() );//lista secundaria
                }

                this.cursos.vaciar( tmpCcurso );
            }
        }

        this.postulantes.vaciar( tmpPostulate );


    }
    public void eliminarPostulante( String ci ){
        PilaPostulante tmpPostulate = new PilaPostulante();
        Postulante itemPostulante = this.buscarPostulante( ci );

        while ( ! this.postulantes.isVacia() && itemPostulante != null ){
            Postulante item = this.postulantes.eliminar();

            if( itemPostulante != item ) // no agrega al postulante buscado
                tmpPostulate.agregar( item );//lista general
            else{//buscar en los cursos al postulante
                ColaCurso tmpCcurso = new ColaCurso();

                while ( !this.cursos.isVacia() ){
                    Curso itemCurso = this.cursos.eliminar();
                    tmpCcurso.agregar( itemCurso );

                    itemCurso.darDeBaja( item.getCi() );//lista secundaria
                }

                this.cursos.vaciar( tmpCcurso );
            }
        }

        this.postulantes.vaciar( tmpPostulate );


    }
    //FIN administracion del postulantes


    public ColaInstructor getInstructores() {
        return instructores;
    }

    public ColaCurso getCursos() {
        return cursos;
    }

    public PilaPostulante getPostulantes() {
        return postulantes;
    }
}