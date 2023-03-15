import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class interpreterTest {

    @Test
    void evaluateExpression() {
        ArrayList<String> lisp = new ArrayList<>();
        lisp.add("(");
        lisp.add("print");
        lisp.add("(");
        lisp.add("+");
        lisp.add("1");
        lisp.add("2");
        lisp.add(")");
        lisp.add(")");
        interpreter.readLisp(lisp);

    }
}