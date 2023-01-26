package src;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        IStack<Integer> miPila = new StackUsingArrayList<Integer>();

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
