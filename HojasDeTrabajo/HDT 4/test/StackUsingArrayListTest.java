import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingArrayListTest {

    @Test
    void count() {
        StackUsingArrayList<Integer> miPila = new StackUsingArrayList<Integer>();
        miPila.push(1);
        assertEquals(1,miPila.count());

    }

    @Test
    void isEmpty() {
        StackUsingArrayList<Integer> miPila = new StackUsingArrayList<Integer>();
        assertEquals(true,miPila.isEmpty());
    }

    @Test
    void push() {
        StackUsingArrayList<Integer> miPila = new StackUsingArrayList<Integer>();
        miPila.push(1);
        assertEquals(1,miPila.count());
    }

    @Test
    void pull() {
        StackUsingArrayList<Integer> miPila = new StackUsingArrayList<Integer>();
        miPila.push(1);
        miPila.push(2);
        miPila.pull();
        assertEquals(1,miPila.count());
    }

    @Test
    void peek() {
        StackUsingArrayList<Integer> miPila = new StackUsingArrayList<Integer>();
        miPila.push(1);
        miPila.push(2);
        assertEquals(2,miPila.peek());
    }
}