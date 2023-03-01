/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */


public class conditionals {

    /**
     * Este método se encarga de verificar si la condición es verdadera o falsa
     * @param a
     * @param b
     * @param operator
     * @return boolean
     */
    public static boolean conditionalCheck(int a, int b, String operator){
        switch (operator) {
            case ">":
                if (a > b) {
                    return true;
                }
            case "<":
                if (a < b) {
                    return true;
                }
            case ">=":
                if (a >= b) {
                    return true;
                }
            case "<=":
                if (a <= b) {
                    return true;
                }
            case "==":
                if (a == b) {
                    return true;
                }
                break;
            case "!=":
                if (a != b) {
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

}
