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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class DormAndMealGUI extends JFrame implements ActionListener, 
ChangeListener{
	private static final long serialVersionUID = 1L;

	// allows user to choose dormitory
	private JSpinner dormSpinner;
	
	// allows user to choose meal plan
	private JSpinner mealSpinner;
	
	// label for dormitory spinner
	private JLabel dormLabel;
	
	// label for meal plan spinner
	private JLabel mealLabel;
	
	// label for total cost text field
	private JLabel totalCostLabel;
	
	// display total cost of dormitory and meal plan per semester
	private JTextField totalCostField;
	
	// cost of dormitory and meal plan per semester
	private double totalCost = 0.0;
	
	// Dormitory object to get dormitory information
	private Dormitory dormObj;
	
	// Meal Plan object to get meal plan information
	private MealPlan mealPlanObj;
	
	/**
	 * Constructor that creates GUI components and adds them
	 * using a GridBagLayout. 
	 */
	DormAndMealGUI() {
		// specifies GUI component layout
		GridBagConstraints layoutConstraints = null;
		
		// specifies list type values to be displayed in dormitory spinner
		SpinnerListModel dormListModel = null;
		
		// specifies list type values to be displayed in meal plan spinner
		SpinnerListModel mealListModel = null;
		
		// set frame title
		setTitle("Cost of Dormitory and Meal Plan per Semester");
		
		// initialize labels
		dormLabel = new JLabel("Dormitory Options:");
		mealLabel = new JLabel("Meal Plan Options:");
		totalCostLabel = new JLabel("Total Cost (in dollars)");
		
		// initialize dormitory object, spinner model, spinner, and set
		// change listener
		dormObj = new Dormitory();
		dormListModel = new SpinnerListModel(dormObj.getDormNameList());
		dormSpinner = new JSpinner(dormListModel);
		dormSpinner.addChangeListener(this);
		
		// initialize meal plan object, spinner model, spinner, and set
		// change listener
		mealPlanObj = new MealPlan();
		mealListModel = new SpinnerListModel(mealPlanObj.getMealPlanList());
		mealSpinner = new JSpinner(mealListModel);
		mealSpinner.addChangeListener(this);
		
		// initialize total cost text field
		totalCostField = new JTextField(15);
		totalCostField.setEditable(false);
		totalCostField.setText(String.valueOf(totalCost));
		
		// Use a GridBagLayout
		setLayout(new GridBagLayout());
		
		// specify component's grid locations
		// dormitory label upper upper left grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.insets = new Insets(5, 5, 5, 1);
		layoutConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 0;
		add(dormLabel, layoutConstraints);
		
		// meal plan label middle upper left grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.insets = new Insets(10, 5, 5, 1);
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 0;
		add(mealLabel, layoutConstraints);
		
		// dormitory spinner upper upper right grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.insets = new Insets(5, 1, 5, 10);
		layoutConstraints.anchor = GridBagConstraints.PAGE_START;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 1;
		add(dormSpinner, layoutConstraints);
		
		// meal plan spinner middle upper right grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.insets = new Insets(10, 1, 5, 10);
		layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 1;
		add(mealSpinner, layoutConstraints);
		
		// total cost label bottom left grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.insets = new Insets(10, 5, 10, 1);
		layoutConstraints.anchor = GridBagConstraints.LAST_LINE_START;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 0;
		add(totalCostLabel, layoutConstraints);
		
		// total cost text field bottom right grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.insets = new Insets(10, 1, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.PAGE_END;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 1;
		add(totalCostField, layoutConstraints);
	}
	
	public static void main(String[] args) {
		
		

	}

}
