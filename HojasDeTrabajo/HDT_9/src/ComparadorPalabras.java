/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *
 *Obtenida del repositorio de Moisés
 **/

import java.util.Comparator;

public class ComparadorPalabras<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        Palabra p1 = (Palabra) o1;
        Palabra p2 = (Palabra) o2;
        return p1.getPalabra().compareTo(p2.getPalabra());
    }

}
