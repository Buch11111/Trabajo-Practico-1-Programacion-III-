/*
## Tabajo Practico N° 1
La biblioteca de la facultad necesita modernizar su sistema de préstamos. 
Se requiere una aplicación 
de consola que permita gestionar libros, estudiantes y préstamos,
 */

//nombre de paquete, siempre va a ser el mismo que la carpeta donde esta el archivo
package com.example;

//importando paquete de prueba \java\packageprueba\claseSub.java
import packageprueba.claseSub;


import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;

public class clasePrincipal {
    public static void main(String[] args) {
        // solo entral paquete packageprueba y su clase claseSub
        claseSub prueba = new claseSub();
        prueba.metodoSub(); // ejecutar el método para asignar la hora antes de imprimir


        // objetos principales
        Libro biblioteca = new Libro();
        Prestamo sistemaPrestamos = new Prestamo();
        Scanner lector = new Scanner(System.in);
        
        boolean salir = false;
       
        while (!salir) {
            System.out.println("\n SISTEMA DE BIBLIOTECA");
            System.out.println("1. Registrar nuevo alumno");
            System.out.println("2. Ver alumnos y sus libros a sus disposicion");
            System.out.println("3. Solicitar Libro");
            System.out.println("4. Devolver Libro");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");
            //manejo de exepcion para no ingresar letras y falle
            try {
                int opcion = lector.nextInt();
                lector.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del alumno: ");
                        String nombre = lector.nextLine();
                        System.out.print("Legajo del alumno: ");
                        String legajo = lector.nextLine();
                        System.out.print("Carrera del alumno: ");
                        String carrera = lector.nextLine();
                        System.out.print("Email del alumno: ");
                        String email = lector.nextLine();
                        // Registramos en la biblioteca (automaticamente usa el HashMap con legajo como clave)
                        biblioteca.registrarAlumnoNuevo(nombre, legajo, carrera, email);
                        break;

                    case 2:
                        System.out.println("\nESTADO DE ALUMNOS:");
                        // Obtenemos el HashMap desde la biblioteca
                        HashMap<String, Alumno> estudiantes = biblioteca.obtenerTodosLosAlumnos();
                        
                        // Iteramos sobre el HashMap con entrySet() para acceder a clave y valor
                        for (var entrada : estudiantes.entrySet()) {
                            String claveLegajo = entrada.getKey();      // Obtiene la clave (legajo)
                            Alumno alumno = entrada.getValue();         // Obtiene el valor (Alumno)
                            System.out.println("- [Legajo: " + claveLegajo + "] " + alumno.getNombre() + 
                                             " | Libros en mano: " + alumno.getCantidadLibros());
                        }
                        break;

                    case 3:
                        // Obtenemos el HashMap de alumnos registrados
                        HashMap<String, Alumno> alumnosRegistrados = biblioteca.obtenerTodosLosAlumnos();
                        
                        // Validamos que haya al menos un alumno registrado antes de solicitar un libro
                        if (alumnosRegistrados.isEmpty()) {
                            System.out.println("Primero registra un alumno.");
                            break;
                        }
                        // Mostramos el catálogo disponible
                        biblioteca.mostrarCatalogo();
                        
                        System.out.print("Escribe el nombre del libro: ");
                        String libroElegido = lector.nextLine();
                        
                        System.out.println("¿A quién se lo prestamos? (Escribe el legajo exacto):");
                        String legajoBuscado = lector.nextLine();
                        
                        // Usamos get(clave) para buscar directamente por legajo en el HashMap
                        Alumno alumnoEncontrado = alumnosRegistrados.get(legajoBuscado);
                        
                        if (alumnoEncontrado != null) {
                            // Si encontramos el alumno, procesamos el préstamo
                            sistemaPrestamos.gestionarPrestamo(alumnoEncontrado, libroElegido, biblioteca);
                        } else {
                            System.out.println("Error: No se encontró alumno con legajo '" + legajoBuscado + "'");
                        }
                        break;

                    case 4:
                        // Obtenemos el HashMap de alumnos registrados
                        HashMap<String, Alumno> alumnosRegistradosDev = biblioteca.obtenerTodosLosAlumnos();
                        
                        // Validamos que haya al menos un alumno registrado
                        if (alumnosRegistradosDev.isEmpty()) {
                            System.out.println("No hay alumnos registrados.");
                            break;
                        }
                        
                        System.out.println("¿De quién es el libro? (Escribe el legajo exacto):");
                        String legajoDev = lector.nextLine();
                        
                        Alumno alumnoDev = alumnosRegistradosDev.get(legajoDev);
                        if (alumnoDev == null) {
                            System.out.println("Error: No se encontró alumno con legajo '" + legajoDev + "'");
                            break;
                        }
                        
                        // Mostrar libros prestados por el alumno
                        HashMap<String, Long> librosPrestados = alumnoDev.getLibrosPrestados();
                        if (librosPrestados.isEmpty()) {
                            System.out.println("El alumno no tiene libros prestados.");
                            break;
                        }
                        
                        System.out.println("Libros prestados por " + alumnoDev.getNombre() + ":");
                        int contador = 1;
                        for (String titulo : librosPrestados.keySet()) {
                            System.out.println(contador + ". " + titulo);
                            contador++;
                        }
                        
                        System.out.print("¿Cuál libro deseas devolver? (Escribe el título exacto): ");
                        String libroDev = lector.nextLine();
                        
                        // Devolver el libro
                        long tiempoUsado = alumnoDev.devolverLibro(libroDev);
                        if (tiempoUsado != -1) {
                            biblioteca.devolverLibro(libroDev);
                            long dias = tiempoUsado / (1000 * 60 * 60 * 24);
                            long horas = (tiempoUsado / (1000 * 60 * 60)) % 24;
                            long minutos = (tiempoUsado / (1000 * 60)) % 60;
                            System.out.println("Devolución exitosa: '" + libroDev + "' está disponible nuevamente.");
                            System.out.println("Tiempo usado: " + dias + " días, " + horas + " horas, " + minutos + " minutos.");
                        } else {
                            System.out.println("Error: El alumno no tiene prestado ese libro.");
                        }
                        break;

                    case 5:
                        salir = true;
                        break;
                        
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido para la opción.");
                lector.nextLine(); // Limpiar el buffer para evitar bucle infinito
            }
        }
        System.out.println("Cerrando sistema");
        lector.close();
    }
}


   
    
    



