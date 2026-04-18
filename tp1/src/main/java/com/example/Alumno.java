package com.example;

import java.util.HashMap;

public class Alumno {
    // ATRIBUTOS 
    private String nombre;
    private String legajo;
    private String carrera;
    private String email;
    // HashMap almacena libros prestados con timestamp de préstamo
    // Estructura: HashMap<String clave(título), Long valor(timestamp)>
    private HashMap<String, Long> librosPrestadosConFecha;

    // CONSTRUCTOR / instanciar
    public Alumno(String nombre, String legajo, String carrera, String email) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.carrera = carrera;
        this.email = email;
        // Inicializamos el HashMap
        this.librosPrestadosConFecha = new HashMap<>();
    }

    // COMPORTAMIENTOS 

    public String getNombre() {
        return nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getEmail() {
        return email;
    }

    // INTERACCION: le pasa cantida de libros 
    public int getCantidadLibros() {
        return librosPrestadosConFecha.size(); // Solo devuelve el número, no la lista completa.
    }

    // INTERACCIN La clase Prestamo usa este método para darle un libro.
    public void agregarLibro(String tituloLibro) {
        librosPrestadosConFecha.put(tituloLibro, System.currentTimeMillis());
    }
    
    // Método para devolver un libro y obtener el tiempo usado
    public long devolverLibro(String tituloLibro) {
        Long tiempoPrestamo = librosPrestadosConFecha.remove(tituloLibro);
        if (tiempoPrestamo != null) {
            long tiempoActual = System.currentTimeMillis();
            return tiempoActual - tiempoPrestamo; // Tiempo en milisegundos
        }
        return -1; // Libro no encontrado
    }
    
    // Método para obtener los libros prestados
    public HashMap<String, Long> getLibrosPrestados() {
        return librosPrestadosConFecha;
    }
}

