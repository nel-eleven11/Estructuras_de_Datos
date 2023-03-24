/*
Nelson García
22434
hdt 7
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {

    private static BinarySearchTree<String, String> ArbolIngles = new BinarySearchTree<String, String>(new ComparadorPalabras());
    private static BinarySearchTree<String, String> ArbolEspaniol = new BinarySearchTree<String, String>(new ComparadorPalabras());
    private static BinarySearchTree<String, String> ArbolFrances = new BinarySearchTree<String, String>(new ComparadorPalabras());

    ArrayList<String> items = new ArrayList<String>();

    public ArrayList<String> getItems() {
        return items;
    }

    public void importFile(String nombreDelArchivo){
        //Ruta del archivo
        String fpath = ".\\src\\"+nombreDelArchivo+".txt";

        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String [] parts = data.split(",");
                for (int i = 0; i < parts.length; i++) {
                    items.add(parts[i]);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void AgregarPalabras(ArrayList<String> items){
        for (int i = 0; i < items.size(); i++) {
            if(i%3==0){
                ArbolIngles.insert(items.get(i), items.get(i+1));
                ArbolEspaniol.insert(items.get(i+1), items.get(i));
                ArbolFrances.insert(items.get(i+2), items.get(i));
            }
            if(i%3==1){
                ArbolIngles.insert(items.get(i), items.get(i-1));
                ArbolEspaniol.insert(items.get(i), items.get(i-1));
                ArbolFrances.insert(items.get(i+1), items.get(i-1));
            }
            if(i%3==2){
                ArbolIngles.insert(items.get(i), items.get(i-2));
                ArbolEspaniol.insert(items.get(i), items.get(i-2));
                ArbolFrances.insert(items.get(i), items.get(i-2));
            }
        }
    }




}
