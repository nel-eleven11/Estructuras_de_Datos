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

public static int verificarOp(int a, int b, String op){
        switch (op){
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }
}
