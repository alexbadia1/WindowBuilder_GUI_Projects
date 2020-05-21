//Author: Alex Badia
//Purpose: All for the Retail Price Form to be sticky
//Input: Data from the Retail Price Filter Form
//Output: Data from the Retail Price Filter Form

import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class BadiaStickyRetailPrice {
	
	//*******************************************
	// Data Field
	//*******************************************
	private double myLessThanPrice;
	private double myGreaterThanPrice;
	private double myMin;
	private double myMax;
	private String myRetailPriceButtonState;
	private ArrayList<JRadioButton> retailPriceButtons = new ArrayList<JRadioButton>();
	
	//*******************************************
	// Constructors
	//*******************************************
	public BadiaStickyRetailPrice() {
		myLessThanPrice = 0.00;
		myGreaterThanPrice = 0.00;
		myMin = 0.00;
		myMax = 0.00;
		setRetailPriceButtonState("Retail Price Filter: OFF");
	}//Null Constructor
	
	//*******************************************
	// Getters and Setters
	//*******************************************
	public double getLessThanPrice() {
		return myLessThanPrice;
	}//getLessThanPrice
	public void setLessThanPrice(double myLessThanPrice) {
		this.myLessThanPrice = myLessThanPrice;
	}//setLessThanPrice
	public double getGreaterThanPrice() {
		return myGreaterThanPrice;
	}//getGreaterThanPrice
	public void setGreaterThanPrice(double myGreaterThanPrice) {
		this.myGreaterThanPrice = myGreaterThanPrice;
	}//setGreaterThanPrice
	public double getMin() {
		return myMin;
	}//getMin()
	public void setMin(double myMin) {
		this.myMin = myMin;
	}//setMin
	public double getMax() {
		return myMax;
	}//getMax
	public void setMax(double myMax) {
		this.myMax = myMax;
	}//setMax
	
	public String getRetailPriceButtonState() {
		return myRetailPriceButtonState;
	}//getRetailPriceButtonState

	public void setRetailPriceButtonState(String newRetailPriceButtonState) {
		this.myRetailPriceButtonState = newRetailPriceButtonState;
	}//setRetailPriceButtonState

	//*******************************************
	// Public Methods
	//*******************************************
	public ArrayList<JRadioButton> getRetailPriceButtons() {
		return retailPriceButtons;
	}//getRetailPriceButtons

	public void add(JRadioButton rdbtn) {
		int count = 0;
		boolean found = false;
		while(count < retailPriceButtons.size() && found != true) {
			if (retailPriceButtons.get(count).getText().trim().equals(rdbtn.getText().trim())) {
				found = true;
			} else count++;
		}//while
		if (!found) {retailPriceButtons.add(rdbtn);}
	}//add
	
	public void removeAll() {
		retailPriceButtons.removeAll(retailPriceButtons);
		System.out.println(retailPriceButtons.size());
	}//removeAll
}//class
