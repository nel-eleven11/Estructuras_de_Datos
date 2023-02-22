/*
Nelson García Bravatti
22434
HDT 4
Clase calculadora
 */

import java.util.ArrayList;

public class Calculadora implements IPostfixCalculator{

    private static Calculadora instance = null;

    private Calculadora() {
    }

    
    /**
     * el método devuelve la instancia de la calculadora
     * @return Calculadora
     */
    public static Calculadora getInstance() {
        if (instance == null) {
            instance = new Calculadora();
        }
        return instance;
    }

    
    /**
     * isOneItem se encarga de verificar si la pila de operandos tiene un solo elemento.
     * @param operandos
     * @return boolean
     */
    @Override
    public boolean isOneItem(IStack operandos) {
        return operandos.count() == 1;
    }

    
    /**
     * suma se encarga de sumar dos números enteros.
     * @param a
     * @param b
     * @return int
     */
    @Override
    public int suma(int a, int b) {
        return a + b;
    }

    
    /**
     * resta se encarga de restar dos números enteros.
     * @param a
     * @param b
     * @return int
     */
    @Override
    public int resta(int a, int b) {
        return a - b;
    }

    
    /**
     * multiplicacion se encarga de multiplicar dos números enteros.
     * @param a
     * @param b
     * @return int
     */
    @Override
    public int multiplicacion(int a, int b) {
        return a * b;
    }

    
    /**
     * division se encarga de dividir dos números enteros.
     * @param a
     * @param b
     * @return int
     */
    @Override
    public int division(int a, int b) {
        return a / b;
    }

    
    /**
     * isOperator se encarga de verificar si el item es un operador.
     * @param item
     * @return boolean
     */
    @Override
    public boolean isOperator(String item) {
        return item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/");
    }

    
    /**
     * getItems se encarga de separar los items de la expresión. Genera un ArrayList con los items.
     * @param _expresion
     * @return ArrayList<String>
     */
    @Override
    public ArrayList<String> getItems(String _expresion) {
        java.util.ArrayList<String> items = new java.util.ArrayList<String>();
        String[] itemsArray = _expresion.split(" ");
        for (String item : itemsArray) {
            items.add(item);
        }
        return items;
    }
    
    /**
     * precedence se encarga de verificar la precedencia de los operadores.
     * @param item
     * @return int
     */
    public int precedence(String item) {
        if (item.equals("+") || item.equals("-")) {
            return 1;
        } else if (item.equals("*") || item.equals("/")) {
            return 2;
        } else {
            return 0;
        }
    }

}
