import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Node test.
 */
class NodeTest {
    /**
     * Test ciudad.
     */
    @Test
    void testCiudad() {
        Node ciudad = new Node("BuenosAires");
        assertEquals("BuenosAires", ciudad.getNombre());

        Integer[] tiempos = new Integer[]{10, 15, 20, 50};
        ciudad.addDistance("SaoPaulo", tiempos);

        Map<String, Integer[]> tiemposViaje = ciudad.getTiemposViaje();
        assertArrayEquals(tiempos, tiemposViaje.get("SaoPaulo"));
    }
}