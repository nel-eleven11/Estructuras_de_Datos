
/*
Nelson García Bravatti
22434
HDT 4
Clase Factory, se encarga de crear las pilas
 */

import java.util.ArrayList;
import java.util.Vector;

public class Factory<T>{

   private IStack<T> stack = null;

    
    /**
     * getStack, crea la pila dependiendo del tipo, 1 = ArrayList, 2 = Vector, 3 = LinkedList, 4 = DoubleLinkedList.
     * @param tipo
     * @return IStack<T>
     */
    public IStack<T> getStack(int tipo){
        switch (tipo){
            case 1:
                return new StackUsingArrayList<T>();
            case 2:
                return new StackUsingVector<T>();
            case 3:
                return new StackUsingLinkedList<T>();
            case 4:
                return new StackUsingDoubleLinkedList<T>();
            default:
                return null;
        }
    }

}
