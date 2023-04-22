/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *
 *
 **/

/**
 * The type Avl arbol.
 *
 * @param <T> the type parameter
 */
public class AVLArbol <T extends Comparable<T>> implements EstructuraArbol<T>{

    private AVLTree<T> miArbolInterno;

    /**
     * Instantiates a new Avl arbol.
     */
    public AVLArbol(){
        miArbolInterno = new AVLTree<T>();
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
     * Get internal tree avl tree.
     *
     * @return the avl tree
     */
    public AVLTree<T> getInternalTree(){
        return miArbolInterno;
    }

}
