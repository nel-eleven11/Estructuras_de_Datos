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
    
    /** 
     * @param args
     */
    public static void main (String [] args){

        Scanner teclado = new Scanner(System.in);
        Controlador miControlador = new Controlador();
        ArrayList<String> operaciones = new ArrayList<String>();
        ArrayList<String> operaciones_ = new ArrayList<String>();
        ArrayList<Integer> respuestas = new ArrayList<Integer>();
        int opcion = 0;

        JOptionPane.showMessageDialog(null, "Bienvenido al programa de calculadora de postfix");
        JOptionPane.showMessageDialog(null, "Este programa lee un archivo de texto y calcula las operaciones que se encuentran en el archivo");
        while (opcion != 5){
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de calculadora que desea utilizar, se basará en el tipo de stack que elija: \n 1. ArrayList \n 2. Vector \n 3. Lista simplemente encadenada \n 4. Lista doblemente encadenada \n 5. Salir"));

            switch (opcion){
                case 1:
                    //ArrayList
                    System.out.println("");
                    System.out.println("ArrayList");
                    operaciones.clear();
                    miControlador.importFile("datos");

                    operaciones = miControlador.getItems();

                    for(int i = 0; i < operaciones.size(); i++){
                        operaciones_.add(miControlador.getItems().get(i));
                        String postFix = miControlador.convertir(operaciones.get(i),1);
                        operaciones.set(i,postFix);
                    }
                    respuestas = miControlador.calculate(operaciones,1);
                    miControlador.importFile("datos");
                    System.out.println("Resultados: ");
                    for(int i = 0; i < respuestas.size(); i++){
                        System.out.println(operaciones_.get(i)+" = "+respuestas.get(i));
                    }

                    break;
                case 2:
                    //Vector
                    System.out.println("");
                    System.out.println("Vector");
                    operaciones.clear();
                    miControlador.importFile("datos");
                    operaciones = miControlador.getItems();
                    for(int i = 0; i < operaciones.size(); i++){
                        operaciones_.add(miControlador.getItems().get(i));
                        String postFix = miControlador.convertir(operaciones.get(i),2);
                        operaciones.set(i,postFix);
                    }
                    respuestas = miControlador.calculate(operaciones,2);
                    for(int i = 0; i < respuestas.size(); i++){
                        System.out.println(operaciones_.get(i)+" = "+respuestas.get(i));
                    }
                    break;
                case 3:
                    //Lista simplemente encadenada
                    System.out.println("");
                    System.out.println("Lista simplemente encadenada");
                    operaciones.clear();
                    miControlador.importFile("datos");
                    operaciones = miControlador.getItems();
                    for(int i = 0; i < operaciones.size(); i++){
                        operaciones_.add(miControlador.getItems().get(i));
                        String postFix = miControlador.convertir(operaciones.get(i),3);
                        operaciones.set(i,postFix);
                    }
                    respuestas = miControlador.calculate(operaciones,3);
                    for(int i = 0; i < respuestas.size(); i++){
                        System.out.println(operaciones_.get(i)+" = "+respuestas.get(i));
                    }

                    break;
                case 4:
                    //Lista doblemente encadenada
                    System.out.println("");
                    System.out.println("Lista doblemente encadenada");
                    operaciones.clear();
                    miControlador.importFile("datos");
                    operaciones = miControlador.getItems();
                    for(int i = 0; i < operaciones.size(); i++){
                        operaciones_.add(miControlador.getItems().get(i));
                        String postFix = miControlador.convertir(operaciones.get(i),4);
                        operaciones.set(i,postFix);
                    }
                    respuestas = miControlador.calculate(operaciones,4);
                    for(int i = 0; i < respuestas.size(); i++){
                        System.out.println(operaciones_.get(i)+" = "+respuestas.get(i));
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
