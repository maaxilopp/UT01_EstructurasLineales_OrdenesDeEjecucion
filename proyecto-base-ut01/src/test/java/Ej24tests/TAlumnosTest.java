package Ej24tests;
import junit.framework.TestCase;
import ucu.edu.aed.impl.ConjuntoEnlazado;
import ej24.TAlumno;

public class TAlumnosTest extends TestCase {

    public void testUnionConAlumnoEnComun() {
        ConjuntoEnlazado<TAlumno> aed1 = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<TAlumno> pf = new ConjuntoEnlazado<>();
        aed1.agregar(new TAlumno(2345, "Trinidad", "Bunge"));
        aed1.agregar(new TAlumno(3444, "Juan Ignacio", "Baldenegro"));
        aed1.agregar(new TAlumno(5638, "Maximiliano", "Lopez"));
        pf.agregar(new TAlumno(1245, "Simone", "Quinteros"));
        pf.agregar(new TAlumno(2006, "José", "Abadie"));
        pf.agregar(new TAlumno(3444, "Juan Ignacio", "Baldenegro"));
        pf.agregar(new TAlumno(3678, "Paola", "Belén"));
        assertEquals(6, aed1.union(pf).tamaño());
    }

    public void testInterseccionConAlumnoEnComun() {
        ConjuntoEnlazado<TAlumno> aed1 = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<TAlumno> pf = new ConjuntoEnlazado<>();
        aed1.agregar(new TAlumno(2345, "Trinidad", "Bunge"));
        aed1.agregar(new TAlumno(3444, "Juan Ignacio", "Baldenegro"));
        pf.agregar(new TAlumno(3444, "Juan Ignacio", "Baldenegro"));
        pf.agregar(new TAlumno(3678, "Paola", "Belén"));
        assertEquals(1, aed1.interseccion(pf).tamaño());
    }

    public void testInterseccionSinAlumnosEnComun() {
        ConjuntoEnlazado<TAlumno> aed1 = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<TAlumno> pf = new ConjuntoEnlazado<>();
        aed1.agregar(new TAlumno(2345, "Trinidad", "Bunge"));
        pf.agregar(new TAlumno(3678, "Paola", "Belén"));
        assertEquals(0, aed1.interseccion(pf).tamaño());
    }

    public void testDiferenciaConAlumnoEnComun() {
        ConjuntoEnlazado<TAlumno> aed1 = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<TAlumno> pf = new ConjuntoEnlazado<>();
        aed1.agregar(new TAlumno(2345, "Trinidad", "Bunge"));
        aed1.agregar(new TAlumno(3444, "Juan Ignacio", "Baldenegro"));
        aed1.agregar(new TAlumno(5638, "Maximiliano", "Lopez"));
        pf.agregar(new TAlumno(3444, "Juan Ignacio", "Baldenegro"));
        assertEquals(2, aed1.diferencia(pf).tamaño());
    }

    public void testEsSubconjuntoDeConAlumnos() {
        ConjuntoEnlazado<TAlumno> aed1 = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<TAlumno> sub = new ConjuntoEnlazado<>();
        aed1.agregar(new TAlumno(2345, "Trinidad", "Bunge"));
        aed1.agregar(new TAlumno(3444, "Juan Ignacio", "Baldenegro"));
        sub.agregar(new TAlumno(3444, "Juan Ignacio", "Baldenegro"));
        assertTrue(sub.esSubconjuntoDe(aed1));
        assertFalse(aed1.esSubconjuntoDe(sub));
    }
}