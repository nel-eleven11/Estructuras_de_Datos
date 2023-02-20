/*
Nelson García Bravatti
22434
HDT 4
Main del programa
 */


import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main (String [] args){

        Scanner teclado = new Scanner(System.in);


        int opcion = 0;


        while (opcion != 5){
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de calculadora que desea utilizar: \n 1. ArrayList \n 2. Vector \n 3. Lista simplemente encadenada \n 4. Lista doblemente encadenada \n 5. Salir"));

            switch (opcion){
                case 1:
                    //ArrayList
                    break;
                case 2:
                    //Vector
                    break;
                case 3:
                    //Lista simplemente encadenada
                    break;
                case 4:
                    //Lista doblemente encadenada
                    break;
                case 5:
                    //Salir
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }


    }
}
