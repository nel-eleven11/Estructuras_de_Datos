/*
Nelson García Bravatti
22434
HDT 4

 */
import java.util.Vector;

public class StackUsingVector <T> extends Stack<T> {

    private Vector<T> miVector;

    public StackUsingVector(){
        miVector = new Vector<T>();
    }

    public int count(){
        return miVector.size();
    }

    public boolean isEmpty(){
        return miVector.isEmpty();
    }

    public void push(T value){
        miVector.add(0,value);
    }

    public T pull(){
        return miVector.remove(0);
    }

    public T peek(){
        return miVector.get(0);
    }


}

