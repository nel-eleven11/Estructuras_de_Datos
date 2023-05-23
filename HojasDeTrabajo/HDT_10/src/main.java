/*
 * HDT 10 Algorigmos y estructura de datos
 * Nelson García Bravatti 22434
 * Joaquín Puente  22296
 *
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class main {

    public static void main (String [] args){

        JOptionPane.showMessageDialog(null, "Bienvenido al programa de rutas de ciudades");


        int menu = 0;
        while(menu != 4){
            menu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la opcion que desea realizar: \n 1. Encontrar la ruta mas corta entre dos ciudades \n 2. Ciudad en el centro del grafo \n 3. Modificar grafo \n 4. Salir"));
            Controladora Micontroladora = new Controladora();
            switch (menu){
                case 1:
                    //se calcula la ruta mas corta entre dos ciudades
                    String ciudad_origen = JOptionPane.showInputDialog("Ingrese la ciudad de origen");
                    String ciudad_destino = JOptionPane.showInputDialog("Ingrese la ciudad de destino");
                    System.out.println(Micontroladora.getRutaMasCorta(ciudad_origen, ciudad_destino).toString());
                    break;
                case 2:
                    //se calcula la ciudad en el centro del grafo
                    System.out.println(Micontroladora.getCentroDelGrafo());
                    break;
                case 3:
                    //se modifica el grafo de las ciudades
                    int opcion = 0;
                    while(opcion != 4){
                        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la opcion que desea realizar: \n 1. Interrupción de ciudades \n 2. Agregar conexion entre ciudades \n 3. Cambio de clima \n 4. Salir"));
                        String ciudad1 = "";
                        String ciudad2 = "";
                        int tiempos [] = new int [4];
                        String clima = "";
                        String linea = "";
                        switch (opcion){
                            case 1:
                                //se interrumpe una conexion entre dos ciudades
                                ciudad1 = JOptionPane.showInputDialog("Ingrese la ciudad de origen");
                                ciudad2 = JOptionPane.showInputDialog("Ingrese la ciudad de destino");
                                linea = ciudad1 + " "+ ciudad2;
                                Micontroladora.modificarArchivo(opcion,linea, "");
                                break;
                            case 2:
                                //se agrega una conexion entre dos ciudades
                                ciudad1 = JOptionPane.showInputDialog("Ingrese la ciudad de origen");
                                ciudad2 = JOptionPane.showInputDialog("Ingrese la ciudad de destino");
                                //se piden los tiempos de viaje  tiempoNormal tiempoLluvia tiempoNieve tiempoTormenta
                                tiempos[0] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tiempo de viaje normal"));
                                tiempos[1] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tiempo de viaje en lluvia"));
                                tiempos[2] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tiempo de viaje en nieve"));
                                tiempos[3] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tiempo de viaje en tormenta"));
                                linea = ciudad1 + " "+ ciudad2 + " " + tiempos[0] + " " + tiempos[1] + " " + tiempos[2] + " " + tiempos[3];
                                Micontroladora.modificarArchivo(opcion ,linea, "");
                                break;
                            case 3:
                                //se cambia el clima de una ciudad
                                ciudad1 = JOptionPane.showInputDialog("Ingrese la ciudad que desea cambiar el clima");
                                ciudad2 = JOptionPane.showInputDialog("Ingrese la ciudad que desea cambiar el clima");
                                linea = ciudad1 + " "+ ciudad2;
                                //se pide el nuevo clima tiempoNormal tiempoLluvia tiempoNieve tiempoTormenta
                                clima = JOptionPane.showInputDialog("Eliga el nuevo clima de la ciudad: \n 1. Normal \n 2. Lluvia \n 3. Nieve \n 4. Tormenta");
                                Micontroladora.modificarArchivo(opcion ,linea, clima);
                                break;
                            case 4:
                                //se sale del menu de modificación
                                JOptionPane.showMessageDialog(null, "Saliendo del menu de modificacion");
                                break;
                            default:
                                //opcion invalida
                                JOptionPane.showMessageDialog(null, "Opcion invalida");
                                break;
                        }
                    }
                    break;
                case 4:
                    //se sale del programa
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                    System.exit(0);
                    break;
                default:
                    //opción invalida
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    break;
            }

        }




    }


}
