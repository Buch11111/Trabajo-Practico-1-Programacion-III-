/*
## Tabajo Practico N° 1
La biblioteca de la facultad necesita modernizar su sistema de préstamos. 
Se requiere una aplicación 
de consola que permita gestionar libros, estudiantes y préstamos,
 */

//nombre de paquete, siempre va a ser el mismo que la carpeta donde esta el archivo
package com.example;

//sdsd martin
import java.util.Scanner;
import java.util.ArrayList;

public class clasePrincipal {
    public static void main(String[] args) {
        // Objetos principales
        Libro biblioteca = new Libro();
        Prestamo sistemaPrestamos = new Prestamo();
        Scanner lector = new Scanner(System.in);
        
        // Lista para manejar a los alumnos que vayamos creando
        ArrayList<Alumno> listaDeAlumnos = new ArrayList<>();
        
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- SISTEMA DE BIBLIOTECA ---");
            System.out.println("1. Registrar nuevo alumno");
            System.out.println("2. Ver alumnos y sus libros");
            System.out.println("3. Prestar un libro");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            
            int opcion = lector.nextInt();
            lector.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del alumno: ");
                    String nombre = lector.nextLine();
                    // Registramos en la biblioteca y guardamos en nuestra lista local
                    Alumno nuevo = biblioteca.registrarAlumnoNuevo(nombre);
                    listaDeAlumnos.add(nuevo);
                    break;

                case 2:
                    System.out.println("\nESTADO DE ALUMNOS:");
                    for (Alumno a : listaDeAlumnos) {
                        // Aquí llamamos al comportamiento del alumno
                        System.out.println("- " + a.getNombre() + " | Libros en mano: " + a.getCantidadLibros());
                    }
                    break;

                case 3:
                    if (listaDeAlumnos.isEmpty()) {
                        System.out.println("Primero registra un alumno.");
                        break;
                    }
                    // Mostramos el catálogo disponible
                    biblioteca.mostrarCatalogo1();
                    
                    System.out.print("Escribe el nombre del libro: ");
                    String libroElegido = lector.nextLine();
                    
                    System.out.println("¿A quién se lo prestamos? (Escribe el nombre exacto):");
                    String nombreAlumno = lector.nextLine();
                    
                    // Buscamos al objeto Alumno en nuestra lista
                    for (Alumno a : listaDeAlumnos) {
                        if (a.getNombre().equalsIgnoreCase(nombreAlumno)) {
                            // INTERACCIÓN: Conectamos Alumno, Libro y Biblioteca
                            sistemaPrestamos.gestionarPrestamo(a, libroElegido, biblioteca);
                        }
                    }
                    break;

                case 4:
                    salir = true;
                    break;
            }
        }
        System.out.println("Cerrando sistema...");
        lector.close();
    }
}


   
    
    




