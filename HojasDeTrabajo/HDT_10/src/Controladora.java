/*
 * HDT 10 Algorigmos y estructura de datos
 * Nelson García Bravatti 22434
 * Joaquín Puente  22296
 *
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Controladora {


    ArrayList<String> items = new ArrayList<String>();

    public ArrayList<String> getItems1() {
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
                String [] dataArr = data.split(",");
                for (int i = 0; i < dataArr.length; i++) {
                    items.add(dataArr[i]);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
