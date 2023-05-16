package src;

/*
 * HDT 1 Algorigmos y estructura de datos
 * Nelson García Bravatti
 * Joaquín Puente
 * Oscar Fuentes
 * Clase main
 */

import java.util.Scanner;

public class Main{
    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        controlador radioUvg = new controlador();
        Scanner teclado = new Scanner(System.in);
        String menuInicial = "1. Encender Radio\n2. salir";
        String menu = "1.Cambia de AM a FM \n2.Avanzar en el dial de las emisoras. Al llegar al final del dial inicia nuevamente. \n3.Permite guardar una emisora en uno de los 12 botones \n4.Permite seleccionar la emisora puesta en un botón \n5. Apagar el radio\n";


        int opcion = 1;
        while (opcion != 2){
            System.out.println(menuInicial);
            System.out.println("Ingrese la opción que desea: ");
            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion){
                case 1 -> {
                    radioUvg.turnOnOff();
                    System.out.println("Radio encendida");

                    onState: while (true){
                        System.out.println(menu);
                        System.out.println("Ingrese la opción que desea: ");
                        int op = Integer.parseInt(teclado.nextLine());
                        switch (op){
                            case 1 -> {
                                radioUvg.changeFrequence();
                                System.out.println(radioUvg.getFrequence());
                            }

                            case 2 -> {
                                dial: while (true) {
                                    System.out.println("presione 1 para avanzar y presione 2 para retroceder y 3 para salir");
                                    System.out.println("usted esta en la frecuencia:");
                                    System.out.println(radioUvg.getFrequence());
                                    System.out.println("y en la estacion:");
                                    if (radioUvg.getFrequence().equals("AM")){
                                        System.out.println(radioUvg.getAMActualStation());
                                    }else{
                                        System.out.println(radioUvg.getFMActualStation());
                                    }
                                    int dial = Integer.parseInt(teclado.nextLine());
                                    switch (dial) {
                                        case 1 -> {
                                            System.out.println(radioUvg.getFrequence());
                                            radioUvg.forward();
                                        }
                                        case 2 -> {
                                            System.out.println(radioUvg.getFrequence());
                                            radioUvg.backward();
                                        }
                                        case 3 -> {
                                            break dial;
                                        }
                                    }
                                }
                            }

                            case 3 -> {
                                System.out.println("Escriba el numero de boton en el cual lo quiere guardar del 1 al 12");
                                opcion = teclado.nextInt();
                                teclado.nextLine();
                                radioUvg.saveStation(opcion);
                                System.out.println("Se guardo la emisora");
                            }
                            case 4 -> {
                                System.out.println("Escriba el numero de boton en el cual se encuentra su emisora");
                                opcion = teclado.nextInt();
                                teclado.nextLine();
                                radioUvg.selectFavoriteSation(opcion);
                                System.out.println("Se ha puesto la emisora");
                                break;
                            }
                            case 5 -> {
                                break onState;
                            }
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Gracias por usar radio uvg");
                    System.exit(0);
                }
            }
        }
    }
 }
    

