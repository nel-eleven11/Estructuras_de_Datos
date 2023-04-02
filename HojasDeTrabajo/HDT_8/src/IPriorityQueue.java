/*
Nelson García 22434
Joaquín Puente 22296
HDT 8
Clase obtenida de la documentaicón del libro
 */
import java.util.*;
import java.lang.Comparable;

/**
 * The interface Priority queue.
 *
 * @param <E> the type parameter
 */
public interface IPriorityQueue<E> extends Comparable<E>{

    /**
     * Gets first.
     *
     * @return the first
     */
    public E getFirst();

    /**
     * Remove e.
     *
     * @return the e
     */
    public E remove();

    /**
     * Add.
     *
     * @param value the value
     */
    public void add(E value);

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty();

    /**
     * Size int.
     *
     * @return the int
     */
    public int size();

    /**
     * Clear.
     */
    public void clear();

}
