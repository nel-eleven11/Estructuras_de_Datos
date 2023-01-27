package src;

/*/
HDT 2 Algoritmos y estructuras de datos
Nelson García Bravatti 22434
Joaquín Puente 22296
Oscar Fuentes 22763

Clase controller test

 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    Controller miControlador = new Controller();

    @Test
    void calculate() {

        miControlador.importFile("texto");

        assertEquals(8, miControlador.calculate("2 6 +"));
    }
}