/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */
import javax.swing.*;

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
    public static void defun(String function, String[] params, String[] body) {
        functions.addFunction(function, new Object[]{params, body});
    }
    /*
    * añade una constante
    * @param constants
    * @param value
    * @return void
     */
    public static void setConst(String constant, String value) {
        variables.addConstant(constant, value);
    }
    /*
    *retorna el valor de una variable
    * @param variables
    * @param name
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
    public  static boolean pred(String simbolo,String a, String b){
        return predicates.verificar(simbolo,a,b);
    }

    public static String print(String value) {
        System.out.println(value);
        return value;
    }



    public static String conditional(String cond, String [] op,String [] a, String [] b, String [] consecuencias){
        return conditionals.verificarCondicion(cond, op, a, b, consecuencias);
    }
}
