import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstJunitTest {
    private FirstJunit unit;
    @Before
    public void setUp() throws Exception {
        unit=new FirstJunit("bishwas");
    }

    @After
    public void tearDown() throws Exception {
        unit=null;

    }

    @Test
    public void getName() throws Exception {

        assertEquals(
                "bishwas",
                unit.getName()
        );



    }
}