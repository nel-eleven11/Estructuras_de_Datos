/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *
 *Obtenida del repositorio de Moisés
 **/


/**
 * The type Rb tree.
 *
 * @param <T> the type parameter
 */
public class RBTree<T extends Comparable<T>> implements EstructuraArbol<T> {

    private RedBlackSearchTree<T> miArbolInterno;

    /**
     * Instantiates a new Rb tree.
     */
    public RBTree() {
        miArbolInterno = new RedBlackSearchTree<T>();
    }

    @Override
    public void add(T value) {
        miArbolInterno.add(value);
    }

    @Override
    public T get(T key) {
        return miArbolInterno.get(key);
    }

    @Override
    public T remove(T key) {
        return miArbolInterno.remove(key);
    }

    @Override
    public int count() {
        return miArbolInterno.size();
    }

    @Override
    public boolean isEmpty() {
        return miArbolInterno.isEmpty();
    }

    /**
     * Get internal tree red black search tree.
     *
     * @return the red black search tree
     */
    public RedBlackSearchTree<T> getInternalTree(){
        return miArbolInterno;
    }
}
