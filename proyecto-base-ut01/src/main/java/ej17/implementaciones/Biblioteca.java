package ej17.implementaciones;

import ucu.edu.aed.impl.ListaEnlazada;

import java.util.function.Predicate;

public class Biblioteca {
    private ListaEnlazada<Libro> catalogo;

    public Biblioteca() {
        this.catalogo = new ListaEnlazada<Libro>();
    }

    public ListaEnlazada<Libro> getCatalogo() {
        return catalogo;
    }

    public void agregarLibro(Libro libro) {
        Libro existente = catalogo.buscar(l -> l.getCodigo().equals(libro.getCodigo()));
        if (existente == null) {
            catalogo.agregar(libro);
        } else {
            existente.agregarEjemplares(libro.getStock());
        }
    }


    public void removerLibro(Libro libro) {
        Libro existente = catalogo.buscar(l -> l.getCodigo().equals(libro.getCodigo()));
        if (existente == null) {
            System.out.println("El libro no existe en el catalogo");
        } else {
            catalogo.remover(existente);
        }
    }

    public Libro buscarLibro(String codigo) {
        return catalogo.buscar(l -> l.getCodigo().equals(codigo));
    }

    public void mostrarCatalogo() {
        for (int i = 0; i < catalogo.tamaño(); i++) {
            Libro libro = catalogo.obtener(i);
            System.out.println("Titulo: " + libro.getTitulo()
                    + " | Codigo: " + libro.getCodigo()
                    + " | Precio: " + libro.getPrecio()
                    + " | Stock: " + libro.getStock());
        }
    }

    public boolean prestarLibro(String codigo, int cantidad) {
        Libro existente = buscarLibro(codigo);
        if (existente == null) return false;
        if (cantidad <= 0) return false;

        int disponibles = existente.getStock();
        if (disponibles <= 0) return false;

        int aPrestar = Math.min(cantidad, disponibles);
        existente.prestarEjemplares(aPrestar);
        return true; //true si se presto al menos 1
    }

    public boolean devolverLibro(String codigo, int cantidad) {
        if (cantidad <= 0) return false;
        Libro existente = buscarLibro(codigo);
        if (existente == null) return false;
        existente.agregarEjemplares(cantidad);
        return true;
    }
}