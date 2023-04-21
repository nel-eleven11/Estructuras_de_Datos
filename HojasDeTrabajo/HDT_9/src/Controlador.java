/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *Clase palabra
 *
 **/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Controlador {

    ArrayList<ArrayList<String>> itemsTexto = new ArrayList<ArrayList<String>>();

    ArrayList<String> itemsDicc = new ArrayList<String>();

    public void importFile(String nombreDelArchivo){
        //Ruta del archivo
        String fpath = ".\\src\\"+nombreDelArchivo+".txt";

        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String [] parts = null;
                ArrayList<String> temp = new ArrayList<String>();
                //agrega las palabras del diccionario a un arraylist
                if(nombreDelArchivo.equals("diccionario")){
                    parts = data.split(",");
                    for (int i = 0; i < parts.length; i++) {
                        itemsDicc.add(parts[i]);
                    }
                }
                //se encarga de separar las oraciones del documento, agregandolas a un arraylist
                if(nombreDelArchivo.equals("texto")){
                    parts = data.split(" ");
                    for (int i = 0; i < parts.length; i++) {
                        temp.add(parts[i]);
                    }
                    itemsTexto.add(temp);
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void AgregarPalabras(ArrayList<String> items){
        for (int i = 0; i < items.size(); i = i + 2) {
            String [] lista = {items.get(i), items.get(i+1)};

        }
    }

}
