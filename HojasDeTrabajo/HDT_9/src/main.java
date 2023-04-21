
/*
* Hdt 9
* Nelson García Bravatti 22434
*
*
**/

import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class main {

    public static void main (String [] args){

        Controlador Micontrolador = new Controlador();
        Micontrolador.importFile("diccionario");
        Micontrolador.importFile("texto");

        String menu = "";

        while (!menu.equals("2")) {
            menu = JOptionPane.showInputDialog("Elija una opción: \n 1. Traducir texto\n 2. Salir");
            switch (menu) {
                case "1":
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;

            }
        }
    }
}
