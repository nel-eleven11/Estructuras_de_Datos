/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EmptyIterator<E> implements Iterator<E> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        throw new NoSuchElementException("This is an empty iterator, and no elements are available.");
    }
}
