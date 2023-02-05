/*
 * HDT 3 - Algoritmos y Estructuras de Datos
 * Nelson García Bravatti 22434
Joaquín Puente 22296
Oscar Fuentes 22763
 * 
 * 
 */

/**
 * The interface Comparator.
 *
 * @param <T> the type parameter
 */
public interface IComparator<T> {
    /**
     * Compare int.
     *
     * @param _object1 the object 1
     * @param _object2 the object 2
     * @return the int
     */
    public int Compare(T _object1, T _object2);
}
