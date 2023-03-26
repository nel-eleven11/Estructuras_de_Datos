/*
Nelson García
22434
hdt 7
 */

import java.util.Comparator;

/**
 * The type Comparador palabras.
 */
public class ComparadorPalabras  implements Comparator<String>  {

/**
 * Compare int.
 *
 * @param a the a
 * @param b the b
 * @return the int
 * @see Comparator#compare(Object, Object)
 */

    public int compare(String a, String b) {
        return a.compareTo(b);
    }
}
