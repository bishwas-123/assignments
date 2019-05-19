import static org.junit.Assert.*;

public class ArrayFlattenerTest {
    private ArrayFlattener arrayFlattener;

    @org.junit.Before
    public void setUp() throws Exception {
        arrayFlattener=new ArrayFlattener();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        arrayFlattener=null;
    }

    @org.junit.Test
    public void flatterArrayTest() {
        int[][] a_in=null;
        Integer[] actual=arrayFlattener.flatterArray(a_in);
        Integer[] expected=null;
       assertArrayEquals(expected,actual);

    }
}