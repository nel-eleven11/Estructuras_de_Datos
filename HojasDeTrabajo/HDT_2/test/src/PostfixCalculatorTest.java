package src;

/*/
HDT 2 Algoritmos y estructuras de datos
Nelson García Bravatti 22434
Joaquín Puente 22296
Oscar Fuentes 22763

Clase postfix calculator test

 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostfixCalculatorTest {

    PostfixCalculator micalc = new PostfixCalculator();

    @Test
    void suma() {

        micalc.suma(2, 3);
        assertEquals(5, micalc.suma(2, 3));

    }

    @Test
    void resta() {

        micalc.resta(2, 3);
        assertEquals(-1, micalc.resta(2, 3));
    }

    @Test
    void multiplicacion() {

        micalc.multiplicacion(2, 3);
        assertEquals(6, micalc.multiplicacion(2, 3));
    }

    @Test
    void division() {

        micalc.division(5,25);
        assertEquals(5, micalc.division(5,25));
    }

    @Test
    void isOperator() {

        micalc.isOperator("+");
        assertEquals(true, micalc.isOperator("+"));
    }

    @Test
    void getItems() {
        micalc.getItems("2 3 +");
        assertEquals(3, micalc.getItems("2 3 +").size());
    }
}