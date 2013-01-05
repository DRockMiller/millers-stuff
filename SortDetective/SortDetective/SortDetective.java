/*
 * @(#)SortDetective.java  1.0  16 August 2001
 *
 * Copyright 2001
 * Department of Computer Science
 * Saint Bonaventure University
 * Saint Bonaventure, NY 14778
 *
 * This software may be used for educational purposes as long as
 * this copyright notice is retained intact at the top of all files.
 *
 * Should this software be modified, the words "Modified from 
 * Original" must be included as a comment below this notice.
 *
 * All publication rights are retained.  This software or its 
 * documentation may not be published in any media either in whole
 * or in part without explicit permission.
 *
 * Contact information:
 *   David Levine		dlevine@cs.sbu.edu
 * 
 * Telephone:          716-375-2598
 *
 * This software was created using the Java Power Tools package
 * from Northeastern University.  
 * 
 * Modified by Derek Miller
 */

import edu.neu.ccs.*;
import edu.neu.ccs.gui.*;
import edu.neu.ccs.util.*;
import edu.neu.ccs.filter.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.io.*;
import javax.swing.*;

/** A program for exploring sorting algorithms
 * A series of sorting algorithms can be executed using a GUI
 * The initial data configuration and summary statistics are
 * also controled through this GUI.  In its pure form, seven
 * sorting algorithms are provided and the button labels are 
 * cryptic.  The idea is for the student to devise a set of
 * experiments to determine which button controls which algorithm.
 *
 * @author  David Levine 
 * @version 16 August 2001
 */

