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

    /**
     * Constructor de la clase
     */
    public StackUsingArrayList() {
        miListaInterna = new ArrayList<T>();
    }

    /**
     * Método que cuenta los elementos de la lista
     * @return cantidad de elementos
     */
    @Override
    public int count() {
        return miListaInterna.size();
    }

    /**
     * Método que verifica si la lista está vacía
     * @return true si está vacía, false si no
     */
    @Override
    public boolean isEmpty() {
        return miListaInterna.isEmpty();
    }

    /**
     * Método que agrega un elemento al stack
     * @param value
     */
    @Override
    public void push(T value) {
        miListaInterna.add(0, value);
    }

    /**
     * Método que saca un elemento del stack
     * @return elemento sacado
     */
    @Override
    public T pull() {
        return miListaInterna.remove(0);
    }

    /**
     * Método que muestra el primer elemento del stack
     * @return primer elemento
     */
    @Override
    public T peek() {
        return miListaInterna.get(0);
    }

}
