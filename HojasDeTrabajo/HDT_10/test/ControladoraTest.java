/*
 * HDT 10 Algorigmos y estructura de datos
 * Nelson García Bravatti 22434
 * Joaquín Puente  22296
 *
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ControladoraTest {
    @Test
    public void testGetRutaMasCorta() {
        // Creamos la instancia de la controladora.
        Controladora controladora = new Controladora();
    }

    @Test
    void leerArchivoTest(){
        Controladora grafo = new Controladora();
        grafo.leerArchivo();
        FloydWarshall fw = grafo.getFloydWarshall();
        assertArrayEquals(new int[]{0, 10, 15}, fw.getDistancias()[0]);
        assertArrayEquals(new String[]{"", "SaoPaulo", "Lima"}, fw.getRecorridos()[0]);
    }
}