import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddItemFrameBadia extends JFrame {

	//**********************************
	//Components
	//**********************************
	private JPanel contentPane;
	private final JFormattedTextField ftfID = new JFormattedTextField();
	private final JFormattedTextField ftfName = new JFormattedTextField();
	private final JFormattedTextField ftfWholesalePrice = new JFormattedTextField();
	private final JFormattedTextField ftfRetailPrice = new JFormattedTextField();
	private final JFormattedTextField ftfQOH = new JFormattedTextField();
	private final JFormattedTextField ftfMinQuant = new JFormattedTextField();
	private final JFormattedTextField ftfClerkName = new JFormattedTextField();
	private final JLabel lblID = new JLabel("Item ID Number:");
	private final JLabel lblName = new JLabel("Item Name:");
	private final JLabel lblCategory = new JLabel("Category:");
	private final JLabel lblWholesalePrice = new JLabel("Wholesale Price:");
	private final JLabel lblRetailPrice = new JLabel("Retail Price:");
	private final JLabel lblQOH = new JLabel("Quantity On Hand:");
	private final JLabel lblMinQuant = new JLabel("Minimum Quantity:");
	private final JLabel lblClerkName = new JLabel("Clerk Name:");
	private final JSeparator separator = new JSeparator();
	private final JLabel lblAddItem = new JLabel("Add New Item");
	private final JLabel lblNewLabel = new JLabel("All fields are required in order to add the item.");
	private final JButton btnOK = new JButton("OK");
	private final JButton btnCancel = new JButton("Cancel");
	private final JLabel lblNewLabel_1 = new JLabel("");
	private final JLabel lblItemIDError = new JLabel("Error depends");
	private final JLabel lblItemNameError = new JLabel("Must only contain alphabetical characters");
	private final JLabel lblWholesalePriceError = new JLabel("Must be a positive number");
	private final JLabel lblRetailPriceError = new JLabel("Must be a positive number");
	private final JLabel lblQOHError = new JLabel("Must be a positive whole number");
	private final JLabel lblMinQuantError = new JLabel("Must be a positive whole number");
	private final JLabel lblClerkError = new JLabel("Must only contain alphabetical characters");
	private final JLabel lblOKError = new JLabel("You must finish completing the form, correctly.");
	private final JComboBox comboBoxCategory = new JComboBox();


	//**********************************
	//Drivers
	//**********************************
	private String conString = "jdbc:ucanaccess://C:/Users/Public/InventoryBadia.accdb";
	
	
	//**********************************
	//Formatters
	//**********************************
	NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

	/**
	 * Create the frame.
	 */
	public AddItemFrameBadia() {
		jbInit();
	}//AddItemFrameBadia
	
	private void jbInit() {
		//**********************************
		//Content Pane Initialization
		//**********************************
		setTitle("Add New Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 821, 865);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//**********************************
		//Actually Load the Driver
		//**********************************
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
		//**********************************
		//INPUT FIELD LISTENERS
		//**********************************
		ftfID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_ftfID_focusLost(e);
			}
		});
		
		ftfName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_ftfName_focusLost(e);
			}
		});
		
		ftfWholesalePrice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_ftfWholesalePrice_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_ftfWholesalePrice_focusGained(e);
			}
		});
		
		ftfRetailPrice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_ftfRetailPrice_focusLost(arg0);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_ftfRetailPrice_focusGained(e);
			}
		});
		
		ftfQOH.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_ftfQOH_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_ftfQOH_focusGained(e);
			}
		});
		
		ftfMinQuant.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_ftfMinQuant_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_ftfMinQuant_focusGained(e);
			}
		});
		
		ftfClerkName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_ftfClerkName_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				do_ftfClerkName_focusGained(arg0);
			}
		});
		
		//**********************************
		//INPUT FIELDS
		//**********************************
		ftfID.setFont(new Font("Courier New", Font.PLAIN, 12));
		ftfID.setBounds(81, 125, 172, 30);
		contentPane.add(ftfID);
		
		ftfName.setFont(new Font("Courier New", Font.PLAIN, 12));
		ftfName.setBounds(81, 192, 172, 30);
		contentPane.add(ftfName);

		ftfWholesalePrice.setForeground(Color.GRAY);
		ftfWholesalePrice.setText("$0.00");
		ftfWholesalePrice.setFont(new Font("Courier New", Font.PLAIN, 12));
		ftfWholesalePrice.setBounds(81, 337, 172, 30);
		contentPane.add(ftfWholesalePrice);
		
		ftfRetailPrice.setText("$0.00");
		ftfRetailPrice.setForeground(Color.GRAY);
		ftfRetailPrice.setFont(new Font("Courier New", Font.PLAIN, 12));
		ftfRetailPrice.setBounds(81, 406, 172, 30);
		contentPane.add(ftfRetailPrice);
		
		ftfQOH.setForeground(Color.GRAY);
		ftfQOH.setText("0");
		ftfQOH.setFont(new Font("Courier New", Font.PLAIN, 12));
		ftfQOH.setBounds(81, 475, 172, 30);
		contentPane.add(ftfQOH);
		
		ftfMinQuant.setForeground(Color.GRAY);
		ftfMinQuant.setText("0");
		ftfMinQuant.setFont(new Font("Courier New", Font.PLAIN, 12));
		ftfMinQuant.setBounds(81, 545, 172, 30);
		contentPane.add(ftfMinQuant);
		
		ftfClerkName.setForeground(Color.GRAY);
		ftfClerkName.setFont(new Font("Courier New", Font.PLAIN, 12));
		ftfClerkName.setBounds(81, 613, 172, 30);
		contentPane.add(ftfClerkName);
		
		//**********************************
		//INPUT FIELD LABELS
		//**********************************
		lblID.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblID.setBounds(81, 99, 172, 30);
		contentPane.add(lblID);
		
		lblName.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblName.setBounds(81, 165, 172, 30);
		contentPane.add(lblName);
	
		lblCategory.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblCategory.setBounds(81, 233, 172, 33);
		contentPane.add(lblCategory);
		
		lblWholesalePrice.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblWholesalePrice.setBounds(81, 306, 172, 30);
		contentPane.add(lblWholesalePrice);
		
		lblRetailPrice.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblRetailPrice.setBounds(81, 379, 172, 33);	
		contentPane.add(lblRetailPrice);

		lblQOH.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblQOH.setBounds(81, 449, 172, 30);	
		contentPane.add(lblQOH);
		
		lblMinQuant.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblMinQuant.setBounds(81, 515, 172, 33);	
		contentPane.add(lblMinQuant);
		
		lblClerkName.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblClerkName.setBounds(81, 586, 172, 33);		
		contentPane.add(lblClerkName);
		
		separator.setBounds(26, 56, 685, 2);		
		contentPane.add(separator);
		
		lblAddItem.setFont(new Font("Courier New", Font.BOLD, 24));
		lblAddItem.setBounds(26, 25, 254, 33);
		contentPane.add(lblAddItem);
		
		lblNewLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		lblNewLabel.setBounds(36, 67, 485, 23);
		contentPane.add(lblNewLabel);
		
		//**********************************
		//BUTTONS
		//**********************************
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnOK_actionPerformed(e);
			}
		});
		btnOK.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnOK.setBounds(81, 714, 172, 35);
		contentPane.add(btnOK);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_actionPerformed(e);
			}
		});
		btnCancel.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnCancel.setBounds(81, 666, 172, 35);
		contentPane.add(btnCancel);
		
		//**********************************
		//ERROR LABELS
		//lblNewLabel_1: the error message
		//appears under the page subtitle
		//**********************************
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(46, 86, 601, 23);
		contentPane.add(lblNewLabel_1);
		
		lblItemIDError.setForeground(Color.RED);
		lblItemIDError.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblItemIDError.setBounds(279, 122, 318, 33);
		lblItemIDError.setVisible(false);	
		contentPane.add(lblItemIDError);
		
		lblItemNameError.setForeground(Color.RED);
		lblItemNameError.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblItemNameError.setBounds(279, 192, 318, 33);
		lblItemNameError.setVisible(false);
		contentPane.add(lblItemNameError);
		
		lblWholesalePriceError.setForeground(Color.RED);
		lblWholesalePriceError.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblWholesalePriceError.setBounds(279, 334, 318, 33);
		lblWholesalePriceError.setVisible(false);
		contentPane.add(lblWholesalePriceError);
		
		lblRetailPriceError.setVisible(false);
		lblRetailPriceError.setForeground(Color.RED);
		lblRetailPriceError.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblRetailPriceError.setBounds(279, 406, 318, 33);
		contentPane.add(lblRetailPriceError);
		
		lblQOHError.setForeground(Color.RED);
		lblQOHError.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblQOHError.setBounds(279, 472, 318, 33);
		lblQOHError.setVisible(false);	
		contentPane.add(lblQOHError);
		
		lblMinQuantError.setForeground(Color.RED);
		lblMinQuantError.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblMinQuantError.setBounds(279, 542, 318, 33);
		lblMinQuantError.setVisible(false);
		contentPane.add(lblMinQuantError);
		
		lblClerkError.setForeground(Color.RED);
		lblClerkError.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblClerkError.setBounds(279, 610, 318, 33);
		lblClerkError.setVisible(false);
		contentPane.add(lblClerkError);
		
		comboBoxCategory.setBackground(Color.WHITE);
		comboBoxCategory.setModel(new DefaultComboBoxModel(new String[] {"Dairy", "Meat", "Frozen", "Canned", "Produce", "Beverage", "Paper", "Snack", "Cereal", "Other"}));
		comboBoxCategory.setFont(new Font("Courier New", Font.PLAIN, 12));
		comboBoxCategory.setBounds(81, 265, 172, 30);	
		contentPane.add(comboBoxCategory);
		
		lblOKError.setForeground(Color.RED);
		lblOKError.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblOKError.setBounds(279, 714, 432, 33);
		lblOKError.setVisible(false);
		contentPane.add(lblOKError);
	}
	
	//*******************************
	//FTF Focus LOST Methods
	//*******************************
	protected void do_ftfID_focusLost(FocusEvent e) {
		if (!ftfID.getText().isEmpty()) {
			if (!containsLetters(ftfID.getText().trim())) {
				if (isPositiveInt(ftfID, lblItemIDError) ) {
					int fieldValue = Integer.parseInt(ftfID.getText().replace(",", "").trim());
					 if (valueExists(ftfID.getText().replace("$", "").replace(",", "").trim(), lblID)) {
						//Item id is already used
						lblItemIDError.setText("ID already used, choose a different ID"); 
						lblItemIDError.setVisible(true);
					} else  {lblItemIDError.setVisible(false); }
				}//if
			} else {
				lblItemIDError.setText("Must only contain numerical characters"); 
				lblItemIDError.setVisible(true);
			}
		} else {
			lblItemIDError.setText("Cannot leave empty, field is required"); 
			lblItemIDError.setVisible(true);
		}
	}//do_ftfID_focusLost
	
	protected void do_ftfName_focusLost(FocusEvent e) {
		if (!ftfName.getText().isEmpty()) {
			if (!containsNumber(ftfName.getText().trim())) {
				 if (valueExists(ftfName.getText().trim(), lblItemNameError)) {
					//Item name is already used
					lblItemNameError.setText("Name already exists, choose a different name"); 
					lblItemNameError.setVisible(true);
				} else  {lblItemNameError.setVisible(false); }
			} else {
				lblItemNameError.setText("Must only contain alphabetical characters"); 
				lblItemNameError.setVisible(true); }
		} else {
			lblItemNameError.setText("Cannot leave empty, field is required"); 
			lblItemNameError.setVisible(true);
		}
	}//do_ftfName_focusLost
	
	protected void do_ftfRetailPrice_focusLost(FocusEvent arg0) {
		isValidDollar(ftfRetailPrice, lblRetailPriceError); 
	}//do_ftfRetailPrice_focusLost
	
	protected void do_ftfQOH_focusLost(FocusEvent e) {
		isPositiveInt(ftfQOH, lblQOHError); 
	}//do_ftfQOH_focusLost
	
	protected void do_ftfWholesalePrice_focusLost(FocusEvent e) {
		isValidDollar(ftfWholesalePrice, lblWholesalePriceError);
	}//do_ftfWholesalePrice_focusLost
	
	protected void do_ftfMinQuant_focusLost(FocusEvent e) {
		isPositiveInt(ftfQOH, lblQOHError);
	}//do_ftfMinQuant_focusLost
	
	protected void do_ftfClerkName_focusLost(FocusEvent e) {
		if (!ftfClerkName.getText().isEmpty()) {
			if (!containsNumber(ftfClerkName.getText().trim())) {
				 if (valueExists(ftfClerkName.getText().trim(), lblClerkError)) {
					//Item name is already used
					 lblClerkError.setText("Name already exists, choose a different name"); 
					 lblClerkError.setVisible(true);
				} else  {lblClerkError.setVisible(false); }
			} else {
				lblClerkError.setText("Must only contain alphabetical characters"); 
				lblClerkError.setVisible(true); }
		} else {
			lblClerkError.setText("Cannot leave empty, field is required"); 
			lblClerkError.setVisible(true);
		}
	}//do_ftfClerkName_focusLost
	
	//*******************************
	//FTF Focus GAINED Methods
	//*******************************
	protected void do_ftfClerkName_focusGained(FocusEvent arg0) {
		clearFTF(ftfClerkName); 
	}//do_ftfClerkName_focusGained
	protected void do_ftfRetailPrice_focusGained(FocusEvent e) {
		clearFTF(ftfRetailPrice); 
	}//do_ftfRetailPrice_focusGained
	protected void do_ftfQOH_focusGained(FocusEvent e) {
		clearFTF(ftfQOH); 
	}//do_ftfQOH_focusGained
	protected void do_ftfWholesalePrice_focusGained(FocusEvent e) {
		clearFTF(ftfWholesalePrice);
	}//do_ftfWholesalePrice_focusGained
	protected void do_ftfMinQuant_focusGained(FocusEvent e) {
		clearFTF(ftfMinQuant); 
	}//do_ftfMinQuant_focusGained
	
	
	//*******************************
	//Button Methods
	//*******************************
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}//do_btnOK_actionPerformed
	
	protected void do_btnOK_actionPerformed(ActionEvent e) {
		boolean noErrors = true;
		//Check first field
		if (!ftfID.getText().isEmpty()) {
			if (!containsLetters(ftfID.getText().trim())) {
				if (isPositiveInt(ftfID, lblItemIDError) ) {
					int fieldValue = Integer.parseInt(ftfID.getText().replace(",", "").trim());
					 if (valueExists(ftfID.getText().replace("$", "").replace(",", "").trim(), lblID)) {
						//Item id is already used
						lblItemIDError.setText("ID already used, choose a different ID"); 
						lblItemIDError.setVisible(true);
						noErrors = false;
					} else  {lblItemIDError.setVisible(false);}
				}//if
			} else {
				lblItemIDError.setText("Must only contain numerical characters"); 
				lblItemIDError.setVisible(true);
				noErrors = false;
			}
		} else {
			lblItemIDError.setText("Cannot leave empty, field is required"); 
			lblItemIDError.setVisible(true);
			noErrors = false;
		}
		
		
		if (!ftfName.getText().isEmpty()) {
			if (!containsNumber(ftfName.getText().trim())) {
				 if (valueExists(ftfName.getText().trim(), lblItemNameError)) {
					//Item name is already used
					lblItemNameError.setText("Name already exists, choose a different name"); 
					lblItemNameError.setVisible(true);
					noErrors = false;
				} else  {lblItemNameError.setVisible(false); }
			} else {
				lblItemNameError.setText("Must only contain alphabetical characters"); 
				lblItemNameError.setVisible(true);
				noErrors = false;}
		} else {
			lblItemNameError.setText("Cannot leave empty, field is required"); 
			lblItemNameError.setVisible(true);
			noErrors = false;
		}
		
		if (!isValidDollar(ftfRetailPrice, lblRetailPriceError)) {
			noErrors = false;
		}
		
		if (!isPositiveInt(ftfQOH, lblQOHError)) {
			noErrors = false;
		}
		
		if (!isValidDollar(ftfWholesalePrice, lblWholesalePriceError)) {
			noErrors = false;
		}
		
		if(!isPositiveInt(ftfQOH, lblQOHError)) {
			noErrors = false;
		}
		
		if (!ftfClerkName.getText().isEmpty()) {
			if (!containsNumber(ftfClerkName.getText().trim())) {
				 if (valueExists(ftfClerkName.getText().trim(), lblClerkError)) {
					//Item name is already used
					 lblClerkError.setText("Name already exists, choose a different name"); 
					 lblClerkError.setVisible(true);
					 noErrors = false;
				} else  {lblClerkError.setVisible(false);}
			} else {
				lblClerkError.setText("Must only contain alphabetical characters"); 
				lblClerkError.setVisible(true);
				noErrors = false;}
		} else {
			lblClerkError.setText("Cannot leave empty, field is required"); 
			lblClerkError.setVisible(true);
			noErrors = false;
		}
		
		if (noErrors == true) {
			insert(
				Integer.parseInt(ftfID.getText().replace(",", "").trim()), 
				ftfName.getText(),
				comboBoxCategory.getSelectedItem().toString().trim(),
				Double.parseDouble(ftfWholesalePrice.getText().replace("$", "").replace("$", "").trim()),
				Double.parseDouble(ftfRetailPrice.getText().replace("$", "").replace("$", "").trim()),
				Integer.parseInt(ftfQOH.getText().replace(",", "").trim()),
				Integer.parseInt(ftfMinQuant.getText().replace(",", "").trim()),
				ftfClerkName.getText() );
			lblOKError.setVisible(false);
			this.dispose();
		} else lblOKError.setVisible(true);
	}//do_btnCancel_actionPerformed
	
	
	//*******************************
	//Helper Methods
	//*******************************
	protected boolean isValidDollar (JFormattedTextField ftf, JLabel lblError) {
		boolean ans = false;
		try {
			if (Double.parseDouble(ftf.getText().replace("$", "").replace(",", "").trim()) >= 0.00) {
				ftf.setText(moneyFormat.format(Double.parseDouble(ftf.getText().replace("$", "").replace(",", "").trim())));
				ftf.setForeground(Color.black);
				lblError.setVisible(false);
				ans = true;}
			else {
				ftf.setForeground(Color.red);
				lblError.setVisible(true); }
		} catch (NumberFormatException e) {
			ftf.setForeground(Color.red);
			lblError.setVisible(true); }
		return ans;
	}//checkValidFormattedTextOnlyField
	
	protected void clearFTF(JFormattedTextField ftf) {
		if (ftf.getForeground() == Color.gray || ftf.getForeground() == Color.red) {
			ftf.setText("");
			ftf.setForeground(Color.black);
		}//if
	}//clear field
	
	protected boolean isPositiveInt(JFormattedTextField ftf, JLabel lblError) {
		boolean ans = false;
		try {
			if (Integer.parseInt(ftf.getText().replace(",", "").trim()) >= 0) {
				ftf.setText(Integer.parseInt(ftf.getText().replace(",", "").trim()) + "");
				ftf.setForeground(Color.black);
				lblError.setVisible(false);
				ans = true;}
			else {
				ftf.setForeground(Color.red);
				lblError.setVisible(true);
				lblError.setText("Must be a positive whole number");}
		} catch (NumberFormatException e) {
			ftf.setForeground(Color.red);
			lblError.setVisible(true); 
			lblError.setText("Must be a positive whole number");}
		return ans;
	}//isPositiveInt
	
	protected boolean valueExists(String value, JLabel lbl) {
		// System.out.println("Function call success");
		int newIntValue = -1;
		boolean ans = false;
		String sqlQuery = "SELECT ItemID FROM Items WHERE ItemName= ? ";
		ResultSet results = null;
		
		if (lbl.getText().equals("Item ID Number:")) {
			newIntValue = Integer.parseInt(value.replace(",", "").trim());
			sqlQuery = "SELECT ItemID FROM Items WHERE ItemID = ? ";
		}
		
		try {
			//2.) Establish the connection
			Connection connection = DriverManager.getConnection(conString);
			
			//3.) Create paramaterized SQL statement
			PreparedStatement statement = connection.prepareStatement(sqlQuery);	
			
			//3.5)Pass the parameters in
			if (lbl.getText().equals("Item ID Number:")) {
				statement.setInt(1, newIntValue); 
			} else statement.setString(1, value);
			
			//4.) Execute
			results = statement.executeQuery();
			
			//5.) Process results
			if (results.next()) {
				ans = true;
			}//if
		
			//6.)Close everything
			results.close();
			statement.close();
			connection.close();
			
		} catch (SQLException ex) {
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		} //catch
		return ans;
	}//exists
	
	protected boolean containsNumber (String string) {
		char[] letters = string.toCharArray();
		int letterPos = 0;
		boolean digitFound = false;
		
		//Check if string is empty
		if (!string.trim().isEmpty()) {
			//Check if the name has any alphabetical characters
		      while ( (letterPos < letters.length) && (digitFound == false) ) {
		         if(Character.isDigit(letters[letterPos])){
		            digitFound = true;
		         } else letterPos++;
		      }//while
		}//if
		return digitFound;
	}//containsLetters
	
	protected boolean containsLetters (String string) {
		string = string.toLowerCase();
		char[] letters = string.toCharArray();
		int letterPos = 0;
		boolean letterFound = false;
		
		//Check if string is empty
		if (!string.trim().isEmpty()) {
			//Check if the name has any numeric characters
		      while ( (letterPos < letters.length) && (letterFound == false) ) {
		         if(Character.isAlphabetic(letters[letterPos])){
		            letterFound = true;
		         } else letterPos++;
		      }//while
		}//if
		return letterFound;
	}//containsLetters
	
	protected void insert(int itemID, String itemName, String itemCategory, double wholesalePrice, double retailPrice, int qoh, int minQuant, String clerk) {
		// System.out.println("Insert Function successful");
		String sqlQuery = "INSERT INTO Items (ItemID, ItemName, ItemCategory, WholesalePrice, RetailPrice, QOH, MinQuant, Clerk) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
		
		try {
			//2.) Establish the connection
			Connection connection = DriverManager.getConnection(conString);
			
			//3.) Create paramaterized SQL statement
			PreparedStatement statement = connection.prepareStatement(sqlQuery);	
			
			//3.5)Pass the parameters in
			statement.setInt(1, itemID);
			statement.setString(2, itemName);
			statement.setString(3, itemCategory);
			statement.setDouble(4, wholesalePrice);
			statement.setDouble(5, retailPrice);
			statement.setInt(6, qoh);
			statement.setInt(7, minQuant);
			statement.setString(8, clerk);
			
			//4.) Execute
			statement.executeUpdate();
			
			//6.)Close everything
			statement.close();
			connection.close();
			
		} catch (SQLException ex) {
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		} //catch
	}//insert

}//class
