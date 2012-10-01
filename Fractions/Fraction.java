/**
 * Creates a fraction in proper form
 * 
 * by Mr. Miller
 * 11/7/2009
 * 
 * Updated
 * 11/13/2010
 */
public class Fraction
{
    // Fraction properties
    private int numer;
    private int denom;

    // accessors
    public int getNumerator() {return this.numer;}
    public int getDenominator() {return this.denom;}
    
    // Sets numer and denom given n and d as parameters
    public Fraction(int n, int d)
    {
       
    }

    // Sets numer and denom when only given whole number
    public Fraction(int n)
    {
        
    }
    
    // Sets numer and denom when given mixed fraction
    public Fraction(int whole, int n, int d)
    {
        
    }
    
    /**
     * A helper method that returns the current fraction as a String
     * 
     * Precondition: The numer and denom variables are set
     * Postcondition: A String in the form numer/denom is returned
     * 
     */
    public String toString()
    {
        if (this.denom != 1)
            return this.numer + "/" + this.denom;
        else
            return "" + this.numer;
    }
    
    /**
     * A helper method that converts the current fraction to proper form
     * Example: 5/3 should be returned as 1 2/3
     * Notice that there is a space between the whole number and the fraction
     * 
     * Precondition: The numer and denom variables are set
     * Postcondition: A String representing a fraction in proper form is returned
     * 
     */
    public String toProper()
    {
          return "0/0"; 
    }
    

    /**
     * A helper method that returns the greatest common factor of two integers
     * The method is static because is does not need to access anything in this class
     * 
     * Precondition: a and b are integers
     * Postcondition: An integer representing the gcf of a and b is returned
     *
     * @param  a   the first integer
     * @param  b   the second integer
     */
    private static int gcf(int a, int b)
    {
        if( a % b == 0 )
            return b;
        else 
            return gcf( b, a % b );
    }
    
    /**
     * A method to reduce a fracton
     * Example: 4/6 should become 2/3
     * The gcf method is helpful for this method
     * 
     * Precondition: The gcf method works correctly
     * Postcondition: A Fraction (not a String) is returned representing the reduced Fraction
     */
    public Fraction reduce()
    {
        return new Fraction(1);
    }
    
    /**
     * A method to multiply the current fraction by rhs (right-hand side)
     * 
     * Precondition: The current fraction and rhs are valid Fraction objects
     * Postcondition: A reduced Fraction (not a String) is returned 
     *          representing the product of the two fractions
     *
     * @param rhs   A Fraction object that will be multiplied by the current Fraction
     */
    public Fraction multiply(Fraction rhs)
    {
        return new Fraction(1);
    }
    
    /**
     * A method to add the current fraction to rhs (right-hand side)
     * 
     * Precondition: The current fraction and rhs are valid Fraction objects
     * Postcondition: A reduced Fraction (not a String) is returned 
     *          representing the sum of the two fractions
     *
     * @param rhs   A Fraction object that will be added to the current Fraction
     */
    public Fraction add(Fraction rhs)
    {
        return new Fraction(1);
    }
    
    /**
     * A method to determine if the current fraction is equal to rhs (right-hand side)
     * 
     * Precondition: The current fraction and rhs are valid Fraction objects
     * Postcondition: true is returned if the fractions are equal, even if they are not reduced
     *
     * @param rhs   A Fraction object that compared to the current Fraction
     */
    public boolean equals(Fraction rhs)
    {
        return false;
    }
}
