package ImplTests;
import junit.framework.TestCase;
import ucu.edu.aed.impl.ColaEnlazada;
import java.util.NoSuchElementException;

public class ColaEnlazadaTest extends TestCase{

    public void testFrenteNoPuedeSerNull() {
        ColaEnlazada<Integer> cola = new ColaEnlazada<>();
        try {
            cola.frente();
            fail("Deberia lanzar excepcion");
        } catch (NoSuchElementException e) {
        }
    }

    public void testFrenteEsPrimero(){
        ColaEnlazada<Integer> cola = new ColaEnlazada<>();
        cola.poneEnCola(67);
        cola.poneEnCola(90);
        assertEquals((Integer) 67, cola.frente());

    }
    public void testSiAgregoAListaVaciaEsPrimero(){
        ColaEnlazada<Integer> cola = new ColaEnlazada<>();
        cola.poneEnCola(67);
        assertTrue(67 == cola.frente());
    }

    public void testAgregoAlFinal(){
        ColaEnlazada<Integer> cola = new ColaEnlazada<>();
        cola.poneEnCola(67);
        cola.poneEnCola(90);
        assertTrue(67 == cola.frente());
    }

    public void testSiQuieroQuitarYEsVaciaExcepcion(){
        ColaEnlazada<Integer> cola = new ColaEnlazada<>();
        try {
        cola.quitaDeCola();
        fail("Deberia lanzar excepcion");
        } catch (NoSuchElementException e) {
        }
    }

    public void testQuitaAlPrimero(){
        ColaEnlazada<Integer> cola = new ColaEnlazada<>();
        cola.poneEnCola(67);
        cola.poneEnCola(90);
        cola.quitaDeCola();
        assertEquals((Integer) 90, cola.frente());
    }
}