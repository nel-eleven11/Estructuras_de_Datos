/*
Nelson García Bravatti
22434
HDT 4
Convierte el fix a post
 */
import java.util.ArrayList;

public class FixToPost {

    public void convertidor(String infix){

        ArrayList<String> items = new ArrayList<String>();
        String[] itemsArray = infix.split(" ");
        for (String item : itemsArray) {
            items.add(item);
        }

        Factory<String> factory = new Factory<String>();
        IStack<String> operandos = factory.getStack(1);
        IStack<String> operadores = factory.getStack(1);
        IStack<String> resultado = factory.getStack(1);

        for (String item : items) {
            if (item.equals("(")) {
                operadores.push(item);
            } else if (item.equals(")")) {
                while (!operadores.peek().equals("(")) {
                    String operador = operadores.pull();
                    String operando2 = operandos.pull();
                    String operando1 = operandos.pull();
                    String expresion = operando1 + " " + operando2 + " " + operador;
                    operandos.push(expresion);
                }
                operadores.pull();
            } else if (Calculadora.getInstance().isOperator(item)) {
                while (!operadores.isEmpty() && !operadores.peek().equals("(") && Calculadora.getInstance().precedence(item) <= Calculadora.getInstance().precedence(operadores.peek())) {
                    String operador = operadores.pull();
                    String operando2 = operandos.pull();
                    String operando1 = operandos.pull();
                    String expresion = operando1 + " " + operando2 + " " + operador;
                    operandos.push(expresion);
                }
                operadores.push(item);
            } else {
                operandos.push(item);
            }
        }
        while (!operadores.isEmpty()) {
            String operador = operadores.pull();
            String operando2 = operandos.pull();
            String operando1 = operandos.pull();
            String expresion = operando1 + " " + operando2 + " " + operador;
            operandos.push(expresion);
        }
        resultado.push(operandos.pull());
        System.out.println(resultado.pull());

    }

}
