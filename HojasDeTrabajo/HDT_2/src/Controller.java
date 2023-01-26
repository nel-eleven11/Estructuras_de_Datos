package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private IPostfixCalculator miCalculadora = new PostfixCalculator();
    private IStack<Integer> miPila = new StackUsingArrayList<Integer>();

    public ArrayList<String> items = new ArrayList<String>();

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

    public Integer calculate(String itemToCalculate){
        ArrayList<String> sepItems = miCalculadora.getItems(itemToCalculate);
        for (String item : sepItems) {

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
        }
        return (miPila.pull());
    }



}
