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
        Integer[] myArray = new Integer[10];
        myArray = new Integer[]{1, 3, 7, 10, 9, 2, 6, 8, 5, 4};


        SortingMethods mySort = new SortingMethods();


        String p = JOptionPane.showInputDialog(null, "Elija que sort desea utilizar: \n 1.QuickSort \n 2.MergeSort \n 3.GnomeSort \n 4.RadixSort \n 5.BubbleSort");
        switch(p){
            case "1":
                //evaluacion quicksort
                mySort.quickSort(myArray, 0, myArray.length - 1);
                for (int i = 0; i < myArray.length; i++) {
                    System.out.println(myArray[i]);
                }
                break;

            case "2":
                //evaluacion mergesort

                mySort.mergeSortRecursive(myArray, 0, myArray.length - 1);
                for (int i = 0; i < myArray.length; i++) {
                    System.out.println(myArray[i]);
                }
                break;

            case "3":
                //evaluacion gnomesort

                mySort.gnomeSort(myArray);
                for (int i = 0; i < myArray.length; i++) {
                    System.out.println(myArray[i]);
                }
                break;

            case "4":
                //evaluacion radixsort

                mySort.radixSort(myArray);
                for (int i = 0; i < myArray.length; i++) {
                    System.out.println(myArray[i]);
                }
                break;

            case "5":
                //evaluacion bubblesort

                mySort.bubbleSort(myArray);
                for (int i = 0; i < myArray.length; i++) {
                    System.out.println(myArray[i]);
                }
                break;

            default:
                System.out.println("Opcion no valida");
                break;

        }
    }
}