package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {


    private IStack<Integer> miPila = new StackUsingArrayList<Integer>();

    public void importFile(){
        //Ruta del archivo
        String fpath = ".\\src\\texto.txt";
        ArrayList items = new ArrayList<String>();

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





}
