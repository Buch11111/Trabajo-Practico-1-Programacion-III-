package com.example;


import java.util.HashMap;


public class Libro {
    // ATRIBUTOS 
    // HashMap almacena libros con su título como clave y disponibilidad como valor
    // Estructura: HashMap<String clave(título), Boolean valor(disponible)>
    private HashMap<String, Boolean> librosDisponibles;
    // HashMap almacena estudiantes con su legajo como clave única
    // Estructura: HashMap<String clave(legajo), Alumno valor(estudiante)>
    private HashMap<String, Alumno> alumnosRegistrados;

    public void mostrarCatalogo() {
        System.out.println("=== Catálogo de Libros Disponibles ===");
        boolean hayDisponibles = false;
        for (var entrada : librosDisponibles.entrySet()) {
            if (entrada.getValue()) { // Solo mostrar disponibles
                System.out.println("- " + entrada.getKey());
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay libros disponibles en este momento.");
        }
    }
    // contructor y definimos libros
    public Libro() {
        // Inicializamos HashMap para almacenar libros con disponibilidad
        this.librosDisponibles = new HashMap<>();
        // Inicializamos HashMap para almacenar estudiantes por legajo
        this.alumnosRegistrados = new HashMap<>();
        
        // Libros definidos en la misma clase - todos disponibles inicialmente
        librosDisponibles.put("Las tres Jorobas de Eva", true);
        librosDisponibles.put("Crepusculo y los tres enenitos ", true);
        librosDisponibles.put("El bananero 3", true);
        librosDisponibles.put("Leomeo y Julieta", true);
    }

    // Metodo para registrar a un chico que viene a la biblioteca
    public Alumno registrarAlumnoNuevo(String nombre, String legajo, String carrera, String email) {
        Alumno nuevoAlumno = new Alumno(nombre, legajo, carrera, email); // Creamos el objeto Alumno
        // Guardamos en HashMap: put(clave, valor) - clave es el legajo, valor es el Alumno
        alumnosRegistrados.put(legajo, nuevoAlumno);

        System.out.println("Registro exitoso: " + nombre + " es ahora miembro.");
        return nuevoAlumno; // Lo devolvemos para poder usarlo inmediatamente
    }
    
    // Método para obtener un alumno por su legajo desde el HashMap
    public Alumno obtenerAlumnoPorLegajo(String legajo) {
        // get(clave) devuelve el valor asociado a esa clave, o null si no existe
        return alumnosRegistrados.get(legajo);
    }
    
    // Método para obtener todos los alumnos registrados
    public HashMap<String, Alumno> obtenerTodosLosAlumnos() {
        // Devolvemos el HashMap completo para iterar sobre todos los alumnos
        return alumnosRegistrados;
    }

    // Método simple para verificar si un libro existe y está disponible
    public boolean tieneLibro(String titulo) {
        return librosDisponibles.containsKey(titulo) && librosDisponibles.get(titulo);
    }
    
    // Método para prestar un libro (marcar como no disponible)
    public boolean prestarLibro(String titulo) {
        if (tieneLibro(titulo)) {
            librosDisponibles.put(titulo, false);
            return true;
        }
        return false;
    }
    
    // Método para devolver un libro (marcar como disponible)
    public boolean devolverLibro(String titulo) {
        if (librosDisponibles.containsKey(titulo)) {
            librosDisponibles.put(titulo, true);
            return true;
        }
        return false;
    }
    

}
