package org.example;

import ucu.edu.aed.impl.Biblioteca;
import ucu.edu.aed.impl.Libro;
import ucu.edu.aed.utils.FileUtils;
import ucu.edu.aed.impl.EnumTipoTramite;

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
                System.out.println("Error al procesar esta linea, el formato es inválido. :((");
            }
        });
    }

    private static void procesarPrestamos(Biblioteca biblioteca) {
        System.out.println("\nTRAMITES QUE FUERON REALIZADOS EN LA BIBLIOTECA RECIENTEMENTE\n");
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

                EnumTipoTramite tipoTramite = EnumTipoTramite.valueOf(tipo.toUpperCase());

                if (tipoTramite == EnumTipoTramite.PRESTAMO) {
                    if (biblioteca.prestarLibro(codigo, cantidad)) {
                        System.out.println("PRESTAMO: " + existente.getTitulo() + " | Stock restante: " + existente.getStock());
                    } else {
                        System.out.println("SIN STOCK: " + existente.getTitulo());
                    }
                } else if (tipoTramite == EnumTipoTramite.DEVOLUCION) {
                    biblioteca.devolverLibro(codigo, cantidad);
                    System.out.println("DEVOLUCION: " + existente.getTitulo() + " | Stock actualizado: " + existente.getStock());
                }
            } catch(NumberFormatException e){
                System.out.println("En esta linea de prestamos hay un error de formato en el texto ingresado:(");
            }catch(IllegalArgumentException e){
                System.out.println("El tramite ingresado en esta linea no existe en la biblioteca :(, solo aceptamos PRESTAMO o DEVOLUCION.");
            }
        });
    }

    private static void mostrarCatalogo(Biblioteca biblioteca) {
        System.out.println("\nCATÁLOGO ACTUALIZADO DE LIBROS EN LA BIBLIOTECA\n");
        biblioteca.mostrarCatalogo();
    }
}