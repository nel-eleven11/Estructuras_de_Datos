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
        myArray = new Integer[]{11, 3, 74, 102, 9, 23, 6, 8, 51, 4};
        mySort.radixSort( myArray);
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

    }
}