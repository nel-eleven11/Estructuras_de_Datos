/*
Nelson García Bravatti
22434
HDT 4

 */

abstract class Stack <T> implements IStack<T> {

    protected int count;

    public Stack(){
        count = 0;
    }

    public int count(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public abstract void push(T value);

    public abstract T pull();

    public abstract T peek();

}
