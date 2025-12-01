package com.proyecto.proyecto_inf_131;

import com.proyecto.proyecto_inf_131.administracion.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class web {
    private Administracion admin = new Administracion();

    @GetMapping("/")
    public String index( Model module ){
        List< List<String> > lista;
        lista = List.of( List.of("Panel de Administracion","/panel_admin"),
                List.of("Panel Instructor","/panel_instructor"),
                List.of("Panel Alumno","/panel_alumno") );

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
                List.of("gestionar cusos","/panel_admin/gestionarCursos"));

        model.addAttribute( "casillas", lista );
        model.addAttribute( "paneles", lista );

        return "admin/adminPanel";
    }

    @GetMapping("/panel_admin/gestionarInstructores")
    public String getionarInstruc( Model model ){
        List<List<String>> lista;
        lista = List.of(
                List.of("mostrar","/panel_admin/mostrarInstructores"),
                List.of("agregar","test"),
                List.of("buscar","test"),
                List.of("eliminar","test"));

        model.addAttribute( "casillas", lista );
        model.addAttribute( "paneles", lista );

        return "admin/gestionarInstruc";
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
        return "admin/mostrarPersonas";
    }

    @GetMapping("/panel_admin/gestionarPostulantes")
    public String getionarPostulante( Model model ){
        List<List<String>> lista;
        lista = List.of(
                List.of("mostrar","/panel_admin/mostrarPostulantes"),
                List.of("agregar","test"),
                List.of("buscar","test"),
                List.of("eliminar","test"));

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
        return "admin/mostrarPersonas";
    }

    @GetMapping("/panel_admin/gestionarCursos")
    public String getionarCursos( Model model ){
        List<List<String>> lista;
        lista = List.of(
                List.of("mostrar","/panel_admin/mostrarCursos"),
                List.of("agregar","test"),
                List.of("buscar","test"),
                List.of("eliminar","test"));

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
        return "admin/mostrarCursos";
    }

    @GetMapping("/form")
    public String formulario( Model model ){
        List<String> datos = List.of("Nombres","Apellidos","CI");
        model.addAttribute( "datos", datos);
        return "formulario";
    }
    //acciones del panel admin FIN

    @GetMapping("/panel_instructor")
    public String instrucPanel(){
        return "instrucPanel";
    }

    @GetMapping("/panel_alumno")
    public String alumnPanel(){
        return "alumnPanel";
    }

   @GetMapping("/test")
    public String test(){
        return "test";
    }

}
