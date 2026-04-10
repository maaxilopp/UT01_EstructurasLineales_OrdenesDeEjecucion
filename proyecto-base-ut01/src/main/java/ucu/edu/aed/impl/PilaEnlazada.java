package ucu.edu.aed.impl;

import ucu.edu.aed.tda.TDAPila;

import java.util.NoSuchElementException;

public class PilaEnlazada <T> extends ListaEnlazada <T> implements TDAPila  <T>{
    @Override
    public T tope() {
        if(primero == null){
            return null;
        }
        return primero.getDato();
    }

    @Override
    public T saca() {
        if (primero == null) {
            throw new NoSuchElementException("La pila está vacía");
        }
        T temporal = primero.getDato();
        primero = primero.getSiguiente();
        return temporal;
    }

    @Override
    public void mete(T dato) {
        Nodo <T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(primero);
        primero = nuevo;
    }
}
