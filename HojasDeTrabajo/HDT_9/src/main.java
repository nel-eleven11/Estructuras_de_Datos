
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

/**
 * The type Main.
 */
public class main {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main (String [] args){

        Controlador Micontrolador = new Controlador();
        Micontrolador.importFile("diccionario");
        Micontrolador.importFile("texto");

        String menu = "";
        String arbol = "";

        JOptionPane.showMessageDialog(null, "Bienvenido al traductor de texto");

        while (!menu.equals("2")) {
            menu = JOptionPane.showInputDialog("Elija una opción: \n 1. Traducir texto\n 2. Salir");
            switch (menu) {
                case "1":
                    arbol = JOptionPane.showInputDialog("Elija el tipo de arbol que desea utilizar: \n 1. RBTree\n 2. SplayTree\n 3. AVLTree");
                    int NumArbol = Integer.parseInt(arbol);
                    if(NumArbol<1 || NumArbol>3){
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    else{
                        Micontrolador.AgregarPalabras(Micontrolador.getItems2(), arbol);
                        for(int i = 0; i < Micontrolador.getItems1().size(); i++){
                            JOptionPane.showMessageDialog(null, "Traducción al español: \n" + Micontrolador.TraducirTexto(Micontrolador.getItems1().get(i), arbol));}
                    }
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
