import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class conditionalsTest {

    @Test
    void verificarCondicion() {
        ArrayList<String> op = new ArrayList<>();
        op.add("<");
        ArrayList<String> a = new ArrayList<>();
        a.add("1");
        ArrayList<String> b = new ArrayList<>();
        b.add("2");
        ArrayList<String> consecuencias = new ArrayList<>();
        consecuencias.add("hola");
        assertEquals("hola", conditionals.verificarCondicion("if", op, a, b, consecuencias));
        ArrayList<String> consecuencias2 = new ArrayList<>();
        consecuencias2.add("hola");
        assertEquals("hola", conditionals.verificarCondicion("cond", op, a, b, consecuencias2));
        ArrayList<String> consecuencias3 = new ArrayList<>();
        consecuencias3.add("hola");
        assertEquals("hola", conditionals.verificarCondicion("when", op, a, b, consecuencias3));
        ArrayList<String> consecuencias4 = new ArrayList<>();
        consecuencias4.add("hola");
        assertEquals("NIL", conditionals.verificarCondicion("unless", op, a, b, consecuencias4));


    }
}