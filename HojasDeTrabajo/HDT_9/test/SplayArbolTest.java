/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplayArbolTest {

    @Test
    void add() {
        EstructuraArbol arbol = new SplayArbol();
        arbol.add(new Palabra("hello","hola"));
        arbol.add(new Palabra("world","mundo"));
        arbol.add(new Palabra("good","bueno"));
        assertEquals("hola", arbol.get("hello"));
        assertEquals("mundo", arbol.get("world"));
        assertEquals("bueno", arbol.get("good"));
    }

    @Test
    void get() {
        EstructuraArbol arbol = new SplayArbol();
        arbol.add(new Palabra("hello","hola"));
        arbol.add(new Palabra("world","mundo"));
        arbol.add(new Palabra("good","bueno"));
        assertEquals("hola", arbol.get("hello"));
        assertEquals("mundo", arbol.get("world"));
        assertEquals("bueno", arbol.get("good"));
    }
}