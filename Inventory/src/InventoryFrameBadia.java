import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class InventoryFrameBadia extends JFrame {
	
	//Static to avoid weird referencing issues
	static BadiaStickyCheckBoxes myCheckBoxes = new BadiaStickyCheckBoxes();
	
	//*******************************************
	// Declaring Components
	//*******************************************
	private JPanel contentPane;
	private final static JTable mainTable = new JTable();
	private final static JLabel lblStatus = new JLabel("Filtering By: NONE, Sortining By: NONE");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenuItem menuItemExit = new JMenuItem("Exit");
	private final JMenu mnTools = new JMenu("Tools");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem menuItemAddItem = new JMenuItem("Add Item");
	private final JLabel lblInventory = new JLabel("Inventory");
	private final JLabel lblResults = new JLabel("Results:");
	private final JMenu mnSetFilter = new JMenu("Set Filter");
	private final JMenuItem mntmByRetailPrice = new JMenuItem("By Retail Price");
	private final JMenuItem mntmByCategory = new JMenuItem("By Category");
	private final JMenu mnSetSort = new JMenu("Set Sort");
	private final JMenuItem mntmSortByName = new JMenuItem("By Name");
	private final JMenuItem mntmSortByRetailprice = new JMenuItem("By Retail Price");
	private final JMenuItem mntmByCategory_1 = new JMenuItem("By Category");
	private final JButton btnRetailPriceFilter = new JButton("Retail Price Filter: OFF");
	private final JButton btnCategoryFilter = new JButton("Category Filter: OFF");
	private final JButton btnSort = new JButton("Sort: OFF");
	private final JMenuItem mntmPageInfoHelp = new JMenuItem("Page Info");

	//*******************************************
	// Loading Driver
	//*******************************************
	private String conString = "jdbc:ucanaccess://C:/Users/Public/InventoryBadia.accdb";
	
	//*******************************************
	// Query Data Objects
	//*******************************************
	private BadiaQuery myQuery = new BadiaQuery();
	private BadiaQuery fakeQuery = new BadiaQuery();
	private BadiaStickyRetailPrice myPrices = new BadiaStickyRetailPrice();
	
	//*******************************************
	// Formatters
	//*******************************************
	NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryFrameBadia frame = new InventoryFrameBadia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InventoryFrameBadia() {
		jbInit();
	}
	private void jbInit() {
		
		//*******************************************
		// CONTENT PANE Initialization
		//*******************************************
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				do_this_windowGainedFocus(arg0);
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setTitle("Inventory");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1114, 769);
		
		//*******************************************
		// MENU BAR
		//*******************************************
		setJMenuBar(menuBar);
		mnFile.setFont(new Font("Courier New", Font.PLAIN, 12));
		menuBar.add(mnFile);
		
		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_menuItemExit_actionPerformed(arg0);
			}
		});
		menuItemExit.setFont(new Font("Courier New", Font.PLAIN, 12));
		mnFile.add(menuItemExit);
		
		mnTools.setFont(new Font("Courier New", Font.PLAIN, 12));
		menuBar.add(mnTools);
		
		menuItemAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_menuItemAddItem_actionPerformed(arg0);
			}
		});
		menuItemAddItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		mnTools.add(menuItemAddItem);
		
		mnSetSort.setFont(new Font("Courier New", Font.PLAIN, 12));
		mnTools.add(mnSetSort);
		
		mntmSortByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmSortByName_actionPerformed(e);
			}
		});
		mntmSortByName.setFont(new Font("Courier New", Font.PLAIN, 12));
		mnSetSort.add(mntmSortByName);
		
		mntmSortByRetailprice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmSortByRetailprice_actionPerformed(arg0);
			}
		});
		mntmSortByRetailprice.setFont(new Font("Courier New", Font.PLAIN, 12));
		mnSetSort.add(mntmSortByRetailprice);
		
		mntmByCategory_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByCategory_1_actionPerformed(e);
			}
		});
		mntmByCategory_1.setFont(new Font("Courier New", Font.PLAIN, 12));
		mnSetSort.add(mntmByCategory_1);
		
		mnSetFilter.setFont(new Font("Courier New", Font.PLAIN, 12));
		mnTools.add(mnSetFilter);
		
		mntmByRetailPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByRetailPrice_actionPerformed(e);
			}
		});
		mntmByRetailPrice.setFont(new Font("Courier New", Font.PLAIN, 12));
		mnSetFilter.add(mntmByRetailPrice);
		
		mntmByCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByCategory_actionPerformed(e);
			}
		});
		mntmByCategory.setFont(new Font("Courier New", Font.PLAIN, 12));
		mnSetFilter.add(mntmByCategory);
		
		mnHelp.setFont(new Font("Courier New", Font.PLAIN, 12));
		menuBar.add(mnHelp);
		
		mntmPageInfoHelp.setFont(new Font("Courier New", Font.PLAIN, 12));
		mntmPageInfoHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmPageInfoHelp_actionPerformed(e);
			}
		});
		mnHelp.add(mntmPageInfoHelp);
		
		//*******************************************
		// TABLE
		//*******************************************
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(26, 141, 875, 282);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(mainTable);
		mainTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Item ID", "Item Name", "Item Category", "Wholesale Price", "Retail Price", "Quantity On Hand", "Minimum Quantity", "Clerk"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		//*******************************************
		// Loading Driver
		//*******************************************
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
		mainTable.setFont(new Font("Courier New", Font.PLAIN, 12));
		mainTable.setToolTipText("Table showing current inventory of products based on filters and sort applied");
		
		//*******************************************
		// LABELS
		//*******************************************
		lblInventory.setFont(new Font("Courier New", Font.PLAIN, 36));
		lblInventory.setBounds(26, 62, 237, 72);
		contentPane.add(lblInventory);
		
		lblResults.setToolTipText("Number of items in the table");
		lblResults.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblResults.setBounds(786, 112, 115, 22);
		lblResults.setText("Total Results: 0");
		contentPane.add(lblResults);
		
		lblStatus.setToolTipText("Current sort settings");
		lblStatus.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblStatus.setBounds(36, 119, 671, 22);
		contentPane.add(lblStatus);
		
		//*******************************************
		// BUTTONS
		//*******************************************
		btnRetailPriceFilter.setToolTipText("Temporarily turn on/off the current retail price filter");
		btnRetailPriceFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRetailPriceFilter_actionPerformed(e);
			}
		});
		btnRetailPriceFilter.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnRetailPriceFilter.setBounds(36, 432, 227, 29);
		contentPane.add(btnRetailPriceFilter);
		btnRetailPriceFilter.setText(myPrices.getRetailPriceButtonState());
		btnCategoryFilter.setToolTipText("Temporarily turn on/off the current category filter");
		btnCategoryFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCategoryFilter_actionPerformed(arg0);
			}
		});
		btnCategoryFilter.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnCategoryFilter.setBounds(302, 432, 227, 29);
		
		contentPane.add(btnCategoryFilter);
		btnSort.setToolTipText("Temporarily turn on/off the current sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSort_actionPerformed(arg0);
			}
		});
		btnSort.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnSort.setBounds(567, 432, 227, 29);
		contentPane.add(btnSort);
		btnSort.setText("Sort: OFF");

		//*******************************************
		// Data Handling
		//*******************************************
		myQuery.setStatus("NONE");
		updateTable(myQuery);
	}//jbInit
	
	//*******************************************
	// Window GAINED Focus
	//*******************************************
	protected void do_this_windowGainedFocus(WindowEvent arg0) {
		System.out.println("Table updated");
		updateTable(myQuery);
	}
	
	//*******************************************
	// Menu Buttons ACTION PERFORMED
	//*******************************************
	protected void do_menuItemAddItem_actionPerformed(ActionEvent arg0) {
		AddItemFrameBadia addItem = new AddItemFrameBadia();
		addItem.setLocation(this.getX() + 30, this.getY() + 30);
		addItem.setVisible(true);
	}//do_menuItemAddItem_actionPerformed
	
	protected void do_mntmByCategory_actionPerformed(ActionEvent e) {
		BadiaFilterByCategoryFrame filterByCategory = new BadiaFilterByCategoryFrame(myQuery, myCheckBoxes, myPrices);
		filterByCategory.setLocation(this.getX() + 30, this.getY() + 30);
		filterByCategory.setVisible(true);
	}//do_mntmByCategory_actionPerformed
	
	protected void do_mntmByRetailPrice_actionPerformed(ActionEvent e) {
		BadiaFilterByRetailPriceFrame filterByRetailPrice = new BadiaFilterByRetailPriceFrame(myQuery, myPrices, myCheckBoxes);
		filterByRetailPrice.setLocation(this.getX() + 30, this.getY() + 30);
		filterByRetailPrice.setVisible(true);
	}//do_mntmByRetailPrice_actionPerformed
	
	protected void do_mntmSortByRetailprice_actionPerformed(ActionEvent arg0) {
		myQuery.setSort("ORDER BY RetailPrice ASC");
		btnSort.setText("Sort: ON");
		myQuery.setStatus("Retail Price");
		if (!myQuery.getCategoryFilter().isEmpty()) {myCheckBoxes.setCategoryButtonState("Category Filter: ON");}
		if (!myQuery.getPriceFilter().isEmpty()) {myPrices.setRetailPriceButtonState("Retail Price Filter: ON");}
		updateTable(myQuery);
	}//do_mntmSortByRetailprice_actionPerformed
	
	protected void do_mntmSortByName_actionPerformed(ActionEvent e) {
		myQuery.setSort("ORDER BY ItemName ASC");
		btnSort.setText("Sort: ON");
		myQuery.setStatus("Item Name");
		if (!myQuery.getCategoryFilter().isEmpty()) {myCheckBoxes.setCategoryButtonState("Category Filter: ON");}
		if (!myQuery.getPriceFilter().isEmpty()) {myPrices.setRetailPriceButtonState("Retail Price Filter: ON");}
		updateTable(myQuery);
	}//do_mntmSortByName_actionPerformed
	
	protected void do_mntmByCategory_1_actionPerformed(ActionEvent e) {
		myQuery.setSort("ORDER BY ItemCategory ASC");
		btnSort.setText("Sort: ON");
		myQuery.setStatus("Item Category");
		if (!myQuery.getCategoryFilter().isEmpty()) {myCheckBoxes.setCategoryButtonState("Category Filter: ON");}
		if (!myQuery.getPriceFilter().isEmpty()) {myPrices.setRetailPriceButtonState("Retail Price Filter: ON");}
		updateTable(myQuery);
	}//do_mntmByCategory_1_actionPerformed
	
	
	//*******************************************
	// Quick Filter BUTTONS
	//*******************************************
	protected void do_btnRetailPriceFilter_actionPerformed(ActionEvent e) {
		if (myPrices.getRetailPriceButtonState().equals("Retail Price Filter: OFF")) {
			btnRetailPriceFilter.setText("Retail Price Filter: ON");
			myPrices.setRetailPriceButtonState("Retail Price Filter: ON");
			fakeQuery.setPriceFilter(myQuery.getPriceFilter());
		} else {
			fakeQuery.setPriceFilter("");
			btnRetailPriceFilter.setText("Retail Price Filter: OFF");
			myPrices.setRetailPriceButtonState("Retail Price Filter: OFF");
		}//if-else
		updateTable(fakeQuery);
	}//do_btnRetailPriceFilter_actionPerformed
	
	protected void do_btnCategoryFilter_actionPerformed(ActionEvent arg0) {
		if (myCheckBoxes.getCategoryButtonState().equals("Category Filter: OFF")) {
			btnCategoryFilter.setText("Category Filter: ON");
			myCheckBoxes.setCategoryButtonState("Category Filter: ON");
			fakeQuery.setCategoryFilter(myQuery.getCategoryFilter());
		} else {
			fakeQuery.setCategoryFilter("");
			btnCategoryFilter.setText("Category Filter: OFF");
			myCheckBoxes.setCategoryButtonState("Category Filter: OFF");
		}//if-else
		updateTable(fakeQuery);
	}//do_btnCategoryFilter_actionPerformed
	
	protected void do_btnSort_actionPerformed(ActionEvent arg0) {
		if (btnSort.getText().equals("Sort: OFF")) {
			btnSort.setText("Sort: ON");
			fakeQuery.setSort(myQuery.getSort());
		} else {
			fakeQuery.setSort("");
			btnSort.setText("Sort: OFF");
		}//if-else
		updateTable(fakeQuery);
	}//do_btnSort_actionPerformed
	
	protected void do_menuItemExit_actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}//do_menuItemExit_actionPerformed
	
	protected void do_mntmPageInfoHelp_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, 
				"<HTML> "
				+ "<body font-size = \"1rem\">"
				+ "<H1> Help Info Page </H1> "
				+ "<ul> "
				+ "<h3> Add Item Field Descriptions </h3> "
				+ "<li> Item ID: an integer that is used to index the item in the inventory. Will not accept duplicate a Item Id. (REQUIRED) </li> "
				+ "<li> Item Name: the name of the item that your are adding to the inventory. Will not accept a duplicate Item Name. (REQUIRED) </li> "
				+ "<li> Item Cetegory: the category of the item you are adding to the inventory. (REQUIRED) </li> "
				+ "<li> Wholesale Price: the price charged for a product usually sold in bulk to other businesses. (REQUIRED) </li> "
				+ "<li> Retail Price: the price charged for a product usually sold to a consumer. (REQUIRED) </li> "
				+ "<li> Quantity On Hand (QOH): current number of items in stock. (REQUIRED) </li> "
				+ "<li> Minumum Quantity (MinQuant): minimum number of items to be in the inentory. (REQUIRED) </li> "
				+ "<li> Clerk: this is the name of the person who last updated the record. (REQUIRED) </li> "
				+ "</ul> "
				+ "<ul> "
				+ "<h3> Filter Field Descriptions </h3> "
				+ "<li> Less Than Retail Price: Show only items LESS than a given price. </li> "
				+ "<li> Greater Than Retail Price: Show only items GREATER than a given price. </li> "
				+ "<li> Range Retail Price: Show only items in a RANGE of given prices. </li> "
				+ "<li> Filter By Category: </li>"
				+ "<li> Show only items in the selected categorie(s) </li> "
				+ "</ul> " 
				+ "<ul> "
				+ "<h3> Sort Option Descriptions </h3> "
				+ "<li> Sort By Retail Price: Items are listed by retail price in ascending order. </li> "
				+ "<li> Sort By Category: Items are listed by their category's alphabetical position, ascending. </li> "
				+ "<li> Sort By Name: Items are listed their name's alphabetical position, ascending </li> "
				+ "</ul> "
				+ "<br><br><br> "
				+ "</body>"
				+ "</html>",
				"Page Info Help", JOptionPane.INFORMATION_MESSAGE);
	}//do_mntmPageInfoHelp_actionPerformed
	
	//*******************************************
	// Helper Methods
	//*******************************************
	protected void updateTable(BadiaQuery query) {
		Statement statement = null;
		ResultSet results = null;
		try {
			//2.) Establish the connection
			Connection connection = DriverManager.getConnection(conString);
			
			//3.) Create SQL
			statement = connection.createStatement();	
			
			//4.) Execute
			System.out.println(query.getQuery());
			results = statement.executeQuery(query.getQuery());
			//5.) Process results
			
			//Remove previously added rows from the JTable
			while(mainTable.getRowCount() > 0) { //while there are still rows in the table
				((DefaultTableModel) mainTable.getModel()).removeRow(0); //remove the first row
			}//while
			
			//How many columns in the result set???
			int numColumns = results.getMetaData().getColumnCount();
			
			while (results.next()) {
				//Create an object array to hold a single record
				Object [] row = new Object[numColumns];
				
				//Grab each field of the record and put it into the row
				for (int i = 0; i < numColumns; i++) {
					row[i] = results.getObject(i+1);
				}//for
				
				//insert the row into the table
				((DefaultTableModel) mainTable.getModel()).insertRow(results.getRow() - 1, row);
				
				try {
					mainTable.setValueAt(moneyFormat.format(mainTable.getValueAt(results.getRow() - 1, 3)), results.getRow() - 1, 3);
					mainTable.setValueAt(moneyFormat.format(mainTable.getValueAt(results.getRow() - 1, 4)), results.getRow() - 1, 4);
				} 
				catch (NumberFormatException e) {
					System.out.println("Money Format Error: " + e.getMessage());
					System.out.println(e.getMessage());
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}//while
			
			
			
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
		
		lblStatus.setText(myQuery.getStatus());
		lblResults.setText("Total Results: " +  mainTable.getRowCount());
		btnRetailPriceFilter.setText(myPrices.getRetailPriceButtonState());
		btnCategoryFilter.setText(myCheckBoxes.getCategoryButtonState());
	}//updateTable

}//InventoryFrameBadia
