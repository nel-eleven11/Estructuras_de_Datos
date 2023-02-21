import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    void getStack() {
        Factory<Integer> factory = new Factory<>();
        IStack<Integer> stack = factory.getStack(1);
        assertEquals(stack.getClass(), StackUsingArrayList.class);
        stack = factory.getStack(2);
        assertEquals(stack.getClass(), StackUsingArrayList.class);
        stack = factory.getStack(3);
        assertEquals(stack.getClass(), StackUsingArrayList.class);
        stack = factory.getStack(4);
        assertEquals(stack.getClass(), StackUsingArrayList.class);


    }
}