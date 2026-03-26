package ucu.edu.aed.impl;

import java.util.function.Predicate;

public class Biblioteca {
    private ListaEnlazada<Libro> catalogo;

    public Biblioteca(){
        this.catalogo = new ListaEnlazada<Libro>();
    }

    public ListaEnlazada<Libro> getCatalogo() {
        return catalogo;
    }
    public void agregarLibro(Libro libro){

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
            existente.agregarEjemplar();
        }
    }

    public void removerLibro (Libro libro){
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





}
