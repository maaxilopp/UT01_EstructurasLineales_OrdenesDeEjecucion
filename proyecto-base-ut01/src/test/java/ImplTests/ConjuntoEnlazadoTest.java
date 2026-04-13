package ImplTests;
import junit.framework.TestCase;
import ucu.edu.aed.impl.ConjuntoEnlazado;


public class ConjuntoEnlazadoTest extends TestCase {

    public void testUnionSiDosConjuntosSonVaciosRetornaConjuntoVacio(){
        ConjuntoEnlazado <Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado <Integer> conjunto2 = new ConjuntoEnlazado<>();
        assertEquals(0, conjunto.union(conjunto2).tamaño());

    }
    public void testSiUnConjuntoEsVacioRetornaElOtro(){
        ConjuntoEnlazado <Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado <Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(2);
        assertEquals(1,conjunto.union(conjunto2).tamaño());
    }

    public void testUnionSiConjuntosSonIgualesRetornaConjuntoA(){
        ConjuntoEnlazado <Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado <Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(99);
        conjunto2.agregar(99);
        conjunto.agregar(54);
        conjunto2.agregar(54);
        assertEquals(2, conjunto.union(conjunto2).tamaño());
    }

    public void testUnionEjemploNormal(){
        ConjuntoEnlazado <Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado <Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(44);
        conjunto2.agregar(44);
        conjunto.agregar(13);
        conjunto2.agregar(13);
        conjunto.agregar(2);
        conjunto2.agregar(6);
        assertEquals(4, conjunto.union(conjunto2).tamaño());
    }

    public void testUnionConjuntosConElementosDistintos(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(3);
        conjunto.agregar(1);
        conjunto2.agregar(4);
        conjunto2.agregar(2);
        assertEquals(4, conjunto.union(conjunto2).tamaño());
    }

    public void testInterseccionPromedio(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(5);
        conjunto.agregar( 1);
        conjunto2.agregar( 5);
        conjunto2.agregar(3);
        assertEquals(1, conjunto.interseccion(conjunto2).tamaño());
    }

    public void testInterseccionConjuntosSinNadaEnComun(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(3);
        conjunto2.agregar(1);
        assertEquals(0, conjunto.interseccion(conjunto2).tamaño());
    }
    public void testInterseccionConUnoNull(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(3);
        assertEquals(0, conjunto.interseccion(conjunto2).tamaño());
    }

    public void testInterseccionConAmbosNull(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        assertEquals(0, conjunto.interseccion(conjunto2).tamaño());
    }

    public void testInterseccionTodosEnComun(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(3);
        conjunto.agregar(2);
        conjunto.agregar(1);
        conjunto2.agregar(3);
        conjunto2.agregar(2);
        conjunto2.agregar(1);
        assertEquals(3, conjunto.interseccion(conjunto2).tamaño());
    }public void testDiferenciaConElementosEnComun(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(5);
        conjunto.agregar(3);
        conjunto.agregar(1);
        conjunto2.agregar(5);
        conjunto2.agregar(3);
        assertEquals(1, conjunto.diferencia(conjunto2).tamaño());
    }

    public void testDiferenciaAmbosVacios(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        assertEquals(0, conjunto.diferencia(conjunto2).tamaño());
    }

    public void testDiferenciaSegundoVacio(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(10);
        conjunto.agregar(2);
        assertEquals(2, conjunto.diferencia(conjunto2).tamaño());
    }

    public void testDiferenciaPrimeroVacio(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto2.agregar(1);
        assertEquals(0, conjunto.diferencia(conjunto2).tamaño());
    }

    public void testDiferenciaSinNadaEnComun(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(10);
        conjunto2.agregar(1);
        assertEquals(1, conjunto.diferencia(conjunto2).tamaño());
    }

    public void testDiferenciaTodosEnComun(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(10);
        conjunto.agregar(2);
        conjunto2.agregar(10);
        conjunto2.agregar(2);
        assertEquals(0, conjunto.diferencia(conjunto2).tamaño());
    }

    public void testEsSubconjuntoDePromedio(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(3);
        conjunto2.agregar(3);
        conjunto2.agregar(1);
        assertTrue(conjunto.esSubconjuntoDe(conjunto2));
    }

    public void testEsSubconjuntoDeAmbosVacios(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        assertTrue(conjunto.esSubconjuntoDe(conjunto2));
    }

    public void testEsSubconjuntoDeConjuntoVacio(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto2.agregar(1);
        assertTrue(conjunto.esSubconjuntoDe(conjunto2));
    }

    public void testNoEsSubconjuntoDe(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(4);
        conjunto.agregar(1);
        conjunto2.agregar(3);
        conjunto2.agregar(1);
        assertFalse(conjunto.esSubconjuntoDe(conjunto2));
    }

    public void testEsSubconjuntoDeIguales(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(10);
        conjunto.agregar(2);
        conjunto2.agregar(10);
        conjunto2.agregar(2);
        assertTrue(conjunto.esSubconjuntoDe(conjunto2));
    }

    public void testNoEsSubconjuntoDeSegundoVacio(){
        ConjuntoEnlazado<Integer> conjunto = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<Integer> conjunto2 = new ConjuntoEnlazado<>();
        conjunto.agregar(1);
        assertFalse(conjunto.esSubconjuntoDe(conjunto2));
    }
}
