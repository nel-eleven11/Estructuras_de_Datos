import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class predicatesTest {

    @Test
    void verificar() {

    assertEquals(true, predicates.verificar("numberp", "1", "", ""));
    assertEquals(true, predicates.verificar("symbolp", "a", "", ""));
    assertEquals(true, predicates.verificar("zerop", "0", "", ""));
    assertEquals(true, predicates.verificar("oddp", "1", "", ""));
    assertEquals(true, predicates.verificar("evenp", "2", "", ""));
    assertEquals(true, predicates.verificar("atom", "a", "", ""));
    assertEquals(true, predicates.verificar("eq", "a", "a", ""));
    assertEquals(true, predicates.verificar("listp", "'(a b c)", "", ""));
    assertEquals(true, predicates.verificar(">", "2", "1", ""));
    assertEquals(true, predicates.verificar("<", "1", "2", ""));
    assertEquals(true, predicates.verificar(">=", "2", "1", ""));
    assertEquals(true, predicates.verificar("<=", "1", "2", ""));
    assertEquals(true, predicates.verificar("==", "1", "1", ""));
    assertEquals(true, predicates.verificar("!=", "1", "2", ""));
    assertEquals(true, predicates.verificar("and", "1 1", "", ""));
    assertEquals(true, predicates.verificar("or", "1 0", "", ""));
    assertEquals(true, predicates.verificar("not", "0", "", ""));
    }
}