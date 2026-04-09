package ImplTests;

import ej19.BalanceDeCorchetes;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackTest extends TestCase {

    public void testListaVacia(){
        BalanceDeCorchetes x = new BalanceDeCorchetes();
        List<Character> vacia = new ArrayList<>(Arrays.asList());
        assertTrue(x.controlCorchetes(vacia));
    }

    public void testSoloAperturas(){
        BalanceDeCorchetes x = new BalanceDeCorchetes();
        List<Character> soloApertura = new ArrayList<>(Arrays.asList('{', '{', '{'));
        assertFalse(x.controlCorchetes(soloApertura));
    }

    public void testSoloCierre(){
        BalanceDeCorchetes x = new BalanceDeCorchetes();
        List<Character> soloCierre = new ArrayList<>(Arrays.asList('}', '}', '}'));
        assertFalse(x.controlCorchetes(soloCierre));
    }

    public void testMalOrden(){
        BalanceDeCorchetes x = new BalanceDeCorchetes();
        List<Character> malOrden = new ArrayList<>(Arrays.asList('}', '{'));
        assertFalse(x.controlCorchetes(malOrden));
    }

    public void testErroFinal(){
        BalanceDeCorchetes x = new BalanceDeCorchetes();
        List<Character> errorFinal = new ArrayList<>(Arrays.asList('{', '{', '}', '}', '{'));
        assertFalse(x.controlCorchetes(errorFinal));
    }
    public void testComplejoCorrecto(){
        BalanceDeCorchetes x = new BalanceDeCorchetes();
        List<Character> complejoCorrecto = new ArrayList<>(Arrays.asList('{', '{', '}', '{', '}', '}'));
        assertTrue(x.controlCorchetes(complejoCorrecto));
    }
}
