package ej26;

import java.util.List;
import java.util.Stack;

public class ControlCorchetes {
    public boolean controlCorchetes(List<Character> entrada){
        Stack<Character> pilaCorchetes = new Stack<>();

        for (char elemento : entrada) {
            if ((elemento != '}') && (elemento != '{')) {
                throw new RuntimeException("ERROR: Carácter inválido: " + elemento);
            }
            if (elemento == '}') {
                if (pilaCorchetes.isEmpty()) {
                    return false;
                } else {
                    pilaCorchetes.pop();
                }
            }
            if (elemento == '{') {
                pilaCorchetes.push(elemento);
            }
        }
        return(pilaCorchetes.isEmpty());
    }
}
