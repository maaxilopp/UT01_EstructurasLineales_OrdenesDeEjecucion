package ej27;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ucu.edu.aed.impl.ColaCircular;

public class ColaCircularTest extends TestCase {


    public void testColaVacia(){
        ColaCircular<Integer> colaVacia = new ColaCircular<Integer>(4); //tamaño del arreglo 4
        assertTrue(colaVacia.esVacio());
    }

    public void testColaNoVacia(){
        ColaCircular<Integer> colaNoVacia = new ColaCircular<Integer>(3);
        colaNoVacia.poneEnCola(2);
        assertNotNull(colaNoVacia.frente());
    }

    public void testRetornarFrente(){
        ColaCircular<Integer> cola = new ColaCircular<Integer>(5);
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        // insertamos dos valores, el que esta en el primer lugar deberia ser el 1.
        int frente = cola.frente();
        assertEquals(1,frente);
    }

    public void testQuitarColaVacia(){
        ColaCircular<Integer> colaVacia = new ColaCircular<Integer>(5);
        assertNull(colaVacia.quitaDeCola());
    }

    public void testAgregarEnColaLlena(){
        ColaCircular<Integer> colaVacia = new ColaCircular<Integer>(2);
        assertTrue(colaVacia.poneEnCola(1));
        assertTrue(colaVacia.poneEnCola(2));
        //se supone que la cola esta llena y no va a poder insertar el elemento 30
        assertFalse(colaVacia.poneEnCola(30));
    }

}
