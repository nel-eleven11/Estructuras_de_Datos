/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */


import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class predicates {
/*
* verifica los predicados que tenemos en lisp
* @param simbolo
* @param a
* @param b
* @return boolean
 */
    public static boolean verificar(String simbolo, String a, String b){
        boolean resultado = false;
        String [] lista;

        switch (simbolo) {
            case "numberp" -> resultado = StringUtils.isNumeric(a);
            case "symbolp" -> resultado = StringUtils.isAlpha(a);
            case "zerop" -> resultado = a.equals("0");
            case "oddp" -> resultado = Integer.parseInt(a) % 2 != 0;
            case "evenp" -> resultado = Integer.parseInt(a) % 2 == 0;
            case "atom" -> resultado = StringUtils.isAlpha(a) || StringUtils.isNumeric(a);
            case "eq" -> resultado = a.equals(b);
            case "listp" -> resultado = a.startsWith("'(") && a.endsWith(")");
            case ">" -> resultado = Integer.parseInt(a) > Integer.parseInt(b);
            case "<" -> resultado = Integer.parseInt(a) < Integer.parseInt(b);
            case ">=" -> resultado = Integer.parseInt(a) >= Integer.parseInt(b);
            case "<=" -> resultado = Integer.parseInt(a) <= Integer.parseInt(b);
            case "==" -> resultado = Integer.parseInt(a) == Integer.parseInt(b);
            case "!=" -> resultado = Integer.parseInt(a) != Integer.parseInt(b);
            case "and" -> {
                lista = a.split(" ");
                for (String s : lista) {
                    resultado = !s.equals("NIL");
                }
            }
            case "or" -> {
                lista = a.split(" ");
                for (String s : lista) {
                    if (!Objects.equals(s, "NIL")) {
                        resultado = true;
                        break;
                    }
                }
            }
            default -> JOptionPane.showMessageDialog(null, "Error: " + simbolo + " no es un predicado válido");
        }
        return resultado;
    }

    public static boolean verificar(String simbolo, String a){
        if(simbolo.equals("not")){
            return !Boolean.parseBoolean(a);
        }
        return false;
    }

}
