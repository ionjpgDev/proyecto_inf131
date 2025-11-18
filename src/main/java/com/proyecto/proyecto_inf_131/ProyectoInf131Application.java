package com.proyecto.proyecto_inf_131;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.proyecto.proyecto_inf_131.administracion.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProyectoInf131Application {
    static Scanner leer = new Scanner( System.in );

	public static void main(String[] args) {
        //SpringApplication.run(ProyectoInf131Application.class, args);
        Administracion admin = new Administracion();

        boolean v = true;

        while ( v ){
            System.out.print( "-----MODO----\n1 -> admin\n2 -> instructor\n3 -> postulante?\n0 -> salir\n" +"$> " );
            switch ( leer.nextLine() ){
                case "1": admin.acciones(); break;
                case "2": {
                    PanelInstructor pI = new PanelInstructor( admin.getInstructores(), admin.getCursos() );
                    break;
                }
                case "3":{
                    PanelPostulante pP = new PanelPostulante( admin.getPostulantes() );
                    break;
                }
                case "0": System.out.println("Mich soy tu padre"); v = false; break;
                default: break;
            }
        }
	}
}