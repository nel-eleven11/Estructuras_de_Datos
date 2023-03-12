/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */


public class conditionals {

    public static String verificarCondicion(String cond, String [] op,String [] a, String [] b, String [] consecuencias){
        boolean respuesta = false;
        String resp = "";
        switch (cond){
            case "if":
                respuesta = predicates.verificar(op[0], a[0], b[0]);
                if (respuesta) {
                    resp= consecuencias[0];
                }
                else{
                    if(consecuencias.length > 1)
                        resp = consecuencias[1];
                    else{
                        resp = "NIL";
                    }
                }
                break;
            case "cond":
                for (int i = 0; i < op.length; i++) {
                    respuesta = predicates.verificar(op[i], a[i], b[i]);
                    if (respuesta) {
                        resp = consecuencias[i];
                        break;
                    }
                    else{
                        resp = "NIL";
                    }
                }

                break;
            case "when":
                respuesta = predicates.verificar(op[0], a[0], b[0]);
                if (respuesta) {
                    resp = consecuencias[consecuencias.length-1];
                }
                else{
                    resp = "NIL";
                }
                break;
            case "unless":
                respuesta = predicates.verificar(op[0],  a[0], b[0]);
                if (!respuesta) {
                    resp = consecuencias[consecuencias.length-1];
                }
                else{
                    resp = "NIL";
                }
                break;
            default:
                resp = "Error";
                break;

        }
        return resp;
    }



}
