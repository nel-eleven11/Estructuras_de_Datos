/*
 * HDT 3 - Algoritmos y Estructuras de Datos
 * Nelson García Bravatti 22434
Joaquín Puente 22296
Oscar Fuentes 22763
 * 
 * 
 */

/**
 * The type Main.
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

        
        mySort.quickSort(myArray, 0, myArray.length - 1);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        mySort.mergeSortRecursive(myArray, 0, myArray.length - 1);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        mySort.gnomeSort(myArray);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        //evaluacion de radix sort
        int[] myArray2 = new int[10];
        myArray2 = new int[]{1, 34, 7, 10, 9, 22, 67, 8, 15, 4};
        mySort.radixSort(myArray2);
        for (int i = 0; i < myArray2.length; i++) {
            System.out.println(myArray2[i]);
        }
        



    }
}