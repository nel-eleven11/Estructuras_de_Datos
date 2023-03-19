/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class main {

    private File archivo;
    private static String [] lineas;
    private static ArrayList<String> items = new ArrayList<String>();

    public static void  importFile(String nombreDelArchivo){
        //Ruta del archivo
        String fpath = "Fase2\\src\\"+nombreDelArchivo+".txt";

        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lineas = data.split(" ");
                int cont = 0;
                String lista = "";
                for (String item : lineas){
                    //ver si es una lista
                    if(item.contains("'(")||(cont > 0)){
                        cont++;
                        if(item.contains(")")){
                            String [] temp = item.split("");
                            String item1 = temp[0]+temp[1];
                            item = "";
                            for(int i = 2; i < temp.length; i++){
                                item += temp[i];
                            }
                            lista += item1;
                            items.add(lista);
                            cont = 0;
                        }
                        else{
                            lista += item + " ";
                            item = "";
                        }
                    }
                    //si no contiene lista
                    if((item.contains("(") || item.contains(")"))&& (!item.contains("'("))){
                        while(item.contains("(") || item.contains(")")){
                            if(item.contains("(")){
                                item = item.substring(1);
                                items.add("(");

                            }else if(item.contains(")")){
                                item = item.substring(0, item.length()-1);
                                cont++;
                            }
                        }
                        items.add(item);
                        for(int i = 0; i < cont; i++){
                            items.add(")");
                        }
                        cont = 0;
                    }else{
                        if(item != ""){
                            items.add(item);
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getItems() {
        return items;
    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Bienvenido al interprete de Lisp");
        while(true){
            String opcion = JOptionPane.showInputDialog("Ingrese el numero de la opcion que desea realizar: \n 1. Leer archivo \n 2. Salir");
            if(opcion.equals("1")){
                String nombreDelArchivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo que desea leer");
                importFile(nombreDelArchivo);
                ArrayList<String> lisp = getItems();
                System.out.println(lisp);
                interpreter.readLisp(lisp);
                break;
            }else if(opcion.equals("2")){
                System.exit(0);
            }else{
                JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        }


    }
}
