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
        Controlador miControlador = new Controlador();
        ArrayList<String> operaciones = new ArrayList<String>();
        ArrayList<Integer> respuestas = new ArrayList<Integer>();
        int opcion = 0;


        while (opcion != 5){
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de calculadora que desea utilizar: \n 1. ArrayList \n 2. Vector \n 3. Lista simplemente encadenada \n 4. Lista doblemente encadenada \n 5. Salir"));

            switch (opcion){
                case 1:
                    //ArrayList
                    operaciones.clear();
                    miControlador.importFile("datos");
                    operaciones = miControlador.getItems();
                    for(int i = 0; i < operaciones.size(); i++){
                        String postFix = miControlador.convertir(operaciones.get(i),1);
                        operaciones.set(i,postFix);
                    }
                    respuestas = miControlador.calculate(operaciones,1);
                    for(int i = 0; i < respuestas.size(); i++){
                        System.out.println(respuestas.get(i));
                    }

                    break;
                case 2:
                    //Vector
                    operaciones.clear();
                    miControlador.importFile("datos");
                    operaciones = miControlador.getItems();
                    for(int i = 0; i < operaciones.size(); i++){
                        String postFix = miControlador.convertir(operaciones.get(i),2);
                        operaciones.set(i,postFix);
                    }
                    respuestas = miControlador.calculate(operaciones,2);
                    for(int i = 0; i < respuestas.size(); i++){
                        System.out.println(respuestas.get(i));
                    }
                    break;
                case 3:
                    //Lista simplemente encadenada
                    operaciones.clear();
                    miControlador.importFile("datos");
                    operaciones = miControlador.getItems();
                    for(int i = 0; i < operaciones.size(); i++){
                        String postFix = miControlador.convertir(operaciones.get(i),3);
                        operaciones.set(i,postFix);
                    }
                    respuestas = miControlador.calculate(operaciones,3);
                    for(int i = 0; i < respuestas.size(); i++){
                        System.out.println(respuestas.get(i));
                    }

                    break;
                case 4:
                    //Lista doblemente encadenada
                    operaciones.clear();
                    miControlador.importFile("datos");
                    operaciones = miControlador.getItems();
                    for(int i = 0; i < operaciones.size(); i++){
                        String postFix = miControlador.convertir(operaciones.get(i),4);
                        operaciones.set(i,postFix);
                    }
                    respuestas = miControlador.calculate(operaciones,4);
                    for(int i = 0; i < respuestas.size(); i++){
                        System.out.println(respuestas.get(i));
                    }
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
