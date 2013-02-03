 
/**
 * Class that represents Binary numbers and their operations. 
 * APCS related: Underlying implementation (int array in this example) should be able to be easily changed to ArrayList, LinkedList, String, ... 
 * The number of bits, REGISTER_SIZE, is also easily changed. 
 * Students will get practice with common "array" operations: traversing a list forwards & backwards, rotating elements, checking the values
 * of each element, changing the values in elements, throwing exceptions, string operations (substring & concatenation), (possibly) 
 * Integer.toString, boolean flags, and modulo '%'. 
 * <B><U>NON-APCS:</U></B> use of 'this' to call a particular constructor. <B><U>NOTES:</U></B>  Contains some typical student solutions and
 * some not so typical solutions.  For example: twosComplement and int2bin call each other (mutual recursion), but don't have to be written this way. 
 * 
 * @author Kyle Gillette
 * @version 4-2-02
 * 
 * Modifications by Derek Miller
 * 12-11-09
 */

public class Binary implements Bin
{   private int [] bit;                            // The underlying data structure that holds the bits. 
    private final static int REGISTER_SIZE = 8;   // Number of bits - some arbitrary size is necessary in order represent negative numbers.

    // Only the following need to be changed if the underlying implementation is changed.
    public int getBit(int nth) { return bit[nth]; }
    public void setBit(int nth, int value) { bit[nth] = value; }
    
    public Binary() { bit = new int [REGISTER_SIZE]; }    // The default constructor - called by all other constructors

    // This constructor takes a binary number as a parameter called anyBin
    // It then sets the current binary number (this) to the value of anyBin
    // The default constructor is called using this() before the values of the bit array are set
    public Binary( Binary anyBin )
    {   
        this();                                          
       // TODO: Fill bit with the binary values from anyBin
       // A for loop would be nice and the setBit method would be useful
    }

    // This constructor takes a decimal number as a parameter called number
    // It then sets the current binary number (this) to the binary value of number
    // The default constructor is called using this() before the values of the bit array are set
    public Binary( int number )
    {  
        this();
        // TODO: Fill bit with the binary version of number
        // You should write the int2bin method before attempting this constructor
    }
    
    // This constructor takes a String as a parameter called bitString
    // It then sets the current binary number (this) to the binary representation of the String
    // This is necessary because of the GUI we are using for the Java applet
    // The default constructor is called using this() before the values of the bit array are set 
    public Binary( String bitString )                   
    {  
        this(); 
        // TODO: Fill bit with the binary representation of bitString
        // All you need to do is determine if you should set each bit to a 0 or a 1
    } 
    
    // Converts the current binary number (this) to a String
    // You will need to convert each bit individually to do this...a loop sounds nice
    public String toString()                          
    {   
        return "";
    }

    // Converts the parameter, num, into a binary number
    // The value of this should not change since this method returns a NEW binary number
    public Binary int2bin( int num )         
    {   
        // TODO: Check if the number is negative first
        
        // TODO: After checking if the number is negative convert it to binary using a for loop, division, and modulus (%)
        
        // TODO: After converting use the following code to throw an exception if there is still a number left after all the division
        // If the number is negative return it using the twosComplement method
        // Otherwise simply return the number generated
        throw new IllegalArgumentException( "Number exceeds " + REGISTER_SIZE + " Bits." );
    }    
    
    // Converts the current binary number (this) to an integer
    public int bin2int()
    {   
        // TODO: Check if the number is negative by examining its first bit
        // If it is negative then take the Two's Complement of it to convert it to a positive
        // Convert the positive number to a decimal number
        // Return the positive or negative result
        
        return 1;
    }       
    
    // Find the opposite of every bit in the current binary number (this)
    // Do not actually change the value of this
    public Binary not()
    {   
        // TODO: Find the opposite of the current binary number
        // The absolute value can be helpful to easily find the opposite of a binary number
        
        return new Binary("0");
    }
    
    // Add the current binary number (this) to the value sent as rhs (right-hand side)
    // Do not actually change the value of this
    public Binary add( Binary rhs )
    {   
        // TODO: Add the bits of both numbers starting on the right
        // It would be helpful (if not essential) to have a variable to keep track of the carry
 
        return new Binary("0");
     }   
    
    // Find the Two's Complement of the current binary number (this)
    public Binary twosComplement()                                
    {   
        // TODO: The Two's Complement is found by finding the complement (not) of all bits and adding 1
        
        return new Binary("0");
    }            
    
    // Rotates all bits to the left of the current binary number (this) and adds a 0 on the right
    // Do not actually change the value of this
    // Used for binary multiplication by 2
    public Binary rotateLeft()
    {   
        // TODO: Shift all bits of this to the left
        // A temporary binary number is essential
        
        return new Binary("0");
    }    

    // Rotates all bits to the right of the current binary number (this) and adds a 0 on the left
    // Do not actually change the value of this
    // Used for binary division by 2
    public Binary rotateRight()                        
    {   
        // TODO: Shift all bits of this to the left
        // A temporary binary number is essential
        
        return new Binary("0");
    }        
}
