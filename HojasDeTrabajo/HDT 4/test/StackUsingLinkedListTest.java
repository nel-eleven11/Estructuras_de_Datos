import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingLinkedListTest {

    @Test
    void count() {
        StackUsingLinkedList<Integer> miPila = new StackUsingLinkedList<Integer>();
        miPila.push(1);
        miPila.push(2);
        assertEquals(2,miPila.count());

    }

    @Test
    void isEmpty() {
        StackUsingLinkedList<Integer> miPila = new StackUsingLinkedList<Integer>();
        assertTrue(miPila.isEmpty());
    }

    @Test
    void push() {
        StackUsingLinkedList<Integer> miPila = new StackUsingLinkedList<Integer>();
        miPila.push(1);
        miPila.push(2);
        assertEquals(2,miPila.count());
    }

    @Test
    void pull() {
        StackUsingLinkedList<Integer> miPila = new StackUsingLinkedList<Integer>();
        miPila.push(1);
        miPila.push(2);
        miPila.pull();
        assertEquals(1,miPila.count());
    }

    @Test
    void peek() {
        StackUsingLinkedList<Integer> miPila = new StackUsingLinkedList<Integer>();
        miPila.push(1);
        miPila.push(2);
        assertEquals(2,miPila.peek());
    }
}