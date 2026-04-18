package com.example;

public class Prestamo {
    // Regla de negocio estricta e inmutable (constante)
    private final int LIMITE_LIBROS = 2; 

    // Este método conecta a todas las clases. Recibe un Alumno, un libro y la Biblioteca.
    public void gestionarPrestamo(Alumno alumno, String libro, Libro Libro) {
        
        System.out.println("--- Iniciando trámite para: " + alumno.getNombre() + " ---");

        // Consultar a la Biblioteca si el libro existe
        if (!Libro.tieneLibro(libro)) {
            System.out.println("Error: El libro '" + libro + "' no existe en la biblioteca.");
            return; // Cortamos la ejecución aquí
        }

        //  interaccion Consultar a la clase Alumno (solo la cantidad)
        int librosActuales = alumno.getCantidadLibros();
        
        // regal de hasta 2 libros
        if (librosActuales >= LIMITE_LIBROS) {
            System.out.println("Rechazado: El alumno ya tiene " + librosActuales + " libros (Límite máximo).");
        } else {
            // 4. INTERACCIÓN DIRECTA: Modificar a la clase Alumno (asociarle el libro)
            alumno.agregarLibro(libro);
            // Marcar el libro como no disponible en la biblioteca
            Libro.prestarLibro(libro);
            System.out.println("Aprobado: Se prestó '" + libro + "' exitosamente.");
        }
    }
}