package ucu.edu.aed.impl;

import ucu.edu.aed.tda.TDACola;

public class ColaEnlazada <T> extends ListaEnlazada<T> implements TDACola <T> {
    @Override
    public T frente() {
        return null;
    }

    @Override
    public boolean poneEnCola(T dato) {
        return false;
    }

    @Override
    public T quitaDeCola() {
        return null;
    }
}
