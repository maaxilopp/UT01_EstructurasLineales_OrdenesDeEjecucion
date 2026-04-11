package ucu.edu.aed.impl;
import ucu.edu.aed.tda.TDAConjunto;

public class ConjuntoEnlazado<T> extends ListaEnlazada <T> implements TDAConjunto<T> {
    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otro) {
        ConjuntoEnlazado<T> conjunto = new ConjuntoEnlazado<>();
        int i = 0;
        int j = 0;
        while(i < this.tamaño() && j < otro.tamaño()){
            if(this.obtener(i) == otro.obtener(j)) {
                conjunto.agregar(this.obtener(i));
                i++;
                j++;
            }
            else if(((Comparable<T>)this.obtener(i)).compareTo(otro.obtener(j)) < 0){
                    conjunto.agregar(this.obtener(i));
                    i++;

            }
            else if(((Comparable<T>)this.obtener(i)).compareTo(otro.obtener(j)) > 0) {
                conjunto.agregar(otro.obtener(j));
                j ++;
            }

        }
        while(i < this.tamaño()){
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
        return null;
    }

    @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otro) {
        return null;
    }

    @Override
    public boolean esSubconjuntoDe(TDAConjunto<T> otro) {
        return false;
    }
}
