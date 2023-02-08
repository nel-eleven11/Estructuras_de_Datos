package vm;/*
 * HDT 3 - Algoritmos y Estructuras de Datos
 * Nelson García Bravatti 22434
Joaquín Puente 22296
Oscar Fuentes 22763
 * 
 * 
 */

import vm.SortingMethods;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

/**
 * The type vm.Main.
 */


public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //Make an array with unordered numbers from 1 to 10
        int numSize = 10;
        Archivo myFile = new Archivo("data.csv");
        Archivo myFileOrdenado = new Archivo("data2.csv");
        Integer[] myArray = new Integer[numSize];
        Integer[] myArray2 = new Integer[numSize];

        String cadena = "";
        for (int i = 0; i < numSize; i++) {
            myArray[i] = (int) (Math.random() * numSize);

            cadena = cadena + myArray[i].toString()+",";

        }
        String cadena2 = "";
        myFile.escribirArchivo(cadena);
        myArray= myFile.leerArchivo();

        SortingMethods mySort = new SortingMethods();

        while (true) {
            String p = JOptionPane.showInputDialog(null, "Elija que sort desea utilizar: \n 1.QuickSort \n 1.5 QuickSort Ordenado \n 2.MergeSort \n 2.5 MergeSort Ordenado\n 3.GnomeSort \n 3.5 GnomeSort Ordenado\n 4.RadixSort \n 4.5 RadixSort Ordenado \n 5.BubbleSort \n 5.5 BubbleSort Ordenado \n 6.Salir");
            switch(p){
                case "1":

                    //evaluacion quicksort
                    mySort.quickSort(myArray, 0, myArray.length - 1);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                        cadena2 = cadena2 + myArray[i].toString()+",";

                    }
                    myFileOrdenado.escribirArchivo(cadena2);
                    break;

                case "1.5":

                    //evaluacion quicksort
                    myArray2 = myFileOrdenado.leerArchivo();
                    mySort.quickSort(myArray2, 0, myArray2.length - 1);
                    for (int i = 0; i < myArray2.length; i++) {
                        System.out.println(myArray2[i]);
                    }
                    break;

                case "2":


                    //evaluacion mergesort

                    mySort.mergeSortRecursive(myArray, 0, myArray.length - 1);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                        cadena2 = cadena2 + myArray[i].toString()+",";
                    }
                    myFileOrdenado.escribirArchivo(cadena2);
                    break;

                case "2.5":


                    //evaluacion mergesort
                    myArray2 = myFileOrdenado.leerArchivo();
                    mySort.mergeSortRecursive(myArray2, 0, myArray2.length - 1);
                    for (int i = 0; i < myArray2.length; i++) {
                        System.out.println(myArray2[i]);
                    }
                    break;

                case "3":

                    //evaluacion gnomesort

                    mySort.gnomeSort(myArray);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                        cadena2 = cadena2 + myArray[i].toString()+",";
                    }
                    myFileOrdenado.escribirArchivo(cadena2);
                    break;

                case "3.5":

                    //evaluacion gnomesort
                    myArray2 = myFileOrdenado.leerArchivo();
                    mySort.gnomeSort(myArray2);
                    for (int i = 0; i < myArray2.length; i++) {
                        System.out.println(myArray2[i]);
                    }
                    break;

                case "4":

                    //evaluacion radixsort

                    mySort.radixSort(myArray);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                        cadena2 = cadena2 + myArray[i].toString()+",";
                    }
                    myFileOrdenado.escribirArchivo(cadena2);
                    break;

                case "4.5":

                    //evaluacion radixsort
                    myArray2 = myFileOrdenado.leerArchivo();
                    mySort.radixSort(myArray2);
                    for (int i = 0; i < myArray2.length; i++) {
                        System.out.println(myArray2[i]);
                    }
                    break;

                case "5":

                    //evaluacion bubblesort

                    mySort.bubbleSort(myArray);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                        cadena2 = cadena2 + myArray[i].toString()+",";
                    }
                    myFileOrdenado.escribirArchivo(cadena2);
                    break;

                case "5.5":

                    //evaluacion bubblesort
                    myArray2 = myFileOrdenado.leerArchivo();
                    mySort.bubbleSort(myArray2);
                    for (int i = 0; i < myArray2.length; i++) {
                        System.out.println(myArray2[i]);
                    }
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
        }

        }
    }
}