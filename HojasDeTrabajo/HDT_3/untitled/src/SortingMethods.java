/*
HDT 3 - Algoritmos y Estructuras de Datos
 * Nelson García Bravatti 22434
Joaquín Puente 22296
Oscar Fuentes 22763
 * 
 * 
 */
//arraylist
import java.util.ArrayList;

/**
 * The type Sorting methods.
 *
 * @param <T> the type parameter
 */
public class SortingMethods <T>{

    /**
     * Quick sort.
     *
     * @param <T>     the type parameter
     * @param myArray the my array
     * @param inf     the inf
     * @param sup     the sup
     */
    public <T extends Comparable<T>> void quickSort(T[] myArray, int inf, int sup) {
        int i = inf - 1;
        int j = sup;
        boolean flag = true;
        T temp;


        if (inf >= sup) {
            return;
        }

        T elem_div = myArray[sup];


        while (flag) {
            while((myArray[++i].compareTo(elem_div)) < 0); //Move the index i until it finds an element bigger than elem_div
            while(((myArray[--j].compareTo(elem_div)) > 0)  && (j > inf)); //Move the index j until it finds element smaller than elem_div

            if (i < j) {
                temp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = temp;
            } else {
                flag = false;
            }
        }

        temp = myArray[i];
        myArray[i] = myArray[sup];
        myArray[sup] = temp;
        quickSort(myArray, inf, i - 1);
        quickSort(myArray, i + 1, sup);
    }

    /**
     * Gnome sort t [ ].
     *
     * @param <T> the type parameter
     * @param arr the arr
     * @return the t [ ]
     */
    public <T extends Comparable<T>> T[] gnomeSort(T[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (index == 0 || arr[index].compareTo(arr[index - 1]) >= 0) {
                index++;
            } else {
                T temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
        return arr;
    }

    /**
     * Merge sort recursive.
     *
     * @param <T>   the type parameter
     * @param arr   the arr
     * @param start the start
     * @param end   the end
     */
    public <T extends Comparable<T>> void mergeSortRecursive(T[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortRecursive(arr, start, mid);
            mergeSortRecursive(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        T[] left = (T[]) new Comparable[n1];
        T[] right = (T[]) new Comparable[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[start + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }


    //radix sort implementando icomparator

    public <T extends Comparable<T>> void radixSort(T[] arr) {

        for(int i = 0; i < 6; i++) {
            ordenar_en_cubos(arr, i);
        }
    }

    public static <T extends Comparable<T>> int revision_digito(T numero, int digito) {
        if(digito == 0) {
            return Integer.parseInt(numero.toString()) % 10;
        } else {
            return revision_digito(Integer.parseInt(numero.toString()) / 10, digito - 1);
        }
    }

    public static <T extends Comparable<T>> void ordenar_en_cubos(T[] arr, int digito) {

        int val_actual;
        ArrayList<T>[] cubos = new ArrayList[10];
        for(int i = 0; i < cubos.length; i++) {
            cubos[i] = new ArrayList<T>();
        }

        int n = arr.length;
        for(int j = 0; j < n; j++) {
            val_actual = revision_digito(arr[j], digito);
            cubos[val_actual].add(arr[j]);
        }

        int k = 0;
        for(int i = 0; i < cubos.length; i++) {
            for(int j = 0; j < cubos[i].size(); j++) {
                arr[k] = cubos[i].get(j);
                k++;
            }
        }
    }

    //bubblesort implementando icomparator
    // este es el sort que eligio el grupo
    public <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        T temp;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < (n - i); j++) {
                /*System.out.println(arr[j - 1] + " " + arr[j]);
                System.out.println("");*/
                if(arr[j - 1].compareTo(arr[j]) > 0) {
                    temp = arr[j - 1];

                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    /*System.out.println(arr[j - 1] + " " + arr[j]);
                    System.out.println("");*/
                }
            }
        }
    }



}
