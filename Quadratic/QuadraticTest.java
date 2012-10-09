/**
 * This unit test is used to check the Quadratic class.
 *
 * by Mr. Miller
 * 11/27/2009
 */
public class QuadraticTest extends junit.framework.TestCase
{
   
    public QuadraticTest()
    {
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
    
    public void testNoReal1()
    {
        assertEquals("No real solutions", Quadratic.quad(2,3,4));
    }
    
    public void testNoReal2()
    {
        assertEquals("No real solutions", Quadratic.quad(1,0,1)); 
    }
    
    public void testNoReal3()
    {
        assertEquals("No real solutions", Quadratic.quad(1,1,2)); 
    }
    
    public void testOneSolution1()
    {
        assertEquals("-1.41", Quadratic.quad(.5,Math.sqrt(2),1)); 
    }
    
    public void testOneSolution2()
    {
        assertEquals("1.33", Quadratic.quad(9,-24,16)); 
    }
    
    public void testOneSolution3()
    {
        assertEquals("1.0", Quadratic.quad(1,-2,1)); 
    }
    
    public void testTwoSolutions1()
    {
        assertEquals("-1.5,2.0", Quadratic.quad(2,-1,-6)); 
    }
    
    public void testTwoSolutions2()
    {
        assertEquals("-2.73,0.73", Quadratic.quad(1,2,-2)); 
    }
    
    public void testTwoSolutions3()
    {
        assertEquals("-1.81,-0.18", Quadratic.quad(3,6,1)); 
    }
}
