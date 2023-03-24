/*
Nelson García
22434
hdt 7
 */
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class main {

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

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido al programa de Diccionario Inglés-Francés-Español");

        String menu = "";
        menu = JOptionPane.showInputDialog("1. Ingresar archivo de texto\n2. Salir");

    }
}
