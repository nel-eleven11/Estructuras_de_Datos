/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *
 */
import java.util.Iterator;

/**
 * The type Avl tree.
 *
 * @param <E> the type parameter
 */
public class AVLTree<E extends Comparable<E>> extends AbstractStructure<E> implements OrderedStructure<E>
{

    /**
     * The Root.
     */
    protected AVLNode<E> root;

    /**
     * The Count.
     */
    protected int count;

    /**
     * Instantiates a new Avl tree.
     */
    public AVLTree()
    {
        root = null;
        count = 0;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void clear()
    {
        root = null;
        count = 0;
    }

    public int size()
    {
        return count;
    }

    public void add(E value)
    {
        if (isEmpty()) {
            root = new AVLNode<>(value);
        } else {
            root = root.add(value);
        }
        count++;
    }

    public E remove(E value){
        if (contains(value)){
            root = root.remove(value);
            count--;
            return value;
        }
        return null;
    }

    public boolean contains(E value){
        return root != null && root.contains(value);
    }

    /**
     * Get e.
     *
     * @param value the value
     * @return the e
     */
    public E get(E value){
        return root == null ? null : root.get(value);
    }

    public Iterator<E> iterator()
    {
        return root == null ? new EmptyIterator<>() : root.iterator();
    }

    /**
     * Tree string string.
     *
     * @return the string
     */
    public String treeString(){
        return root == null ? "" : root.treeString(0);
    }

    public String toString(){
        return root == null ? "[]" : root.toString();
    }

    public int hashCode(){
        return root == null ? 0 : root.hashCode();
    }
}
