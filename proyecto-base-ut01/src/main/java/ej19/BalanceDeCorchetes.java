package ej19;
import ucu.edu.aed.impl.PilaEnlazada;
import java.util.List;

public class BalanceDeCorchetes {
    public boolean controlCorchetes(List<Character> listaDeEntrada) {
        PilaEnlazada<Character> pila = new PilaEnlazada<>();

        for (int i = 0; i < listaDeEntrada.size(); i++) {
            char elemento = listaDeEntrada.get(i);

            if (elemento != '}' && elemento != '{') {
                throw new RuntimeException("La pila solo almacena corchetes");
            }
            else if (elemento == '}') {
                if (pila.tope() == null) {
                    return false;
                } else {
                    pila.saca();
                }
            }

            else if (elemento == '{') {
                pila.mete(elemento);
            }

        }
        return (pila.tope() == null);
    }
}