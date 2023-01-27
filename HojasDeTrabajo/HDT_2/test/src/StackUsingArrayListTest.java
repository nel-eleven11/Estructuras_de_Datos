package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingArrayListTest {

    StackUsingArrayList<Integer> miPila = new StackUsingArrayList<Integer>();

    @Test
    void count() {

        miPila.count();
        assertEquals(0, miPila.count());

    }

    @Test
    void isEmpty() {

        miPila.isEmpty();
        assertEquals(true, miPila.isEmpty());
    }

    @Test
    void push() {

        miPila.push(1);
        assertEquals(1, miPila.count());
    }

    @Test
    void pull() {

            miPila.push(1);
            miPila.pull();
            assertEquals(0, miPila.count());
    }

    @Test
    void peek() {

        miPila.push(1);
        miPila.peek();
        assertEquals(1, miPila.peek());
    }
}