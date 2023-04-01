import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class filesTest {


    @Test
    void importFile() {
        files.importFile();
        ArrayList<ArrayList<String>> items = files.getItems();
        assertEquals("vi", items.get(0).get(0));
        assertEquals("juan02", items.get(0).get(1));
        assertEquals("0", items.get(0).get(2));
        assertEquals("120", items.get(0).get(3));
    }
}