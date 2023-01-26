package src;

public class PostfixCalculator  implements IPostfixCalculator{

    @Override
    public boolean isOneItem(IStack operandos) {
        return operandos.count() == 1;
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
    public java.util.ArrayList<String> getItems(String _expresion) {
        java.util.ArrayList<String> items = new java.util.ArrayList<String>();
        String[] itemsArray = _expresion.split(" ");
        for (String item : itemsArray) {
            items.add(item);
        }
        return items;
    }
}
