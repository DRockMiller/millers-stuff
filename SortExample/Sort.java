import java.util.ArrayList;

/**
 * This class adds a number to a list and sorts it
 * 
 * @Mr. Miller
 * @11/1/2010
 */
public class Sort
{
    // ArrayList to store values
    private ArrayList<Integer> values = new ArrayList<Integer>();

    /**
     * Constructor to initialize the list
     */
    public Sort()
    {
        values.add(2);
        values.add(5);
        values.add(9);
    }

    /**
     * A helper method used to sort the list
     * 
     * Precondition: The list contains values to sort
     * Postcondition: The list is sorted from smallest to largest
     * 
     */
    private void sortList()
    {
        // Uses selection sort to sort values
        int maxPos, max;
        
        for (int i=0; i<values.size()-1; i++)
        {
            max = values.get(i);
            maxPos = i;
            for (int j=i+1; j<values.size(); j++)
            {
                if (max >= values.get(j))
                {
                    max = values.get(j);
                    maxPos = j;
                }
            }
            
            swap(i, maxPos);
        }
    }
    
    /**
     * A helper method used to swap list values
     * 
     * Precondition: i and j are positions within the list
     * Postcondition: The values at i and j are swapped within the list
     * 
     * @param  i   the position of the 1st value to swap
     * @param  j   the position of the 2nd value to swap
     */
    private void swap(int i, int j)
    {
        int temp = values.get(i);
        values.set(i,values.get(j));
        values.set(j,temp);
    }
    
    /**
     * Method to return the values in the list
     * 
     * Precondition: The list contains values
     * Postcondition: The list is returned
     * 
     * @return      the full ArrayList is returned
     */
    public ArrayList<Integer> showList()
    {
        return values;
    }
    
    /**
     * Method to add a number to the list
     * The list is sorted after the number is added
     * 
     * Precondition: num is an integer
     * Postcondition: num is added to the list and the list is sorted
     * 
     * @param  num   the number to add to the list
     * @return       the full ArrayList is returned
     */
    public ArrayList<Integer> addNumber(int num)
    {
        values.add(num);
        sortList();
        return showList();
    }
}
