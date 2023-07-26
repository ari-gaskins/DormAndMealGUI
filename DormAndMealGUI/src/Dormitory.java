/*******************************************************************************
'Project: Java GUI Assignment 01
'Programmer: Ari Gaskins
'Company Info:  arigaskins.work@gmail.com 
'Date: 24 07 2023
'Description:  Problem Number 01.  
'    
'   Application which gives user option to choose their dormitory hall and 
'   their meal plan. Input taken through event listeners. Output shows the
'   calculated totalCost of the dormitory and meal plan.
'
'
'  LINE LENGTH - AVOID LINES LONGER THAN 80 CHARACTERS
'  SCALE BELOW IS TO CALIBRATE SCREENSHOTS
'  DO NOT HAVE YOUR CODE OR SCREENSHOT EXTEND BEYOND THE SCALE
0........1.........2.........3.........4.........5.........6.........7.........8
12345678901234567890123456789012345678901234567890123456789012345678901234567890
*/

/**
 * A class representing the dormitory hall and its costs.
 * Each dormitory name is associated with a corresponding cost per semester. 
 * User selects their option in main.
 * @author Ari Gaskins
 * @version 1.0
 */
public class Dormitory {
	// array of the dormitory names 
	private String[] dormNames = {"None","Allen Hall", "Pike Hall", "Farthing Hall", 
			"University Suites"};
	
	// array of the dormitory costs (aligned with dormNames)
	private double[] roomCosts = {0.0, 1500.0, 1600.0, 1200.0, 1800.0};
	
	// user dormitory selection name
	private String dormSelection;
	
	// user dormitory selection cost
	private double roomCostSelection;
	
	/**
	 * Default constructor initializing dormitory name and room 
	 * cost to their first values.
	 */
	public Dormitory() {
		dormSelection = dormNames[0];
		roomCostSelection = roomCosts[0];
	}
	
	/**
	 * Constructor setting the dormitory name and room cost based on returned
	 * index from selection.
	 * @paramuserSelection index returned by user's selection
	 */
	public Dormitory(int userSelection) {
		dormSelection = dormNames[userSelection];
		roomCostSelection = roomCosts[userSelection];
	}
	
	/**
	 * Sets the dormitory name and room cost based on returned index from
	 * selection.
	 * @paramuserSelection index returned by user's selection
	 */
	public void setDormAndRoom(int userSelection) {
		dormSelection = dormNames[userSelection];
		roomCostSelection = roomCosts[userSelection];
	}
	
	/**
	 * Returns list of dormitories Spinner model.
	 * @return dormNames String array of dormitory names
	 */
	public String[] getDormNameList() {
		return dormNames;
	}
	
	/**
	 * Returns dormitory name selected.
	 * @return dormSelection String name of dormitory
	 */
	public String getDormName() {
		return dormSelection;
	}
	
	/**
	 * Returns cost of selected dormitory
	 * @return roomCostSelection double cost of selected dormitory
	 */
	public double getRoomCost() {
		return roomCostSelection;
	}
	
}