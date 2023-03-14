/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */
import java.util.Arrays;
import java.util.Stack;


public class interpreter {

    private static Object evaluate(String expression) {
        String[] tokensL = expression.split("\\s+");
        Stack<Object> stack = new Stack<>();
        for (int i = tokensL.length - 1; i >= 0; i--) {
            String token = tokensL[i];

            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                Object operand1 = stack.pop();
                Object operand2 = stack.pop();
                double result = (tokens.arithmetic((Double) operand1, (Double) operand2,token));
                stack.push(result);
            } else if (isLispExpression(token)) {
                // Remove the first and last parentheses of the Lisp expression
                String lispExpression = token.substring(1, token.length() - 1);
                Object result = evaluate(lispExpression);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static boolean isLispExpression(String token) {
        return token.startsWith("(") && token.endsWith(")");
    }

    public static void evaluateExpression(String comando) {
        String[] comandoSeparado = comando.split(" ");

        System.out.println(comando);

        for (int i = 0; i < comandoSeparado.length; i++) {
            comandoSeparado[i] = comandoSeparado[i].trim();
            System.out.println(comandoSeparado[i]);
        }

        for (int i = 0; i < comandoSeparado.length; i++) {
            if (comandoSeparado[i].equals("(")) {

            }
        }

        if (comandoSeparado[0].equals("(")) {
            // Start of a Lisp expression
            Stack<String> stack = new Stack<>();
            stack.push("(");
            for (int i = 1; i < comandoSeparado.length; i++) {
                String token = comandoSeparado[i];
                if (token.equals("(")) {
                    stack.push("(");
                } else if (token.equals(")")) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        // End of the Lisp expression
                        String lispExpression = comando.substring(1, i + 1);
                        System.out.println(lispExpression);
                        Object result = evaluate(lispExpression);
                        System.out.println(result); // Print the result
                        break;
                    }
                }
            }
        } else {
            // Not a Lisp expression, handle as a regular token
            String[] predicatesSym = {"<", ">", "<=", ">=", "==", "!=", "listp", "atom", "symbolp", "numberp", "consp", "eq", "equal", "zerop", "oddp", "evenp", "and", "or", "not"};
            String[] arithmeticOp = {"+", "-", "*", "/", "mod", "exp", "sqrt"};
            String[] conditonalsSym = {"if", "cond", "when", "unless"};

            if (comando.equalsIgnoreCase("defun")) {
                String nombreFuncion = comandoSeparado[1];
                String[] parametros = comandoSeparado[2].split(",");
                String[] cuerpo = comando.substring(comando.indexOf("(") + 1, comando.lastIndexOf(")")).split(" ");
                tokens.defun(nombreFuncion, parametros, cuerpo);
            } else if (comando.equalsIgnoreCase("setq")) {
                tokens.setq(comandoSeparado[1], comandoSeparado[2]);
            } else if (comando.equalsIgnoreCase("defconstant")) {
                tokens.setConst(comandoSeparado[1], comandoSeparado[2]);
            } else if (Arrays.stream(arithmeticOp).anyMatch(comando::equalsIgnoreCase)) {
                double a = Double.parseDouble(comandoSeparado[1]);
                double b = Double.parseDouble(comandoSeparado[2]);
                double result = tokens.arithmetic(a, b, comando);
                System.out.println(result); // Print the result
            } else if (Arrays.stream(conditonalsSym).anyMatch(comando::equalsIgnoreCase)) {

                //TODO: conditonals

            } else if (Arrays.stream(predicatesSym).anyMatch(comando::equalsIgnoreCase)) {
                boolean result = tokens.pred(comando, comandoSeparado[1], comandoSeparado[2]);
                System.out.println(result); // Print the result
            } else if (comando.equalsIgnoreCase("quote")) {
                String value = comandoSeparado[1];
                System.out.println(tokens.quote(value)); // Print the result
            } else if (comando.equalsIgnoreCase("print")) {
                Object value = comandoSeparado[1];
                tokens.print(value);
            }
        }
    }



}