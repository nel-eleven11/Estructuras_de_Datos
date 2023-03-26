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

/**
 * The type Main.
 * clase main
 */
public class main {


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Controlador Micontrolador = new Controlador();
        Micontrolador.importFile("diccionario");
        Micontrolador.importFile("texto");
        //se agregan los datos del diccionario a los arboles
        Micontrolador.AgregarPalabras(Micontrolador.getItems2());

        JOptionPane.showMessageDialog(null, "Bienvenido al programa de Diccionario Inglés-Francés-Español");

        String menu = "";
        String menu2 = "";
        while (!menu.equals("3")){
            menu = JOptionPane.showInputDialog("Elija una opción: \n 1. Traducir texto\n 2. Mostrar Diccionario\n 3. Salir");
            switch (menu){
                case"1":
                    //se traduce el texto
                    menu2 = JOptionPane.showInputDialog("Elija a qué idioma desea traducir el texto: \n1. Inglés\n2. Francés\n3. Español");
                    switch (menu2){
                        case "1":
                            //se traduce al ingles
                            for(int i = 0; i < Micontrolador.getItems1().size(); i++){
                                JOptionPane.showMessageDialog(null, "Traducción al inglés: \n" + Micontrolador.TraducirTexto(Micontrolador.getItems1().get(i), "ingles"));
                            }
                            break;
                        case "2":
                            //se traduce al frances
                            for(int i = 0; i < Micontrolador.getItems1().size(); i++) {
                                JOptionPane.showMessageDialog(null, "Traducción al francés: \n" + Micontrolador.TraducirTexto(Micontrolador.getItems1().get(i), "frances"));
                            }
                            break;
                        case "3":
                            //se traduce al español
                            for(int i = 0; i < Micontrolador.getItems1().size(); i++) {
                                JOptionPane.showMessageDialog(null, "Traducción al español: \n" + Micontrolador.TraducirTexto(Micontrolador.getItems1().get(i), "espaniol"));
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida");
                            break;
                    }
                    break;
                case "2":
                    //se muestra el diccionario
                    JOptionPane.showMessageDialog(null, "Palabras que están en el diccionario:");
                    JOptionPane.showMessageDialog(null , Micontrolador.MostrarDiccionario());

                    break;
                case "3":
                    //salir
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
