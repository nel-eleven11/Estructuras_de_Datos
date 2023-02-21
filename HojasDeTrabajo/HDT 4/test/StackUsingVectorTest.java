import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingVectorTest {

    @Test
    void count() {
        StackUsingVector<Integer> miPila = new StackUsingVector<Integer>();
        miPila.push(1);
        miPila.push(2);
        assertEquals(2,miPila.count());
    }

    @Test
    void isEmpty() {
        StackUsingVector<Integer> miPila = new StackUsingVector<Integer>();
        assertEquals(true,miPila.isEmpty());
    }

    @Test
    void push() {
        StackUsingVector<Integer> miPila = new StackUsingVector<Integer>();
        miPila.push(1);
        miPila.push(2);
        assertEquals(2,miPila.count());


    }

    @Test
    void pull() {
        StackUsingVector<Integer> miPila = new StackUsingVector<Integer>();
        miPila.push(1);
        miPila.push(2);
        miPila.pull();
        assertEquals(1,miPila.count());
    }

    @Test
    void peek() {
        StackUsingVector<Integer> miPila = new StackUsingVector<Integer>();
        miPila.push(1);
        miPila.push(2);
        assertEquals(2,miPila.peek());
    }
}