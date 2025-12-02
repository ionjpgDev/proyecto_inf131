package com.proyecto.proyecto_inf_131;

import com.proyecto.proyecto_inf_131.administracion.*;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class web {
    private Administracion admin = new Administracion();
    private PanelPostulante panelPostulante;
    private PanelInstructor panelInstructor;

    @GetMapping("/")
    public String index( Model module ){
        List< List<String> > lista;
        lista = List.of( List.of("Panel de Administracion","/panel_admin"),
                List.of("Panel Instructor","/panel_instructor/login"),
                List.of("Panel Alumno","/panel_alumno/login") );

        module.addAttribute( "casillas", lista );
        module.addAttribute( "paneles", lista );
        return "index";
    }

    //acciones del panel admin INICIO
    @GetMapping("/panel_admin")
    public String adminPanel( Model model ){
        List<List<String>> lista;
        lista = List.of(
                List.of("gestionar instructores","/panel_admin/gestionarInstructores"),
                List.of("gestionar postulantes","/panel_admin/gestionarPostulantes"),
                List.of("gestionar cursos","/panel_admin/gestionarCursos"));

        model.addAttribute( "casillas", lista );
        model.addAttribute( "paneles", lista );

        return "admin/adminPanel";
    }

    @GetMapping("/panel_admin/gestionarInstructores")
    public String getionarInstruc( Model model ){
        List<List<String>> lista;
        lista = List.of(
                List.of("mostrar","/panel_admin/mostrarInstructores"),
                List.of("agregar","/panel_admin/formInstructor"));

        model.addAttribute( "casillas", lista );
        model.addAttribute( "paneles", lista );

        return "admin/gestionarInstruc";
    }

    @GetMapping("/panel_admin/formInstructor")
    public String formularioInstruc( Model model ){
        List<String> datos = List.of("Nombres","Apellidos","CI", "Nombre del deporte", "Turno","Hora");
        model.addAttribute( "datos", datos);
        model.addAttribute( "ruta", "/panel_admin/agregarInstructor" );
        return "formulario";
    }

    @PostMapping("/panel_admin/agregarInstructor")
    public ResponseEntity<String> agregarInstruc( @RequestParam("Nombres") String nombre,
                                                  @RequestParam("Apellidos") String ap,
                                                  @RequestParam("CI") String ci,
                                                  @RequestParam("Nombre del deporte") String depor,
                                                  @RequestParam("Turno") String turno,
                                                  @RequestParam("Hora") String hora ){
        this.admin.agregarInstructor( new Instructor(nombre,ap,ci,depor, new Horario(turno,hora) ) );
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/panel_admin/mostrarInstructores")
    public String gestiInstrucMostrar( Model model ){
        List<Instructor> lista = new ArrayList<>();
        ColaInstructor tmpCola = new ColaInstructor();
        Instructor tmp;

        while ( ! admin.getInstructores().isVacia()  ){
            tmp = this.admin.getInstructores().eliminar();
            tmpCola.agregar( tmp );
            lista.add( tmp );
        }
        this.admin.getInstructores().vaciar( tmpCola );

        model.addAttribute( "data", List.of("nombres","apellidos","ci") );
        model.addAttribute("personas", lista);
        model.addAttribute( "enlace_ver","/panel_admin/verInstructor" );
        model.addAttribute( "enlace_eliminar","/panel_admin/eliminarInstructor" );
        return "admin/mostrarPersonas";
    }

    @GetMapping("/panel_admin/gestionarPostulantes")
    public String getionarPostulante( Model model ){
        List<List<String>> lista;
        lista = List.of(
                List.of("mostrar","/panel_admin/mostrarPostulantes"),
                List.of("agregar","/panel_admin/formPostulante"));

        model.addAttribute( "casillas", lista );
        model.addAttribute( "paneles", lista );

        return "admin/gestionarPostu";
    }

    @GetMapping("/panel_admin/mostrarPostulantes")
    public String gestiPostuMostrar( Model model ){
        List<Postulante> lista = new ArrayList<>();
        PilaPostulante tmpCola = new PilaPostulante();
        Postulante tmp;

        while ( ! admin.getPostulantes().isVacia()  ){
            tmp = this.admin.getPostulantes().eliminar();
            tmpCola.agregar( tmp );
            lista.add( tmp );
        }
        this.admin.getPostulantes().vaciar( tmpCola );

        model.addAttribute( "data", List.of("nombres","apellidos","ci") );
        model.addAttribute("personas", lista);
        model.addAttribute( "enlace_ver", "/panel_admin/verPostulante" );
        model.addAttribute( "enlace_eliminar", "/panel_admin/eliminarPostulante" );
        return "admin/mostrarPersonas";
    }

    @GetMapping("/panel_admin/formPostulante")
    public String formularioPostulante( Model model ){
        //String nombres, String apellidos, String ci, String celular, String matriculaUniv, String correo, String facultad, String carrera, String primerIngreso, Horario horario, String tipoDeSeguro, String enfermedadDeBase, String nombreDeporte
        List<String> datos = List.of("Nombres","Apellidos","CI", "celular",  "matriculaUniv", "correo", "facultad", "carrera", "primerIngreso", "turno","hora", "tipoDeSeguro", "enfermedadDeBase", "nombreDeporte");
        model.addAttribute( "datos", datos);
        model.addAttribute( "ruta", "/panel_admin/agregarPostulante" );
        return "formulario";
    }

    @PostMapping("/panel_admin/agregarPostulante")
    public ResponseEntity<String> agregarPostulante( @RequestParam("Nombres") String nombre,
                                                  @RequestParam("Apellidos") String ap,
                                                  @RequestParam("CI") String ci,
                                                  @RequestParam("celular") String celular,
                                                  @RequestParam("matriculaUniv") String matriculaUniv,
                                                  @RequestParam("correo") String correo,
                                                  @RequestParam("facultad") String facultad,
                                                  @RequestParam("carrera") String carrera,
                                                  @RequestParam("primerIngreso") String primerIngreso,
                                                  @RequestParam("turno") String turno,
                                                  @RequestParam("hora") String hora,
                                                  @RequestParam("tipoDeSeguro") String tipoDeSeguro,
                                                  @RequestParam("enfermedadDeBase") String enfermedadDeBase,
                                                  @RequestParam("nombreDeporte") String depor){
        this.admin.inscribirPostulante( new Postulante( nombre,ap,ci,celular,matriculaUniv,correo,facultad,carrera,
                                                    primerIngreso,new Horario(turno, hora ),tipoDeSeguro,enfermedadDeBase,depor) );
        this.admin.mostrarPostulantes();
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/panel_admin/gestionarCursos")
    public String getionarCursos( Model model ){
        List<List<String>> lista;
        lista = List.of(
                List.of("mostrar","/panel_admin/mostrarCursos"),
                List.of("agregar","/panel_admin/formCurso"));

        model.addAttribute( "casillas", lista );
        model.addAttribute( "paneles", lista );

        return "admin/gestionarPostu";
    }

    @GetMapping("/panel_admin/mostrarCursos")
    public String gestiCursosMostrar( Model model ){
        List<Curso> lista = new ArrayList<>();
        ColaCurso tmpCola = new ColaCurso();
        Curso tmp;

        while ( ! admin.getCursos().isVacia() ){
            tmp = this.admin.getCursos().eliminar();
            tmpCola.agregar( tmp );
            lista.add( tmp );
        }
        this.admin.getCursos().vaciar( tmpCola );

        model.addAttribute( "data", List.of("nombre","horario","cupos","tiempo (dias)") );
        model.addAttribute("cursos", lista);
        model.addAttribute( "enlace_ver","/panel_admin/verCurso" );
        model.addAttribute( "enlace_eliminar","/panel_admin/eliminarCurso" );
        return "admin/mostrarCursos";
    }

    @GetMapping("/panel_admin/eliminarInstructor")
    public ResponseEntity<String> eliminarInstructor( @RequestParam("ci") String ci, Model model ){

        this.admin.eliminarInstructor( ci );
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/panel_admin/verInstructor")
    public String verInstructor( @RequestParam("ci") String ci, Model model ){
        Instructor item = this.admin.verInstructor( ci );


        model.addAttribute( "data",List.of( "nombres","apellidos", "ci", "deporte", "horario") );
        model.addAttribute( "cuerpo", List.of( item.getNombres(), item.getApellidos(), item.getCi(), item.getNombreDeporte(),item.getHorario()  ) );

        return "ver";
    }

    @GetMapping("/panel_admin/eliminarPostulante")
    public ResponseEntity<String> eliminarPostulante( @RequestParam("ci") String ci, Model model ){

        this.admin.eliminarPostulante( ci );
        this.admin.mostrarPostulantes();
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/panel_admin/verPostulante")
    public String verPostulante( @RequestParam("ci") String ci, Model model ){
        Postulante item = this.admin.verPostulante( ci );

        model.addAttribute( "data",List.of( "nombres","apellidos", "ci", "matricula", "deporte", "celular", "facultad", "carrera", "correo","enfermedad","primer ingreso","seguro", "horario") );
        model.addAttribute( "cuerpo", List.of( item.getNombres(), item.getApellidos(), item.getCi(), item.getRequisitos().getMatriculaUniv(), item.getRequisitos().getNombreDeporte(),
                item.getRequisitos().getCelular(), item.getRequisitos().getFacultad(), item.getRequisitos().getCarrera(), item.getRequisitos().getCorreo(),
                item.getRequisitos().getEnfermedadDeBase(), item.getRequisitos().getPrimerIngreso(), item.getRequisitos().getTipoDeSeguro(), item.getRequisitos().getHorario() ) );

        return "ver";
    }

    @GetMapping("/panel_admin/verCurso")
    public String verCurso(@RequestParam("deporte") String depo,
            @RequestParam("disponible") String disponible,
            @RequestParam("cupos") String cupos,
            @RequestParam("instructor") String instruc,
            @RequestParam("clases") String clases,
            @RequestParam("turno") String turno,
            @RequestParam("hora") String hora, Model model ){

        model.addAttribute( "data", List.of("nombre Deporte", "cupos disponibles", "cupos", "instructor","clases (dias)","turno","hora") );
        model.addAttribute( "cuerpo", List.of(depo, disponible, cupos, instruc, clases,turno,hora) );
        return  "ver";
    }

    @GetMapping("/panel_admin/eliminarCurso")
    public ResponseEntity<String> eliminarCurso(@RequestParam("deporte") String depo,
                                @RequestParam("turno") String turno,
                                @RequestParam("hora") String hora ) {
        this.admin.eliminarCurso( depo, new Horario(turno,hora) );
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/panel_admin/formCurso")
    public String formularioCurso( Model model ){
        //String nombre, int cupos, Horario horario, int nroClases
        List<String> datos = List.of( "nombre", "cupos", "turno", "hora", "nroClases");
        model.addAttribute( "datos", datos);
        model.addAttribute( "ruta", "/panel_admin/agregarCurso" );
        return "formulario";
    }

    @PostMapping("/panel_admin/agregarCurso")
    public ResponseEntity<String> agregarCurso( @RequestParam("nombre") String depor,
                                                @RequestParam("cupos") String cupos,
                                                @RequestParam("turno") String turno,
                                                @RequestParam("hora") String hora,
                                                @RequestParam("nroClases") String clases){
        this.admin.crearCurso( new Curso( depor, Integer.parseInt( cupos ), new Horario(turno, hora ), Integer.parseInt( clases ) ) );
        return ResponseEntity.ok("ok");
    }


    //acciones del panel admin FIN

    //panel instructor INICIO
    @GetMapping("/panel_instructor")
    public String instrucPanel( Model model ){
        List<List<String>> lista;
        lista = List.of(
                List.of("ver perfil","/panel_instructor/perfil"),
                List.of("editar datos personales","/panel_instructor/editarPerfil"));

        model.addAttribute( "casillas", lista );
        model.addAttribute( "paneles", lista );

        return "instrucPanel";
    }

    @GetMapping("/panel_instructor/login")
    public String instrucLogin( Model model ){
        model.addAttribute( "datos", List.of("nombres","apellidos","ci" ) );
        model.addAttribute( "ruta", "/panel_instructor/verificar" );
        return "formulario";
    }

    @PostMapping("/panel_instructor/verificar")
    public String verificarInstruc( @RequestParam("nombres") String nombres,
                             @RequestParam("apellidos") String apellidos,
                             @RequestParam("ci") String ci ){
        this.panelInstructor = new PanelInstructor();
        if( this.panelInstructor.login( nombres, apellidos, ci, this.admin.getInstructores() ) )
            return "redirect:/panel_instructor";
        return "redirect:/panel_instructor/login";
    }


    @GetMapping("/panel_instructor/perfil")
    public String perfilInstruc( Model model ){
        Instructor item = this.panelInstructor.getInstructor();

        model.addAttribute( "data",List.of( "nombres","apellidos", "ci", "nombreDeporte", "horario") );
        model.addAttribute( "cuerpo", List.of(  item.getNombres(), item.getApellidos(), item.getCi(), item.getNombreDeporte(),
                item.getHorario() ) );

        return "ver";
    }

    @GetMapping("/panel_instructor/editarPerfil")
    public String editarInstruc( Model model ){
        model.addAttribute( "datos", List.of( List.of( "nombres", this.panelInstructor.getInstructor().getNombres()),
                List.of( "apellidos", this.panelInstructor.getInstructor().getApellidos()),
                List.of( "ci", this.panelInstructor.getInstructor().getCi()),
                List.of( "nombreDeporte", this.panelInstructor.getInstructor().getNombreDeporte()),
                List.of( "turno", this.panelInstructor.getInstructor().getHorario().getTurno()),
                List.of( "hora", this.panelInstructor.getInstructor().getHorario().getHora() ) ) );
        model.addAttribute( "ruta", "/panel_instructor/editar" );
        return "editar";
    }

    @PostMapping("/panel_instructor/editar")
    public String editarInstruc( @RequestParam("nombres") String nombre,
                                @RequestParam("apellidos") String apellidos,
                                @RequestParam("ci") String ci,
                                 @RequestParam("nombreDeporte") String depor,
                                 @RequestParam("turno") String turno,
                                 @RequestParam("hora") String hora ){
            this.panelInstructor.getInstructor().setNombres( nombre );
            this.panelInstructor.getInstructor().setApellidos( apellidos );
            this.panelInstructor.getInstructor().setCi( ci );
            this.panelInstructor.getInstructor().setNombreDeporte( depor );
            this.panelInstructor.getInstructor().getHorario().setTurno( turno );
            this.panelInstructor.getInstructor().getHorario().setHora( hora );

        return "redirect:/panel_instructor";
    }
    //panel instructor FIN

    //panel alumno INICIO
    @GetMapping("/panel_alumno")
    public String alumnPanel( Model model ){
        List<List<String>> lista;
        lista = List.of(
                List.of("ver perfil","/panel_alumno/perfil"),
                List.of("editar datos personales","/panel_alumno/editarPerfil"),
                List.of("editar requisitos","/panel_alumno/editarRequisitos"));

        model.addAttribute( "casillas", lista );
        model.addAttribute( "paneles", lista );

        return "alumnPanel";
    }

    @GetMapping("/panel_alumno/login")
    public String loginAlumno( Model model ){
        model.addAttribute( "datos", List.of("nombres","apellidos","ci" ) );
        model.addAttribute( "ruta", "/panel_alumno/verificar" );
        return "formulario";
    }

    @PostMapping("/panel_alumno/verificar")
    public String verificar( @RequestParam("nombres") String nombres,
                             @RequestParam("apellidos") String apellidos,
                             @RequestParam("ci") String ci ){
        this.panelPostulante = new PanelPostulante();
        if( this.panelPostulante.login( nombres, apellidos, ci, this.admin.getPostulantes() ) )
            return "redirect:/panel_alumno";
        return "redirect:/panel_alumno/login";
    }

    @GetMapping("/panel_alumno/perfil")
    public String perfilAlumno( Model model ){
        Postulante item = this.panelPostulante.getUsr();

        model.addAttribute( "data",List.of( "nombres","apellidos", "ci", "matricula", "deporte", "celular", "facultad", "carrera", "correo","enfermedad","primer ingreso","seguro", "horario") );
        model.addAttribute( "cuerpo", List.of( item.getNombres(), item.getApellidos(), item.getCi(), item.getRequisitos().getMatriculaUniv(), item.getRequisitos().getNombreDeporte(),
                item.getRequisitos().getCelular(), item.getRequisitos().getFacultad(), item.getRequisitos().getCarrera(), item.getRequisitos().getCorreo(),
                item.getRequisitos().getEnfermedadDeBase(), item.getRequisitos().getPrimerIngreso(), item.getRequisitos().getTipoDeSeguro(), item.getRequisitos().getHorario() ) );

        return "ver";
    }

    @GetMapping("/panel_alumno/editarPerfil")
    public String editarAlumno( Model model ){

        model.addAttribute( "datos", List.of( List.of( "nombres", this.panelPostulante.getUsr().getNombres()),
                List.of( "apellidos", this.panelPostulante.getUsr().getApellidos()),
                List.of( "ci", this.panelPostulante.getUsr().getCi()) ) );
        model.addAttribute( "ruta", "/panel_alumno/editar" );
        return "editar";
    }

    @PostMapping("/panel_alumno/editar")
    public String editarAlumno( @RequestParam("nombres") String nombre,
                                @RequestParam("apellidos") String apellidos,
                                @RequestParam("ci") String ci ){
        if ( !this.panelPostulante.getUsr().getNombres().equals( "" ) )
            this.panelPostulante.getUsr().setNombres( nombre );

        if ( !this.panelPostulante.getUsr().getApellidos().equals( "" ) )
            this.panelPostulante.getUsr().setApellidos( apellidos );

        if ( !this.panelPostulante.getUsr().getCi().equals( "" ) )
            this.panelPostulante.getUsr().setCi( ci );

        return "redirect:/panel_alumno";
    }

    @GetMapping("/panel_alumno/editarRequisitos")
    public String editarReq( Model model ){
        model.addAttribute( "datos",
                List.of( List.of( "matricula", this.panelPostulante.getUsr().getRequisitos().getMatriculaUniv() ),
                List.of( "deporte", this.panelPostulante.getUsr().getRequisitos().getNombreDeporte() ),
                List.of( "celular", this.panelPostulante.getUsr().getRequisitos().getCelular() ),
                List.of( "facultad", this.panelPostulante.getUsr().getRequisitos().getFacultad() ),
                List.of( "carrera", this.panelPostulante.getUsr().getRequisitos().getCarrera() ),
                List.of( "correo", this.panelPostulante.getUsr().getRequisitos().getCorreo() ),
                List.of( "enfermedad", this.panelPostulante.getUsr().getRequisitos().getEnfermedadDeBase() ),
                List.of( "primerIngreso", this.panelPostulante.getUsr().getRequisitos().getPrimerIngreso() ),
                List.of( "seguro", this.panelPostulante.getUsr().getRequisitos().getTipoDeSeguro() ),
                List.of( "turno", this.panelPostulante.getUsr().getRequisitos().getHorario().getTurno() ),
                List.of( "hora", this.panelPostulante.getUsr().getRequisitos().getHorario().getHora() ) ));
        model.addAttribute( "ruta", "/panel_alumno/editarReq" );
        return "editar";
    }

    @PostMapping("/panel_alumno/editarReq")
    public String editarReq( @RequestParam("celular") String celular,
                             @RequestParam("matricula") String matriculaUniv,
                             @RequestParam("correo") String correo,
                             @RequestParam("facultad") String facultad,
                             @RequestParam("carrera") String carrera,
                             @RequestParam("primerIngreso") String primerIngreso,
                             @RequestParam("turno") String turno,
                             @RequestParam("hora") String hora,
                             @RequestParam("seguro") String tipoDeSeguro,
                             @RequestParam("enfermedad") String enfermedadDeBase,
                             @RequestParam("deporte") String depor ){

        this.panelPostulante.getUsr().getRequisitos().setCelular( celular );
        this.panelPostulante.getUsr().getRequisitos().setMatriculaUniv( matriculaUniv );
        this.panelPostulante.getUsr().getRequisitos().setCorreo( correo );
        this.panelPostulante.getUsr().getRequisitos().setFacultad( facultad );
        this.panelPostulante.getUsr().getRequisitos().setCarrera( carrera );
        this.panelPostulante.getUsr().getRequisitos().setPrimerIngreso( primerIngreso );
        this.panelPostulante.getUsr().getRequisitos().getHorario().setTurno( turno );
        this.panelPostulante.getUsr().getRequisitos().getHorario().setHora( hora );
        this.panelPostulante.getUsr().getRequisitos().setTipoDeSeguro( tipoDeSeguro );
        this.panelPostulante.getUsr().getRequisitos().setEnfermedadDeBase( enfermedadDeBase );
        this.panelPostulante.getUsr().getRequisitos().setNombreDeporte( depor );

        return "redirect:/panel_alumno";
    }

//panel alumno FIN
   @GetMapping("/test")
    public String test(){
        return "test";
    }

}
