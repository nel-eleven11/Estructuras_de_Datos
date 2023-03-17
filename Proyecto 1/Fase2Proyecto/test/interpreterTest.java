import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class interpreterTest {

    @Test
    void evaluateExpression() {
        ArrayList<String> lisp = new ArrayList<>();
        lisp.add("(");
        lisp.add("defun");
        lisp.add("funcion");
        lisp.add("(");
        lisp.add("x");
        lisp.add("y");
        lisp.add(")");
        lisp.add("(");
        lisp.add("+");
        lisp.add("x");
        lisp.add("y");
        lisp.add(")");
        lisp.add(")");
        System.out.println(lisp);
        interpreter.readLisp(lisp);
        System.out.println(functions.getFunction("funcion").get(0));




    }
}