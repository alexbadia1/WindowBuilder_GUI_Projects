//Author: Alex Badia
//Purpose: Hold data about an SQL query
//Input: String data to build a query
//Output: outputs a constructed SQL query

public class BadiaQuery {
	
	//*******************************************
	// Data Field
	//*******************************************
	private String myQuery;
	private String myBase;
	private String myPriceFilter;
	private String myCategoryFilter;
	private String mySort;
	private String myStatus;
	private String mySortType;
	
	//*******************************************
	// Constructors
	//*******************************************
	public BadiaQuery () {
		myBase = "SELECT ItemID, ItemName, ItemCategory, WholesalePrice, RetailPrice, QOH, MinQuant, Clerk "
				+ "FROM Items "
				+ "WHERE (1=1) ";
		myPriceFilter = "";
		myCategoryFilter = "";
		mySort = "ORDER BY ItemID ASC";
		myStatus = "Filtering By: NONE, Sorting By: NONE";
		mySortType = "Item ID";
		buildQuery();
	}//null constructor

	//*******************************************
	// Getters and Setters
	//*******************************************
	public void setStatus(String status) {
			myStatus = "Filtering By: ";
			if (!getPriceFilter().isEmpty()) {
				myStatus += "Retail Price";
				if (getCategoryFilter().isEmpty()) { 
					myStatus += " ";
				} else myStatus += ", ";
			}//if
			if (!getCategoryFilter().isEmpty()) {
				myStatus += "Category ";
			}//if
			if (getPriceFilter().isEmpty() && getCategoryFilter().isEmpty()) {
				myStatus += "NONE ";
			}//if
			myStatus += "and Sorting By: " + status;
			mySortType = status;
	}//setStatus

	public String getStatus() {
		myStatus = "Filtering By: ";
		if (!getPriceFilter().isEmpty()) {
			myStatus += "Retail Price";
			if (getCategoryFilter().isEmpty()) { 
				myStatus += " ";
			} else myStatus += ", ";
		}//if
		if (!getCategoryFilter().isEmpty()) {
			myStatus += "Category ";
		}//if
		if (getPriceFilter().isEmpty() && getCategoryFilter().isEmpty()) {
			myStatus += "NONE ";
		}//if
		myStatus += "and Sorting By: " + mySortType;
		return myStatus;
	}//getStatus
	
	
	public String getQuery() {
		return myQuery;
	}//getQuery
	
	public String getPriceFilter() {
		return myPriceFilter;
	}//getPriceFilter
	
	public String getCategoryFilter() {
		return myCategoryFilter;
	}//getCategoryFilter
	
	public String getSort() {
		return mySort;
	}//getSort

	public void setPriceFilter(String newPriceFilter) {
		myPriceFilter = newPriceFilter;
		buildQuery();
	}//setPriceFilter

	public void setCategoryFilter(String newCategoryFilter) {
		myCategoryFilter = newCategoryFilter;
		buildQuery();
	}//setCategoryFilter

	public void setSort(String newSort) {
		mySort = newSort; 
		buildQuery();
	}//setSort
	
	//*******************************************
	// Private Methods
	//*******************************************
	private void buildQuery() {
		myQuery = myBase + " " + myPriceFilter + " " + myCategoryFilter + " " + mySort;
	}//BuildQuery
	
}//class
