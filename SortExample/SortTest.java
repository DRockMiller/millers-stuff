import java.util.ArrayList;

/**
 * Unit tests for the Sort class
 *
 * @Mr. Miller
 * @11/1/2010
 */
public class SortTest extends junit.framework.TestCase
{
    private Sort sort1;
    private ArrayList<Integer> test1 = new ArrayList<Integer>();
    private ArrayList<Integer> test2 = new ArrayList<Integer>();
    private ArrayList<Integer> test3 = new ArrayList<Integer>();
    private ArrayList<Integer> test4 = new ArrayList<Integer>();
    private ArrayList<Integer> test5 = new ArrayList<Integer>();
    private ArrayList<Integer> test6 = new ArrayList<Integer>();
    private ArrayList<Integer> test7 = new ArrayList<Integer>();
    private ArrayList<Integer> test8 = new ArrayList<Integer>();

    /**
     * Populate all of the test lists
     */
    public SortTest()
    {
        test1.add(1);
        test1.add(2);
        test1.add(5);
        test1.add(9);
        
        test2.add(2);
        test2.add(4);
        test2.add(5);
        test2.add(9);
        
        test3.add(2);
        test3.add(5);
        test3.add(7);
        test3.add(9);
        
        test4.add(2);
        test4.add(5);
        test4.add(9);
        test4.add(10);
        
        test5.add(2);
        test5.add(2);
        test5.add(5);
        test5.add(9);
        
        test6.add(2);
        test6.add(5);
        test6.add(5);
        test6.add(9);
        
        test7.add(2);
        test7.add(5);
        test7.add(9);
        test7.add(9);
        
        test8.add(-5);
        test8.add(2);
        test8.add(5);
        test8.add(9);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }
    
    public void testSortClass()
    {
        sort1 = new Sort();
        assertEquals(test1, sort1.addNumber(1));
        
        sort1 = new Sort();
        assertEquals(test2, sort1.addNumber(4));
        
        sort1 = new Sort();
        assertEquals(test3, sort1.addNumber(7));
        
        sort1 = new Sort();
        assertEquals(test4, sort1.addNumber(10));
        
        sort1 = new Sort();
        assertEquals(test5, sort1.addNumber(2));
        
        sort1 = new Sort();
        assertEquals(test6, sort1.addNumber(5));
        
        sort1 = new Sort();
        assertEquals(test7, sort1.addNumber(9));
        
        sort1 = new Sort();
        assertEquals(test8, sort1.addNumber(-5));
    }
}
