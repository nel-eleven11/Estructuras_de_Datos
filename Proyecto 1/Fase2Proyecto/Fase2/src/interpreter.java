/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */
import java.util.*;
import java.util.function.UnaryOperator;


public class interpreter {
    /**
     * Tokens reservado en lisp
     */
    private static final String[] reservedTokens = {"<", ">", "<=", ">=", "==", "!=", "listp", "atom", "symbolp", "numberp", "consp", "eq", "equal", "zerop", "oddp", "evenp", "and", "or", "not", "+", "-", "*", "/", "mod", "exp", "sqrt", "if", "cond", "when", "unless", "print", "setq", "defun", "quote"};
    /**
     * The number of arguments each token takes.
     */
    private static final HashMap<String, Integer> tokenArguments = new HashMap<>() {{
        put("<", 2);
        put(">", 2);
        put("<=", 2);
        put(">=", 2);
        put("==", 2);
        put("!=", 2);
        put("listp", 1);
        put("atom", 1);
        put("symbolp", 1);
        put("numberp", 1);
        put("consp", 1);
        put("eq", 2);
        put("equal", 2);
        put("zerop", 1);
        put("oddp", 1);
        put("evenp", 1);
        put("and", 2);
        put("or", 2);
        put("not", 1);
        put("+", 2);
        put("-", 2);
        put("*", 2);
        put("/", 2);
        put("mod", 2);
        put("exp", 2);
        put("sqrt", 1);
        put("if", 3);
        put("cond", 2);
        put("when", 2);
        put("unless", 2);
        put("print", 1);
        put("setq", 2);
        put("defun", 3);
        put("quote", 1);
    }};

    /*
     *verifica si el nombre de una funcion es valido
     * @param ArrayList<String> lisp
     * @return String
     */

