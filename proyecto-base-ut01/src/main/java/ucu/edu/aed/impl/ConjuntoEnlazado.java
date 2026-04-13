package ucu.edu.aed.impl;
import ucu.edu.aed.tda.TDAConjunto;

public class ConjuntoEnlazado<T extends Comparable<T>> extends ListaEnlazada <T> implements TDAConjunto<T> {

    @Override
    public void agregar(T elem) {
        Nodo<T> nuevo = new Nodo<>(elem);
        if (primero == null || elem.compareTo(primero.getDato()) < 0) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
            return;
        }
        if (elem.compareTo(primero.getDato()) == 0) return;
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null) {
            int cmp = elem.compareTo(actual.getSiguiente().getDato());
            if (cmp == 0) return;
            if (cmp < 0) break;
            actual = actual.getSiguiente();
        }
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
    }

    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otro) {
        ConjuntoEnlazado<T> conjunto = new ConjuntoEnlazado<>();
        Nodo<T> nodoA = this.primero;
        Nodo<T> nodoB = ((ConjuntoEnlazado<T>) otro).primero;

        while (nodoA != null && nodoB != null) {
            int comparacion = nodoA.getDato().compareTo(nodoB.getDato());
            if (comparacion == 0) {
                conjunto.agregarAlFinal(nodoA.getDato());
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();

            } else if (comparacion < 0) {
                conjunto.agregarAlFinal( nodoA.getDato());
                nodoA = nodoA.getSiguiente();
            } else {
                conjunto.agregarAlFinal( nodoB.getDato());
                nodoB = nodoB.getSiguiente();
            }
        }
        while (nodoA != null) {
            conjunto.agregarAlFinal(nodoA.getDato());
            nodoA = nodoA.getSiguiente();
        }
        while (nodoB != null) {
            conjunto.agregarAlFinal( nodoB.getDato());
            nodoB = nodoB.getSiguiente();
        }
        return conjunto;
    }

    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otro) {
        ConjuntoEnlazado<T> conjunto = new ConjuntoEnlazado<>();
        Nodo<T> nodoA = this.primero;
        Nodo<T> nodoB = ((ConjuntoEnlazado<T>) otro).primero;
        while (nodoA != null && nodoB != null) {
            int comparacion = nodoA.getDato().compareTo(nodoB.getDato());
            if (comparacion == 0) {
               conjunto.agregarAlFinal(nodoA.getDato());
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();
            } else if (comparacion < 0) {
                nodoA = nodoA.getSiguiente();
            } else {
                nodoB = nodoB.getSiguiente(); // no continua xq si ya se recorrio un conjunto entero, no  va a haber mas elementos en comun.
            }
        }
        return conjunto;
    }

    @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otro) {
        ConjuntoEnlazado<T> conjunto = new ConjuntoEnlazado<>();
        Nodo<T> nodoA = this.primero;
        Nodo<T> nodoB = ((ConjuntoEnlazado<T>) otro).primero;
        while (nodoA != null && nodoB != null) {
            int comparacion = nodoA.getDato().compareTo(nodoB.getDato());
            if (comparacion == 0) {
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();
            } else if (comparacion < 0) {
                conjunto.agregarAlFinal( nodoA.getDato());
                nodoA = nodoA.getSiguiente();

            } else {
                nodoB = nodoB.getSiguiente();
            }
        }
        while (nodoA != null) {
            conjunto.agregarAlFinal(nodoA.getDato());
            nodoA = nodoA.getSiguiente();
        }
        return conjunto;
    }

    @Override
    public boolean esSubconjuntoDe(TDAConjunto<T> otro) {
        Nodo<T> nodoA = this.primero;
        Nodo<T> nodoB = ((ConjuntoEnlazado<T>) otro).primero;
        while (nodoA != null && nodoB != null) {
            int comparacion = nodoA.getDato().compareTo(nodoB.getDato());
            if (comparacion == 0) {
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();
            } else if (comparacion < 0) {
                return false;
            } else {
                nodoB = nodoB.getSiguiente();
            }
        }
        return nodoA == null;
    }

    protected Nodo<T> ultimo;

    private void agregarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (this.primero == null) {
            this.primero = nuevo;
            this.ultimo = nuevo;
        } else {
            this.ultimo.setSiguiente(nuevo);
            this.ultimo = nuevo;
        }
    }
}
