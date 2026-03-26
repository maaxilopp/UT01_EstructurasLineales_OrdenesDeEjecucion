package org.example;

import ucu.edu.aed.impl.Biblioteca;
import ucu.edu.aed.impl.Libro;
import ucu.edu.aed.utils.FileUtils;

public class App {
    public static void main(String[] args) {
        //Crear biblioteca
        Biblioteca biblioteca = new Biblioteca();
        cargarAdquisiciones(biblioteca);
        procesarPrestamos(biblioteca);
        mostrarCatalogo(biblioteca);


    }
    private static void cargarAdquisiciones(Biblioteca biblioteca){
        //Cargar los libros desde adquisiciones.txt
        FileUtils.leerLineas("src/main/java/resources/adquisiciones.txt", linea -> {
            String[] partes = linea.split(",");
            String titulo = partes[0];
            String codigo = partes[1];
            double precio = Double.parseDouble(partes[2]);
            int stock = Integer.parseInt(partes[3]);

            Libro libro = new Libro(titulo, codigo, precio, stock);
            biblioteca.agregarLibro(libro);
        });

    }

    private static void procesarPrestamos(Biblioteca biblioteca) {
        //Gestionar prestamos
        FileUtils.leerLineas("src/main/java/resources/adquisiciones.txt", linea -> {
            String[] partes = linea.split(",");

            if (partes.length == 3) {

                String codigo = partes[0].trim();
                String tipo = partes[1].trim();
                int cantidad = Integer.parseInt(partes[2].trim());

                if (tipo.equalsIgnoreCase("prestamo")) {

                    for (int i = 0; i < cantidad; i++) {
                        Libro libro = new Libro("", codigo, 0, 0);
                        biblioteca.removerLibro(libro);
                    }

                } else if (tipo.equalsIgnoreCase("devolucion")) {

                    for (int i = 0; i < cantidad; i++) {
                        Libro libro = new Libro("", codigo, 0, 0);
                        biblioteca.agregarLibro(libro);
                    }

                }
            }
        });
    }

    private static void mostrarCatalogo(Biblioteca biblioteca){
        for (int i = 0; i < biblioteca.getCatalogo().tamaño(); i++) {
            Libro libro = biblioteca.getCatalogo().obtener(i);
            System.out.println("Titulo: " + libro.getTitulo()
                    + ", Codigo: " + libro.getCodigo()
                    + ", Precio: " + libro.getPrecio()
                    + ", Stock: " + libro.getStock());
        }
    }


}




