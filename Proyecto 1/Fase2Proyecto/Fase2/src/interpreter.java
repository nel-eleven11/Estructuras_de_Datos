/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */
import java.util.*;
import java.util.function.UnaryOperator;


public class interpreter {


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
                System.out.println("Iteración: " + i + " Token: " + lisp.get(i));
                System.out.println("Stack: " + stack);
                System.out.println("Lista: " + lisp);
                if (Arrays.stream(tokens.getReservedTokens()).anyMatch(lisp.get(i)::equalsIgnoreCase)) {
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
                        System.out.println("Funcion: " + func);

                        lisp.subList(startIndex, endIndex).clear();
                        lisp.addAll(startIndex, func);

                    }
                    else if (variables.getVariables().containsKey(lisp.get(i))) {
                        String valor = variables.getVariable(lisp.get(i));
                        System.out.println("Valor: " + valor);
                        lisp.remove(i);
                        lisp.add(i, valor);
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

                    String returnVal = readLisp(microFunc);
                    System.out.println("Sali");
                    System.out.println("Stack Size: " + stack.size());
                    if(returnVal != null) {
                        stack.push(returnVal);
                    }
                    System.out.println("Stack Size: " + stack.size());

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



                if (Arrays.stream(tokens.getReservedTokens()).noneMatch(lisp.get(i)::equalsIgnoreCase) && !lisp.get(i).equals(")")){
                    stack.add(lisp.get(i));
                }

                try {
                    if(stack.size() == tokens.getTokenArguments().get(currentToken)){


                        if (currentToken.equalsIgnoreCase("defun")) {
                            String nombre = String.valueOf(stack.pop());
                            ArrayList<String> params = (ArrayList<String>) stack.pop();
                            ArrayList<String> body = (ArrayList<String>) stack.pop();

                            tokens.defun(nombre, params, body);

                        } else if (currentToken.equalsIgnoreCase("setq")) {
                            String valor = String.valueOf(stack.pop());
                            String variable = String.valueOf(stack.pop());
                            tokens.setq(variable, valor);
                            System.out.println();
                            System.out.println("Varaiable " + variable + " seteada a " + valor);
                            return null;
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
                catch (Exception e){
                    System.out.println("Error");
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
