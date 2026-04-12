package ucu.edu.aed.impl;
import ucu.edu.aed.tda.TDAConjunto;

public class ConjuntoEnlazado<T extends Comparable<T>> extends ListaEnlazada <T> implements TDAConjunto<T> {

    @Override
    public void agregar(T elem) {
        if (this.contiene(elem)) return;

        super.agregar(elem);
        this.ordenar((a, b) -> a.compareTo(b)); // agrega por orden, para que esté ordenada.
    }

    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otro) {
        ConjuntoEnlazado<T> conjunto = new ConjuntoEnlazado<>();
        int i = 0;
        int j = 0;
        while (i < this.tamaño() && j < otro.tamaño()) {
            if ((this.obtener(i)).compareTo(otro.obtener(j)) == 0) {
                conjunto.agregar(this.obtener(i));
                i++;
                j++;
            } else if (( this.obtener(i)).compareTo(otro.obtener(j)) < 0) {
                conjunto.agregar(this.obtener(i));
                i++;

            } else if (( this.obtener(i)).compareTo(otro.obtener(j)) > 0) {
                conjunto.agregar(otro.obtener(j));
                j++;
            }

        }
        while (i < this.tamaño()) {
            conjunto.agregar(this.obtener(i));
            i++;
        }
        while (j < otro.tamaño()) {

            conjunto.agregar(otro.obtener(j));
            j++;
        }
        return conjunto;
    }

    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otro) {
        ConjuntoEnlazado<T> conjunto = new ConjuntoEnlazado<>();
        int i = 0;
        int j = 0;
        while (i < this.tamaño() && j < otro.tamaño()) {
            if ((this.obtener(i)).compareTo(otro.obtener(j)) == 0) {
                conjunto.agregar(this.obtener(i));
                i++;
                j++;
            } else if (( this.obtener(i)).compareTo(otro.obtener(j)) < 0) {
                i++;
            } else if (( this.obtener(i)).compareTo(otro.obtener(j)) > 0) {
                j++;
            }
        }
        return conjunto;
    }

    @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otro) {
        ConjuntoEnlazado<T> conjunto = new ConjuntoEnlazado<>();
        int i = 0;
        int j = 0;
        while (i < this.tamaño() && j < otro.tamaño()) {
            if (( this.obtener(i)).compareTo(otro.obtener(j)) == 0) {
                i++;
                j++;
            } else if (( this.obtener(i)).compareTo(otro.obtener(j)) < 0) {
                conjunto.agregar(this.obtener(i));
                i++;
            } else if (( this.obtener(i)).compareTo(otro.obtener(j)) > 0) {
                j++;
            }
        }
        while (i < this.tamaño()) {
            conjunto.agregar(this.obtener(i));
            i++;
        }
        return conjunto;
    }

    @Override
    public boolean esSubconjuntoDe(TDAConjunto<T> otro) {
        int i = 0;
        int j = 0;
        while (i < this.tamaño() && j < otro.tamaño()) {
            if ((this.obtener(i)).compareTo(otro.obtener(j)) == 0) {
                i++;
                j++;
            } else if (( this.obtener(i)).compareTo(otro.obtener(j)) < 0) { // si el elemento de a es menor que el de b y ya pasó la comparación de si es igual a b,como esta ordenado, ya no es subconjunto de b.
                return false;
            } else if (( this.obtener(i)).compareTo(otro.obtener(j)) > 0) {
                j++;
            }
        }
        return(i == this.tamaño()); // si todos los elementos de A, estan en B, el contador de la cantidad de elementos iguales vale lo mismo que el tamaño de A.
    }
}
