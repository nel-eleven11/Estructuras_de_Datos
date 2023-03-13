import javax.swing.*;

public class tokens {

    public static void setq(String variable, String value) {
        variables.addVariable(variable, value);
    }

    public static void defun(String function, String value) {
        functions.addFunction(function, value);
    }

    public static void setConst(String constant, String value) {
        variables.addConstant(constant, value);
    }

    public static double arithmetic(double a, double b, String op) {
        return arithmetic.verificarOp(a, b, op);
    }

    /**
     * quote sirve para pasar de cualquier tipo de dato a una String
     *
     * @param value
     * @return String
     */
    public static String quote(Object value) {
        return value.toString();
    }
    public  static boolean pred(String simbolo,String a, String b){
        return predicates.verificar(simbolo,a,b);
    }
    public static void print(Object value) {
        System.out.println(value);
    }
}
