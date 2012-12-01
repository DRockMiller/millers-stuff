
/**
 * Perform operations on integer matrices
 * Note that all methods are static, 
 * meaning you do not need to create an instance
 * 
 * @Derek Miller
 * @Modified 12/1/2012
 * 
 * Original Version by Brandon Horn
 */
public class TheMatrix
{   
    /**
     * Determines if the two matrix parameters can be added using matrix addition
     * 
     * Precondition:  none
     * Postcondition: true will be returned if matrix addition is allowed, false otherwise
     * 
     * @param  first   the first matrix to check
     * @param  second  the second matrix to check
     */
    public static boolean addable(int[][] first, int[][] second)
    {
        return true; // remove this
    }
    
    /**
     * Add the two matrix paramters using matrix addition
     * 
     * Precondition: addable(first, second) returns true
     * Postcondition: the resulting matrix of first + second
     * 
     * @param  first   the first matrix to add
     * @param  second  the second matrix to add
     * 
     * @throws IllegalArgumentException if the precondition is not met
     */
    public static int[][] add(int[][] first, int[][] second)
    {
        return null; // remove this
    }
    
    /**
     * Performs multiplication between an integer and a matrix
     * 
     * Precondition: the matrix is populated and the first row is populated
     * Postcondition: the resulting matrix of scalar * matrix
     * 
     * @param  scalar  the number to multiply by
     * @param  matrix  the matrix to multiply by the scalar
     * 
     * @throws IllegalArgumentException if the precondition is not met
     */
    public static int[][] multiplyByScalar(int scalar, int[][] matrix)
    {
        return null; // remove this
    }
    
    /**
     * Multiplies the specified row of the first matrix by the specified column of the second matrix
     * 
     * Precondition: the row and column are populated and the same length
     * Postcondition: the resulting matrix of multiplying the specified row and column
     * 
     * @param  first  the matrix that contains the specified row to multiply
     * @param  row    the row to multiply from the first matrix
     * @param  second the matrix that contains the specified column to multiply
     * @param  col    the column to multiply from the second matrix
     * 
     * @throws IllegalArgumentException if the precondition is not met
     */
    public static int multiply(int[][] first, int row, int[][] second, int col)
    {
        return 0; // remove this
    }
    
    /**
     * Determines if the first and second matrices can be multiplied
     * Two matrices can be multiplied if the number of columns in the first 
     * is the same as the number of rows in the second
     * 
     * Precondition:  none
     * Postcondition: true will be returned if the two matrices can be multiplied, false otherwise
     * 
     * @param  first  the first matrix to check
     * @param  second the second matrix to check
     */
    public static boolean multipliable(int[][] first, int[][] second)
    {
        return true; // remove this
    }
    
    /**
     * Multiplies the first matrix by the second matrix
     * 
     * Precondition: the first and second matrix are multipliable
     * Postcondition: the resulting matrix of the multiplication
     * 
     * @param  first  the first matrix to multiply
     * @param  second the second matrix to multiply
     * 
     * @throws IllegalArgumentException if the precondition is not met
     */
    public static int[][] multiply(int[][] first, int[][] second)
    {
        return null; // remove this
    }
    
    /**
     * A helper method to determine if a matrix is at least 1x1
     * 
     * Precondition:  none
     * Postcondition: returns true if the matrix is at least 1 row and 1 column, false otherwise
     * 
     * @param  matrix  the matrix to check
     */
    private static boolean atLeastOneByOne(int[][] matrix)
    {
        return matrix != null && matrix.length > 0 && matrix[0].length > 0;
    }
    
    /**
     * The print method is used so a matrix can be printed
     */
    public static void print(int[][] matrix)
    {
        for (int row = 0; row < matrix.length; row++)
            System.out.println(java.util.Arrays.toString(matrix[row]));
    }
    
    	public static void test()
	{
	int[][] first = new int[3][4];
    int[][] second = new int[4][2];

    int[][] correctAnswer = new int[][] {
        
    };
    
    int num = 20;

    for (int row = 0; row < first.length; row++)
      for (int col = 0; col < first[0].length; col++)
        first[row][col] = num++;

    for (int row = 0; row < second.length; row++)
      for (int col = 0; col < second[0].length; col++)
        second[row][col] = num++;
          TheMatrix.print(second);
	}
}
