import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class interpreterTest {

    @Test
    void evaluateExpression() {

        interpreter.evaluateExpression("( print ( + 1 2 ) )");

    }
}