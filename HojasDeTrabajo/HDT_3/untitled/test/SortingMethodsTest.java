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

        mySort.radixSort(new int[]{1, 34, 7, 10, 9, 22, 67, 8, 15, 4});
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

        mySort.ordenar_en_cubos(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0);

    }
}