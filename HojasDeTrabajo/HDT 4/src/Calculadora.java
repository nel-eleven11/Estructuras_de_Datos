/*
Nelson García Bravatti
22434
HDT 4

 */

import java.util.ArrayList;

public class Calculadora implements IPostfixCalculator{

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
}
