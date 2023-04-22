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

/**
 * The type Controlador.
 */
public class Controlador {

    /**
     * The Items texto.
     */
    ArrayList<ArrayList<String>> itemsTexto = new ArrayList<ArrayList<String>>();

    /**
     * The Items dicc.
     */
    ArrayList<String> itemsDicc = new ArrayList<String>();

    /**
     * Gets items 1.
     *
     * @return the items 1
     */
    public ArrayList<ArrayList<String>> getItems1() {
        return itemsTexto;
    }

    /**
     * Gets items 2.
     *
     * @return the items 2
     */
    public ArrayList<String> getItems2() {
        return itemsDicc;
    }

    /**
     * Import file.
     *
     * @param nombreDelArchivo the nombre del archivo
     */
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

    /**
     * Agregar palabras.
     *
     * @param items     the items
     * @param tipoArbol the tipo arbol
     */
    public void AgregarPalabras(ArrayList<String> items, String tipoArbol){
        EstructuraArbol arbol = Factory.getArbol(tipoArbol);
        for (int i = 0; i < items.size(); i = i + 2) {
            String [] lista = {items.get(i), items.get(i+1)};
            arbol.add(new Palabra(lista[0],lista[1]));
        }
    }

    /**
     * Traducir texto string.
     *
     * @param items     the items
     * @param tipoArbol the tipo arbol
     * @return the string
     */
    public String TraducirTexto(ArrayList<String> items, String tipoArbol){
        EstructuraArbol arbol = Factory.getArbol(tipoArbol);
        String oracionFinal = "";
        Boolean idiomaDetectado = false;
        for(String item : items) {
            for (int i = 0; i < itemsDicc.size(); i = i + 3) {
                if (item.equals(itemsDicc.get(i))) {
                    idiomaDetectado = true;
                    break;
                }
            }
        }

        if(!idiomaDetectado){
            for(String item : items){
                oracionFinal = oracionFinal + "*"+ item + "* ";
            }
            oracionFinal = "Ninguna de las palabras se encuentra en el diccioario, no se pudo traducir la oración: \n" + oracionFinal;
        }
        else{
            for (int i = 0; i < items.size(); i++) {
                Palabra pal = (Palabra)arbol.get(items.get(i));

                if(pal != null){
                    String palabra = ((Palabra) arbol.get(items.get(i))).getPEspanol();
                    oracionFinal = oracionFinal + palabra + " ";
                }
                else{
                    oracionFinal = oracionFinal + "*"+ items.get(i) + "* ";
                }

            }
        }
        return oracionFinal;
    }

}
