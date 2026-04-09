package ImplTests;

import junit.framework.TestCase;
import ucu.edu.aed.impl.ListaEnlazada;


public class ListaEnlazadaTest extends TestCase {

    public void testSiListaEsCreadaEsVacia() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        assertEquals(0, lista.tamaño());
    }

    public void testSiAgregoEsPrimero() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        assertEquals(10, (int) lista.obtener(0));
    }

    public void testSiAgregoPorIndiceFunciona() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        lista.agregar(9);
        lista.agregar(2, 3);
        assertEquals(3, (int) lista.obtener(2));
    }

    public void testBuscarEncuentra() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        lista.agregar(20);
        assertEquals((Integer)(10), lista.buscar(e -> e == 10));
    }

    public void testSiRemueveSacaDeLista() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        lista.agregar(20);
        lista.remover(1);
        assertEquals((Integer)(20), lista.obtener(0));
    }

    public void testSiEsVaciaYSeQuiereRemoverTiraExcepcion() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        try {
            lista.remover(1);
            fail("Debería haber lanzado excepción");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    public void testSiIndiceFueraDeRangoParaRemoverExcepcion() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        try {
            lista.remover(1);
            fail("Debería haber lanzado excepción");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    public void testRemoverPorElementoExiste(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        assertTrue(lista.remover((Integer)(10)));
    }

    public void testRemoverPorElementoNoExiste(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        assertFalse(lista.remover((Integer)(99)));
    }

    public void testRemoverPrimerElemento(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        lista.agregar(20);
        lista.remover((Integer)(20));
        assertEquals((Integer)(10), lista.obtener(0));
    }

    public void testRemoverElementoDelMedio(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.remover((Integer)(20));
        assertEquals(2, lista.tamaño());
    }

    public void testContieneElementoExiste(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        assertTrue(lista.contiene(10));
    }

    public void testContieneElementoNoExiste(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        assertFalse(lista.contiene(99));
    }

    public void testContieneEnListaVacia(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        assertFalse(lista.contiene(10));
    }

    public void testIndiceDeElementoExiste(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        lista.agregar(20);
        assertEquals(1, lista.indiceDe(10));
    }

    public void testIndiceDeElementoNoExiste(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        assertEquals(-1, lista.indiceDe(99));
    }

    public void testOrdenar(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        lista.agregar(30);
        lista.agregar(20);
        lista.ordenar(Integer::compareTo);
        assertEquals((Integer)(10), lista.obtener(0));
        assertEquals((Integer)(20), lista.obtener(1));
        assertEquals((Integer)(30), lista.obtener(2));
    }

    public void testTamañoListaVacia(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        assertEquals(0, lista.tamaño());
    }

    public void testTamañoConElementos(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        lista.agregar(20);
        assertEquals(2, lista.tamaño());
    }

    public void testEsVacioListaVacia(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        assertTrue(lista.esVacio());
    }

    public void testEsVacioConElementos(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        assertFalse(lista.esVacio());
    }

    public void testSiVaciarFunciona(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        lista.agregar(20);
        lista.vaciar();
        assertTrue(lista.esVacio());
    }
    public void testBuscarElementoExiste(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        lista.agregar(20);
        assertEquals((Integer)10, lista.buscar(e -> e == 10));
    }

    public void testBuscarElementoNoExiste(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        assertNull(lista.buscar(e -> e == 99));
    }










}
