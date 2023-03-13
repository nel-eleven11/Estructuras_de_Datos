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

    public static boolean verificar(String simbolo, String a, String b){
        boolean resultado = false;
        String [] lista;

        switch (simbolo){
            case "numberp":
                resultado = StringUtils.isNumeric(a);
                break;
            case "symbolp":
                resultado = StringUtils.isAlpha(a);
                break;
            case "zerop":
                resultado = a.equals("0");
                break;
            case "oddp":
                resultado = Integer.parseInt(a) % 2 != 0;
                break;
            case "evenp":
                resultado = Integer.parseInt(a) % 2 == 0;
                break;
            case "atom":
                resultado = StringUtils.isAlpha(a) || StringUtils.isNumeric(a);
                break;
            case "eq":
                resultado = a.equals(b);
                break;
            case "listp":
                resultado = a.startsWith("(") && a.endsWith(")");
                break;
            case ">":
                if (Integer.parseInt(a) > Integer.parseInt(b)) {
                    resultado = true;
                }
                else{
                    resultado = false;
                }
                break;
            case "<":
                if (Integer.parseInt(a) < Integer.parseInt(b)) {
                    resultado = true;
                }
                else{
                    resultado = false;
                }
                break;
            case ">=":
                if (Integer.parseInt(a) >= Integer.parseInt(b)) {
                    resultado = true;
                }
                else{
                    resultado = false;
                }
                break;
            case "<=":
                if (Integer.parseInt(a) <= Integer.parseInt(b)) {
                    resultado = true;
                }
                else{
                    resultado = false;
                }
                break;
            case "==":
                if (Integer.parseInt(a) == Integer.parseInt(b)) {
                    resultado = true;
                }
                else{
                    resultado = false;
                }
                break;
            case "!=":
                if (Integer.parseInt(a) != Integer.parseInt(b)) {
                    resultado = true;
                }
                else{
                    resultado = false;
                }
                break;
            case "not":
                if(predicates.verificar(simbolo, a, b) == true){
                    resultado = false;
                }
                else{
                    resultado = true;
                }
                break;
            case "and":
                lista = a.split(" ");
                for (int i = 0; i < lista.length; i++) {
                    if (lista[i].equals("NIL")) {
                        resultado = false;
                        break;
                    }
                }
                break;
            case "or":
                lista = a.split(" ");
                for (int i = 0; i < lista.length; i++) {
                    if (!Objects.equals(lista[i], "NIL")) {
                        resultado = true;
                        break;
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error: " + simbolo + " no es un predicado válido");
                break;
        }
        return resultado;
    }

}
