/*
Nelson García Bravatti
22434
HDT 4

 */


import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main (String [] args){

        /*
        public void importFile(String nombreDelArchivo){
        //Ruta del archivo
        String fpath = ".\\src\\"+nombreDelArchivo+".txt";

        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                items.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
         */

        Scanner teclado = new Scanner(System.in);


        int opcion = 0;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de calculadora que desea utilizar: \n 1. ArrayList \n 2. Vector \n 3. Lista simplemente encadenada \n 4. Lista doblemente encadenada \n 5. Salir"));

        while (opcion != 5){

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
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }


    }
}
