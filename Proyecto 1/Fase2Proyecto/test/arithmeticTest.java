import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class arithmeticTest {

    @Test
    void verificarOp() {
        assertEquals(3, arithmetic.verificarOp(1, 2, "+"));
        assertEquals(-1, arithmetic.verificarOp(1, 2, "-"));
        assertEquals(2, arithmetic.verificarOp(1, 2, "*"));
        assertEquals(0.5, arithmetic.verificarOp(1, 2, "/"));
        assertEquals(1, arithmetic.verificarOp(1, 2, "mod"));
        assertEquals(1, arithmetic.verificarOp(1, 2, "expt"));
        assertEquals(1, arithmetic.verificarOp(1, 2, "sqrt"));
    }
}