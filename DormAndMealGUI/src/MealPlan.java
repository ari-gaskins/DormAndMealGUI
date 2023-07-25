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
 * A class representing the meal plan and its cost. Each meal plan is 
 * associated with a corresponding cost per semester. User selects their
 * option in main.
 * @author Ari Gaskins
 * @version 1.0
 */
public class MealPlan {
	// array of meal plan options
	private String[] mealPlans = {"None","7 meals per week", "14 meals per week",
			"Unlimited meals"};
	
	// array of meal plan options' costs
	private double[] mealPlanCosts = {0.0, 560.0, 1095.0, 5150.0};
	
	// user meal plan selection string
	private String mealPlanSelection;
	
	// user meal plan selection cost
	private double mealCostSelection;
	
	/**
	 * Default constructor initializing mealPlanSelection and mealCostSelection
	 * to their first values.
	 */
	public MealPlan() {
		mealPlanSelection = mealPlans[0];
		mealCostSelection = mealPlanCosts[0];
	}
	
	/**
	 * Constructor initializing meal plan selection and cost based on index
	 * selected by user
	 * @paramuserSelection index returned by selection
	 */
	public MealPlan(int userSelection) {
		mealPlanSelection = mealPlans[userSelection];
		mealCostSelection = mealPlanCosts[userSelection];
	}
	
	
	/**
	 * Return list of meal plans for Spinner model.
	 * @return mealPlans String array of meal plan options
	 */
	public String[] getMealPlanList() {
		return mealPlans;
	}
	
	/**
	 * Return meal plan string.
	 * @return mealPlanSelection String description of meal plan
	 */
	public String getMealPlan() {
		return mealPlanSelection;
	}
	
	/**
	 * Return meal plan cost.
	 * @return mealCostSelection double cost of meal plan
	 */
	public double getMealPlanCost() {
		return mealCostSelection;
	}
}
