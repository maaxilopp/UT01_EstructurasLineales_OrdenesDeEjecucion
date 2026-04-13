package ej24;

import ucu.edu.aed.impl.ConjuntoEnlazado;
import ucu.edu.aed.tda.TDAConjunto;

public class App {
    public static void main(String[] args) {
        ConjuntoEnlazado<TAlumno> AED1 = new ConjuntoEnlazado<>();
        ConjuntoEnlazado<TAlumno> PF = new ConjuntoEnlazado<>();

        TAlumno alumno1 = new TAlumno(5638, "Maximiliano", "Lopez");
        TAlumno alumno2 = new TAlumno(2345, "Trinidad", "Bunge");
        TAlumno alumno3 = new TAlumno(3444, "Juan Ignacio", "Baldenegro");
        TAlumno alumno4 = new TAlumno(1245, "Simone", "Quinteros");
        TAlumno alumno5 = new TAlumno(2006, "José", "Abadie");
        TAlumno alumno6 = new TAlumno(3678, "Paola", "Belén");

        AED1.agregar(alumno1);
        AED1.agregar(alumno2);
        AED1.agregar(alumno3);;

        PF.agregar(alumno4);
        PF.agregar(alumno5);
        PF.agregar(alumno6);
        PF.agregar(alumno3);

        TDAConjunto<TAlumno> union = AED1.union(PF);
        ConjuntoEnlazado<TAlumno> unionConj = (ConjuntoEnlazado<TAlumno>) union;
        System.out.println("La unión de los grupos AED1 y PF es: ");
        for (int i = 0; i < unionConj.tamaño(); i++) {
            System.out.println(unionConj.obtener(i)+ "");
        }

        TDAConjunto<TAlumno> intersec = AED1.interseccion(PF);
        ConjuntoEnlazado<TAlumno> intersecConj = (ConjuntoEnlazado<TAlumno>) intersec;
        System.out.println("\nLa intersección de los grupos AED1 y PF es: ");
        for (int i = 0; i < intersecConj.tamaño(); i++) {
            System.out.println(intersecConj.obtener(i));
        }
    }
}