public class SortDetective extends DisplayPanel
    implements JPTConstants {

    
    /////////////////
    // Static Data //
    /////////////////
    
    // Slider constants 
    
    private static final int 	LOG_MIN_SIZE100 = 401;
    private static final int 	LOG_MAX_SIZE100 = 2000;
    private static final int 	LOG_DEFAULT_SIZE100 = 500;
    private static final String DEFAULT_SIZE = "32";
    private static final int 	MIN_SIZE = 16;
    private static final int 	MAX_SIZE = 1048576;
  
  	// Order property constants
  	
    private static final int 	IN_ORDER = 0;
    private static final int 	REVERSE_ORDER = 1;
    private static final int 	ALMOST_ORDER = 2;
    private static final int 	RANDOM_ORDER = 3;
    private static final int 	DEFAULT_ORDER = RANDOM_ORDER;
    private static final double DISORDER_FRACTION = 0.05;

 
    public static final String[] Orderings =
    		{ "InOrder", "ReverseOrder", "AlmostOrder", "Random" };
    		  
    
    ////////////////////////////////
    //  List Construction section //
    ////////////////////////////////
    
    
    // List type
    private OptionsView orderOptionsView =
    	new OptionsView
    		(Orderings, DEFAULT_ORDER, new GridLayout(2,2));


  	// List size
 	
	private SliderView listSizeSlider = new 
			SliderView(SwingConstants.HORIZONTAL, LOG_MIN_SIZE100, LOG_MAX_SIZE100, LOG_DEFAULT_SIZE100);
			

	// List text field  
    private TextFieldView sizeTFV =
        new TextFieldView(
            DEFAULT_SIZE,                     // initial value displayed in the TFV
            "Size must be between "+MIN_SIZE+" and "+ MAX_SIZE+":",  	  // prompt for correcting the input
            "Incorrect input");         	  // title for the error dialog box

    private RangeFilter.Long sizeRangeFilter = new RangeFilter.Long(MIN_SIZE,true,MAX_SIZE,true);
    
     // Create list button
    private SimpleAction createList = 
        new SimpleAction("Create The List") {
           public void perform(){ makeNewList(); }
        };
 
   private ActionsPanel listActions = 
    	new ActionsPanel(new Action[] {createList}, new GridLayout(1,0));
     
    private DisplayCollection sizes = 
    	new DisplayCollection( new Displayable[] { listSizeSlider, sizeTFV }, HORIZONTAL);
    	
    private DisplayCollection listSection =
    	new DisplayCollection( new Displayable[] { orderOptionsView, sizes, listActions }, VERTICAL);
    	
    private Display listSectionDisplay =
    	new Display(listSection, null, "List Properties");
    	
    int[] 	theList;  // The actual list of data!!!
    int		listType; // The type of list that was created
   
    //////////////////////////////
    //  Output Display section  //
    //////////////////////////////
  
    // these TextFieldViews will only be used to display the output of sort experiments
    private TextFieldView listSizeTFV =
        new TextFieldView("");
  
    private TextFieldView listTypeTFV =
       new TextFieldView("");

    private TextFieldView buttonTFV =
       new TextFieldView("");

    private TextFieldView comparisonsTFV =
       new TextFieldView("");

    private TextFieldView movementsTFV =
       new TextFieldView("");

    private TextFieldView timeTFV =
       new TextFieldView("");

   // array of wrapped text field views
    private Displayable[] outputList = {
    	new DisplayWrapper(new Display(listSizeTFV, "                      N:", null)),
	   	new DisplayWrapper(new Display(listTypeTFV, "       DataType:", null)),
 	   	new DisplayWrapper(new Display(buttonTFV, "                 Sort:", null)),
	  	new DisplayWrapper(new Display(comparisonsTFV, "Comparisons:", null)),
  		new DisplayWrapper(new Display(movementsTFV, "    Movements:", null)),
  		new DisplayWrapper(new Display(timeTFV, "       Total time:", null))
  	};
    		
    
    // collection of the text field views for the GUI
    private DisplayCollection dataFields = new DisplayCollection(outputList);
    
    private Display dataFieldsDisplay =
    	new Display(dataFields, null, "Experimental Results");

	private DisplayCollection rightSide = 
		new DisplayCollection( new Displayable[] {listSectionDisplay, dataFieldsDisplay}, VERTICAL);
		
    /////////////////////
    // Sorting Actions //
    /////////////////////    
	
	private static final String[] buttonNames = 
			{ "Alpha", "Beta", "Gamma", "Delta"};
	
	private Action[] sorts = new Action[]
	{
		new SimpleAction(buttonNames[0]) {
	           public void perform(){ runExperiment(SortingExperiment.selectionSort,buttonNames[0]); } },
	           
		new SimpleAction(buttonNames[1]) {
	           public void perform(){ runExperiment(SortingExperiment.insertionSort, buttonNames[1]); } },

 		new SimpleAction(buttonNames[2]) {
	           public void perform(){ runExperiment(SortingExperiment.quickSort, buttonNames[2]);  } },
	           
		new SimpleAction(buttonNames[3]) {
	           public void perform(){ runExperiment(SortingExperiment.mergeSort, buttonNames[3]);  } }
	 };
	 
	           
    // sortActions panel

    private ActionsPanel sortActions = 
    	new ActionsPanel(sorts, new GridLayout(sorts.length,0));


    private Display sortsDisplay =
    	new Display(sortActions, null, "Which Sort Is Which?");

      

    //////////////////        
    // Main Program //
    //////////////////
        
    /* 
     * Standard JPT main function
     */
     
    public static void main(String[] args) {
        
        JPTFrame.createQuickJPTFrame("Sort Detective", new SortDetective());            
    }
    
    
    /////////////////
    // Constructor //
    /////////////////
    
    public SortDetective() {
    

        // add components to layout
        setLayout(new BorderLayout());
        add(rightSide, BorderLayout.EAST);
        add(sortsDisplay, BorderLayout.WEST);
        
        
        // Adjust size of various components \    
	    sortsDisplay.setPreferredSize( new Dimension(200,200) );       
        sizeTFV.setPreferredWidth(60);
        listSizeTFV.setPreferredWidth(150);
        listTypeTFV.setPreferredWidth(150);
        buttonTFV.setPreferredWidth(150);
        comparisonsTFV.setPreferredWidth(150);
        movementsTFV.setPreferredWidth(150);
        timeTFV.setPreferredWidth(150);
        
        // Set actions for various components
        
        listSizeSlider.addSlidingAction( new SimpleAction() {
	           public void perform(){ setListWindowFromSlider(); } } );

        sizeTFV.addActionListener( new SimpleAction() {
	          public void perform(){ setSliderFromListWindow(); } } );	
     
        // Start with a valid list
     	
     	makeNewList();
    }
    
    
    /////////////////////////////
    // Sort Action Definitions //
    /////////////////////////////  

	public void runExperiment(SortingExperiment se, String sortName)
	{
		// Clone the list so that we can run multiple sorts on the same data
		int listCopy[] = new int[theList.length];
		for (int i=0; i<theList.length; i++)
		{
			listCopy[i] = theList[i];
		}	
		
		// Run the experiment
		se.performExperiment(listCopy);
		
		// Validate the sort
		if (! isSorted(listCopy) )
		{
			System.out.println("Sort FAILED");
		  	if (listCopy.length<33)
		    	{
		    		for (int i=0; i<listCopy.length; i++)
		    		{
		    			System.out.print(" "+listCopy[i]);
		    		}
		    		System.out.println("");
		 		}
		}
		
		// And print the results
		
		buttonTFV.setViewState(sortName);
		comparisonsTFV.setViewState(""+se.getComparisons());
		movementsTFV.setViewState(""+se.getMovements());
		timeTFV.setViewState(""+se.getTime());
	}
   
   	/*
   	 * isSorted returns true iff the array list is in monotonically 
   	 * (but not strictly) increasing order
   	 *
   	 */
   	private boolean isSorted(int list[])
   	{
   		for (int i=0; i<list.length-1; i++)
   		{
   			if (list[i] > list[i+1])
   			{
   				System.out.println("List failed to be sorted at position " + i);
   				return false;
   			}
   		}
   		return true;
   	}
    ///////////////////////////////////
    // GUI Manipulation Definitions  //
    ///////////////////////////////////

	/*
	 * makeNewList creates a new list to be sorted based upon the
	 * settings of the GUI widgets
	 *
	 */
    public void makeNewList() {
    	
    	setSliderFromListWindow();		// In case the user typed a size, but didn't hit return

    	int size = sizeTFV.demandInt(sizeRangeFilter);
    	theList = new int[size];
    	
    	listType = orderOptionsView.getSelectedIndex();
    	switch(listType) {
    		case IN_ORDER:
    			for (int i=0; i<theList.length; i++)
    			{
    				theList[i] = i;
    			}
    			break;
    		case REVERSE_ORDER:
    			for (int i=0; i<theList.length; i++)
    			{
    				theList[i] = theList.length-1-i;
    			}
    			break;
    		case ALMOST_ORDER:
    			// Start with in-order list and perform a small number of swaps
      			for (int i=0; i<theList.length; i++)
    			{
    				theList[i] = i;
    			}
     			for (int j=0; j<theList.length*DISORDER_FRACTION; j++)
    			{
    				int randomIndex1 = (int) (Math.random()*theList.length);
    				int randomIndex2 = (int) (Math.random()*theList.length);
    				int temp = theList[randomIndex1];
    				theList[randomIndex1] = theList[randomIndex2];
    				theList[randomIndex2] = temp;
    			}
   				break;
     		case RANDOM_ORDER:
     			// Start with in-order list and do a standard shuffle
      			for (int i=0; i<theList.length; i++)
    			{
    				theList[i] = i;
    			}
    			for (int j=theList.length-1; j>0; j--)
    			{
    				int randomIndex = (int) (Math.random()*j);
    				int temp = theList[j];
    				theList[j] = theList[randomIndex];
    				theList[randomIndex] = temp;
    			}
    			break;
    		
    	}
    	
    	listSizeTFV.setViewState(""+theList.length);
    	listTypeTFV.setViewState(Orderings[listType]);
 		comparisonsTFV.setViewState("");
		movementsTFV.setViewState("");
		timeTFV.setViewState("");
   	
    	// Debugging Code...
    	
    	if (theList.length<33)
    	{
    		for (int i=0; i<theList.length; i++)
    		{
    			System.out.print(" "+theList[i]);
    		}
    		System.out.println("");
 		}
   		
    }
    
   /*
    *
    * Slider manipulation actions
    * 	
    * The slider is logarithmic, not linear.  A slider value of N represents
    * a list size of 2^(N/100)  These functions simply synchronize the list
    * size slider and the associated text view according to that equivalence
    *
    */ 
 	public void setListWindowFromSlider() {
 		double sliderValue = listSizeSlider.getValue()/100.0;
 		int listSize = (int) Math.exp( sliderValue* Math.log(2) );
 		
 		sizeTFV.setViewState(""+listSize);
 	} 
 	
 	public void setSliderFromListWindow() {	
 		int listSize = sizeTFV.demandInt(sizeRangeFilter);
 		int sliderValue = (int) (100*Math.log(listSize)/Math.log(2));
 		
 		listSizeSlider.setValue(sliderValue);
 	}
 
}