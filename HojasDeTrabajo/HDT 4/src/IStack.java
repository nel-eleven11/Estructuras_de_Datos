/*
Nelson García Bravatti
22434
HDT 4

Obtenida del repositorio de Moises

 */

public interface IStack<T> {

    int count();

    boolean isEmpty();

    void push(T value);

    T pull();

    T peek();

}
