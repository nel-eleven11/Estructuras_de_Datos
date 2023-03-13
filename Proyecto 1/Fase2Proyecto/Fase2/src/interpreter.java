/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */

public class interpreter {

    public static void interpretar(String comando) {
        comando = comando.substring(1, comando.length() - 1);

        String[] comandoSeparado = comando.split(" ");

        if (comandoSeparado[0].equalsIgnoreCase("defun")) {
            String nombreFuncion = comandoSeparado[1];
            String[] parametros = comandoSeparado[2].split(",");
            String[] cuerpo = comando.substring(comando.indexOf("(") + 1, comando.lastIndexOf(")")).split(" ");
            tokens.defun(nombreFuncion, parametros, cuerpo);
        } else if (comandoSeparado[0].equalsIgnoreCase("setq")) {
            tokens.setq(comandoSeparado[1], comandoSeparado[2]);
        } else if (comandoSeparado[0].equalsIgnoreCase("defconstant")) {
            tokens.setConst(comandoSeparado[1], comandoSeparado[2]);
        } else if (comandoSeparado[0].equalsIgnoreCase("+") || comandoSeparado[0].equalsIgnoreCase("-") || comandoSeparado[0].equalsIgnoreCase("*") || comandoSeparado[0].equalsIgnoreCase("/") || comandoSeparado[0].equalsIgnoreCase("mod") || comandoSeparado[0].equalsIgnoreCase("exp") || comandoSeparado[0].equalsIgnoreCase("sqrt")){
            tokens.arithmetic(Integer.parseInt(comandoSeparado[1]), Integer.parseInt(comandoSeparado[2]), comandoSeparado[0]);
        } else if (comandoSeparado[0].equalsIgnoreCase("if") || comandoSeparado[0].equalsIgnoreCase("cond") || comandoSeparado[0].equalsIgnoreCase("when") || comandoSeparado[0].equalsIgnoreCase("unless")) {

        } else if (comandoSeparado[0].equalsIgnoreCase("quote")) {
            tokens.quote(comandoSeparado[1]);
        } else if () {
            
        }


    }
}
