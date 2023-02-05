/*
HDT 3 - Algoritmos y Estructuras de Datos
 * Nelson García Bravatti 22434
Joaquín Puente 22296
Oscar Fuentes 22763
 *
 *
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingMethodsTest {

    SortingMethods mySort = new SortingMethods();

    @Test
    void quickSort() {

        Integer[] myArray = new Integer[10];
        myArray = new Integer[]{11, 3, 74, 102, 9, 23, 6, 8, 51, 4};
        mySort.quickSort(myArray, 0, myArray.length - 1);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

    }

    @Test
    void gnomeSort() {
    }

    @Test
    void mergeSortRecursive() {
    }

    @Test
    void radixSort() {


        Integer[] myArray = new Integer[10];
        Integer[] compArray = new Integer[10]; //array para comparar, este está ordenado
        compArray = new Integer[]{3,4,6,8,9,11,23,51,74,102};
        myArray = new Integer[]{11, 3, 74, 102, 9, 23, 6, 8, 51, 4};
        mySort.radixSort( myArray);

        for (int i = 0; i < myArray.length; i++) {
            assertEquals(compArray[i], myArray[i]);
            System.out.println(myArray[i]);
        }
    }

    @Test
    void revision_digito() {

        // numero es 1 y digito es 0 (unidades)
        assertEquals(1, mySort.revision_digito(11, 0));

        //numero 23 y digito 1 (decenas)

        assertEquals(2, mySort.revision_digito(23, 1));

        //numero 523 y digito 2 (centenas)
        assertEquals(5, mySort.revision_digito(523, 2));
    }

    @Test
    void ordenar_en_cubos() {

        Integer[] myArray = new Integer[10];
        myArray = new Integer[]{11, 3, 74, 102, 9, 23, 6, 8, 51, 4};
        mySort.ordenar_en_cubos(myArray, 0);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }


    }
}