package org.example;

import ucu.edu.aed.impl.Biblioteca;
import ucu.edu.aed.impl.Libro;
import ucu.edu.aed.utils.FileUtils;

public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        cargarAdquisiciones(biblioteca);
        procesarPrestamos(biblioteca);
        mostrarCatalogo(biblioteca);
    }

    private static void cargarAdquisiciones(Biblioteca biblioteca) {
        FileUtils.leerLineas("adquisiciones.txt", linea -> {
        String[] partes = linea.split(",");
            if (partes.length < 4) return;

            try {
                String codigo = partes[0].trim();
                String titulo = partes[1].trim();
                double precio = Double.parseDouble(partes[2].trim());
                int stock = Integer.parseInt(partes[3].trim());

                biblioteca.agregarLibro(new Libro(titulo, codigo, precio, stock));
            } catch(NumberFormatException e){
                System.out.println("En la linea de adquisiciones numero: " + linea + ", hay un error :(");
            }
        });
    }

    private static void procesarPrestamos(Biblioteca biblioteca) {
        FileUtils.leerLineas("prestamos.txt", linea -> {
            String[] partes = linea.split(",");
            if (partes.length < 3) return;
            try {
                String codigo = partes[0].trim();
                String tipo = partes[1].trim();
                int cantidad = Integer.parseInt(partes[2].trim());

                Libro existente = biblioteca.buscarLibro(codigo);
                if (existente == null) {
                    System.out.println("No encontrado: " + codigo);
                    return;
                }

                if (tipo.equalsIgnoreCase("PRESTAMO")) {
                    if (existente.getStock() >= cantidad) {
                        existente.prestarEjemplares(cantidad);
                        System.out.println("PRESTAMO: " + existente.getTitulo() + " | Stock: " + existente.getStock());
                    } else {
                        System.out.println("SIN STOCK: " + existente.getTitulo());
                    }
                } else if (tipo.equalsIgnoreCase("DEVOLUCION")) {
                    existente.agregarEjemplares(cantidad);
                    System.out.println("DEVOLUCION: " + existente.getTitulo() + " | Stock: " + existente.getStock());
                }
            } catch(NumberFormatException e){
                System.out.println("En la linea de prestamos numero: " + linea + ", hay un error :(");
            }
        });
    }

    private static void mostrarCatalogo(Biblioteca biblioteca) {
        for (int i = 0; i < biblioteca.getCatalogo().tamaño(); i++) {
            Libro libro = biblioteca.getCatalogo().obtener(i);
            System.out.println("Titulo: " + libro.getTitulo()
                    + " | Codigo: " + libro.getCodigo()
                    + " | Precio: " + libro.getPrecio()
                    + " | Stock: " + libro.getStock());
        }
    }
}