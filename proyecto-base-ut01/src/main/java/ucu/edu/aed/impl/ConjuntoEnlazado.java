package ucu.edu.aed.impl;
import ucu.edu.aed.tda.TDAConjunto;

public class ConjuntoEnlazado<T extends Comparable<T>> extends ListaEnlazada <T> implements TDAConjunto<T> {

    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otro) {
        ConjuntoEnlazado<T> conjunto = new ConjuntoEnlazado<>();
        Nodo<T> nodoA = this.primero;
        Nodo<T> nodoB = ((ConjuntoEnlazado<T>) otro).primero;

        while (nodoA != null && nodoB != null) {
            int comparacion = nodoA.getDato().compareTo(nodoB.getDato());
            if (comparacion == 0) {
                conjunto.agregar(nodoA.getDato());
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();
            } else if (comparacion < 0) {
                conjunto.agregar(nodoA.getDato());
                nodoA = nodoA.getSiguiente();
            } else {
                conjunto.agregar(nodoB.getDato());
                nodoB = nodoB.getSiguiente();
            }
        }
        while (nodoA != null) {
            conjunto.agregar(nodoA.getDato());
            nodoA = nodoA.getSiguiente();
        }
        while (nodoB != null) {
            conjunto.agregar(nodoB.getDato());
            nodoB = nodoB.getSiguiente();
        }
        return conjunto;
    }

    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otro) {
        ConjuntoEnlazado<T> conjunto = new ConjuntoEnlazado<>();
        Nodo <T> nodoA = this.primero;
        Nodo <T> nodoB = ((ConjuntoEnlazado<T>)otro).primero;
        while (nodoA != null && nodoB != null) {
            int comparacion = nodoA.getDato().compareTo(nodoB.getDato());
            if (comparacion==0) {
                conjunto.agregar(nodoA.getDato());
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();
            } else if ( comparacion < 0) {
                nodoA = nodoA.getSiguiente();
            }
            else{
                nodoB= nodoB.getSiguiente(); // no continua xq si ya se recorrio un conjunto entero, no  va a haber mas elementos en comun.
            }
        }
        return conjunto;
    }

    @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otro) {
        ConjuntoEnlazado<T> conjunto = new ConjuntoEnlazado<>();
        Nodo <T> nodoA = this.primero;
        Nodo <T> nodoB = ((ConjuntoEnlazado<T>)otro).primero;
        while (nodoA != null && nodoB != null) {
            int comparacion = nodoA.getDato().compareTo(nodoB.getDato());
            if ( comparacion == 0) {
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();
            }
            else if (comparacion < 0){
                conjunto.agregar(nodoA.getDato());
                nodoA = nodoA.getSiguiente();

            } else {
                nodoB = nodoB.getSiguiente();
            }
        }
        while (nodoA != null) {
            conjunto.agregar(nodoA.getDato());
            nodoA = nodoA.getSiguiente();
        }
        return conjunto;
    }

    @Override
    public boolean esSubconjuntoDe(TDAConjunto<T> otro) {
        Nodo <T> nodoA = this.primero;
        Nodo <T> nodoB = ((ConjuntoEnlazado<T>)otro).primero;
        int contador = 0;
        while (nodoA != null && nodoB != null) {
            int comparacion = nodoA.getDato().compareTo(nodoB.getDato());
            if (comparacion == 0) {
                contador++;
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();
            } else if (comparacion < 0) { // si el elemento de a es menor que el de b y ya pasó la comparación de si es igual a b,como esta ordenado, ya no es subconjunto de b.
                return false;
            } else if (comparacion > 0) {
                nodoB = nodoB.getSiguiente();
            }
        }
        return( contador == this.tamaño()); // si todos los elementos de A, estan en B, el contador de la cantidad de elementos iguales vale lo mismo que el tamaño de A.
    }
}
