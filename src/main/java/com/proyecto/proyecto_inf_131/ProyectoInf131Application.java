package com.proyecto.proyecto_inf_131;

import com.proyecto.proyecto_inf_131.administracion.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoInf131Application {

	public static void main(String[] args) {
        //SpringApplication.run(ProyectoInf131Application.class, args);
        Administracion admin = new Administracion();
        //muestra de como funcionaria el sistema
        admin.mostrarInstructores();
        admin.mostrarPostulantes();
        admin.mostrarCursos();
	}

}
