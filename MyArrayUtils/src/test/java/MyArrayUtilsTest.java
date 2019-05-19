import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayUtilsTest {
    private MyArrayUtils myArrayUtils;

    @Before
    public void setUp() throws Exception {
        myArrayUtils=new MyArrayUtils();
    }

    @Test
    public void hasMultipleMaximum() {
        int[] arr_in=new int[]{-6, 2, 5, 6, -6, 5, 6};
        boolean actual=myArrayUtils.hasMultipleMaximum(arr_in);
        assertTrue(actual);
    }
}