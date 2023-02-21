/*
Nelson García Bravatti
22434
HDT 4
Convierte el fix a post
 */
import java.util.ArrayList;

public class FixToPost {

    
    /**
     * el método convertidor se encarga de convertir la expresión infix a postfix, devuelve un string con la expresión en postfix.
     * el parámetro 'tipo' es para indicar el tipo de pila que se va a utilizar, 1 para ArrayList, 2 para Vector, 3 para SinglyLinkedList y 4 para DoublyLinkedList.
     * @param infix
     * @param tipo
     * @return String
     */
    public String convertidor(String infix, int tipo) {

        ArrayList<String> items = new ArrayList<String>();

        String[] itemsArray;
        if(infix.contains(" ")){
            itemsArray = infix.split((" "));
        }
        else{
            itemsArray = infix.split((""));
        }

        for (String item : itemsArray) {
            items.add(item);
        }

        Factory<String> factory = new Factory<String>();
        IStack<String> operandos = factory.getStack(tipo);
        IStack<String> operadores = factory.getStack(tipo);
        IStack<String> resultado = factory.getStack(tipo);

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
        return resultado.pull();
        //System.out.println(resultado.pull());

    }

}
