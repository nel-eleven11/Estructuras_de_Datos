/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */
import java.util.Arrays;
import java.util.Stack;

public class interpreter {



    public class LispExpression {
        public static int evaluate(String expression) {
            String[] tokens = expression.split("\\s+");
            Stack<Integer> stack = new Stack<>();
            for (int i = tokens.length - 1; i >= 0; i--) {
                String token = tokens[i];



                if (isNumber(token)) {
                    stack.push(Integer.parseInt(token));
                } else if (isOperator(token)) {
                    int operand1 = stack.pop();
                    int operand2 = stack.pop();
                    int result = evaluateExpression(token, operand1, operand2);
                    stack.push(result);
                } else if (isLispExpression(token)) {
                    // Remove the first and last parentheses of the Lisp expression
                    String lispExpression = token.substring(1, token.length() - 1);
                    int result = evaluate(lispExpression);
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
        String[] predicatesSym = {"<", ">", "<=", ">=", "==", "!=", "listp", "atom", "symbolp", "numberp", "consp", "eq", "equal", "zerop","oddp","evenp","and","or","not"};
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
        } else if (Arrays.stream(arithmeticOp).anyMatch(comando::equalsIgnoreCase)){
            tokens.arithmetic(Integer.parseInt(comandoSeparado[1]), Integer.parseInt(comandoSeparado[2]), comando);
        } else if (Arrays.stream(conditonalsSym).anyMatch(comando::equalsIgnoreCase)) {

            //TODO: conditonals

        } else if (Arrays.stream(predicatesSym).anyMatch(comando::equalsIgnoreCase)) {
            tokens.pred(comando, comandoSeparado[1], comandoSeparado[2]);
        } else if (comando.equalsIgnoreCase("quote")) {
            tokens.quote(comandoSeparado[1]);
        } else if (comando.equalsIgnoreCase("print")) {
            tokens.print(comandoSeparado[1]);
        }


    }
}
