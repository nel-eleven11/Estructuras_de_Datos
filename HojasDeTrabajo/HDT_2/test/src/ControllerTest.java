package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    Controller miControlador = new Controller();

    @Test
    void calculate() {

        miControlador.importFile("texto");

        assertEquals(5, miControlador.calculate("2 3 +"));
    }
}