import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BadiaFilterByCategoryFrame extends JFrame {

	private JPanel contentPane;
	
	//Static to avoid weird referencing issues,
	//When trying to make these check boxes 'sticky'
	private final static JCheckBox chckbxDairy = new JCheckBox("Dairy");
	private final static JCheckBox chckbxMeat = new JCheckBox("Meat");
	private final static JCheckBox chckbxFrozen = new JCheckBox("Frozen");
	private final static JCheckBox chckbxCanned = new JCheckBox("Canned");
	private final static JCheckBox chckbxProduce = new JCheckBox("Produce");
	private final static JCheckBox chckbxBeverage = new JCheckBox("Beverage");
	private final static JCheckBox chckbxPaper = new JCheckBox("Paper");
	private final static JCheckBox chckbxSnack = new JCheckBox("Snack");
	private final static JCheckBox chckbxCereal = new JCheckBox("Cereal");
	private final static JCheckBox chckbxOther = new JCheckBox("Other");
	
	private final JLabel lblNewLabel = new JLabel("Filter By Category");
	private final JSeparator separator = new JSeparator();
	private final JButton btnCancel = new JButton("Cancel");
	private final JButton btnApplyAndClose = new JButton("Apply and Close");
	private final JLabel lblDirections = new JLabel("Select the following categories to filter by...");
	private final JLabel errorLabel = new JLabel("Error");

	//Declaring a query object to reference the query from the main page
	private BadiaQuery myQuery;
	
	//Declaring the Check Boxes Object
	private BadiaStickyCheckBoxes myCheckBoxes;
	private BadiaStickyRetailPrice myPrices;


	/**
	 * Create the frame.
	 */
	public BadiaFilterByCategoryFrame(BadiaQuery newQuery, BadiaStickyCheckBoxes newCheckBoxes, BadiaStickyRetailPrice newPrices) {
		myQuery = newQuery;
		myCheckBoxes = newCheckBoxes;
		myPrices = newPrices;
		jbInit();
	}//constructor
	
	private void jbInit() {
		//*******************************************
		// Content Pane Initialization
		//*******************************************
		setTitle("Filter By Category");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//*******************************************
		// HEADING Labels
		//*******************************************
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 24));
		lblNewLabel.setBounds(26, 28, 292, 33);
		contentPane.add(lblNewLabel);
		
		lblDirections.setFont(new Font("Courier New", Font.ITALIC, 12));
		lblDirections.setBounds(36, 59, 388, 33);
		contentPane.add(lblDirections);
		
		//*******************************************
		// ERROR Labels
		//*******************************************
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		errorLabel.setBounds(214, 485, 335, 33);
		contentPane.add(errorLabel);
		errorLabel.setVisible(false);
		
		separator.setBounds(26, 59, 470, 2);
		contentPane.add(separator);
		
		//*******************************************
		// CHECK BOXES
		//*******************************************
		chckbxDairy.setFont(new Font("Courier New", Font.PLAIN, 12));
		chckbxDairy.setBounds(36, 108, 171, 41);
		contentPane.add(chckbxDairy);
		
		chckbxMeat.setFont(new Font("Courier New", Font.PLAIN, 12));
		chckbxMeat.setBounds(36, 169, 171, 41);
		contentPane.add(chckbxMeat);
		
		chckbxFrozen.setFont(new Font("Courier New", Font.PLAIN, 12));
		chckbxFrozen.setBounds(36, 230, 171, 41);
		contentPane.add(chckbxFrozen);
		
		chckbxCanned.setFont(new Font("Courier New", Font.PLAIN, 12));
		chckbxCanned.setBounds(36, 291, 171, 41);
		contentPane.add(chckbxCanned);
		
		chckbxProduce.setFont(new Font("Courier New", Font.PLAIN, 12));
		chckbxProduce.setBounds(36, 352, 171, 41);
		contentPane.add(chckbxProduce);
		
		chckbxBeverage.setFont(new Font("Courier New", Font.PLAIN, 12));
		chckbxBeverage.setBounds(225, 105, 221, 41);
		contentPane.add(chckbxBeverage);
		
		chckbxPaper.setFont(new Font("Courier New", Font.PLAIN, 12));
		chckbxPaper.setBounds(225, 169, 221, 41);
		contentPane.add(chckbxPaper);
		
		chckbxSnack.setFont(new Font("Courier New", Font.PLAIN, 12));
		chckbxSnack.setBounds(225, 230, 221, 41);
		contentPane.add(chckbxSnack);
		
		chckbxCereal.setFont(new Font("Courier New", Font.PLAIN, 12));
		chckbxCereal.setBounds(225, 291, 221, 41);
		contentPane.add(chckbxCereal);
		
		chckbxOther.setFont(new Font("Courier New", Font.PLAIN, 12));
		chckbxOther.setBounds(225, 352, 221, 41);
		contentPane.add(chckbxOther);
		
		//*******************************************
		// BUTTONS
		//*******************************************
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCancel_actionPerformed(arg0);
			}
		});
		btnCancel.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnCancel.setBounds(36, 417, 152, 41);
		contentPane.add(btnCancel);
		
		btnApplyAndClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnApplyAndClose_actionPerformed(e);
			}
		});
		btnApplyAndClose.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnApplyAndClose.setBounds(36, 477, 152, 41);
		contentPane.add(btnApplyAndClose);
		
		//*******************************************
		// Making Check Boxes STICKY
		//*******************************************
		if (!myCheckBoxes.isEmpty()) {
			int pos = 0;
			for (pos = 0; pos < myCheckBoxes.getCheckedCheckBoxes().size(); pos++) {
				myCheckBoxes.getCheckedCheckBoxes().get(pos).setSelected(true);
			}//for
			myCheckBoxes.removeAll();
		}//if
		
	}//jbInit
	
	
	//*******************************************
	// BUTTON Methods
	//*******************************************
	protected void do_btnApplyAndClose_actionPerformed(ActionEvent e) 
	{
		//TODO 1a.) Check if there are any check boxes checked
		
			ArrayList<String> categories = new ArrayList<String>();
			
			if (chckbxDairy.isSelected()) 
			{
				categories.add("Dairy");
				JCheckBox Dairy = chckbxDairy;
				myCheckBoxes.add(Dairy);
			}//if
			
			if (chckbxMeat.isSelected()) 
			{
				categories.add("Meat");
				myCheckBoxes.add(chckbxMeat);
			}//if
			
			if (chckbxFrozen.isSelected()) 
			{
				categories.add("Frozen");
				myCheckBoxes.add(chckbxFrozen);
			}//if
			
			if (chckbxCanned.isSelected()) 
			{
				categories.add("Canned");
				myCheckBoxes.add(chckbxCanned);
			}//if
			
			if (chckbxProduce.isSelected()) 
			{
				categories.add("Produce");
				myCheckBoxes.add(chckbxProduce);
			}//if
			
			if (chckbxBeverage.isSelected()) 
			{
				categories.add("Beverage");
				myCheckBoxes.add(chckbxBeverage);
			}//if
			
			if (chckbxPaper.isSelected()) 
			{
				categories.add("Paper");
				myCheckBoxes.add(chckbxPaper);
			}//if
			
			if (chckbxSnack.isSelected()) 
			{
				categories.add("Snack");
				myCheckBoxes.add(chckbxSnack);
			}//if
			
			if (chckbxCereal.isSelected()) 
			{
				categories.add("Cereal");
				myCheckBoxes.add(chckbxCereal);
			}//if
			
			if (chckbxOther.isSelected()) 
			{
				categories.add("Other");
				myCheckBoxes.add(chckbxOther);
			}//if
			
			if(!categories.isEmpty()) 
			{
				errorLabel.setVisible(false);
				
				//TODO: 2.) Build category filter
				String ans = "AND ( (1 = 0) ";
				for (int i = 0; i < categories.size(); i++) 
				{
					if (i == categories.size() - 1) 
					{	
						ans += " OR (ItemCategory = '" + categories.get(i) + "' ))"; 
					} else ans += " OR (ItemCategory = '" + categories.get(i) + "')"; 
				}//for
				
				//TODO: 3.) Implement category filter into the query
					myQuery.setCategoryFilter(ans);
					
				//TODO 4.) Update the table and close the window
					myCheckBoxes.setCategoryButtonState("Category Filter: ON");
					if (!myQuery.getPriceFilter().isEmpty()) 
					{
						myPrices.setRetailPriceButtonState("Retail Price Filter: ON");
					}//if
					this.dispose();
			}//for
			else 
			{
				//TODO: 1b.) Create an error message if no filter is selected
				errorLabel.setText("You did not select any categories!");
				errorLabel.setVisible(true);
			}//else
	}//do_btnNewButton_1_actionPerformed
	
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) 
	{
		this.dispose();
	}//do_btnNewButton_actionPerformed
}//class
