/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */

public class arithmetic {

    /*
    * @param a
    * @param b
    * @param op
    * @return int
    */

public static double verificarOp(double a, double b, String op){
    return switch (op) {
        case "+" -> a + b;
        case "-" -> a - b;
        case "*" -> a * b;
        case "/" -> a / b;
        case "mod" -> a % b;
        case "expt" -> (double) Math.pow(a, b);
        case "sqrt" -> (double) Math.sqrt(a);
        default -> 0;
    };
    }
}
