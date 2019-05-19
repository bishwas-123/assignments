import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.IArrayFlattener;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayReversorTestNull {
private ArrayReversor arrayReversor;
    // private IArrayFlattener arrayFlattener = mock(IArrayFlattener.class);

private IArrayFlattener arrayFlattener=mock(IArrayFlattener.class);

    @Before
    public void setUp() throws Exception {
        arrayReversor=new ArrayReversor(arrayFlattener);
    }

    @After
    public void tearDown() throws Exception {
        arrayReversor=null;
    }

    @Test
    public void reverseArray() {
        int[][] a_in=null;
        int[] actual=arrayReversor.reverseArray(a_in);
        int[]expected=null;
        when(arrayFlattener.flattenArray(a_in)).thenReturn(null);
        assertArrayEquals(expected,actual);
        verify(arrayFlattener).flattenArray(a_in);

    }
}