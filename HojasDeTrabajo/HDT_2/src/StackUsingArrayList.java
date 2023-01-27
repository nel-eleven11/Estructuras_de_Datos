/*/
HDT 2 Algoritmos y estructuras de datos
Nelson García Bravatti 22434
Joaquín Puente 22296
Oscar Fuentes 22763

Clase stack using array list

 */
package src;

import java.util.ArrayList;

public class StackUsingArrayList<T> implements IStack<T> {

    private ArrayList<T> miListaInterna;

    public StackUsingArrayList() {
        miListaInterna = new ArrayList<T>();
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
