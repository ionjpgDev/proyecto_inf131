package com.proyecto.proyecto_inf_131.administracion;

public class Curso {
    private String nombreDeporte, horario;
    private int cupos;
    private Instructor instructor;
    private PilaPostulante inscritos;

    public Curso( String nombre, int cupos, String horario ) {
        this.nombreDeporte = nombre;
        this.cupos = cupos;
        this.horario = horario;
        this.inscritos = new PilaPostulante();
        this.instructor = new Instructor( "", "", "", new String[]{""} );
    }
    public int cuposDisponibles(){
        return this.cupos - inscritos.getNroElement();
    }

    public void mostrarInscritos() {
        System.out.println( "--------------------LISTA-DE-INSCRITOS-------------------------" );
        this.inscritos.mostrar();
        System.out.println( "---------------------------------------------------------------" );
    }

   public void inscribir( Postulante item ) {
        if ( this.cuposDisponibles() <= 0)
            System.out.println("_____CUPOS__LLENOS_____");
        else
            this.inscritos.agregar( item );
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor( Instructor instructor ) {
        this.instructor = instructor;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos( int cupos ) {
        this.cupos = cupos;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario( String horario ) {
        this.horario = horario;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte( String nombreDeporte ) {
        this.nombreDeporte = nombreDeporte;
    }

    @Override
    public String toString() {
        return "\tCurso{" +
                "nombreDeporte='" + nombreDeporte + '\'' +
                ", cupos=" + cupos +
                ", horario='" + horario + '\'' +
                '}';
    }
}