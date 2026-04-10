package ImplTests;
import junit.framework.TestCase;
import ucu.edu.aed.impl.PilaEnlazada;

import java.util.NoSuchElementException;

public class PilaEnlazadaTest extends TestCase {

    public void testTopeUltimoElementoInsertado() {
        PilaEnlazada<Integer> pila = new PilaEnlazada<>();
        pila.mete(1);
        pila.mete(2);
        pila.mete(3);
        assertEquals((Integer) 3, pila.tope()); // 3 es last in, entonces es tope


    }

    public void testEsLIFO() {
        PilaEnlazada<Integer> pila = new PilaEnlazada<>();
        pila.mete(1);
        pila.mete(2);
        pila.mete(3);
        pila.saca();
        assertEquals((Integer) 2, pila.tope()); // que salga el 3, para ser LIFO y quede 2 como tope.
    }

    public void testSiEsNullTopeEsNull() {
        PilaEnlazada<Integer> pila = new PilaEnlazada<>();
        assertNull(pila.tope()); //pila vacia, tope null
    }

    public void testSiEsNullNoseRemueve() {
        PilaEnlazada<Integer> pila = new PilaEnlazada<>();
        try {
            pila.saca();
            fail("Debería lanzar excepcion");
        } catch (NoSuchElementException e) {
        }
    }

    public void testTopeNoRemueve() {
        PilaEnlazada<Integer> pila = new PilaEnlazada<>();
        pila.mete(1);
        pila.tope();
        pila.tope();
        assertEquals((Integer) 1, pila.saca()); // si despues de dos tope, el saca retorna 1, significa que nunca salió con tope()
    }

    public void testSiVacioPilaQuedaNull(){
        PilaEnlazada<Integer> pila = new PilaEnlazada<>();
        pila.mete(1);
        pila.saca();
        assertNull(pila.tope()); // si es (o queda) vacia, el tope es null
    }

    public void testEliminoYSacoMuchosParaProbar() {
        PilaEnlazada<Integer> pila = new PilaEnlazada<>();
        pila.mete(1);
        pila.mete(2);
        pila.mete(3);
        assertEquals((Integer) 3, pila.saca());
        assertEquals((Integer) 2, pila.saca());
        assertEquals((Integer) 1, pila.saca());
        assertNull(pila.tope()); // debería quedar vacía
    }
}
