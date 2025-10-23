package com.proyecto.proyecto_inf_131;

import com.proyecto.proyecto_inf_131.administracion.*;

public class Administracion {
    private PilaPostulante postulantes;
    private ColaInstructor instructores;
    private ColaCurso cursos;

    public Administracion() {
        this.postulantes = new PilaPostulante();
        this.instructores = new ColaInstructor();
        this.cursos = new ColaCurso();

        this.datosPrb();//borrar o comentar
    }

    private void datosPrb(){
        this.agregarPostulante( new Postulante( "a1","","","" ) );
        this.agregarPostulante( new Postulante( "a2","","","" ) );
        this.agregarPostulante( new Postulante( "a3","","","" ) );

        this.agregarInstructor( new Instructor( "i1","","",new String[]{"",""} ) );
        this.agregarInstructor( new Instructor( "i2","","",new String[]{"",""} ) );
        this.agregarInstructor( new Instructor( "i3","","",new String[]{"",""} ) );

        this.crearCurso( new Curso( "d1", 21,"" ) );
        this.crearCurso( new Curso( "d2", 21,"" ) );
        this.crearCurso( new Curso( "d3", 21,"" ) );
    }
    public void crearCurso( Curso item ){
        this.cursos.agregar( item );
    }

    public void mostrarCursos(){
        System.out.println("-----lista-De-Cursos-de-las-escuelas-deportivas-UMSA----------");
        this.cursos.mostrar();
        System.out.println("--------------------------------------------------------------");
    }

    public void agregarInstructor( Instructor item ){
        this.instructores.agregar( item );
    }

    public void mostrarInstructores(){
        System.out.println("-----lista-De-Instructores-a-las-escuelas-deportivas-UMSA------");
        this.instructores.mostrar();
        System.out.println("--------------------------------------------------------------");
    }

    public void agregarPostulante( Postulante item ){
        this.postulantes.agregar( item );
    }
    
    public void mostrarPostulantes(){
        System.out.println("-----lista-De-Postulantes-a-las-escuelas-deportivas-UMSA------");
        this.postulantes.mostrar();
        System.out.println("--------------------------------------------------------------");
    }
}