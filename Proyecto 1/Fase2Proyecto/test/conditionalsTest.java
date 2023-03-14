import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class conditionalsTest {

    @Test
    void verificarCondicion() {
        String [] op = {"<"};
        String [] a = {"1"};
        String [] b = {"2"};
        String [] consecuencias = {"hola"};
        assertEquals("hola", conditionals.verificarCondicion("if", op, a, b, consecuencias));
        String [] consecuencias2 = {"hola", "mundo"};
        String [] op1 = {"<"};
        String [] a1 = {"1"};
        String [] b1 = {"2"};
        assertEquals("hola", conditionals.verificarCondicion("cond", op, a, b, consecuencias2));
        String [] consecuencias3 = {"hola"};
        String [] op2 = {"<"};
        String [] a2 = {"1"};
        String [] b2 = {"2"};
        assertEquals("hola", conditionals.verificarCondicion("when", op, a, b, consecuencias3));
        String [] consecuencias4 = {"hola"};
        assertEquals("NIL", conditionals.verificarCondicion("unless", op, a, b, consecuencias4));


    }
}