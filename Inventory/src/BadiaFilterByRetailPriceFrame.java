import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;

public class BadiaFilterByRetailPriceFrame extends JFrame {
	
	//*******************************************
	// Components
	//*******************************************
	private JPanel contentPane;
	private final JLabel lblFilterByRetail = new JLabel("Filter By Retail Price");
	private final JSeparator separator = new JSeparator();
	private final JLabel lblChooseOneMethod = new JLabel("Choose ONE method to filter by.");
	private final JFormattedTextField ftfLessThanPrice = new JFormattedTextField();
	private final JFormattedTextField ftfGreaterThanPrice = new JFormattedTextField();
	private final JFormattedTextField ftfMin = new JFormattedTextField();
	private final JFormattedTextField ftfMax = new JFormattedTextField();
	private final JLabel lblMin = new JLabel("Minimum Price:");
	private final JLabel lblMax = new JLabel("Maximum Price:");
	private final JLabel lblGreaterThanPrice = new JLabel("Starting Price:");
	private final JLabel lblLessThanPrice = new JLabel("Starting Price:");
	private final ButtonGroup filterByButtonGroup = new ButtonGroup();
	private final JButton btnApplyAndClose = new JButton("Apply and Close");
	private final JLabel lblLessThanPriceError = new JLabel("Error");
	private final JLabel lblGreaterThanPriceError = new JLabel("Error");
	private final JLabel lblMinError = new JLabel("Error");
	private final JLabel lblMaxError = new JLabel("Error");
	private final JButton btnCancel = new JButton("Cancel");
	
	//Static shortcut to allow for the radio buttons to be sticky
	private final static JRadioButton rdbtnLessThan = new JRadioButton("Only show items with prices LOWER than: ");
	private final static JRadioButton rdbtnGreaterThan = new JRadioButton("Only show items with prices GREATER than:");
	private final static JRadioButton rdbtnRange = new JRadioButton("Only show itemse in a specified range:");
	
	//*******************************************
	// Money Formatters
	//*******************************************
	NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
	
	//*******************************************
	// Query Data
	//*******************************************
	private BadiaQuery myQuery;
	private BadiaStickyRetailPrice myPrices;
	private BadiaStickyCheckBoxes myCheckBoxes;


	/**
	 * Create the frame.
	 */
	public BadiaFilterByRetailPriceFrame(BadiaQuery newQuery, BadiaStickyRetailPrice thePrices, BadiaStickyCheckBoxes newCheckBoxes ) {
		myPrices = thePrices;
		myQuery = newQuery;
		myCheckBoxes = newCheckBoxes;
		jbInit();
	}//jbInit
	
