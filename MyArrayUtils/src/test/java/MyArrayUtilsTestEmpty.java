import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayUtilsTestEmpty {
    private MyArrayUtils myArrayUtils;

    @Before
    public void setUp() throws Exception {
        myArrayUtils=new MyArrayUtils();
    }

    @After
    public void tearDown() throws Exception {
        myArrayUtils=null;
    }

    @Test
    public void hasMultipleMaximum() {
        int[] inputArr={};
        boolean actual =myArrayUtils.hasMultipleMaximum(inputArr);
        assertFalse(actual);
    }

}