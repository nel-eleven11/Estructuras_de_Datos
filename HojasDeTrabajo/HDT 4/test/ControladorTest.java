import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControladorTest {

    @Test
    void importFile() {
        Controlador controlador = new Controlador();
        controlador.importFile("datos");
        assertEquals(controlador.getItems().size(), 2);
    }

    @Test
    void convertir() {
        Controlador controlador = new Controlador();
        String inFix = "1 + 2 ";
        controlador.convertir(inFix, 1);
        assertEquals(controlador.convertir(inFix, 1), "1 2 +");
    }

    @Test
    void calculate() {
        Controlador controlador = new Controlador();
        controlador.importFile("datos");
        ArrayList<String> items = new ArrayList<String>();
        items.add("1 2 +");
        controlador.calculate(items, 1);
        assertEquals(controlador.calculate(items, 1).get(0), 3);

    }

    @Test
    void getItems() {
        Controlador controlador = new Controlador();
        controlador.importFile("datos");
        assertEquals(controlador.getItems().size(), 2);

    }
}