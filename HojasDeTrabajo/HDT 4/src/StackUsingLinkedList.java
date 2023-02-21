
/*
Nelson García Bravatti
22434
HDT 4
Obtenida del repositorio de Moises
 */

public class StackUsingLinkedList<T> extends Stack<T>{

    private SingleLinkedList<T> listaInterna;

    public StackUsingLinkedList()
    {
        listaInterna = new SingleLinkedList<T>();
    }

    
    /**
     * count, cuenta el numero de elementos en la lista
     * @return int
     */
    @Override
    public int count() {
        return listaInterna.Count();
    }

    
    /**
     * isEmpty, verifica si la lista esta vacia
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return listaInterna.IsEmpty();
    }

    
    /**
     * push, agrega un elemento al inicio de la lista
     * @param value
     */
    @Override
    public void push(T value) {
        listaInterna.InsertAtStart(value);
    }

    
    /**
     * pull, elimina el primer elemento de la lista, y lo retorna
     * @return T
     */
    @Override
    public T pull() {
        return listaInterna.Delete(0);
    }

    
    /**
     *  peek, retorna el primer elemento de la lista
     * @return T
     */
    @Override
    public T peek() {
        return listaInterna.Get(0);
    }

}

