import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixToPostTest {

    @Test
    void convertidor() {
        FixToPost fixToPost = new FixToPost();
        String postFix = fixToPost.convertidor("1+2", 1);
        assertEquals(postFix, "12+");
        postFix = fixToPost.convertidor("1+2*3", 1);
        assertEquals(postFix, "123*+");
    }
}