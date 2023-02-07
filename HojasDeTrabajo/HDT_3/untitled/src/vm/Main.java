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

        //solicitar un numero con java swing joptionpane

        String p = JOptionPane.showInputDialog(null, "Ingrese un numero para ordenar");
        if(p.equals("1"))
        {
            //evaluacion quicksort
            mySort.quickSort(myArray, 0, myArray.length - 1);
            for (int i = 0; i < myArray.length; i++) {
                System.out.println(myArray[i]);
            }
        }





        /*
        //evaluacion mergesort

        mySort.mergeSortRecursive(myArray, 0, myArray.length - 1);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        //evaluacion gnomesort

        mySort.gnomeSort(myArray);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        //evaluacion radixsort

        mySort.radixSort(myArray);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        //evaluacion bubblesort

        mySort.bubbleSort(myArray);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }*/


    }
}