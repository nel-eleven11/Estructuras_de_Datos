
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

       Controlador controlador = new Controlador();

        int opcion = 0;

        JOptionPane.showMessageDialog(null, "Bienvenido a la tienda online");


        while(opcion != 7){
            JOptionPane.showMessageDialog(null, "Seleccione con qué tipo de mapa desea trabajar");
            int mapa = Integer.parseInt(JOptionPane.showInputDialog("1. HashMap\n2. TreeMap\n3.LinkedHashMap"));
            controlador.importFile("ListadoProducto (2)");
            controlador.cargarProductos(controlador.getItems(), mapa);
            JOptionPane.showMessageDialog(null, "Seleccione una opción");
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Agregar producto\n2. Mostrar la categoría del producto\n3.Mostrar los datos del producto\n4.Mostrar productos ordenados\n5. Mostrar inventario\n6. Inventario ordenado\n7. Salir"));
            switch (opcion){
                case 1:
                    JOptionPane.showMessageDialog(null, "Agregar producto");
                    int categoria = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la categoría del producto\n1. Mueble de terraza\n2. Sillones de masaje\n3. Bebidas\n4.Condimentos\n5. Frutas\n6. Cárnes\n7. Lácteos"));
                    int producto;
                    int cantidad;
                    switch (categoria){
                        case 1:
                            producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el producto\n1. Mesas de jardín\n2. Sillas de jardín\n3. Conjuntos mesas y sillas de jardín\n4. Mesas de Ping Pong exteriores"));
                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea agregar"));
                            controlador.agregarProducto(categoria-1, producto-1, cantidad, mapa);
                            break;
                        case 2:
                            producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el producto\n1. Cojines y colchonetas de masaje\n2. Sillones relax y sofás de masajes\n3. Sillones de masaje avanzados\n4. Sofás camas"));
                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea agregar"));
                            controlador.agregarProducto(categoria-1, producto-1, cantidad, mapa);
                            break;
                        case 3:
                            producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el producto\1. Cerveza tibetana Barley\n2. Té frio\n3. Coca cola 1 litro\n4. Coca cola 2 litros"));
                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea agregar"));
                            controlador.agregarProducto(categoria-1, producto-1, cantidad, mapa);
                            break;
                        case 4:
                            producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el producto\n1. Sirope de regaliz\n2. Especies Cajun del chef\n3. Mezcla Gumbo del chef"));
                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea agregar"));
                            controlador.agregarProducto(categoria-1, producto-1, cantidad, mapa);
                            break;
                        case 5:
                            producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el producto\n1. Peras secas\n2. Pasas\n3. Manzanas rojas\n4. Manzanas verdes"));
                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea agregar"));
                            controlador.agregarProducto(categoria-1, producto-1, cantidad, mapa);
                            break;
                        case 6:
                            producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el producto\n1. Res\n2. Pollo\n3. Cerdo\n4. Camarones\n5. Pescado"));
                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea agregar"));
                            controlador.agregarProducto(categoria-1, producto-1, cantidad, mapa);
                            break;
                        case 7:
                            producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el producto\n1. Queso de cabra\n2. Queso Manchego\n3.Leche descremada\n4. Leche deslactosada\n5. Leche entera"));
                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea agregar"));
                            controlador.agregarProducto(categoria-1, producto-1, cantidad, mapa);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Categoría no válida");
                            break;
                    }

                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Mostrar la categoría del producto");
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                    controlador.mostrarCategoria(nombre, mapa);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Mostrar los datos del producto");
                    nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                    controlador.mostrarProducto(nombre, mapa);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Mostrar productos ordenados");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Mostrar inventario");
                    controlador.mostrarInventario(mapa);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Inventario ordenado");
                    controlador.mostrarInventarioOrdenado(mapa);
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Salir");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }

        }



    }
}
