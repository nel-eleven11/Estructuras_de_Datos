package src;

/*/
HDT 2 Algoritmos y estructuras de datos
Nelson García Bravatti 22434
Joaquín Puente 22296
Oscar Fuentes 22763

Clase postfix calculator

 */
public class PostfixCalculator  implements IPostfixCalculator{

    /**
     * Método que verifica si el stack tiene un solo item
     * @param operandos
     */
    @Override
    public boolean isOneItem(IStack operandos) {
        return operandos.count() == 1;
    }

    /**
     * Método que suma dos números
     * @param a
     * @param b
     * @return a + b
     */
    @Override
    public int suma(int a, int b) {
        return a + b;
    }

    /**
     * Método que resta dos números
     * @param a
     * @param b
     * @return a - b
     */
    @Override
    public int resta(int a, int b) {
        return a - b;
    }

    /**
     * Método que multiplica dos números
     * @param a
     * @param b
     * @return a * b
     */
    @Override
    public int multiplicacion(int a, int b) {
        return a * b;
    }

    /**
     * Método que divide dos números
     * @param a
     * @param b
     * @return a / b
     */
    @Override
    public int division(int a, int b) {
        return a / b;
    }

    /**
     * Método que verifica si un caracter es un operador
     * @param item
     * @return resultado
     */
    @Override
    public boolean isOperator(String item) {
        return item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/");
    }

    /**
     * Método que divide el string en caracteres individuales para operar
     * @param _expresion
     * @return resultado
     */
    @Override
    public java.util.ArrayList<String> getItems(String _expresion) {
        java.util.ArrayList<String> items = new java.util.ArrayList<String>();
        String[] itemsArray = _expresion.split(" ");
        for (String item : itemsArray) {
            items.add(item);
        }
        return items;
    }
}
