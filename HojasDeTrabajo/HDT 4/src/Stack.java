/*
Nelson García Bravatti
22434
HDT 4
Clase abstracta Stack
 */

abstract class Stack <T> implements IStack<T> {

    protected int count;

    public Stack(){
        count = 0;
    }

    
    /** 
     * @return int
     */
    public int count(){
        return count;
    }

    
    /** 
     * @return boolean
     */
    public boolean isEmpty(){
        return false;
    }

    public abstract void push(T value);

    public abstract T pull();

    public abstract T peek();

}
