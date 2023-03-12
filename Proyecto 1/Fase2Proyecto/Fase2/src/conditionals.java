/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */


public class conditionals {

    public static String verificarCondicion(String cond, String op,String a, String b, String [] consecuencias){
        boolean respuesta = false;
        String resp = "";
        switch (cond){
            case "if":
                respuesta = predicates.verificar(op, a, b);
                if (respuesta) {
                    resp= consecuencias[0];
                }
                else{
                    resp = consecuencias[1];
                }
                break;
            case "cond":
                for (int i = 0; i < consecuencias.length; i++) {
                    String[] condicion = consecuencias[i].split(" ");
                    respuesta = predicates.verificar(condicion[0], condicion[1], condicion[2]);
                    if (respuesta) {
                        resp = condicion[3];
                        break;
                    }
                }
                break;
            case "":

        }
        return resp;
    }



}
