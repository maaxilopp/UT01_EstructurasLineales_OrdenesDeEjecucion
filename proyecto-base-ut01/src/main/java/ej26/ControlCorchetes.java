package ej26;

import java.util.List;
import java.util.Stack;

public class ControlCorchetes {
    public boolean controlCorchetes(List<Character> entrada){
        Stack<Character> pilaCorchetes = new Stack<>();

        for(int i = 0; i < entrada.size();i++){
            char elemento = entrada.get(i);

            if((elemento != '}') && (elemento != '{')){
                throw new RuntimeException("La estructura solo soporta { o }");
            }
            if(elemento == '}') {
                if (pilaCorchetes.isEmpty()) {
                    return false;
                }
                else{
                    pilaCorchetes.pop();
                }
            }
            if(elemento== '{'){
                pilaCorchetes.push(elemento);
            }
        }
        return(pilaCorchetes.isEmpty());
    }
}
