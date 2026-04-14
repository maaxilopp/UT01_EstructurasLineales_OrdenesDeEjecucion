package ej17Tests;

import junit.framework.TestCase;
import ej17.implementaciones.Biblioteca;
import ej17.implementaciones.Libro;

public class BibliotecaTest extends TestCase {

    // prestamo promedio
    public void testPrestarLibroStockSuficiente() {
        Biblioteca b = new Biblioteca();
        b.agregarLibro(new Libro("Hamlet", "001", 100.0, 5));
        assertTrue(b.prestarLibro("001", 3));
        assertEquals(2, b.buscarLibro("001").getStock());
    }

    // hace prestamo parcial
    public void testPrestarLibroStockInsuficiente() {
        Biblioteca b = new Biblioteca();
        b.agregarLibro(new Libro("Edipo Rey", "001", 100.0, 2));
        assertTrue(b.prestarLibro("001", 5)); // pide 5, solo hay 2
        assertEquals(0, b.buscarLibro("001").getStock()); // presta dos
    }

    // prestamo sin stock
    public void testPrestarLibroSinStock() {
        Biblioteca b = new Biblioteca();
        b.agregarLibro(new Libro("Don Quijote", "001", 100.0, 0));
        assertFalse(b.prestarLibro("001", 1));
    }

    // devolución normal
    public void testDevolverLibro() {
        Biblioteca b = new Biblioteca();
        b.agregarLibro(new Libro("Martin Fierro", "001", 100.0, 1));
        b.prestarLibro("001", 1);
        b.devolverLibro("001", 1);
        assertEquals(1, b.buscarLibro("001").getStock());
    }

    // libro inexistente para prestar
    public void testPrestarLibroInexistente() {
        Biblioteca b = new Biblioteca();
        assertFalse(b.prestarLibro("999", 1));
    }

    // cantidad negativa en devolución
    public void testDevolverCantidadNegativa() {
        Biblioteca b = new Biblioteca();
        b.agregarLibro(new Libro("Harry Potter", "001", 100.0, 3));
        assertFalse(b.devolverLibro("001", -1));
        assertEquals(3, b.buscarLibro("001").getStock()); // stock no cambió
    }
}