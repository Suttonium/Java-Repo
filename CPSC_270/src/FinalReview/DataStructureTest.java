package FinalReview;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class DataStructureTest {
    private DataStructure bst;
    private DataStructure bst2;
    private DataStructure list;
    private DataStructure list2;

    @Before
    public void constructor() {
        bst = new DataStructure();
        bst.insert('b');
        bst.insert('a');
        bst.insert('c');
        bst2 = new DataStructure();
        list = new DataStructure();
        list.insertSorted('d');
        list.insertSorted('b');
        list.insertSorted('a');
        list2 = new DataStructure();
    }

    @Test
    public void testPreorder() {
        assertEquals("bac", bst.preorder());
    }

    @Test
    public void testNullPreorder() {
        assertEquals("", bst2.preorder());
    }

    @Test
    public void testInsertSorted() {
        list.insertSorted('c');
        assertEquals("abcd", list.toString());
    }

    @Test(expected = RuntimeException.class)
    public void testExceptionIsThrownForGet() {
        list2.get();
        assertNotNull(list2);
    }
}
