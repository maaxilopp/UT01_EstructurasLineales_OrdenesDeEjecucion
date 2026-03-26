package org.example;

import ucu.edu.aed.impl.Biblioteca;
import ucu.edu.aed.impl.Libro;
import ucu.edu.aed.utils.FileUtils;

public class App {
    public static void main (String[] args){
        //Crear biblioteca
        Biblioteca biblioteca = new Biblioteca();

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

        FileUtils.leerLineas("src/main/java/resources/adquisiciones.txt", linea ->){

        }
    }
}
