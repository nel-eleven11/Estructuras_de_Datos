// This is an implementation of binary search trees.
// (c) 1998, 2001 duane a. bailey

import java.util.Iterator;
import java.util.Comparator;
import java.util.Random;
import structure5.RedBlackTree;

/**
 * Red black trees, are binary trees that guarantee the following three properties. <BR>
 * 1. Every child of every leaf is considered black<BR> 
 * 2. Every red node has two black children<BR>
 * 3. Every path from a node to a descendant leaf contains the same
 *    number of black nodes. <BR>
 * <P>
 * These properties ensure that elements can be inserted, deleted, and 
 * located in logorithmic time. 
 * <P>
 * Example usage:
 * <P>
 * To create a red-black tree containing the months of the year
 * and to print out this tree as it grows we could use the following
 * <P>
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
 * @version $Id: RedBlackSearchTree.java 22 2006-08-21 19:27:26Z bailey $
 * @author, 2001 duane a. bailey & evan s. sandhaus
 * @see AVLTree
 * @see SplayTree
 * @see BinaryTree
 */
public class RedBlackSearchTree<E extends Comparable<E>> extends AbstractStructure<E> implements OrderedStructure<E>
{
    protected RedBlackTree<E> root;


    protected int count;


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


    public E get(E value){
        return root.contains(value).value;
    }


    public boolean isRedBlack()
    {
        return root.consistency();
    }


    public Iterator<E> iterator()
    {
        return root.iterator();
    }


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

