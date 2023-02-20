/*
Nelson García Bravatti
22434
HDT 4

 */


import javax.swing.JOptionPane;
import java.util.Scanner;


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

        String menuInicial = "1. \n2. Salir ";
        int opcion = 1;

        System.out.println(menuInicial);
        System.out.println("Ingrese la opción que desea: ");
        opcion = teclado.nextInt();
        teclado.nextLine();


    }
}
