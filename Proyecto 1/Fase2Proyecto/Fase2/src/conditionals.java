/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */


import java.util.ArrayList;

public class conditionals {
    /*
    * verifica las  condicionales que tenemos en lisp
    * @param cond
    * @param op
    * @param a
    * @param b
    * @param consecuencias
    * @return String
     */

    public static String verificarCondicion(String cond, ArrayList<String> op, ArrayList<String> a, ArrayList<String> b, ArrayList<String> consecuencias){
        boolean respuesta = false;
        String resp = "";
        switch (cond) {
            case "if" -> {
                respuesta = predicates.verificar(op.get(0), a.get(0), b.get(0));
                if (respuesta) {
                    resp = consecuencias.get(0);
                } else {
                    if (consecuencias.size() > 1)
                        resp = consecuencias.get(0);
                    else {
                        resp = "NIL";
                    }
                }
            }
            case "cond" -> {
                if(op.get(op.size()-1).equals("t")){
                    for (int i = 0; i < op.size()-1; i++) {
                        respuesta = predicates.verificar(op.get(i), a.get(i), b.get(i));
                        if (respuesta) {
                            resp = consecuencias.get(i);
                        } else {
                            resp = "NIL";
                        }
                    }
                    if(resp.equals("NIL")) {
                        resp = consecuencias.get(consecuencias.size() - 1);
                    }
                }
                else{
                    for (int i = 0; i < op.size(); i++) {
                        respuesta = predicates.verificar(op.get(i), a.get(i), b.get(i));
                        if (respuesta) {
                            resp = consecuencias.get(i);
                        } else {
                            resp = "NIL";
                        }
                    }
                }
            }
            case "when" -> {
                respuesta = predicates.verificar(op.get(0), a.get(0), b.get(0));
                if (respuesta) {
                    resp = consecuencias.get(consecuencias.size() - 1);
                } else {
                    resp = "NIL";
                }
            }
            case "unless" -> {
                respuesta = predicates.verificar(op.get(0), a.get(0), b.get(0));
                if (!respuesta) {
                    resp = consecuencias.get(consecuencias.size() - 1);
                } else {
                    resp = "NIL";
                }
            }
            default -> resp = "Error";
        }
        return resp;
    }



}