	private void jbInit() {
		setTitle("Filter By Retail Price");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 994, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Title Label
		lblFilterByRetail.setFont(new Font("Courier New", Font.BOLD, 24));
		lblFilterByRetail.setBounds(26, 28, 393, 33);
		contentPane.add(lblFilterByRetail);
		
		//Underline for title separator
		separator.setBounds(26, 59, 869, 2);
		contentPane.add(separator);
		
		//Directions Label
		lblChooseOneMethod.setFont(new Font("Courier New", Font.ITALIC, 12));
		lblChooseOneMethod.setBounds(36, 59, 327, 33);
		contentPane.add(lblChooseOneMethod);
		
		//Radio Button: Less Than Option
		filterByButtonGroup.add(rdbtnLessThan);
		rdbtnLessThan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnLessThan_actionPerformed(arg0);
			}
		});
		rdbtnLessThan.setFont(new Font("Courier New", Font.PLAIN, 12));
		rdbtnLessThan.setBounds(46, 113, 336, 41);
		contentPane.add(rdbtnLessThan);
		
		//Radio Button: Greater Than Option
		filterByButtonGroup.add(rdbtnGreaterThan);
		rdbtnGreaterThan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnGreaterThan_actionPerformed(e);
			}
		});
		rdbtnGreaterThan.setFont(new Font("Courier New", Font.PLAIN, 12));
		rdbtnGreaterThan.setBounds(46, 209, 373, 41);
		contentPane.add(rdbtnGreaterThan);
		
		//Radio Button: Range Option
		filterByButtonGroup.add(rdbtnRange);
		rdbtnRange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnRange_actionPerformed(e);
			}
		});
		rdbtnRange.setFont(new Font("Courier New", Font.PLAIN, 12));
		rdbtnRange.setBounds(46, 303, 373, 41);
		contentPane.add(rdbtnRange);
		ftfLessThanPrice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				do_ftfLessThanPrice_focusGained(e);
			}
		});

		//Less Than Formatted Text Field
		ftfLessThanPrice.setFont(new Font("Courier New", Font.PLAIN, 12));
		ftfLessThanPrice.setBounds(227, 164, 136, 28);
		contentPane.add(ftfLessThanPrice);
		ftfLessThanPrice.setText(moneyFormat.format(myPrices.getLessThanPrice()));
		ftfGreaterThanPrice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_ftfGreaterThanPrice_focusGained(arg0);
			}
		});
		
		//Greater Than Formatted Text Field
		ftfGreaterThanPrice.setFont(new Font("Courier New", Font.PLAIN, 12));
		ftfGreaterThanPrice.setBounds(227, 250, 136, 33);
		contentPane.add(ftfGreaterThanPrice);
		ftfGreaterThanPrice.setText(moneyFormat.format(myPrices.getGreaterThanPrice()));
		ftfMin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				do_ftfMin_focusGained(e);
			}
		});
		
		//Minimum Formatted Text Field
		ftfMin.setFont(new Font("Courier New", Font.PLAIN, 12));
		ftfMin.setBounds(227, 348, 136, 33);
		contentPane.add(ftfMin);
		ftfMin.setText(moneyFormat.format(myPrices.getMin()));
		ftfMax.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				do_ftfMax_focusGained(e);
			}
		});
		
		//Maximum Formatted Text Field
		ftfMax.setFont(new Font("Courier New", Font.PLAIN, 12));
		ftfMax.setBounds(227, 392, 136, 33);
		contentPane.add(ftfMax);
		ftfMax.setText(moneyFormat.format(myPrices.getMax()));
		
		//Minimum Label
		lblMin.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblMin.setBounds(104, 348, 115, 33);
		contentPane.add(lblMin);
		
		//Maximum Label
		lblMax.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblMax.setBounds(104, 392, 115, 33);
		contentPane.add(lblMax);

		//Greater Than Label
		lblGreaterThanPrice.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblGreaterThanPrice.setBounds(104, 250, 115, 33);
		contentPane.add(lblGreaterThanPrice);
		
		//Less Than Label
		lblLessThanPrice.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblLessThanPrice.setBounds(104, 162, 115, 33);
		contentPane.add(lblLessThanPrice);
		
		//Button Apply and Close
		btnApplyAndClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnApplyAndClose_actionPerformed(e);
			}
		});
		btnApplyAndClose.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnApplyAndClose.setBounds(208, 505, 155, 41);
		contentPane.add(btnApplyAndClose);
		
		//Error Label for Less Than Option
		lblLessThanPriceError.setForeground(Color.RED);
		lblLessThanPriceError.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblLessThanPriceError.setBounds(375, 159, 520, 33);
		contentPane.add(lblLessThanPriceError);
		lblLessThanPriceError.setVisible(false);
		
		//Error Label for Greater Than Option
		lblGreaterThanPriceError.setForeground(Color.RED);
		lblGreaterThanPriceError.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblGreaterThanPriceError.setBounds(375, 250, 520, 33);
		contentPane.add(lblGreaterThanPriceError);
		lblGreaterThanPriceError.setVisible(false);
		
		//Error Label for Minimum Price Error
		lblMinError.setForeground(Color.RED);
		lblMinError.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblMinError.setBounds(375, 348, 520, 33);
		contentPane.add(lblMinError);
		lblMinError.setVisible(false);
		
		//Error Label for Maximum price Error
		lblMaxError.setForeground(Color.RED);
		lblMaxError.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		lblMaxError.setBounds(375, 392, 520, 33);
		contentPane.add(lblMaxError);
		lblMaxError.setVisible(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_actionPerformed(e);
			}
		});
		btnCancel.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnCancel.setBounds(208, 447, 155, 41);
		
		contentPane.add(btnCancel);
		
		//TODO Make the radio boxes sticky
		//First time, auto select the Less Than option
			rdbtnLessThan.setSelected(true);
			myPrices.add(rdbtnLessThan);
			if (!myPrices.getRetailPriceButtons().isEmpty()) {
				int pos = 0;
				for (pos = 0; pos < myPrices.getRetailPriceButtons().size(); pos++) {
					myPrices.getRetailPriceButtons().get(pos).setSelected(true);
				}//for
				myPrices.removeAll();
				
				//Brute Force, sorry for the copy and paste
				if (rdbtnLessThan.isSelected()) {
					enableLessThanFilter();
				}//if
				else if (rdbtnGreaterThan.isSelected()) {
					enableGreaterThanFilter();
				} //else-if
				else {
					enableRangeFilter();
				}//else
			}//if
	}//jbInit
	
	//*******************************************
	// Radio Buttons ACTION PERFORMED
	//*******************************************
	protected void do_rdbtnLessThan_actionPerformed(ActionEvent arg0) {
		enableLessThanFilter();
	}//do_rdbtnLessThan_actionPerformed
	
	protected void do_rdbtnGreaterThan_actionPerformed(ActionEvent e) {
		enableGreaterThanFilter();
	}//do_rdbtnGreaterThan_actionPerformed
	
	protected void do_rdbtnRange_actionPerformed(ActionEvent e) {
		enableRangeFilter();
	}//do_rdbtnRange_actionPerformed
	
	//*******************************************
	// Retail Price Form GAINED Focus
	//*******************************************
	protected void do_ftfLessThanPrice_focusGained(FocusEvent e) {
		clearFTF(ftfLessThanPrice); 
	}//do_ftfLessThanPrice_focusGained
	
	protected void do_ftfGreaterThanPrice_focusGained(FocusEvent arg0) {
		clearFTF(ftfGreaterThanPrice);
	}//do_ftfGreaterThanPrice_focusGained
	protected void do_ftfMin_focusGained(FocusEvent e) {
		clearFTF(ftfMin); 
	}//do_ftfMin_focusGained
	protected void do_ftfMax_focusGained(FocusEvent e) {
		clearFTF(ftfMax);
	}//do_ftfMax_focusGained
	
	//*******************************************
	// BUTTONS
	//*******************************************
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}//do_btnCancel_actionPerformed
	
	protected void do_btnApplyAndClose_actionPerformed(ActionEvent e) {
		if (rdbtnLessThan.isSelected()) {
			if (!ftfLessThanPrice.getText().isEmpty()) {
				if (isValidDollar(ftfLessThanPrice, lblLessThanPriceError)) {
					//TODO: 1.) Apply the Less than Filter
						myQuery.setPriceFilter("AND RetailPrice < " + ftfLessThanPrice.getText().replace("$", "").replace(",", "").trim());
					//TODO: 2.) Update the sticky data
						myPrices.setLessThanPrice(Double.parseDouble(ftfLessThanPrice.getText().replace("$", "").replace(",", "").trim()));
						myPrices.setGreaterThanPrice(0.00);
						myPrices.setMin(0.00);
						myPrices.setMax(0.00);
						myPrices.add(rdbtnLessThan);
						if (!myQuery.getCategoryFilter().isEmpty()) {myCheckBoxes.setCategoryButtonState("Category Filter: ON");}
						myPrices.setRetailPriceButtonState("Retail Button Filter: ON");
					//TODO: 3.) Update Table Close Window
						this.dispose();
				}//else
			} else {lblLessThanPriceError.setText("Empty field cannot be applied as a filter!");}//else
		} //if
		else if (rdbtnGreaterThan.isSelected()) {
			if (!ftfGreaterThanPrice.getText().isEmpty()) {
				if (isValidDollar(ftfGreaterThanPrice, lblGreaterThanPriceError)) {
					//TODO: 4.) Apply the Greater than Filter
						myQuery.setPriceFilter("AND RetailPrice > " + ftfGreaterThanPrice.getText().replace("$", "").replace(",", "").trim());
					//TODO: 5.) Update the sticky data
						myPrices.setGreaterThanPrice(Double.parseDouble(ftfGreaterThanPrice.getText().replace("$", "").replace(",", "").trim()));
						myPrices.setLessThanPrice(0.00);
						myPrices.setMin(0.00);
						myPrices.setMax(0.00);
						myPrices.add(rdbtnGreaterThan);
					//TODO: 6.) Update Table Close Window
						if (!myQuery.getCategoryFilter().isEmpty()) {myCheckBoxes.setCategoryButtonState("Category Filter: ON");}
						myPrices.setRetailPriceButtonState("Retail Button Filter: ON");
						//InventoryFrameBadia.updateTable(myQuery, connectionString);
						this.dispose();
				}//else
			}//if
			else {lblGreaterThanPriceError.setText("Empty field cannot be applied as a filter!");}//else
		}//else-if
		else if (rdbtnRange.isSelected()) {
			boolean minIsDollar = false;
			boolean maxIsDollar = false;
			
			//Check if minimum value is a valid US dollar amount
			if (!ftfMin.getText().isEmpty()) {
				if (isValidDollar(ftfMin, lblMinError)) {minIsDollar = true;}//if
			} else {lblMinError.setText("Empty field cannot be applied as a filter!");}//else
			
			////Check if maximum value is a valid US dollar amount
			if (!ftfMax.getText().isEmpty()) {
				if (isValidDollar(ftfMax, lblMaxError)) {maxIsDollar = true;}//if
			} else {lblMaxError.setText("Empty field cannot be applied as a filter!");}//else
			
			//Check for logically valid minimum and maximum values in relation to each other
			if (minIsDollar && maxIsDollar) {
				if(Double.parseDouble(ftfMin.getText().replace("$", "").replace(",", "").trim()) 
					> Double.parseDouble(ftfMax.getText().replace("$", "").replace(",", "").trim())) {
					lblMinError.setText("Min value cannot be greater than Max value");
					lblMinError.setVisible(true);
					lblMaxError.setText("Max value cannot be less than Min value");
					lblMaxError.setVisible(true);
				}//if
				else {
					lblMinError.setVisible(false);
					lblMaxError.setVisible(false);
					//TODO: 1.) Apply the Greater than Filter
						myQuery.setPriceFilter("AND RetailPrice < " + ftfMax.getText().replace("$", "").replace(",", "").trim() + 
								" AND RetailPrice > " + ftfMin.getText().replace("$", "").replace(",", "").trim());
					//TODO 2.) Update the sticky price object 
						myPrices.setMin(Double.parseDouble(ftfMin.getText().replace("$", "").replace(",", "").trim()));
						myPrices.setMax(Double.parseDouble(ftfMax.getText().replace("$", "").replace(",", "").trim()));
						myPrices.setGreaterThanPrice(0.00);
						myPrices.setLessThanPrice(0.00);
						myPrices.setRetailPriceButtonState("Retail Button Filter: ON");
						myPrices.add(rdbtnRange);
						if (!myQuery.getCategoryFilter().isEmpty()) {myCheckBoxes.setCategoryButtonState("Category Filter: ON");}
					//TODO: 3.) Close Window
						this.dispose();
				}//else
			}//if
		}
	}//do_btnApplyAndClose_actionPerformed
	
	//*******************************************
	// Helper Methods
	//*******************************************
	protected void clearFTF(JFormattedTextField ftf) {
		if (ftf.getForeground() == Color.gray || ftf.getForeground() == Color.red) {
			ftf.setText("");
			ftf.setForeground(Color.black);
		}//if
	}//clearFTF
	
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
				lblError.setVisible(true);
				lblError.setText("Must be a positive dollar amount!");}
		} catch (NumberFormatException e) {
			ftf.setForeground(Color.red);
			lblError.setVisible(true);
			lblError.setText("Must only contain numeric values!");}
		return ans;
	}//isValidDollar
	
	protected void enableLessThanFilter() {
		//RadioButton:Less Than Option
		enableInput(ftfLessThanPrice, lblLessThanPrice, rdbtnLessThan);
			
		//Radio Button: Greater Than Option
		disableInput(ftfGreaterThanPrice, lblGreaterThanPrice, rdbtnGreaterThan);
		
		//Radio Button: Range Option
		disableInput(ftfMin, lblMin, rdbtnRange);
		disableInput(ftfMax, lblMax, rdbtnRange);
	}//enableLessThanFilter
	
	protected void enableGreaterThanFilter() {
		//RadioButton:Less Than Option
		disableInput(ftfLessThanPrice, lblLessThanPrice, rdbtnLessThan);
			
		//Radio Button: Greater Than Option
		enableInput(ftfGreaterThanPrice, lblGreaterThanPrice, rdbtnGreaterThan);
		
		//Radio Button: Range Option
		disableInput(ftfMin, lblMin, rdbtnRange);
		disableInput(ftfMax, lblMax, rdbtnRange);
	}//enableGreaterThanFilter
	
	protected void enableRangeFilter() {
		//RadioButton:Less Than Option
		disableInput(ftfLessThanPrice, lblLessThanPrice, rdbtnLessThan);
			
		//Radio Button: Greater Than Option
		disableInput(ftfGreaterThanPrice, lblGreaterThanPrice, rdbtnGreaterThan);
		
		//Radio Button: Range Option
		enableInput(ftfMin, lblMin, rdbtnRange);
		enableInput(ftfMax, lblMax, rdbtnRange);
	}//enableRangeFilter
	
	protected void disableInput(JFormattedTextField ftf, JLabel lbl, JRadioButton rdbtn) {
		ftf.disable();
		ftf.setBackground(Color.LIGHT_GRAY);
		ftf.setText(moneyFormat.format(0.00));
		ftf.setForeground(Color.black);
		lbl.disable();
		lbl.setForeground(Color.gray);
		rdbtn.setForeground(Color.gray);
	}//disableInput
	
	protected void enableInput(JFormattedTextField ftf, JLabel lbl, JRadioButton rdbtn) {
		ftf.enable();
		ftf.setBackground(Color.white);
		ftf.setForeground(Color.gray);
		lbl.enable();
		lbl.setForeground(Color.black);
		rdbtn.setForeground(Color.black);
	}//enableInput
}//class
