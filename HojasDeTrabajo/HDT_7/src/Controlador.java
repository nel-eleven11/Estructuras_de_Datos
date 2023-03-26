/*
Nelson García
22434
hdt 7
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Controlador {

    static final BinarySearchTree<String, Palabra> ArbolIngles = new BinarySearchTree<String, Palabra>(new ComparadorPalabras());
    static final BinarySearchTree<String, Palabra> ArbolEspaniol = new BinarySearchTree<String, Palabra>(new ComparadorPalabras());
    static final BinarySearchTree<String, Palabra> ArbolFrances = new BinarySearchTree<String, Palabra>(new ComparadorPalabras());

    ArrayList<String> itemsDicc = new ArrayList<String>();

    ArrayList<ArrayList<String>> itemsTexto = new ArrayList<ArrayList<String>>();

    public ArrayList<ArrayList<String>> getItems1() {
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
                ArrayList<String> temp = new ArrayList<String>();
                if(nombreDelArchivo.equals("diccionario")){
                    parts = data.split(",");
                    for (int i = 0; i < parts.length; i++) {
                        itemsDicc.add(parts[i]);
                    }
                }
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
        for (int i = 0; i < items.size(); i = i + 3) {
            String [] lista = {items.get(i), items.get(i+1), items.get(i+2)};
            ArbolIngles.insert(items.get(i), new Palabra(lista[0], lista[0], lista[1], lista[2]));
            ArbolEspaniol.insert(items.get(i+1), new Palabra(lista[1], lista[0], lista[1], lista[2]));
            ArbolFrances.insert(items.get(i+2), new Palabra(lista[2], lista[0], lista[1], lista[2]));
        }
    }

    public String TraducirTexto(ArrayList<String> items, String idioma){
        String oracionFinal = "";
        BinarySearchTree<String, Palabra> arbol = null;
        //primero se detecta que idioma es el que se va a traducir
        for(String item : items){
            for(int i = 0; i < itemsDicc.size(); i = i + 3){
                if(item.equals(itemsDicc.get(i))){
                    //el idioma es ingles
                    arbol = ArbolIngles;
                }
            }
            for(int i = 1; i < itemsDicc.size(); i = i + 3){
                if(item.equals(itemsDicc.get(i))){
                    //el idioma es español
                    arbol = ArbolEspaniol;
                }
            }
            for(int i = 2; i < itemsDicc.size(); i = i + 3){
                if(item.equals(itemsDicc.get(i))){
                    //el idioma es frances
                    arbol = ArbolFrances;
                }
            }
        }
        if(idioma.equals("ingles")){
            for (int i = 0; i < items.size(); i++) {
                Palabra pal = (Palabra)arbol.search(items.get(i));

                if(pal != null){
                    String palabra = pal.getPIngles();
                    oracionFinal = oracionFinal + palabra + " ";
                }
                else{
                    oracionFinal = oracionFinal + "*"+ items.get(i) + "* ";
                }

            }
        }
        if(idioma.equals("espaniol")){
            for (int i = 0; i < items.size(); i++) {
                Palabra pal = (Palabra)arbol.search(items.get(i));

                if(pal != null){
                    String palabra = pal.getPEspanol();
                    oracionFinal = oracionFinal + palabra + " ";
                }
                else{
                    oracionFinal = oracionFinal + "*"+ items.get(i) + "* ";
                }

            }
        }
        if(idioma.equals("frances")){
            for (int i = 0; i < items.size(); i++) {
                Palabra pal = (Palabra)arbol.search(items.get(i));

                if(pal != null){
                    String palabra = pal.getPFrances();
                    oracionFinal = oracionFinal + palabra + " ";
                }
                else{
                    oracionFinal = oracionFinal + "*"+ items.get(i) + "* ";
                }

            }
        }
        return oracionFinal;
    }

    public String MostrarDiccionario(){
        VerPalabra<String, Palabra> ver = new VerPalabra<String, Palabra>();
        ArbolIngles.InOrderTraversal(ver);
        ver.getDatos();
        String diccionario = "";
        for(int i = 0; i < ver.getDatos().size(); i++){
            diccionario = diccionario +"\n"+(i+1)+". "+  ver.getDatos().get(i);
        }
        return diccionario;
    }


}
