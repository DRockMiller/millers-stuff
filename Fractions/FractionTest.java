

/**
 * This unit test is used to check the Fraction class.
 *
 * by Mr. Miller
 * 11/7/2009
 */
public class FractionTest extends junit.framework.TestCase
{
    private Fraction fraction1 = new Fraction(6, 8);
    private Fraction fraction2 = new Fraction(1, 2);
    private Fraction fraction3 = new Fraction(5, 3);
    private Fraction fraction4 = new Fraction(6);
    private Fraction fraction5 = new Fraction(1,2,3);
    

    /**
     * Default constructor for test class FractionTest
     */
    public FractionTest()
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

    public void testConstructorTest1()
    {
        assertEquals("6/8",fraction1.toString());
        assertEquals("1/2",fraction2.toString());
        assertEquals("5/3",fraction3.toString());
    }
    
    public void testConstructorTest2()
    {
        assertEquals("6",fraction4.toString());
    }
    
    public void testConstructorTest3()
    {
        assertEquals("5/3",fraction5.toString());
    }
    
    public void testReduceTest()
    {
        assertEquals("3/4",fraction1.reduce().toString());
    }
    
    public void testProperFractionTest2()
    {
        assertEquals("1 1/4",fraction1.add(fraction2).toProper()); 
    }
    
    public void testMultiplicationTest()
    {
        assertEquals("3/8",fraction1.multiply(fraction2).toString());
    }
    
    public void testAdditionTest()
    {
        assertEquals("5/4",fraction1.add(fraction2).toString());
    }
    
    public void testEqualityTest1()
    {
        assertEquals(true,fraction1.equals(new Fraction(3,4)));
    }
    
    public void testEqualityTest2()
    {
        assertEquals(false,fraction1.equals(fraction2)); 
    }
}


