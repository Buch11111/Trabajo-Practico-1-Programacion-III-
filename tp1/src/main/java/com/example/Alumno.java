package com.example;
import java.util.ArrayList;

public class Alumno {
    // ATRIBUTOS 
    private String nombre;
    private ArrayList<String> librosPrestados;

    // CONSTRUCTOR / instanciar
    public Alumno(String nombre) {
        this.nombre = nombre;
        // Inicializamos el ArrayList
        this.librosPrestados = new ArrayList<>();
    }

    // COMPORTAMIENTOS 

    public String getNombre() {
        return nombre;
    }

    // INTERACCION: le pasa cantida de libros 
    public int getCantidadLibros() {
        return librosPrestados.size(); // Solo devuelve el número, no la lista completa.
    }

    // INTERACCIN La clase Prestamo usa este método para darle un libro.
    public void agregarLibro(String tituloLibro) {
        librosPrestados.add(tituloLibro);
    }
}

