import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import service.IArrayFlattener;

import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayReversorTest {
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
        int[][] a_in= {{1,3}, {0}, {4,5,9}};
        when(arrayFlattener.flattenArray(a_in)).thenReturn(new int[] {1,3,0,1,4,9});
        int[] actual=arrayReversor.reverseArray(a_in);
                int[] expected=new int[]{9,4,1,0,3,1};
                assertArrayEquals(expected,actual);
                verify(arrayFlattener).flattenArray(a_in);



    }


}