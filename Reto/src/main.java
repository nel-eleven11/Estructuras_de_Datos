/*
Nelson García Bravatti
22434
Reto
 */

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Bienvenido al programa.");
        int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de 'a' que desea evaluar."));
        int b = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de 'b' que desea evaluar."));

        Queue<String> cola = new LinkedList<String>();
        Stack<Integer> pila = new Stack<Integer>();
        for(int i = 0; i < a; i++){
            //agregar "a" a la cola
            cola.add("a");
        }
        for(int i = 0; i < b; i++){
            //agregar "b" a la cola
            cola.add("b");
        }
        int cont = 1;
        int num;
        pila.push(0);

        while(!cola.isEmpty()||(cont != 0)) {
            if(cola.peek() == "a"){
                pila.push(1);
                JOptionPane.showMessageDialog(null, "A");
                cola.remove();
            }
            else if(cola.peek() == "b"){
                num = pila.pop();
                JOptionPane.showMessageDialog(null, "B");
                cola.remove();
                if(num != 1){
                    JOptionPane.showMessageDialog(null, "La expresión no es válida.");
                    cont = 0;
                }
            }
            else{
                num = pila.pop();

                if(num != 0){
                    JOptionPane.showMessageDialog(null, "La expresión no es válida.");
                    cont = 0;
                }
                else{
                    cont = 0;
                    JOptionPane.showMessageDialog(null, "La expresión es válida.");
                }
            }


        }
        JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa.");
    }
}
