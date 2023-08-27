/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umariana.laboratorio1;

import Mundo.Alumno;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Sofia Burbano
 */
public class Laboratorio1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // bandera que permite terminar el programa
      
        try ( // Funcion que permite leer la opcion del usuario
                
             Scanner lector = new Scanner (System.in )) {
             
            // bandera que permite terminar el programa
            
            boolean activo = true;
            
            // se crea el array en el que se guardara cada dato
            
            ArrayList<Alumno>misAlumnos = new ArrayList<>();
              lecturaArchivo(misAlumnos);
           
            //Utilizamos un do-while para que el menu se repita hasta que el usuario lo termine 
            //Menu de opciones
            do {
                System.out.println(" - - - - - - - Menú de opciones :) - - - - - - - -");
                System.out.println(" por favor inserte una opcion <3 ");
                System.out.println("1. Agregar alumno");
                System.out.println("2. Eliminar alumno");
                System.out.println("3. Eliminar lista de alumnos");
                System.out.println("4. Consultar alumno individual");
                 System.out.println("5. Consultar lista de alumnos");
                System.out.println("6. Modificar Alumno ");
                 System.out.println("7. Terminar programa :) ");
               
                
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - -");
                
                //definimos opcion como int 
                int opcion = lector.nextInt();
                
                //abrimos switch en el que pondremos el menu de opciones
                
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Ah elegido la opcion de Agregar Alumnos");
                         System.out.println("------------------------------------------");
                        //llamamos a la funcion  agregarAlumnos
                        agregarAlumnos(misAlumnos,lector);
                        escrituraArchivo(misAlumnos);
                        break;
                    }
                    case 2 -> {
                        System.out.println("Ah elegido la opcion de Eliminar Alumno");
                          System.out.println("------------------------------------------");
                        //llamamos a la funcion eliminarAlumnos
                        eliminarAlumnos(misAlumnos, lector);
                        escrituraArchivo(misAlumnos);
                         break;
                    }
                    case 6 ->{ System.out.println("Ah elegido la opcion de Modificar Alumnos");
                      System.out.println("------------------------------------------");
                    //llamamos a la funcion  modificarAlumnos
                    modificarAlumnos(misAlumnos, lector);
                     break;
                    }
                    case 4 -> {
                        System.out.println("Ah elegido la opcion de ver alumno individual");
                          System.out.println("------------------------------------------");
                        //llamamos a la funcion  consultarAlumnos
                       
                        consultarAlumnoIndividual(misAlumnos,lector);
                         break;
                        
                    }
                    case 3 -> {
                        
                        System.out.println("Ah elegido la opcion de El programa ha terminado:) ");
                          System.out.println("------------------------------------------");
                        activo = false;
                        // la opcion donde el programa termina
                         break;
                    }
                    case 5  -> {  System.out.println("Ah elegido la opcion de ver lista de alumnos");
                      System.out.println("------------------------------------------");
                    //llamamos a la funcion  consultarAlumnos
                    verListaAlumnos(misAlumnos); 
                     break;
                    }
                     case 7  -> {  System.out.println("Ah elegido la opcion de eliminar lista de alumnos");
                      System.out.println("------------------------------------------");
                    //llamamos a la funcion  eliminarAlumnos
                    lecturaArchivo(misAlumnos);
                    eliminarAlumnos(misAlumnos); 
                     break;
                    }
                    default -> 
                        
                        System.out.println("Debe seleccionar una de las opciones del menú, porfavor intente de nuevo");
                }
            } while (activo == true);
            //cerramos el lector
        }
    }
    
     
    /**
     * ELIMINAR ALUMNO
     * @param misAlumnos
     * @param lector 
     */
    //eliminarAlumnos
    
    public static void eliminarAlumnos (ArrayList<Alumno>misAlumnos,Scanner lector) {
        
        System.out.println("Ingrese la C.C del alumno que desea eliminar");
        
        String cedulaEliminar = lector.next();
        // if con empty para ver si esta vacio
        if (!misAlumnos.isEmpty())  {
            //Pedimos la cedula del alumno
            //se guarda la cedula en la variable cedula eliminar 
            String eliminarCedula = lector.next();
            boolean verificar = false;
            
            //creamos el ciclo for para que recorra el array 
            
            for (Alumno estudiante: misAlumnos) {
                // el condicional para determinar que no exista una cedula duplicada
                if(eliminarCedula.equals(estudiante.getCedula())) {
                    
                    //eliminamos al estudiante 
                    misAlumnos.remove(estudiante);
                    
                    System.out.println("Se ha eliminado el alumno :) ");
                    
                    verificar= true;
                    break;
                }
            }
            
        } else { 
            //mensaje que se indica si en el recorrido del array no se encuentra la cedula digitada
             System.out.println("Ups, no hay estudiante registrado con esa identificacion"); 
        }
            }
   
    /**
     * CONSULTAR ALUMNOS 
     * @param misAlumnos
     * @param lector 
     */
    public static void consultarAlumnoIndividual (ArrayList<Alumno>misAlumnos,Scanner lector){
         
         System.out.println("Ingrese la cedula del alumno que desea consultar");
         String consultarCedula = lector.next();
         
         Alumno consultarAlumno = null;
         for(Alumno alumno : misAlumnos) {
             if (alumno.getCedula().equals(consultarCedula)){
                 consultarAlumno=alumno;
                 break;
             }
         }
         if(consultarAlumno != null) {
             
             System.out.println("Datos del alumno que desea consultar");
             System.out.println("Cedula:" + consultarAlumno.getCedula());
             System.out.println("Nombre:" + consultarAlumno.getNombre());
             System.out.println("Apellido:" + consultarAlumno.getApellido());
             System.out.println("Correo:" + consultarAlumno.getCorreo());
             System.out.println("Celular:" + consultarAlumno.getCelular());
             System.out.println("Semestre:" + consultarAlumno.getSemestre());
         } else {
             System.out.println("Ups! no se encontro ningun alumno :( ");
         }
              
         
     }
   
    /**
     * AGREGAR ALUMNO
     * @param misAlumnos
     * @param lector 
     */
    
    public static void agregarAlumnos (ArrayList<Alumno>misAlumnos,Scanner lector){
        //utilizando un swith 
        Alumno alumnoNuevo = new Alumno ();
         System.out.println("Digite la Cedula del alumno");
          alumnoNuevo.setCedula(lector.next().trim());
         //un while para que digite el correo porque si esta vacio no se puede guardar devolviendo un true
        while (alumnoNuevo.getCedula().isEmpty()){
             System.out.println("Digite la Cedula nuevamente");
             alumnoNuevo.setCedula(lector.next().trim());
        }
        
        System.out.println("Digite el Nombre del alumno");
         alumnoNuevo.setNombre(lector.next().trim());
         //un while para que digite el nombre porque si esta vacio no se puede guardar devolviendo un true
        while (alumnoNuevo.getNombre().isEmpty()){
             System.out.println("Digite el Nombre nuevamente");
             alumnoNuevo.setNombre(lector.next().trim());
        }
        
        System.out.println("Digite el Apellido del alumno");
          alumnoNuevo.setApellido(lector.next().trim());
         //un while para que digite el apellido porque si esta vacio no se puede guardar devolviendo un true
        while (alumnoNuevo.getApellido().isEmpty()){
             System.out.println("Digite el Apellido nuevamente");
             alumnoNuevo.setApellido(lector.next().trim());
        }
        
        System.out.println("Digite el correo del alumno");
          alumnoNuevo.setCorreo(lector.next().trim());
         //un while para que digite el correo porque si esta vacio no se puede guardar devolviendo un true
        while (alumnoNuevo.getCorreo().isEmpty()){
             System.out.println("Digite el correo nuevamente");
             alumnoNuevo.setCorreo(lector.next().trim());
        }
        
           System.out.println("Digite el Celular del alumno");
          alumnoNuevo.setCelular(lector.next().trim());
         //un while para que digite el correo porque si esta vacio no se puede guardar devolviendo un true
        while (alumnoNuevo.getCelular().isEmpty()){
             System.out.println("Digite el Celular nuevamente");
             alumnoNuevo.setCelular(lector.next().trim());
        }  
          
        System.out.println("Digite el Semestre del alumno");
          alumnoNuevo.setSemestre(lector.next().trim());
         //un while para que digite el correo porque si esta vacio no se puede guardar devolviendo un true
        while (alumnoNuevo.getSemestre().isEmpty()){
             System.out.println("Digite el Semestre al que se inscribira nuevamente");
             alumnoNuevo.setSemestre(lector.next().trim());
        } 
        
        misAlumnos.add(alumnoNuevo);
        System.out.println("Alumno agregado! :) ");
        
    }

    /**
     *MODIFICAR ALUMNO
     * @param misAlumnos
     * @param lector 
     */
 
    public static void modificarAlumnos (ArrayList<Alumno>misAlumnos,Scanner lector){
        if (!misAlumnos.isEmpty()){
            System.out.println("Digite la cedula del estudiante que desea modificar y/o actualizar");
            
            String nuevaCedula = lector.next();
            boolean verificar = false; 
            for (Alumno estudiante : misAlumnos ){
                if (nuevaCedula.equals(estudiante.getCedula()));
                System.out.println("Digite la nueva cedula");
                
               String cedulaModificada = lector.next();
                estudiante.setCedula(cedulaModificada);
                
                System.out.println("Digite el nuevo nombre");
                
               String nombreModificado = lector.next();
                estudiante.setNombre(nombreModificado);
                
                 System.out.println("Digite el nuevo Apellido");
                
               String apellidoModificado = lector.next();
                estudiante.setApellido(apellidoModificado);
                
                System.out.println("Digite el nuevo correo");
                
               String correoModificado = lector.next();
                estudiante.setCorreo(correoModificado);
                
                System.out.println("Digite el nuevo celular");
                
               String celularModificado = lector.next();
                estudiante.setCelular(celularModificado);
                
                System.out.println("Digite el nuevo semestre");
                
               String semestreModificado = lector.next();
                estudiante.setSemestre(semestreModificado);
                
            }
            
            System.out.println("alumno modificado exitosamente :) ");
            verificar = true; 
        }
        
    }
   
    /**
     * LISTA MATRICULADOS
     * @param misAlumnos 
     */

    
    public static void  verListaAlumnos (ArrayList<Alumno>misAlumnos) {
    if (misAlumnos.isEmpty()) {
        System.out.println("No hay alumnos en la lista :( ");
    } else {
        System.out.println("El listado de Alumnos es : ");
        for (Alumno alumno : misAlumnos) {
            System.out.println("---------------------------");
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Cédula: " + alumno.getCedula());
            System.out.println("Semestre: " + alumno.getSemestre());
            System.out.println("Correo: " + alumno.getCorreo());
            System.out.println("Celular: " + alumno.getCelular());
            System.out.println("---------------------------");
                    
        }
    }
}
    public static void escrituraArchivo (ArrayList<Alumno>misAlumnos) throws FileNotFoundException {
        File archivo = new File ("./data/miReporte.txt");
        PrintWriter pluma = new PrintWriter(archivo);
        for (Alumno alumno: misAlumnos) {
            String alumnosDigitados = alumno.getCedula()+" ,"+alumno.getNombre() + " ," +alumno.getApellido()
            + " ," + alumno.getCorreo()+ " ," + alumno.getCelular() + " ," + alumno.getSemestre(); 
          
            pluma.println(alumnosDigitados);
           
        }
        
          pluma.close();
    }
    
    public static void lecturaArchivo (ArrayList<Alumno>misAlumnos) throws FileNotFoundException, IOException {
        File archivo = new File ("./data/miReporte.txt");
       FileReader fr = new FileReader (archivo);
       BufferedReader lector = new BufferedReader (fr);
       String recorrido;
       
       while((recorrido = lector.readLine()) != null ) {
           //inicializo split,hace un espaciado "," cuando el array almacena datos de forma ordenada en txt
           String [] registro = recorrido.split(",");
           //armamos array 
           //.trim elimina espacios en blanco
           String cedula = registro [0].trim();
           String nombre = registro [1].trim();
           String apellido = registro [2].trim();
           String correo = registro [3].trim();
           String celular = registro [4].trim();
           String semestre = registro [5].trim();
           Alumno alumno = new Alumno(cedula, nombre, apellido, correo, celular, semestre);
           misAlumnos.add(alumno);

      }
       lector.close();
    }
    
    public static void eliminarAlumnos (ArrayList<Alumno>misAlumnos) {
        misAlumnos.clear();
        System.out.println("se borraron");
    }
}
