/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class mainTest {

    @Test
    void importFile() {

        main.importFile("archivo");
        int i = main.getItems().size();
        boolean b = false;
        if (i > 0) {
            b = true;
        }
        else{
            b = false;
        }
        assertEquals(true, b);

    }

    @Test
    void getItems() {
        main.importFile("archivo");
        for (int i = 0; i < main.getItems().size(); i++){
            System.out.print(main.getItems().get(i)+" ");
        }
        assertEquals("(", main.getItems().get(0));
    }

    @Test
    void main() {
    }
}