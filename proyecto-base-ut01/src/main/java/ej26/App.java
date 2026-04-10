package ej26;
import ej26.ControlCorchetes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args){
        ControlCorchetes x = new ControlCorchetes();
        List<Character> ejemplo = new ArrayList<>(Arrays.asList('{', '}', '{', '{', '}', '}')); // true si todo sale bien
        List <Character> mal = new ArrayList<>(Arrays.asList( '{','{','{','{','{','}')); // false si todo sale bien
        List <Character> hiperMal = new ArrayList<>(Arrays.asList( '}', '{')); // false si todo sale bien
        List <Character> excepcionable = new ArrayList<>(Arrays.asList( 'a', '{')); // excepcion
        System.out.println( ejemplo + " es balanceada: " + x.controlCorchetes(ejemplo));
        System.out.println( mal + " es balanceada: " + x.controlCorchetes(mal));
        System.out.println( hiperMal + " es balanceada: " + x.controlCorchetes(hiperMal));
        try {
            System.out.println(excepcionable + " es balanceada: " + x.controlCorchetes(excepcionable));
        } catch (RuntimeException e) {
            System.out.println(excepcionable + " " +  e.getMessage());
        }
    }
}
