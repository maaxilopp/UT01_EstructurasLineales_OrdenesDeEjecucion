package ucu.edu.aed.impl;

import ucu.edu.aed.tda.TDACola;

import java.util.NoSuchElementException;

public class ColaEnlazada <T> extends ListaEnlazada<T> implements TDACola <T> {
    @Override
    public T frente() {
        if(primero == null){
            throw new NoSuchElementException("Cola vacia");
        }
        return primero.getDato();
    }

    @Override
    public boolean poneEnCola(T dato) {
        Nodo <T> actual = primero;
        Nodo<T> nuevo = new Nodo<>(dato);
        if(primero == null){
            primero = nuevo;
            return true;
        }
        while(actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
        return true;
    }

    @Override
    public T quitaDeCola() {
        if(primero == null){
            throw new NoSuchElementException("Cola Vacía");
        }
        Nodo <T> temp = primero;
        primero = primero.getSiguiente();
        return temp.getDato();
    }
}
