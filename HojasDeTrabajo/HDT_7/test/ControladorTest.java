import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ControladorTest {

    @Test
    void getItems() {
        Controlador controlador = new Controlador();
        controlador.importFile("diccionario");
        for(String item : controlador.getItems2())
            System.out.println(item);
        assertEquals(18, controlador.getItems2().size());
    }

    @Test
    void importFile() {
        Controlador controlador = new Controlador();
        controlador.importFile("diccionario");
        for(String item : controlador.getItems2())
            System.out.println(item);
        assertEquals(18, controlador.getItems2().size());

    }

    @Test
    void importFile2() {
        Controlador controlador = new Controlador();
        controlador.importFile("texto");
        for(ArrayList<String> item : controlador.getItems1())
            System.out.println(item);
        assertEquals(2, controlador.getItems1().size());
    }

    @Test
    void agregarPalabras() {
        Controlador controlador = new Controlador();
        controlador.importFile("diccionario");
        controlador.AgregarPalabras(controlador.getItems2());
        assertEquals(false, controlador.ArbolIngles.isEmpty());
        assertEquals(false, controlador.ArbolEspaniol.isEmpty());
        assertEquals(false, controlador.ArbolFrances.isEmpty());
    }

    @Test
    void buscarPalabra() {
        Controlador controlador = new Controlador();
        controlador.importFile("diccionario");
        controlador.AgregarPalabras(controlador.getItems2());
        assertEquals("house", controlador.ArbolIngles.search("house").getPalabra());

    }
}