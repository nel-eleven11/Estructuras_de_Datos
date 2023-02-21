import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class CalculadoraTest {

    @Test
    void getInstance() {
        Calculadora calculadora = Calculadora.getInstance();
        assertEquals(calculadora.getClass(), Calculadora.class);

    }

    @Test
    void isOneItem() {

        Calculadora calculadora = Calculadora.getInstance();
        IStack operandos = new StackUsingArrayList();
        operandos.push(1);
        assertTrue(calculadora.isOneItem(operandos));
        operandos.push(1);
        assertFalse(calculadora.isOneItem(operandos));

    }

    @Test
    void suma() {
        Calculadora calculadora = Calculadora.getInstance();
        assertEquals(calculadora.suma(1, 2), 3);

    }

    @Test
    void resta() {
        Calculadora calculadora = Calculadora.getInstance();
        assertEquals(calculadora.resta(1, 2), -1);
    }

    @Test
    void multiplicacion() {
        Calculadora calculadora = Calculadora.getInstance();
        assertEquals(calculadora.multiplicacion(1, 2), 2);
    }

    @Test
    void division() {
        Calculadora calculadora = Calculadora.getInstance();
        assertEquals(calculadora.division(1, 2), 0);
    }

    @Test
    void isOperator() {
        Calculadora calculadora = Calculadora.getInstance();
        assertTrue(calculadora.isOperator("+"));
        assertTrue(calculadora.isOperator("-"));
        assertTrue(calculadora.isOperator("*"));
        assertTrue(calculadora.isOperator("/"));
        assertFalse(calculadora.isOperator("a"));
    }

    @Test
    void getItems() {
        Calculadora calculadora = Calculadora.getInstance();
        ArrayList<String> items = calculadora.getItems("1 + 2");
        assertEquals(items.get(0), "1");
        assertEquals(items.get(1), "+");
        assertEquals(items.get(2), "2");
    }

    @Test
    void precedence() {
        Calculadora calculadora = Calculadora.getInstance();
        assertEquals(calculadora.precedence("+"), 1);
        assertEquals(calculadora.precedence("-"), 1);
        assertEquals(calculadora.precedence("*"), 2);
        assertEquals(calculadora.precedence("/"), 2);
        assertEquals(calculadora.precedence("a"), 0);
    }
}