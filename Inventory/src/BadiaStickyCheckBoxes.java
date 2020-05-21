//Author: Alex Badia
//Purpose: Hold data about the sticky checkboxes
//Input: boolean data about the current check boxes' states
//Output: boolean data about the current check boxes' states

import java.util.*;
import javax.swing.JCheckBox;

public class BadiaStickyCheckBoxes {
	
	//*******************************************
	// Data Field
	//*******************************************
	private String myCategoryButtonState;
	private ArrayList<JCheckBox> checkedCheckBoxes = new ArrayList<JCheckBox>();
	
	//*******************************************
	// Constructors
	//*******************************************
	public BadiaStickyCheckBoxes () {
		setCategoryButtonState("Category Filter: OFF");
	}//null constructor
	
	//*******************************************
	// Getters and Setters
	//*******************************************
	public String getCategoryButtonState() {
		return myCategoryButtonState;
	}//getCategoryButtonState

	public void setCategoryButtonState(String newCategoryButtonState) {
		this.myCategoryButtonState = newCategoryButtonState;
	}//setCategoryButtonState
	
	//*******************************************
	// Public Methods
	//*******************************************
	public boolean isEmpty() {
		return checkedCheckBoxes.isEmpty();
	}//isEmpty
	
	public void removeAll() {
		checkedCheckBoxes.removeAll(checkedCheckBoxes);
		System.out.println(checkedCheckBoxes.size());
	}//removeAll
	
	public ArrayList<JCheckBox> getCheckedCheckBoxes() {
		return checkedCheckBoxes;
	}//getCheckedCheckBoxes
	
	public void add(JCheckBox checkBox) {
		int count = 0;
		boolean found = false;
		while(count < checkedCheckBoxes.size() && found != true) {
			if (checkedCheckBoxes.get(count).getText().trim().equals(checkBox.getText().trim())) {
				found = true;
			} else count++;
		}//while
		if (!found) {
			checkedCheckBoxes.add(checkBox);
		}
	}//add
	
}//class
