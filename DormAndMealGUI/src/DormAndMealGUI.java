/*******************************************************************************
'Project: Java GUI Assignment 01
'Programmer: Ari Gaskins
'Company Info:  arigaskins.work@gmail.com 
'Date: 24 07 2023
'Description:  Problem Number 01. 
'GitHub: https://github.com/ari-gaskins/DormAndMealGUI 
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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * A class that creates a small graphical user interface that allows user
 * to select their dormitory location and their meal plan and calculate 
 * the total cost.
 * @author Ari Gaskins
 * @version 1.6
 */
public class DormAndMealGUI extends JFrame{
	private static final long serialVersionUID = 1L;

	// allows user to choose dormitory
	private JSpinner dormSpinner;
	
	// allows user to choose meal plan
	private JSpinner mealSpinner;
	
	// submit button to trigger showing total cost
	JButton submitButton = new JButton("Submit");
	
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
	
	// declare change listener for the dormSpinner component
	ChangeListener dormOptionChange;
	
	// declare change listener for the mealSpinner component
	ChangeListener mealPlanChange;
	
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
		setTitle("Cost of Dormitory and Meal Plan");
		
		// initialize labels
		dormLabel = new JLabel("Dormitory Options:");
		mealLabel = new JLabel("Meal Plan Options:");
		totalCostLabel = new JLabel("Total Cost (in dollars)");
		
		// initialize dormitory object, spinner model, spinner, and set
		// change listener
		dormObj = new Dormitory();
		dormListModel = new SpinnerListModel(dormObj.getDormNameList());
		dormSpinner = new JSpinner(dormListModel);
		
		//dormSpinner.addChangeListener(this);
		
		// initialize meal plan object, spinner model, spinner, and set
		// change listener
		mealPlanObj = new MealPlan();
		mealListModel = new SpinnerListModel(mealPlanObj.getMealPlanList());
		mealSpinner = new JSpinner(mealListModel);
		//mealSpinner.addChangeListener(this);
		
		// initialize total cost text field
		totalCostField = new JTextField(20);
		totalCostField.setEditable(false);
		totalCostField.setText(String.valueOf(totalCost));
		
		// Use a GridBagLayout
		setLayout(new GridBagLayout());
		
		// specify component's grid locations
		// dormitory label upper upper left grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 0;
		add(dormLabel, layoutConstraints);
		
		// meal plan label middle upper left grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(20, 10, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 1;
		add(mealLabel, layoutConstraints);
		
		// dormitory spinner upper upper right grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 5, 10, 20);
		layoutConstraints.anchor = GridBagConstraints.PAGE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 0;
		add(dormSpinner, layoutConstraints);
		
		// meal plan spinner middle upper right grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(20, 5, 10, 20);
		layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 1;
		add(mealSpinner, layoutConstraints);
		
		// total cost label bottom left grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(20, 10, 20, 5);
		layoutConstraints.anchor = GridBagConstraints.LAST_LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 2;
		add(totalCostLabel, layoutConstraints);
		
		// total cost text field bottom right grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(20, 5, 20, 10);
		layoutConstraints.anchor = GridBagConstraints.PAGE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 2;
		add(totalCostField, layoutConstraints);
		
		// submit button bottom center grid
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 5, 5, 5);
		layoutConstraints.anchor = GridBagConstraints.PAGE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 3;
		add(submitButton, layoutConstraints);
	
		// add change listener to dormitory spinner to track and 
		// get user selection
		dormOptionChange = new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				if (dormSpinner == event.getSource()) {
					String dormNameSelection;
					String[] dormList;
					int i;
			
					dormNameSelection = (String) dormSpinner.getValue();
					dormList = dormObj.getDormNameList();
			
					// check selection and set values
					for (i = 0; i < dormList.length; ++i) {
						if (dormNameSelection.equals(dormList[i])) {
							dormObj.setDormAndRoom(i);
						}
					}
				}
			}
		};
		
		dormSpinner.addChangeListener(dormOptionChange);
		
		// add change listener to meal plan spinner to track and
		// get user selection
		mealPlanChange = new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				if (mealSpinner == event.getSource()) {
					String mealPlanSelection;
					String[] mealList;
					int i;
				
					mealPlanSelection = (String) mealSpinner.getValue();
					mealList = mealPlanObj.getMealPlanList();
				
					// check selection and set values
					for (i = 0; i < mealList.length; ++i) {
						if (mealPlanSelection.equals(mealList[i])) {
							mealPlanObj.setMealAndCost(i);
						}
					}
				}
			}
		};
		
		mealSpinner.addChangeListener(mealPlanChange);
		
		// add action listener to submit button to show total cost
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				getTotalCost();
			}
		});
	}
	
	/**
	 * Calculate total cost; show total cost in text field.
	 */
	public void getTotalCost() {
		double dormCost = dormObj.getRoomCost();
		double mealPlanCost = mealPlanObj.getMealPlanCost();
		 
		totalCost = dormCost + mealPlanCost;
		
		totalCostField.setText(String.valueOf(totalCost));
	}
    
	
	public static void main(String[] args) {
		// declares and initializes DormAndMealGUI  and its component
		DormAndMealGUI dormMealFrame = new DormAndMealGUI();
		
		dormMealFrame.setSize(4000, 4000);
		dormMealFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dormMealFrame.pack();
		dormMealFrame.setVisible(true);
	}

}
