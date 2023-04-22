/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *
 *
 **/

public class AVLArbol <T extends Comparable<T>> implements EstructuraArbol<T>{

    private AVLTree<T> miArbolInterno;

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

    public AVLTree<T> getInternalTree(){
        return miArbolInterno;
    }

}
