/*
Nelson García 22434
Joaquín Puente 22296
HDT 8

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The type Files.
 */
public class files {

    private static ArrayList<ArrayList<String>> items = new ArrayList<>();

    /**
     * Import file.
     */
    public static void importFile(){
        //Ruta del archivo
        String fpath = ".\\src\\procesos.txt";

        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                ArrayList<String> subItems = new ArrayList<>();
                String data = myReader.nextLine();
                String [] datos = data.split(",");
                subItems.addAll(Arrays.asList(datos));
                int prioridad = Integer.parseInt(datos[2]) + 120;
                subItems.add(String.valueOf(prioridad));
                items.add(subItems);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public static ArrayList<ArrayList<String>> getItems() {
        return items;
    }

}
