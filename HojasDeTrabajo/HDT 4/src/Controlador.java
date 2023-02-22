/*
Nelson García Bravatti
22434
HDT 4
Clase controladora
 */

import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controlador {

    ArrayList<String> items = new ArrayList<String>();
    private IPostfixCalculator miCalculadora = Calculadora.getInstance();
    private IStack<Integer> miPila;


    
    /**
     * este método importa el archivo de texto que se le indique, y lo guarda en un ArrayList. En este caso es 'Datos'
     * @param nombreDelArchivo
     */
    public void importFile(String nombreDelArchivo){
    //Ruta del archivo
    String fpath = ".\\src\\"+nombreDelArchivo+".txt";

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

    
    /**
     * convertir utiliza el método convertidor de la clase FixToPost para convertir la expresión infix a postfix, devuelve un string con la expresión en postfix.
     * @param expresion
     * @param tipo
     * @return String
     */
    public String convertir(String expresion, int tipo){
        FixToPost miConvertidor = new FixToPost();
        String postFix = miConvertidor.convertidor(expresion,tipo);
        return postFix;
    }

    
    /**
     * calculate utiliza el método calculate de la clase Calculadora para calcular la expresión postfix, devuelve un ArrayList con las respuestas.
     * @param itemToCalculate
     * @param tipo
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> calculate(ArrayList<String> itemToCalculate, int tipo){
        Factory<Integer> factory = new Factory<Integer>();
        miPila = factory.getStack(tipo);
        ArrayList<Integer> respuestas = new ArrayList<Integer>();
        for (String itemX : itemToCalculate) {

            ArrayList<String> sepItems = miCalculadora.getItems(itemX);
            for (String item : sepItems) {
                try {
                    if (miCalculadora.isOperator(item)) {
                        int b = (miPila.pull());
                        int a = (miPila.pull());

                        int result = 0;
                        switch (item) {
                            case "+":
                                result = miCalculadora.suma(a, b);
                                break;
                            case "-":
                                result = miCalculadora.resta(a, b);
                                break;
                            case "*":
                                result = miCalculadora.multiplicacion(a, b);
                                break;
                            case "/":
                                result = miCalculadora.division(a, b);
                                break;
                        }
                        miPila.push((result));
                    } else {
                        miPila.push(Integer.parseInt(item));
                    }
                } catch (Exception e){
                    System.out.println("Error en la operación");
                    return null;
                }
            }
            respuestas.add(miPila.pull());
        }
        return respuestas;
    }

    
    /**
     * getItems devuelve el ArrayList con los datos del archivo de texto.
     * @return ArrayList<String>
     */
    public ArrayList<String> getItems() {
        return items;
    }

}