    public static String readLisp(ArrayList<String> lisp) {

        Stack<Object> stack = new Stack<>();
        String currentToken = "";

        String[] predicatesSym = {"<", ">", "<=", ">=", "==", "!=", "listp", "atom", "symbolp", "numberp", "consp", "eq", "equal", "zerop", "oddp", "evenp", "and", "or", "not"};
        String[] arithmeticOp = {"+", "-", "*", "/", "mod", "exp", "sqrt"};
        String[] conditonalsSym = {"if", "cond", "when", "unless"};

        if (lisp.get(0).equals("(")) {
            for (int i = lisp.size()-1; i >= 0; i--) {
                if (lisp.get(i).equals(")")) {
                    lisp.remove(i);
                    lisp.remove(0);
                    break;
                }
            }
            for (int i = 0; i < lisp.size(); i++) {
                if (Arrays.stream(reservedTokens).anyMatch(lisp.get(i)::equalsIgnoreCase)) {
                    System.out.println("Reserved token");
                    System.out.println("Token: " + lisp.get(i));
                    currentToken = lisp.get(i);
                }

                if (functions.getFunctions().containsKey(lisp.get(i)) || variables.getVariables().containsKey(lisp.get(i))) {
                    if (functions.getFunctions().containsKey(lisp.get(i))) {
                        int startIndex = i;
                        int endIndex = 0;
                        for (int j = i; j < lisp.size(); j++) {
                            if (lisp.get(j).equals(")")) {
                                endIndex = j;
                                break;
                            }
                        }
                        ArrayList<String> params = new ArrayList<>();
                        for (int j = startIndex+1; j < endIndex; j++) {
                            params.add(lisp.get(j));
                        }

                        ArrayList<String> func = (ArrayList<String>) functions.getFunction(lisp.get(i)).get(1);
                        ArrayList<String> funcParams = (ArrayList<String>) functions.getFunction(lisp.get(i)).get(0);
                        for (int j = 0; j < funcParams.size(); j++) {
                            for (int k = 0; k < func.size(); k++) {
                                if (func.get(k).equals(funcParams.get(j))) {
                                    func.remove(k);
                                    func.add(k, params.get(j));
                                }
                            }
                        }

                        lisp.subList(startIndex, endIndex).clear();
                        lisp.addAll(startIndex, func);

                    }
                    else if (variables.getVariables().containsKey(lisp.get(i))) {
                        lisp.remove(i);
                        lisp.add(i, variables.getVariable(lisp.get(i)));
                    }
                }

                //Algoritmo de interpretación recursivo
                if (lisp.get(i).equals("(") && !currentToken.equalsIgnoreCase("defun") && !currentToken.equalsIgnoreCase("cond")) {
                    ArrayList<String> microFunc = new ArrayList<>();
                    for (int j = i; j < lisp.size(); j++) {
                        if (lisp.get(j).equals(")")) {
                            i = j;
                            break;
                        }
                        microFunc.add(lisp.get(j));
                    }
                    microFunc.add(")");

                    stack.add(readLisp(microFunc));
                }

                //Programación del caso especial de defun
                if (currentToken.equalsIgnoreCase("defun")) {
                    int counter = 0;
                    String nombre = "";
                    ArrayList<String> body = new ArrayList<>();
                    ArrayList<String> params = new ArrayList<>();


                    for (int j = i+1; j < lisp.size(); j++){
                        if (counter == 0) {
                            nombre = lisp.get(j);
                            counter++;
                        }

                        else if (counter == 1) {
                            params.add(lisp.get(j));
                            if (lisp.get(j).equals(")")) {
                                counter++;
                            }
                        }
                        else if (counter == 2) {
                            body.add(lisp.get(j));
                            if (lisp.get(j).equals(")")) {
                                counter++;
                            }
                        }
                        if (counter == 3) {
                            i=j;
                            break;
                        }

                    }
                    stack.push(body);
                    stack.push(params);
                    stack.push(nombre);
                }

                if(currentToken.equalsIgnoreCase("cond")){
                    ArrayList<String> condicion = new ArrayList<>();
                    ArrayList<String> consecuencias = new ArrayList<>();
                    int abrir = 1;
                    int cerrar = 0;
                    while(abrir != cerrar){
                        for (int j = i+1; j < lisp.size(); j++) {
                            if (lisp.get(j).equals(")")) {
                                cerrar++;
                                break;
                            }
                            if (lisp.get(j).equals("(")) {
                                abrir++;
                                for (int k = j; k < lisp.size(); k++) {
                                    if (lisp.get(k).equals(")")) {
                                        cerrar++;
                                        j = k;
                                        break;
                                    }
                                    if(lisp.get(k).equals("t")){
                                        condicion.add(lisp.get(k));
                                        break;
                                    }
                                    condicion.add(lisp.get(k));
                                }
                            }
                            else {
                                consecuencias.add(lisp.get(j));
                            }
                        }
                    }
                    stack.push(consecuencias);
                    stack.push(condicion);
                }



                if (Arrays.stream(reservedTokens).noneMatch(lisp.get(i)::equalsIgnoreCase) && !lisp.get(i).equals(")")){
                    stack.add(lisp.get(i));
                }

                if(stack.size() == tokenArguments.get(currentToken)){

                    if (currentToken.equalsIgnoreCase("defun")) {
                        String nombre = String.valueOf(stack.pop());
                        ArrayList<String> params = (ArrayList<String>) stack.pop();
                        ArrayList<String> body = (ArrayList<String>) stack.pop();

                        tokens.defun(nombre, params, body);

                    } else if (currentToken.equalsIgnoreCase("setq")) {
                        String valor = String.valueOf(stack.pop());
                        String variable = String.valueOf(stack.pop());
                        tokens.setq(variable, valor);
                    } else if (currentToken.equalsIgnoreCase("defconstant")) {
                        String valor = String.valueOf(stack.pop());
                        String variable = String.valueOf(stack.pop());
                        tokens.setConst(variable, valor);
                    } else if (Arrays.stream(arithmeticOp).anyMatch(currentToken::equalsIgnoreCase)) {
                        String operador2 = String.valueOf(stack.pop());
                        String operador1 = String.valueOf(stack.pop());

                        double a = Double.parseDouble(operador1);
                        double b = Double.parseDouble(operador2);
                        double result = tokens.arithmetic(a, b, currentToken);
                        stack.add(String.valueOf(result));

                    } else if (Arrays.stream(conditonalsSym).anyMatch(currentToken::equalsIgnoreCase)) {

                        ArrayList<String> cond = (ArrayList<String>) stack.pop();
                        ArrayList<String> consecuencias = (ArrayList<String>) stack.pop();
                        ArrayList<String> operadores = new ArrayList<>();
                        ArrayList<String> op1 = new ArrayList<>();
                        ArrayList<String> op2 = new ArrayList<>();
                        String [] predicates = {"numberp", "symbolp", "listp", "zerop", "oddp", "evenp", "atom", "eq", "not", "and", "or", "<", ">", "<=", ">=", "==", "!="};
                        for(int j = 0; j < cond.size(); j++) {
                            if (Arrays.stream(predicates).anyMatch(cond.get(j)::equalsIgnoreCase)) {
                                operadores.add(cond.get(j));
                                op1.add(cond.get(j+1));
                                op2.add(cond.get(j+2));
                            }

                            if (cond.get(j).equals("t")) {
                                operadores.add(cond.get(j));
                                break;
                            }
                        }

                        String resultado = tokens.conditional(currentToken, operadores, op1, op2, consecuencias);
                        stack.add(String.valueOf(resultado));



                    } else if (Arrays.stream(predicatesSym).anyMatch(currentToken::equalsIgnoreCase)) {
                        String operador2 = String.valueOf(stack.pop());
                        String operador1 = String.valueOf(stack.pop());

                        boolean result = tokens.pred(currentToken, operador1, operador2);
                        stack.add(String.valueOf(result));

                    } else if (currentToken.equalsIgnoreCase("quote")) {
                        String quote = String.valueOf(stack.pop());
                        stack.add(quote);
                    } else if (currentToken.equalsIgnoreCase("print")) {
                        String print = String.valueOf(stack.pop());

                        stack.add(tokens.print(print));
                    }
                }
            }
        }
        if (stack.size() == 0) {
            return null;
        } else {
            return String.valueOf(stack.pop());
        }

    }
}

/*

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



        }
    }

*/
