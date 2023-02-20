/*
Nelson García Bravatti
22434
HDT 4
Clase calculadora
 */

import java.util.ArrayList;

public class Calculadora implements IPostfixCalculator{

    //metodo para hacer que solo se puede crear una instancia de la calculadora
    private static Calculadora instance = null;

    private Calculadora() {
    }

    public static Calculadora getInstance() {
        if (instance == null) {
            instance = new Calculadora();
        }
        return instance;
    }

    @Override
    public boolean isOneItem(IStack operandos) {
        return false;
    }

    @Override
    public int suma(int a, int b) {
        return a + b;
    }

    @Override
    public int resta(int a, int b) {
        return a - b;
    }

    @Override
    public int multiplicacion(int a, int b) {
        return a * b;
    }

    @Override
    public int division(int a, int b) {
        return a / b;
    }

    @Override
    public boolean isOperator(String item) {
        return item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/");
    }

    @Override
    public ArrayList<String> getItems(String _expresion) {
        java.util.ArrayList<String> items = new java.util.ArrayList<String>();
        String[] itemsArray = _expresion.split(" ");
        for (String item : itemsArray) {
            items.add(item);
        }
        return items;
    }
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
