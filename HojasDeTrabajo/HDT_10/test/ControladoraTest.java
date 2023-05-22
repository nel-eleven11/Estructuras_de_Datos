/*
 * HDT 10 Algorigmos y estructura de datos
 * Nelson García Bravatti 22434
 * Joaquín Puente  22296
 *
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    void getRutaMasCorta() {
        Controladora controladora = new Controladora();

        List<String> ciudades = Arrays.asList("BuenosAires", "Lima", "Quito");

        ArrayList<String> rutaMasCorta = controladora.getRutaMasCorta("BuenosAires", "Quito");

        for (int i = 0; i < rutaMasCorta.size(); i++) {
            System.out.println(i + " " + rutaMasCorta.get(i));
        }

        assertEquals(3, rutaMasCorta.size());
        assertEquals("BuenosAires", rutaMasCorta.get(0));
        assertEquals("Lima", rutaMasCorta.get(1));
        assertEquals("Quito", rutaMasCorta.get(2));
    }
}