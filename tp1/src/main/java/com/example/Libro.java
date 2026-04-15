package com.example;

import java.util.ArrayList;

public class Libro {
    // ATRIBUTOS 
    private ArrayList<String> catalogoLibros;
    private ArrayList<Alumno> alumnosRegistrados;

    public void mostrarCatalogo1() {
    System.out.println("Libros disponibles: " + catalogoLibros);
}
    // contructor y definimos libros
    public Libro() {
        this.catalogoLibros = new ArrayList<>();
        this.alumnosRegistrados = new ArrayList<>();
        
        // Libros definidos en la misma clase
        catalogoLibros.add("Java para Novatos");
        catalogoLibros.add("Estructuras de Datos");
        catalogoLibros.add("Clean Code");
    }

    // Metodo para registrar a un chico que viene a la biblioteca
    public Alumno registrarAlumnoNuevo(String nombre) {
        Alumno nuevoAlumno = new Alumno(nombre); // Creamos el objeto Alumno
        alumnosRegistrados.add(nuevoAlumno);     // Lo guardamos en el sistema

        System.out.println("Registro exitoso: " + nombre + " es ahora miembro.");
        return nuevoAlumno; // Lo devolvemos para poder usarlo inmediatamente
    }

    // Método simple para verificar si un libro existe en la biblioteca
    public boolean tieneLibro(String titulo) {
        return catalogoLibros.contains(titulo);
    }
    
    public void mostrarCatalogo() {

      throw new UnsupportedOperationException("Unimplemented method 'mostrarCatalogo'");
    }
}
