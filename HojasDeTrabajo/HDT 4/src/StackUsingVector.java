package edu.uvg.structures.src;
/*
Nelson García Bravatti
22434
HDT 4

 */
import java.util.Stack;
import java.util.Vector;

public class StackUsingVector <T> extends Stack<T> implements IStack<T> {

    private Vector<T> miListaInterna;

    public StackusingVector() {
        miListaInterna = new Vector<T>();
    }

    @Override
    public int count() {
        return miListaInterna.size();
    }

    @Override
    public boolean isEmpty() {
        return miListaInterna.isEmpty();
    }

    @Override
    public void push(T value) {
        miListaInterna.add(0, value);
    }

    @Override
    public T pull() {
        return miListaInterna.remove(0);
    }

    @Override
    public T peek() {
        return miListaInterna.get(0);
    }

}
