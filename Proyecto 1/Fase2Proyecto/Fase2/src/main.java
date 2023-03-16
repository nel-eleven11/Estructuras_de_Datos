/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class main {

    private File archivo;
    private static String [] lineas;
    private static ArrayList<String> items = new ArrayList<String>();

    public static void  importFile(String nombreDelArchivo){
        //Ruta del archivo
        String fpath = "Fase2\\src\\"+nombreDelArchivo+".txt";

        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lineas = data.split(" ");
                int cont = 0;
                for (String item : lineas){
                    if(item.contains("(") || item.contains(")")){
                        while(item.contains("(") || item.contains(")")){
                            if(item.contains("(")){
                                item = item.substring(1);
                                items.add("(");

                            }else if(item.contains(")")){
                                item = item.substring(0, item.length()-1);
                                cont++;
                            }
                        }
                        items.add(item);
                        for(int i = 0; i < cont; i++){
                            items.add(")");
                        }
                    }else{
                        items.add(item);

                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getItems() {
        return items;
    }

    public static void main(String[] args) {

    }

}
