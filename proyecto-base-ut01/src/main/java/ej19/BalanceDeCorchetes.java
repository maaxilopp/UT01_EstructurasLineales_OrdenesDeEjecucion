package ej19;
import ucu.edu.aed.impl.PilaEnlazada;
import java.util.List;

public class BalanceDeCorchetes {
    public boolean controlCorchetes(List<Character> listaDeEntrada){
        PilaEnlazada<Character> pila = new PilaEnlazada<>();
        for(int i = 0; i < listaDeEntrada.size(); i++){
            if(listaDeEntrada.get(i) != '}' && listaDeEntrada.get(i) != '{'){
                throw new RuntimeException("La pila solo almacena corchetes");
            }
            if(listaDeEntrada.get(i) == '}' && pila.tope() == null){
                return false;
            }
            if(listaDeEntrada.get(i) == '{'){
                pila.mete(listaDeEntrada.get(i));
            }
            if(listaDeEntrada.get(i) == '}' && pila.tope() != null){
                pila.saca();
            }
        }
        if(pila.tope() == null){
            return true;
        }
        else{
            return false;
        }

    }
}