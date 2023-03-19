import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
class interpreterTest {

    @Test
    public void testReadLisp() {
        ArrayList<String> lisp = new ArrayList<>(Arrays.asList("(", "+", "2", "3", ")"));
        String result = interpreter.readLisp(lisp);
        assertEquals("5", result);

        lisp = new ArrayList<>(Arrays.asList("(", "*", "(", "+", "1", "2", ")", "3", ")"));
        result = interpreter.readLisp(lisp);
        assertEquals("9", result);

        lisp = new ArrayList<>(Arrays.asList("(", "if", "(", "<", "1", "2", ")", "(", "+", "1", "2", ")", "(", "*", "3", "4", ")", ")"));
        result = interpreter.readLisp(lisp);
        assertEquals("3", result);
    }

    @Test
    public void testIfOperator() {
        ArrayList<String> lisp = new ArrayList<>(Arrays.asList("(", "if", "(", ">", "5", "3", ")", "(", "+", "2", "2", ")", "(", "-", "2", "2", ")", ")"));
        String expected = "4";
        String result = interpreter.readLisp(lisp);
        assertEquals(expected, result);
    }

    @Test
    public void testOrOperator() {
        ArrayList<String> lisp = new ArrayList<>(Arrays.asList("(", "or", "(", ">", "5", "3", ")", "(", "<", "2", "1", ")", ")", "t", "nil"));
        String expected = "t";
        String result = interpreter.readLisp(lisp);
        assertEquals(expected, result);
    }

    @Test
    public void testAndOperator() {
        ArrayList<String> lisp = new ArrayList<>(Arrays.asList("(", "and", "(", ">", "5", "3", ")", "(", "<", "2", "1", ")", ")", "t", "nil"));
        String expected = "nil";
        String result = interpreter.readLisp(lisp);

    }

    @Test
    void setqTest() {
        ArrayList<String> lisp = new ArrayList<>(Arrays.asList("(","(","setq", "a", "5", ")","(","print", "a", ")",")"));
        String expected = "5";
        String result = interpreter.readLisp(lisp);
        assertEquals(expected, result);
    }

    @Test
    void defunTest() {
        ArrayList<String> lisp = new ArrayList<>(Arrays.asList("(","defun","suma","(", "x", "y", ")","(","print", "(","+","x","y",")",")","(", "suma", "2", "5", ")",")"));
        String expected = "7";
        String result = interpreter.readLisp(lisp);
        System.out.println(functions.getFunction("suma"));
    }
}