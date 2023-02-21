import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingDoubleLinkedListTest {

    @Test
    void count() {
        StackUsingDoubleLinkedList<Integer> miPila = new StackUsingDoubleLinkedList<Integer>();
        miPila.push(1);
        miPila.push(2);
        assertEquals(2,miPila.count());
    }

    @Test
    void isEmpty() {
        StackUsingDoubleLinkedList<Integer> miPila = new StackUsingDoubleLinkedList<Integer>();
        assertEquals(true,miPila.isEmpty());

    }

    @Test
    void push() {
        StackUsingDoubleLinkedList<Integer> miPila = new StackUsingDoubleLinkedList<Integer>();
        miPila.push(1);
        miPila.push(2);
        assertEquals(2,miPila.count());
    }

    @Test
    void pull() {
        StackUsingDoubleLinkedList<Integer> miPila = new StackUsingDoubleLinkedList<Integer>();
        miPila.push(1);
        miPila.push(2);
        miPila.pull();
        assertEquals(1,miPila.count());
    }

    @Test
    void peek() {
        StackUsingDoubleLinkedList<Integer> miPila = new StackUsingDoubleLinkedList<Integer>();
        miPila.push(1);
        miPila.push(2);
        assertEquals(2,miPila.peek());
    }
}