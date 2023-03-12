import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class predicatesTest {

    @Test
    void verificar() {


        assertEquals(true, predicates.verificar("numberp", "1", "2"));
    }
}