import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TheMatrixTest
{
    /**
     * Default constructor for test class TheMatrixTest
     */
    public TheMatrixTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testSum()
    {
        int[][] first = new int[2][5];
        int[][] second = new int[2][5];
        
        int[][] correctAnswer = new int[][] {
            {12, 14, 16, 18, 20},
            {22, 24, 26, 28, 30}
        };
        
        int num = 0;

        for (int row = 0; row < first.length; row++)
          for (int col = 0; col < first[0].length; col++)
          {
            first[row][col] = ++num;
            second[row][col] = num + 10;
          }
          
        assertEquals(correctAnswer, TheMatrix.add(first,second));
    }
    
    @Test
    public void testScalarMultiplication()
    {
        int[][] matrix = new int[2][5];
        int scalar = 2;
        
        int[][] correctAnswer = new int[][] {
            {2, 4, 6, 8, 10},
            {12, 14, 16, 18, 20}
        };

        int num = 0;

        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[0].length; col++)
                matrix[row][col] = ++num;
          
        assertEquals(correctAnswer, TheMatrix.multiplyByScalar(scalar,matrix));
    }
    
    @Test
    public void testRowColumnMultiplication()
    {
        int[][] first = new int[3][4];
        int[][] second = new int[4][2];
        
        int correctAnswer = 3020;

        int num = 20;

        for (int row = 0; row < first.length; row++)
            for (int col = 0; col < first[0].length; col++)
                first[row][col] = num++;

        for (int row = 0; row < second.length; row++)
            for (int col = 0; col < second[0].length; col++)
                second[row][col] = num++;
          
        assertEquals(correctAnswer, TheMatrix.multiply(first,1,second,1));
    }

    @Test
    public void testMultiplication()
    {
        int[][] first = new int[3][4];
        int[][] second = new int[4][2];

        int[][] correctAnswer = new int[][] {
            {3020, 3106},
            {3580, 3682},
            {4140, 4258}
        };
    
        int num = 20;

        for (int row = 0; row < first.length; row++)
            for (int col = 0; col < first[0].length; col++)
                first[row][col] = num++;

        for (int row = 0; row < second.length; row++)
            for (int col = 0; col < second[0].length; col++)
                second[row][col] = num++;
          
        assertEquals(correctAnswer, TheMatrix.multiply(first,second));
    }
}

