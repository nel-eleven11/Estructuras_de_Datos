import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class predicatesTest {

    @Test
    void verificar() {


        assertTrue(predicates.verificar("numberp", "1", "2"));
        assertTrue(predicates.verificar("symbolp", "a", "2"));
        assertTrue(predicates.verificar("zerop", "0", "2"));
        assertEquals(true,predicates.verificar("oddp", "1", "2"));
        assertEquals(true,predicates.verificar("evenp", "2", "2"));
        assertEquals(true,predicates.verificar("atom", "a", "2"));
        assertEquals(true,predicates.verificar("eq", "a", "a"));
        assertEquals(true,predicates.verificar("listp", "'(a b c)", "2"));
        assertEquals(true,predicates.verificar(">", "2", "1"));
        assertEquals(true,predicates.verificar("<", "1", "2"));
        assertEquals(true,predicates.verificar(">=", "2", "1"));
        assertEquals(true,predicates.verificar("<=", "1", "2"));
        assertEquals(true,predicates.verificar("==", "1", "1"));
        assertEquals(true,predicates.verificar("!=", "1", "2"));
        assertEquals(true,predicates.verificar("not", "a"));
        assertEquals(true,predicates.verificar("and", "T", "T"));
        assertEquals(true,predicates.verificar("or", "T", "F"));

    }
}