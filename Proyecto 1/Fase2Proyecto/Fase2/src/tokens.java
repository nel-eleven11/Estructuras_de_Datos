/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class tokens {
    /*
    * Clase que contiene los tokens que se van a utilizar en el proyecto
    * @param variables
    * @param value
    * @return void
     */
    public static void setq(String variable, String value) {
        variables.addVariable(variable, value);
    }
    /*
    * añade a una funcion
    * @param functions
    * @param value
    * @return void
     */
    public static void defun(String function, ArrayList<String> params, ArrayList<String> body) {
        ArrayList<ArrayList<String>> paramsAndBody = new ArrayList<>();
        params.remove(0);
        params.remove(params.size() - 1);
        paramsAndBody.add(params);
        paramsAndBody.add(body);
        functions.addFunction(function, paramsAndBody);
    }
    /*
    * añade una constante
    * @param constants
    * @param value
    * @return void
     */
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

    /**
     *predicados
     * @param simbolo
     * @param a
     * @param b
     * @return boolean
     */
    public  static boolean pred(String simbolo,String a, String b, String simobolo2){
        return predicates.verificar(simbolo,a,b,simobolo2);
    }
    /**
     * print sirve para imprimir en consola
     *
     * @param value
     * @return String
     */
    public static String print(String value) {
        System.out.println(value);
        return value;
    }
    /**
     * print sirve para imprimir en consola
     *
     * @param cond
     * @param op
     * @param a
     * @param b
     * @param consecuencias
     * @return String
     */
    public static String conditional(String cond, ArrayList<String> op, ArrayList<String> a, ArrayList<String> b, ArrayList<String> consecuencias){
        return conditionals.verificarCondicion(cond, op, a, b, consecuencias);
    }

    /**
     * Tokens reservado en lisp
     */
    private static final String[] reservedTokens = {"<", ">", "<=", ">=", "==", "!=", "listp", "atom", "symbolp", "numberp", "consp", "eq", "equal", "zerop", "oddp", "evenp", "and", "or", "not", "+", "-", "*", "/", "mod", "exp", "sqrt", "if", "cond", "when", "unless", "print", "setq", "defun", "quote"};
    /**
     * The number of arguments each token takes.
     */
    private static final HashMap<String, Integer> tokenArguments = new HashMap<>() {{
        put("<", 2);
        put(">", 2);
        put("<=", 2);
        put(">=", 2);
        put("==", 2);
        put("!=", 2);
        put("listp", 1);
        put("atom", 1);
        put("symbolp", 1);
        put("numberp", 1);
        put("consp", 1);
        put("eq", 2);
        put("equal", 2);
        put("zerop", 1);
        put("oddp", 1);
        put("evenp", 1);
        put("and", 2);
        put("or", 2);
        put("not", 1);
        put("+", 2);
        put("-", 2);
        put("*", 2);
        put("/", 2);
        put("mod", 2);
        put("exp", 2);
        put("sqrt", 1);
        put("if", 3);
        put("cond", 2);
        put("when", 2);
        put("unless", 2);
        put("print", 1);
        put("setq", 2);
        put("defun", 3);
        put("quote", 1);
    }};

    public static HashMap<String, Integer> getTokenArguments() {
        return tokenArguments;
    }

    public static String[] getReservedTokens() {
        return reservedTokens;
    }


}
