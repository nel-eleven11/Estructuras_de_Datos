import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorTest {

    @Test
    void getItems() {
    }

    @Test
    void importFile() {
        Controlador controlador = new Controlador();
        controlador.importFile("diccionario");
        for(String item : controlador.getItems())
            System.out.println(item);
        assertEquals(18, controlador.getItems().size());

    }

    @Test
    void importFile2() {
        Controlador controlador = new Controlador();
        controlador.importFile("texto");
        for(String item : controlador.getItems())
            System.out.println(item);
        assertEquals(11, controlador.getItems().size());
    }

    @Test
    void agregarPalabras() {
        Controlador controlador = new Controlador();
        controlador.importFile("diccionario");
    }
}