package ucu.edu.aed.impl;

import ucu.edu.aed.tda.TDACola;




public class ColaCircular<T> implements TDACola<T> {
    private T[] elementos;
    private int primero;
    private int ultimo;
    private int cantidad;

    public ColaCircular(int capacidad){
        this.elementos = (T[]) new Object[capacidad]; // ✔ correcto
        this.primero = -1;
        this.ultimo = -1;
        this.cantidad = 0;
    }

    private boolean esVacio(){
        return cantidad == 0;
    }

    @Override
    public T quitaDeCola() {
        T elemento;
        if (esVacio()) {
            return null;
        } else {
            elemento = elementos[primero];
            elementos[primero] = null;
        }
        if (primero == ultimo) {
            primero = -1;
            ultimo = -1;
        } else {
            primero = (primero + 1) % elementos.length;
        }
        return elemento;

    }

    @Override
    public T frente() {
        return elementos[0];
        }



    @Override
    public boolean poneEnCola(T dato){
        if (cantidad == elementos.length){
            System.out.println("COLA LLENA");
            return false;
        } else if () {
            
        }
    }
    
}






