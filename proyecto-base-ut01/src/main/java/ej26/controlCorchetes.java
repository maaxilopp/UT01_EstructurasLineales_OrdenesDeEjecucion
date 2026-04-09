package ej26;

import java.util.List;
import java.util.Stack;

public class controlCorchetes {
    public boolean controCorchetes(List<Character> entrada){
        Stack<Character> pilaCorchetes = new Stack<>();
        boolean flag = false;
        for(int i = 0; i < entrada.size();i++){
            if((entrada.get(i) != '}') && (entrada.get(i) != '{')){
                System.out.println("La estructura solo soporta { o }");
                break;
            }
            if(entrada.get(i) == '}' && pilaCorchetes.pop() == null){
                return flag;
            }
            if(entrada.get(i)== '{'){
                pilaCorchetes.push(entrada.get(i));
            }
            if (entrada.get(i) == '}' && pilaCorchetes.pop() != null){
                pilaCorchetes.pop();
            }
        }
        if (pilaCorchetes.pop()== null){
            flag = true;
        }
        return flag;
    }
}
