
/*
Nelson García 22434
HDT 6
 */

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

       // Controlador controlador = new Controlador();

        int opcion = 0;

        JOptionPane.showMessageDialog(null, "Bienvenido a la tienda onnline");
        JOptionPane.showMessageDialog(null, "Seleccione una opción");
        opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Agregar producto\n2. Mostrar la categoría del producto\n3.Mostrar los datos del producto\n4.Mostrar productos ordenados\n5. Mostrar inventario\n6. Inventario ordenado\n7. Salir"));
    }
}
