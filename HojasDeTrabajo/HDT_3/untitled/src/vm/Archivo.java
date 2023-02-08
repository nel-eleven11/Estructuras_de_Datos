package vm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class Archivo {

    private File archivo;

    public Archivo (String nombreArchivo){
        archivo = new File(nombreArchivo);
        try {
            archivo.createNewFile();
        } catch (IOException e) {
            // El archivo ya existe o está en uso
            e.printStackTrace();
        }
    }

    public void escribirArchivo(String linea){
        try {
            FileWriter miEscritor = new FileWriter(archivo);
            miEscritor.write(linea);
            miEscritor.close();
        } catch (IOException e) {
            // Ocurrió un error en la escritura
            e.printStackTrace();
        }
    }
    public Integer[] leerArchivo(){
        Scanner miLector;
        Integer[] myArray = new Integer[3000];
        try {
            miLector = new Scanner(archivo);
            while (miLector.hasNextLine()){
                String linea = miLector.nextLine();
                String[] numeros = linea.split(",");
                for (int i = 0; i < numeros.length; i++) {
                    myArray[i] = Integer.parseInt(numeros[i]);
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return myArray;
    }

    public void eliminarArchivo(){
        archivo.delete();
    }
}
