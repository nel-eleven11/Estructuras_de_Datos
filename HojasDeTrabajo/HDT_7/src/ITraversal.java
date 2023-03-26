
/*
Nelson García
22434
hdt 7
 */

/**
 * The interface Traversal.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 * @author MAAG
 */
public interface ITraversal <K, V>{

    /**
     * Visit.
     *
     * @param actualNode the actual node
     */
    void visit(TreeNode<K, V> actualNode);

}
