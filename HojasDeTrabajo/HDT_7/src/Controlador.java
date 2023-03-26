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

    private static final BinarySearchTree<String, Palabra> ArbolIngles = new BinarySearchTree<String, Palabra>(new ComparadorPalabras());
    private static final BinarySearchTree<String, Palabra> ArbolEspaniol = new BinarySearchTree<String, Palabra>(new ComparadorPalabras());
    private static final BinarySearchTree<String, Palabra> ArbolFrances = new BinarySearchTree<String, Palabra>(new ComparadorPalabras());

    ArrayList<String> itemsDicc = new ArrayList<String>();

    ArrayList<String> itemsTexto = new ArrayList<String>();

    public ArrayList<String> getItems1() {
        return itemsTexto;
    }

    public ArrayList<String> getItems2() {
        return itemsDicc;
    }

    public void importFile(String nombreDelArchivo){
        //Ruta del archivo
        String fpath = ".\\src\\"+nombreDelArchivo+".txt";

        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String [] parts = null;
                if(nombreDelArchivo.equals("diccionario")){
                    parts = data.split(",");
                    for (int i = 0; i < parts.length; i++) {
                        itemsDicc.add(parts[i]);
                    }
                }
                if(nombreDelArchivo.equals("texto")){
                    parts = data.split(" ");
                    for (int i = 0; i < parts.length; i++) {
                        itemsTexto.add(parts[i]);
                    }
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void AgregarPalabras(ArrayList<String> items){
        for (int i = 0; i < items.size(); i = i + 3) {
            String [] lista = {items.get(i), items.get(i+1), items.get(i+2)};
            ArbolIngles.insert(items.get(i), new Palabra(lista[0], lista[0], lista[1], lista[2]));
            ArbolEspaniol.insert(items.get(i+1), new Palabra(lista[1], lista[0], lista[1], lista[2]));
            ArbolFrances.insert(items.get(i+2), new Palabra(lista[2], lista[0], lista[1], lista[2]));
        }
    }

    public String TraducirTexto(ArrayList<String> items, String idioma){
        String oracionFinal = "";
        for (int i = 0; i < items.size(); i++) {
            Palabra pal = (Palabra)ArbolIngles.search(items.get(i));

            if(pal != null){
                String palabra = pal.getPEspanol();
                oracionFinal = oracionFinal + palabra + " ";
            }
            else{
                oracionFinal = oracionFinal + "*"+ items.get(i) + "* ";
            }

        }
        return oracionFinal;
    }

    public void MostrarDiccionario(){
        ArbolIngles.InOrderTraversal(new VerPalabra<String, Palabra>());
    }


}
