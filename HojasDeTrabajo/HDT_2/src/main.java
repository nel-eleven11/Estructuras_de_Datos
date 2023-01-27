package src;

import java.util.ArrayList;
import java.util.Scanner;

/*

HDT 2 Algoritmos y estructuras de datos
Nelson García Bravatti 22434
Joaquín Puente 22296
Oscar Fuentes 22763

Clase main

 */
public class main {


    public static void main(String[] args) {
        Controller MiControlador = new Controller();
        Scanner teclado = new Scanner(System.in);
        String menuInicial = "1. Importar Operaciones de TXT\n2. Salir ";
        int opcion = 1;
        System.out.println(menuInicial);
        System.out.println("Ingrese la opción que desea: ");
        opcion = teclado.nextInt();
        teclado.nextLine();
        while (opcion != 2) {
            switch (opcion){
                case 1 -> {
                    System.out.println("Escriba el nombre del archivo");
                    String NombreDelArchivo = teclado.nextLine();
                    MiControlador.importFile(NombreDelArchivo);
                    ArrayList<Integer> respuestas =  MiControlador.calculate(MiControlador.items);
                    for (int i = 0 ; i < respuestas.size(); i++) {
                        System.out.println(MiControlador.items.get(i) + " = " + respuestas.get(i));
                    }
                }
                case 2 -> {
                    System.exit(0);
                }
            }
        }
    }




}

