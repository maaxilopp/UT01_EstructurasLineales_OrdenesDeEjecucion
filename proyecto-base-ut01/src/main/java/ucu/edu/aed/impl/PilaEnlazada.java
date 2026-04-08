package ucu.edu.aed.impl;

import ucu.edu.aed.tda.TDAPila;

public class PilaEnlazada <T> extends ListaEnlazada <T> implements TDAPila  <T>{
    @Override
    public T tope() {
        Nodo <T> actual = primero;
        if(actual == null){
            throw new IndexOutOfBoundsException("Pila vacía, no se puede mostrar el tope");
        }
        return actual.getDato();
    }

    @Override
    public T saca() {
        Nodo <T> actual = primero;
        if(actual == null){
            throw new IndexOutOfBoundsException("La pila está vacia, no se le pueden sacar elementos");
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
