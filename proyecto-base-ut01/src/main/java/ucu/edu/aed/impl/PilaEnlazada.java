package ucu.edu.aed.impl;

import ucu.edu.aed.tda.TDAPila;

import java.util.NoSuchElementException;

public class PilaEnlazada <T> extends ListaEnlazada <T> implements TDAPila  <T>{
    @Override
    public T tope() {
        Nodo <T> actual = primero;
        if(actual == null){
            return null;
        }
        return actual.getDato();
    }

    @Override
    public T saca() {
        Nodo <T> actual = primero;
        if(actual == null) {
            throw new NoSuchElementException("La pila está vacia, no se le pueden sacar elementos");
        }
        primero = actual.getSiguiente();
        return actual.getDato();
    }

    @Override
    public void mete(T dato) {
        Nodo <T> actual = primero;
        Nodo <T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(actual);
        primero = nuevo;
    }
}
