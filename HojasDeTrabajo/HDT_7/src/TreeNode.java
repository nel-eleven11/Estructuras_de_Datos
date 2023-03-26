/*
Nelson García
22434
hdt 7
 */

/**
 * The type Tree node.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 * @author MAAG
 */
public class TreeNode <K, V>{

    private K key;
    private V value;

    private TreeNode<K,V> left;
    private TreeNode<K,V> right;
    private TreeNode<K,V> parent;

    /**
     * Instantiates a new Tree node.
     *
     * @param _key   the key
     * @param _value the value
     */
    public TreeNode(K _key, V _value) {
        setKey(_key);
        setValue(_value);
        setLeft(null);
        setRight(null);
        setParent(null);
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * Sets key.
     *
     * @param key the key to set
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value to set
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Gets left.
     *
     * @return the left
     */
    public TreeNode<K, V> getLeft() {
        return left;
    }

    /**
     * Sets left.
     *
     * @param left the left to set
     */
    public void setLeft(TreeNode<K, V> left) {
        this.left = left;
    }

    /**
     * Gets right.
     *
     * @return the right
     */
    public TreeNode<K, V> getRight() {
        return right;
    }

    /**
     * Sets right.
     *
     * @param right the right to set
     */
    public void setRight(TreeNode<K, V> right) {
        this.right = right;
    }

    /**
     * Gets parent.
     *
     * @return the parent
     */
    public TreeNode<K, V> getParent() {
        return parent;
    }

    /**
     * Sets parent.
     *
     * @param parent the parent to set
     */
    public void setParent(TreeNode<K, V> parent) {
        this.parent = parent;
    }

}
