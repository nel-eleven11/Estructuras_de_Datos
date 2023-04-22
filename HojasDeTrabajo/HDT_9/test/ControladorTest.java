import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class ControladorTest {

    @Test
    void getItems1() {
        Controlador controlador = new Controlador();
        controlador.importFile("diccionario");
        controlador.importFile("texto");
        System.out.println(controlador.getItems1());
        System.out.println(" /n ");
        System.out.println(controlador.getItems2());
    }



    @Test
    void importFile() {
        Controlador controlador = new Controlador();
        controlador.importFile("diccionario");
        for(String item : controlador.getItems2())
            System.out.println(item);
    }

    @Test
    void importFile2() {
        Controlador controlador = new Controlador();
        controlador.importFile("texto");
        for(ArrayList<String> item : controlador.getItems1())
            System.out.println(item);
    }

    @Test
    void agregarPalabras() {
    }

    @Test
    void traducirTexto() {
    }
}