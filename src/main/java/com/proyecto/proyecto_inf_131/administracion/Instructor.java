package com.proyecto.proyecto_inf_131.administracion;

import com.proyecto.proyecto_inf_131.Persona;
import java.util.Arrays;
import java.util.Scanner;

public class Instructor extends Persona {
    private String nombreDeporte;
    private Horario horario;
    private ColaCurso cursos;

    public Instructor(String nombres, String apellidos, String ci, String nombreDeporte, Horario horario) {
        super(nombres, apellidos, ci );
        this.nombreDeporte = nombreDeporte;
        this.horario = horario;
        this.cursos= new ColaCurso();
    }

    public Instructor(){
        super();
        Scanner leer = new Scanner( System.in );

        System.out.print("deporte: ");
        this.nombreDeporte = leer.nextLine();

        this.horario = new Horario();
        this.cursos= new ColaCurso();
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ci='" + ci + '\'' +
                '}';
    }

    public void mostrarTodo() {
        System.out.println( "Instructor{\n" +
                "\tnombres='" + nombres + '\n' +
                "\tapellidos='" + apellidos + '\n' +
                "\tci='" + ci + '\n' +
                "\tnombreDeporte='" + nombreDeporte + '\n' +
                "\thorario=" + horario.toString() +
                '}' );
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }


    public boolean horario( Horario horario ){
        return this.horario.igual( horario );
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario( Horario horario ) {
        this.horario = horario;
    }

    public void agregarCurso( Curso item ){
        this.cursos.agregar( item );
    }
    public void calificarAsistencia(){
        Scanner leer = new Scanner( System.in );
        ColaCurso tmpCurso = new ColaCurso();
        PilaPostulante tmpPostulante = new PilaPostulante();
        String nomDeporte = "";

        System.out.println("nombre de deporte: " );
        nomDeporte = leer.nextLine();

        while ( !this.cursos.isVacia() ){
            Curso itemCurso = this.cursos.eliminar();
            tmpCurso.agregar( itemCurso );

            if ( itemCurso.getNombreDeporte().equals( nomDeporte ) ){
                while ( ! itemCurso.getInscritos().isVacia() ){
                    Postulante itemPostulante = itemCurso.getInscritos().eliminar();
                    tmpPostulante.agregar( itemPostulante );

                    System.out.println("asistio: " + itemPostulante + "\n1 -> asistio\n0 -> NO asistio");
                    if( Integer.parseInt( leer.nextLine() ) > 0  )//valores mayores a cero asistio el postulante
                        itemPostulante.setAsistencia( itemCurso.getNroClases() );

                }
                itemCurso.getInscritos().vaciar( tmpPostulante );
                break; //cuando encontramos el curso que buscamos salimos
            }
        }
        this.cursos.vaciar( tmpCurso );

    }
    public Postulante verPostulante(){
        Scanner leer = new Scanner( System.in );
        ColaCurso tmpCurso = new ColaCurso();
        PilaPostulante tmpPostulante = new PilaPostulante();
        Postulante buscar = new Postulante("","","","","","","","","",new Horario("",""),"","","");

        System.out.print("nombres: ");
        buscar.setNombres( leer.nextLine() );

        System.out.print("apellidos: ");
        buscar.setApellidos( leer.nextLine() );

        System.out.print("ci: ");
        buscar.setCi( leer.nextLine() );

        while ( !this.cursos.isVacia() ){
            Curso itemCurso = this.cursos.eliminar();
            tmpCurso.agregar( itemCurso );

            while ( !itemCurso.getInscritos().isVacia() ){
                Postulante itemPostulante = itemCurso.getInscritos().eliminar();
                tmpPostulante.agregar( itemPostulante );

                if( buscar.igual( itemPostulante ) ) {
                    buscar = itemPostulante;
                    buscar.mostrarTodo();
                    break;
                }

            }
            itemCurso.getInscritos().vaciar( tmpPostulante );
        }
        this.cursos.vaciar( tmpCurso );

        return buscar;
    }
    public void mostrarCursos(){
        this.cursos.mostrar();
    }

    public ColaCurso getCursos() {
        return cursos;
    }
}
