/*
Nelson García 22434
Joaquín Puente 22296
HDT 8
 */
import java.util.*;
import java.lang.Comparable;
public interface IPriorityQueue<E> extends Comparable<E>{

    public E getFirst();
    public E remove();
    public void add(E value);
    public boolean isEmpty();
    public int size();
    public void clear();

}
