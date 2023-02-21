import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixToPostTest {

    @Test
    void convertidor() {
        FixToPost fixToPost = new FixToPost();
        String postFix = fixToPost.convertidor("( 1 + 2 ) * 9", 1);
        System.out.println(postFix);
        assertEquals("1 2 + 9 *",postFix);
        postFix = fixToPost.convertidor("1 + ( 2 * 3 )", 1);
        System.out.println(postFix);
        assertEquals("1 2 3 * +",postFix );
    }
}