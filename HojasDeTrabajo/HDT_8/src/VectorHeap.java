/*
Nelson García 22434
Joaquín Puente 22296
HDT 8

Clase obtenida de la documentaicón del libro
 */
import java.util.*;
import java.lang.Comparable;

/**
 * The type Vector heap.
 *
 * @param <E> the type parameter
 */
public class VectorHeap<E extends Comparable<E>> implements IPriorityQueue<E> {

    /**
     * The Data.
     */
    protected Vector<E> data;

    /**
     * Instantiates a new Vector heap.
     */
    public VectorHeap()
    {
        data = new Vector<E>();
    }

    /**
     * Instantiates a new Vector heap.
     *
     * @param v the v
     */
    public VectorHeap(Vector<E> v)
    {
        int i;
        data = new Vector<E>(v.size());
        for (i = 0; i < v.size(); i++)
        {
            add(v.get(i));
        }
    }

    /**
     * Parent int.
     *
     * @param i the
     * @return the int
     */
    protected static int parent(int i)
    {
        return (i-1)/2;
    }

    /**
     * Left int.
     *
     * @param i the
     * @return the int
     */
    protected static int left(int i)
    {
        return 2*i+1;
    }

    /**
     * Right int.
     *
     * @param i the
     * @return the int
     */
    protected static int right(int i)
    {
        return (2*i+1) + 1;
    }

    /**
     * Percolate up.
     *
     * @param leaf the leaf
     */
    protected void percolateUp(int leaf)
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    public void add(E value)
    {
        data.add(value);
        percolateUp(data.size()-1);
    }

    /**
     * Push down root.
     *
     * @param root the root
     */
    protected void pushDownRoot(int root)
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos+1)).compareTo
                                (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo
                        (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root,value);
                    return;
                }
            } else {
                data.set(root,value);
                return;
            }
        }
    }

    public E remove()
    {
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    public int compareTo(E obj){
        return 0;
    }

    @Override
    public E getFirst() {
        if(data.isEmpty()){
            return null;
        }
        return data.firstElement();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
    @Override
    public int size() {
        //Devuelve el tamaño del vector
        return data.size();
    }

    public void clear() {
        data.clear();
    }

}