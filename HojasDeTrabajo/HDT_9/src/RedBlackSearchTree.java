// This is an implementation of binary search trees.
// (c) 1998, 2001 duane a. bailey

import java.util.Iterator;
import java.util.Comparator;
import java.util.Random;


/**
 * Red black trees, are binary trees that guarantee the following three properties. <BR>
 * 1. Every child of every leaf is considered black<BR>
 * 2. Every red node has two black children<BR>
 * 3. Every path from a node to a descendant leaf contains the same
 * number of black nodes. <BR>
 * <p>
 * These properties ensure that elements can be inserted, deleted, and
 * located in logorithmic time.
 * <p>
 * Example usage:
 * <p>
 * To create a red-black tree containing the months of the year
 * and to print out this tree as it grows we could use the following
 * <p>
 * <pre>
 * public static void main(String[] argv){
 *     RedBlackSearchTree test = new {@link #RedBlackSearchTree()};
 *
 *     //declare an array of months
 *     String[] months = new String[]{"March", "May", "November", "August",
 *                                    "April", "January", "December", "July",
 *                                    "February", "June", "October", "September"};
 *
 *     //add the months to the tree and print out the tree as it grows
 *     for(int i=0; i < months.length; i++){
 *        test.{@link #add(Object) add(months[i])};
 *        System.out.println("Adding: " + months[i] + "\n" +test.{@link #treeString()});
 *      }
 *  }
 * </pre>
 *
 * @param <E> the type parameter
 * @version $Id : RedBlackSearchTree.java 22 2006-08-21 19:27:26Z bailey $
 * @author, 2001 duane a. bailey & evan s. sandhaus
 * @see AVLTree
 * @see SplayTree
 * @see BinaryTree
 */
public class RedBlackSearchTree<E extends Comparable<E>> extends AbstractStructure<E> implements OrderedStructure<E>
{
    /**
     * The Root.
     */
    protected RedBlackTree<E> root;


    /**
     * The Count.
     */
    protected int count;


    /**
     * Instantiates a new Red black search tree.
     */
    public RedBlackSearchTree()
    {
        root = new RedBlackTree<E>();
        count = 0;
    }


    public boolean isEmpty()
    {
        return root.isEmpty();
    }


    public void clear()
    {
        root = new RedBlackTree<E>();
        count = 0;
    }


    public int size()
    {
        return count;
    }


    public void add(E value)
    {

        root = root.add(value);
        count++;
    }


    public E remove(E value){

        if (root.contains(value) != null){
            root = root.remove(value);
            count--;
            return value;
        }
        return null;
    }

    public boolean contains(E value){
        return root.contains(value) != null;
    }


    /**
     * Get e.
     *
     * @param value the value
     * @return the e
     */
    public E get(E value){
        return root.contains(value).value;
    }


    /**
     * Is red black boolean.
     *
     * @return the boolean
     */
    public boolean isRedBlack()
    {
        return root.consistency();
    }


    public Iterator<E> iterator()
    {
        return root.iterator();
    }


    /**
     * Tree string string.
     *
     * @return the string
     */
    public String treeString(){
        return root.treeString();
    }


    public String toString(){
        return root.toString();
    }


    public int hashCode() {
        return root.hashCode();

    }


}

