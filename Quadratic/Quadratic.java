/**
 * Solves a quadratic equation for x
 * 
 * by Mr. Miller
 * 11/27/2009
 */
public class Quadratic
{
    // Truncates a number (num) to the number of places specified by the places parameter
    // This method does not round to the nearest number
    public static double round(double num, int places)
    {
        int temp = (int)((num*Math.pow(10,places)));
        return (((double)temp)/Math.pow(10,places));
    }
    
    // low and high are the lowest and highest possible values of a, b, and c
    // This method should call the quad function once a, b, and c are calculated
    // The output should look like the following (Note the line breaks):
    // a=2.0
    // b=3.0
    // c=4.0
    // x=No real solutions
    // The output should be sent to the console using System.out.println
    // There are no unit test for this method because it is random
    public static void randomQuad(int low, int high)
    {

    }
    
    // This method returns the value(s) of x given a, b, and c
    // The discriminant should be calculated first
    // If there are no real solutions the method should return "No real solutions"
    // If there is one solution the method should simply return that solution
    // If there are two solutions the method should return them, in order, with a comma between them but no space
    public static String quad(double a, double b, double c)
    {

    }
}
