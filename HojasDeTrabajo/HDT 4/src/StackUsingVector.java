/*
Nelson García Bravatti
22434
HDT 4
Stack compuesto por vectores
 */
import java.util.Vector;

public class StackUsingVector <T> extends Stack<T> {

    private Vector<T> miVector;

    public StackUsingVector(){
        miVector = new Vector<T>();
    }

    
    /**
     * count, cuenta el numero de elementos en la lista
     * @return int
     */
    public int count(){
        return miVector.size();
    }

    
    /**
     * isEmpty, verifica si la lista esta vacia
     * @return boolean
     */
    public boolean isEmpty(){
        return miVector.isEmpty();
    }

    
    /**
     * push, agrega un elemento al inicio de la lista
     * @param value
     */
    public void push(T value){
        miVector.add(0,value);
    }

    
    /**
     * pull, elimina el primer elemento de la lista, y lo retorna
     * @return T
     */
    public T pull(){
        return miVector.remove(0);
    }

    
    /**
     * peek, retorna el primer elemento de la lista
     * @return T
     */
    public T peek(){
        return miVector.get(0);
    }


}

