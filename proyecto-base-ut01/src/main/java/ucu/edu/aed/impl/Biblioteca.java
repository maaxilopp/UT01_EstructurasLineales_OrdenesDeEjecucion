package ucu.edu.aed.impl;

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
        Predicate<Libro> criterio = new Predicate<Libro>() {
            @Override
            public boolean test(Libro l) {
                return l.getCodigo().equals(libro.getCodigo());
            }
        };
        Libro existente = catalogo.buscar(criterio);
        if (existente == null) {
            catalogo.agregar(libro);
        } else {
            existente.agregarEjemplares(libro.getStock());
        }
    }

    public void removerLibro(Libro libro) {
        Predicate<Libro> criterio = new Predicate<Libro>() {
            @Override
            public boolean test(Libro l) {
                return l.getCodigo().equals(libro.getCodigo());
            }
        };
        Libro existente = catalogo.buscar(criterio);
        if (existente == null) {
            System.out.println("El libro no existe en el catalogo");
        } else {
            catalogo.remover(libro);
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
        if (existente.getStock() < cantidad) return false;
        existente.prestarEjemplares(cantidad);
        return true;
    }

    public boolean devolverLibro(String codigo, int cantidad) {
        Libro existente = buscarLibro(codigo);
        if (existente == null) return false;
        existente.agregarEjemplares(cantidad);
        return true;
    }
}