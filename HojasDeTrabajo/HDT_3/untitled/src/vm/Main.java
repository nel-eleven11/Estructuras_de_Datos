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



        SortingMethods mySort = new SortingMethods();
        Integer[] myArray = new Integer[3000];
        while (true) {
            String p = JOptionPane.showInputDialog(null, "Elija que sort desea utilizar: \n 1.QuickSort \n 1.5 QuickSort Ordenado \n 2.MergeSort \n 2.5 MergeSort Ordenado\n 3.GnomeSort \n 3.5 GnomeSort Ordenado\n 4.RadixSort \n 4.5 RadixSort Ordenado \n 5.BubbleSort \n 5.5 BubbleSort Ordenado \n 6.Salir");
            switch(p){
                case "1":
                    for (int i = 0; i < 3000; i++) {
                        myArray[i] = (int) (Math.random() * 3000);
                    }

                    //evaluacion quicksort
                    mySort.quickSort(myArray, 0, myArray.length - 1);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                    }
                    break;

                case "1.5":
                    for (int i = 0; i < 3000; i++) {
                        myArray[i] = i;
                    }

                    //evaluacion quicksort
                    mySort.quickSort(myArray, 0, myArray.length - 1);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                    }
                    break;

                case "2":
                    for (int i = 0; i < 3000; i++) {
                        myArray[i] = (int) (Math.random() * 3000);
                    }

                    //evaluacion mergesort

                    mySort.mergeSortRecursive(myArray, 0, myArray.length - 1);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                    }
                    break;

                case "2.5":
                    for (int i = 0; i < 3000; i++) {
                        myArray[i] = i;
                    }

                    //evaluacion mergesort

                    mySort.mergeSortRecursive(myArray, 0, myArray.length - 1);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                    }
                    break;

                case "3":
                    for (int i = 0; i < 3000; i++) {
                        myArray[i] = (int) (Math.random() * 3000);
                    }
                    //evaluacion gnomesort

                    mySort.gnomeSort(myArray);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                    }
                    break;

                case "3.5":
                    for (int i = 0; i < 3000; i++) {
                        myArray[i] = i;
                    }
                    //evaluacion gnomesort

                    mySort.gnomeSort(myArray);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                    }
                    break;

                case "4":
                    for (int i = 0; i < 3000; i++) {
                        myArray[i] = (int) (Math.random() * 3000);
                    }
                    //evaluacion radixsort

                    mySort.radixSort(myArray);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                    }
                    break;

                case "4.5":
                    for (int i = 0; i < 3000; i++) {
                        myArray[i] = i;
                    }
                    //evaluacion radixsort

                    mySort.radixSort(myArray);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                    }
                    break;

                case "5":
                    for (int i = 0; i < 3000; i++) {
                        myArray[i] = (int) (Math.random() * 3000);
                    }
                    //evaluacion bubblesort

                    mySort.bubbleSort(myArray);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
                    }
                    break;

                case "5.5":
                    for (int i = 0; i < 3000; i++) {
                        myArray[i] = i;
                    }
                    //evaluacion bubblesort

                    mySort.bubbleSort(myArray);
                    for (int i = 0; i < myArray.length; i++) {
                        System.out.println(myArray[i]);
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