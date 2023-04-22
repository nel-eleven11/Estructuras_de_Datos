/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *
 *Obtenida del repositorio de Moisés
 **/

import java.util.Comparator;

import structure5.SplayTree;

/**
 * The type Splay arbol.
 *
 * @param <T> the type parameter
 */
public class SplayArbol <T extends Comparable<T>> implements EstructuraArbol<T> {

    private SplayTree<T> miArbolInterno;

    /**
     * Instantiates a new Splay arbol.
     */
    public SplayArbol() {
        miArbolInterno = new SplayTree<T>();
    }

    /**
     * Instantiates a new Splay arbol.
     *
     * @param comparador the comparador
     */
    public SplayArbol(Comparator<T> comparador) {
        miArbolInterno = new SplayTree<T>(comparador);
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
     * Get internal tree splay tree.
     *
     * @return the splay tree
     */
    public SplayTree<T> getInternalTree(){
        return miArbolInterno;
    }
}
