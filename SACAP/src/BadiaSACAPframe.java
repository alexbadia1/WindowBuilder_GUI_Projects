import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JLayeredPane;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Component;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;
import java.util.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Component;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class BadiaSACAPframe extends JFrame {
	
	private JPanel contentPane;
	
	//Declaring masks
	MaskFormatter socialSecurityMask = createFormatter("###-##-####");
	MaskFormatter zipCodeMask = createFormatter("#####");
	MaskFormatter spouseSocialSecurityMask = createFormatter("###-##-####");
	MaskFormatter resident1SocialSecurityMask = createFormatter("###-##-####");
	MaskFormatter resident2SocialSecurityMask = createFormatter("###-##-####");
	MaskFormatter resident3SocialSecurityMask = createFormatter("###-##-####");
	MaskFormatter resident4SocialSecurityMask = createFormatter("###-##-####");
	MaskFormatter resident5SocialSecurityMask = createFormatter("###-##-####");
	MaskFormatter resident6SocialSecurityMask = createFormatter("###-##-####");
	MaskFormatter phoneNumberMask = createFormatter("(###)-###-####");
	
	//Declaring money formatters
	NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM//dd/yyyy");
	Date date = new Date();
	
	//Declaring Error Arrays

	
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JLayeredPane applicantInfoPanel = new JLayeredPane();
	private final JPanel householdInfoPanel = new JPanel();
	private final JPanel financialInfoPanel = new JPanel();
	private final JLabel lblFirstName = new JLabel("First Name:");
	private final JLabel lblLastName = new JLabel("Last Name: ");
	private final JLabel lblDateOfBirth = new JLabel("Date of Birth:");
	private final JLabel lblSocialSecurityNumber = new JLabel("Social Security Number:");
	private final JLabel lblAddress = new JLabel("Address:");
	private final JLabel lblCity = new JLabel("City: ");
	private final JLabel lblCounty = new JLabel("County:");
	private final JLabel lblZipCode = new JLabel("ZIP Code:");
	private final JLabel lblPhoneNumber = new JLabel("Preferred Phone Number:");
	private final JLabel lblAboutMe = new JLabel("Identification and Contact");
	private final JSeparator separator = new JSeparator();
	private final JComboBox comboBoxDay = new JComboBox();
	private final JComboBox comboBoxMonth = new JComboBox();
	private final JComboBox comboBoxYear = new JComboBox();
	private final JLabel lblEthnicity = new JLabel("Please select one of the following ethnicities:");
	private final JRadioButton rdbtnWhite = new JRadioButton("White");
	private final JRadioButton rdbtnBlack = new JRadioButton("Black");
	private final JRadioButton rdbtnHispanic = new JRadioButton("Hispanic");
	private final JRadioButton rdbtnAsian = new JRadioButton("Asian");
	private final JRadioButton rdbtnAmerican = new JRadioButton("American");
	private final JRadioButton rdbtnIndian = new JRadioButton("Indian");
	private final JRadioButton rdbtnOther = new JRadioButton("Other");
	private final JLabel lblLocation = new JLabel("Location");
	private final JSeparator separator_1 = new JSeparator();
	private final JComboBox comboBoxCounty = new JComboBox();
	private final JSeparator separator_4 = new JSeparator();
	private final JFormattedTextField formattedTextFieldSocialSecurityNumber = new JFormattedTextField();
	private final JFormattedTextField formattedTextFieldPhoneNumber = new JFormattedTextField();
	private final JLabel lblEmployment = new JLabel("Employment");
	private final JSeparator separator_6 = new JSeparator();
	private final JLabel lblEmployedQuestion = new JLabel("Are you employed?");
	private final JRadioButton rdbtnYes = new JRadioButton("Yes");
	private final JRadioButton rdbtnNo = new JRadioButton("No");
	private final JLabel lblIfYes = new JLabel("If yes, place of employement:");
	private final JTextField lblPlaceEmployed = new JTextField();
	private final JLabel lblIfNo = new JLabel("If no, how long?");
	private final JComboBox comboBoxMonthsUnemployed = new JComboBox();
	private final JComboBox comboBoxDaysUnemployed = new JComboBox();
	private final JComboBox comboBoxYearsUnemployed = new JComboBox();
	private final JLabel lblPresentProblem = new JLabel("Present Problem");
	private final JSeparator separator_8 = new JSeparator();
	private final ButtonGroup ethnicityButtonGroup = new ButtonGroup();
	private final JLabel lblAssistanceRequested = new JLabel("Assistance you are requesting: ");
	private final JLabel lblReferredBy = new JLabel("Referred By:");
	private final JSeparator separator_10 = new JSeparator();
	private final JLabel lblHouseholdResidents = new JLabel("Household Residents");
	private final JLabel lblHouseholdDirections = new JLabel("List anyone in your household, OTHER than you or your spouse:");
	private final JLabel lblResidentFirstName_1 = new JLabel("First Name:");
	private final JLabel lblResidentLastName_1 = new JLabel("Last Name:");
	private final JLabel lblRelationship_1 = new JLabel("Relationship:");
	private final JComboBox comboBoxRelationship_1 = new JComboBox();
	private final JLabel lblAge_1 = new JLabel("Age:");
	private final JComboBox comboBoxAge_1 = new JComboBox();
	private final JLabel lblResidentSocialSecurityNumber_1 = new JLabel("Social Security Number:");
	private final JLabel lblResidentFirstName_2 = new JLabel("First Name:");
	private final JLabel lblResidentLastName_2 = new JLabel("Last Name:");
	private final JLabel lblRelationship_2 = new JLabel("Relationship:");
	private final JLabel lblAge_2 = new JLabel("Age:");
	private final JLabel lblResidentSocialSecurityNumber_2 = new JLabel("Social Security Number:");
	private final JComboBox comboBoxAge_2 = new JComboBox();
	private final JComboBox comboBoxRelationship_2 = new JComboBox();
	private final JLabel lblResidentFirstName_3 = new JLabel("First Name:");
	private final JLabel lblResidentLastName_3 = new JLabel("Last Name:");
	private final JLabel lblRelationship_3 = new JLabel("Relationship:");
	private final JLabel lblAge_3 = new JLabel("Age:");
	private final JLabel lblResidentSocialSecurityNumber_3 = new JLabel("Social Security Number:");
	private final JComboBox comboBoxAge_3 = new JComboBox();
	private final JComboBox comboBoxRelationship_3 = new JComboBox();
	private final JSeparator separator_2 = new JSeparator();
	private final JLabel lblIncome = new JLabel("Income");
	private final JLabel lblIncomedirections = new JLabel("Income of ANYONE living in your household INCLUDING YOURSELF:");
	private final JLabel lblSalary = new JLabel("Salary:");
	private final JLabel lblUnemployment = new JLabel("Unemployment:");
	private final JLabel lbltanf = new JLabel("TANF/AFDC:");
	private final JLabel lblSocialsecurity = new JLabel("Social Security:");
	private final JLabel lblDisability = new JLabel("Disability:");
	private final JLabel lblChildSupport = new JLabel("Child Support:");
	private final JLabel lblUtilityAssistance = new JLabel("Utility Assistance:");
	private final JLabel lblFoodStamps = new JLabel("Food Stamps:");
	private final JLabel lblOther = new JLabel("Other:");
	private final JFormattedTextField FTFSalary = new JFormattedTextField();
	private final JFormattedTextField FTFUnemployment = new JFormattedTextField();
	private final JFormattedTextField FTFtanf = new JFormattedTextField();
	private final JFormattedTextField FTFSocialSecurity = new JFormattedTextField();
	private final JFormattedTextField FTFDisability = new JFormattedTextField();
	private final JFormattedTextField FTFChildSupport = new JFormattedTextField();
	private final JFormattedTextField FTFUtilityAssistance = new JFormattedTextField();
	private final JFormattedTextField FTFFoodStamps = new JFormattedTextField();
	private final JFormattedTextField FTFOther = new JFormattedTextField();
	private final JSeparator separator_3 = new JSeparator();
	private final JLabel lblSpouseIdentification = new JLabel("Spouse Identification");
	private final JLabel lblSpouseFirstName = new JLabel("First Name:");
	private final JLabel lblSpouseLastName = new JLabel("Last Name:");
	private final JLabel lblSpouseDateOfBirth = new JLabel("Date of Birth:");
	private final JLabel lblSpouseSocialSecurityNumber = new JLabel("Social Security Number:");
	private final JFormattedTextField formattedTextFieldSpouseSocialSecurityNumber = new JFormattedTextField();
	private final JComboBox comboBoxSpouseMonth = new JComboBox();
	private final JComboBox comboBoxSpouseDay = new JComboBox();
	private final JComboBox comboBoxSpouseYear = new JComboBox();
	private final JSeparator separator_5 = new JSeparator();
	private final JLabel lblSpouseEmployment = new JLabel("Spouse Employment");
	private final JLabel lblSpouseEmployedQuestion = new JLabel("Are you unemployed?");
	private final JRadioButton rdbtnSpouseYes = new JRadioButton("Yes");
	private final JRadioButton rdbtnSpouseNo = new JRadioButton("No");
	private final JLabel lblSpouseIfYes = new JLabel("If yes, place of employement:");
	private final JTextField textField_2 = new JTextField();
	private final JLabel lblSpouseIfNo = new JLabel("If no, how long?");
	private final JComboBox comboBoxSpouseMonthsUnemployed = new JComboBox();
	private final JComboBox comboBoxSpouseDaysUnemployed = new JComboBox();
	private final JComboBox comboBoxSpouseYearsUnemployed = new JComboBox();
	private final JSeparator separator_7 = new JSeparator();
	private final JLabel lblSpouseEthnicity = new JLabel("Please select one of the following ethnicities:");
	private final JRadioButton rdbtnSpouseWhite = new JRadioButton("White");
	private final JRadioButton rdbtnSpouseBlack = new JRadioButton("Black");
	private final JRadioButton rdbtnSpouseHispanic = new JRadioButton("Hispanic");
	private final JRadioButton rdbtnSpouseAsian = new JRadioButton("Asian");
	private final JRadioButton rdbtnSpouseAmerican = new JRadioButton("American");
	private final JRadioButton rdbtnSpouseIndian = new JRadioButton("Indian");
	private final JRadioButton rdbtnSpouseOther = new JRadioButton("Other");
	private final ButtonGroup spouseEthnicityButtonGroup = new ButtonGroup();
	private final JSeparator separator_9 = new JSeparator();
	private final JLabel lblResidentFirstName_4 = new JLabel("First Name:");
	private final JLabel lblResidentLastName_4 = new JLabel("Last Name:");
	private final JLabel lblRelationship_3_1 = new JLabel("Relationship:");
	private final JComboBox comboBoxRelationship_4 = new JComboBox();
	private final JLabel lblAge_4 = new JLabel("Age:");
	private final JComboBox comboBoxAge_4 = new JComboBox();
	private final JLabel lblResidentSocialSecurityNumber_4 = new JLabel("Social Security Number:");
	private final JLabel lblResidentFirstName_5 = new JLabel("First Name:");
	private final JLabel lblResidentLastName_5 = new JLabel("Last Name:");
	private final JLabel lblRelationship_3_2 = new JLabel("Relationship:");
	private final JComboBox comboBoxRelationship_5 = new JComboBox();
	private final JLabel lblAge_5 = new JLabel("Age:");
	private final JComboBox comboBoxAge_5 = new JComboBox();
	private final JLabel lblResidentSocialSecurityNumber_5 = new JLabel("Social Security Number:");
	private final JLabel lblResidentFirstName_6 = new JLabel("First Name:");
	private final JLabel lblResidentLastName_6 = new JLabel("Last Name:");
	private final JLabel lblRelationship_3_3 = new JLabel("Relationship:");
	private final JComboBox comboBoxRelationship_6 = new JComboBox();
	private final JLabel lblAge_6 = new JLabel("Age:");
	private final JComboBox comboBoxAge_6 = new JComboBox();
	private final JLabel lblResidentSocialSecurityNumber_6 = new JLabel("Social Security Number:");
	private final JSeparator separator_11 = new JSeparator();
	private final JLabel lblResident_1 = new JLabel("Resident 1");
	private final JLabel lblResident_2 = new JLabel("Resident 2");
	private final JLabel lblResident_3 = new JLabel("Resident 3");
	private final JLabel lblResident_6 = new JLabel("Resident 6");
	private final JLabel lblResident_5 = new JLabel("Resident 5");
	private final JLabel lblResident_5_1 = new JLabel("Resident 4");
	private final JLabel lblHouseholdApplicant = new JLabel("Applicant: <Name Goes Here>");
	private final JTextPane txtpnProblem = new JTextPane();
	private final JLabel lblidentificationAndContactErrorMessage = new JLabel("Error Message");
	private final JLabel lblLocationErrorMessage = new JLabel("Error Message");
	private final JLabel lblEmploymentErrorMessage = new JLabel("Error Message");
	private final JLabel lblPresentProblemErrorMessage = new JLabel("Error Message");
	private final JLabel lblSpouseEmployementErrorMessage = new JLabel("Error Message");
	private final JLabel lblSpouseIdentificationErrorMessage = new JLabel("Error Message");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JSeparator separator_2_1 = new JSeparator();
	private final JLabel lblExpenses = new JLabel("Expenses");
	private final JLabel lblExpenseDirections = new JLabel("MONTHLY expenses of each category listed:");
	private final JLabel lblRent = new JLabel("Rent:");
	private final JFormattedTextField FTFRent = new JFormattedTextField();
	private final JLabel lblPhoneBill = new JLabel("Phone Bill:");
	private final JFormattedTextField FTFPhoneBill = new JFormattedTextField();
	private final JLabel lblGasWater = new JLabel("Gas/Water:");
	private final JFormattedTextField FTFGasWater = new JFormattedTextField();
	private final JLabel lblLightBill = new JLabel("Light Bill:");
	private final JFormattedTextField FTFLightBill = new JFormattedTextField();
	private final JLabel lblCarPayment = new JLabel("Car Payment:");
	private final JFormattedTextField FTFCarPayment = new JFormattedTextField();
	private final JLabel lblFurnaceAppliances = new JLabel("Furnace/Appliances:");
	private final JFormattedTextField FTFFurnaceAppliances = new JFormattedTextField();
	private final JLabel lblCableTV = new JLabel("Cable TV:");
	private final JFormattedTextField FTFCableTV = new JFormattedTextField();
	private final JSeparator separator_12 = new JSeparator();
	private final JLabel lblDoctorMedical = new JLabel("Doctor/Medical:");
	private final JFormattedTextField FTFDoctorMedical = new JFormattedTextField();
	private final JLabel lblOtherExpenses = new JLabel("Other:");
	private final JFormattedTextField FTFOtherExpenses = new JFormattedTextField();
	private final JTextPane txtpnExplainExpenses = new JTextPane();
	private final JSeparator separator_2_2 = new JSeparator();
	private final JLabel lblFinancialSummary = new JLabel("Financial Summary");
	private final JLabel lblTotalIncome = new JLabel("Total Income:");
	private final JLabel lblTotalExpenses = new JLabel("Total Expenses:");
	private final JLabel lblNetIncome = new JLabel("Net Income:");
	private final JSeparator separator_13 = new JSeparator();
	private final JLabel lblTotalIncomeValue = new JLabel("$0.00");
	private final JLabel lblTotalExpensesValue = new JLabel("$0.00");
	private final JLabel lblNetIncomeValue = new JLabel("$0.00");
	private final JLabel lblNewLabel_3 = new JLabel("or");
	private final JLabel lblNewLabel_3_1 = new JLabel("or");
	private final JLabel lblEmploymedOr = new JLabel("or");
	private final JLabel lblNewLabel_3_3 = new JLabel("or");
	private final JLabel lblNewLabel_3_4 = new JLabel("or");
	private final JLabel lblNewLabel_3_5 = new JLabel("or");
	private final ButtonGroup unemployedButtonGroup = new ButtonGroup();
	private final ButtonGroup spouseUnemployedButtonGroup = new ButtonGroup();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmStartNewApplication = new JMenuItem("Start New Application");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JFormattedTextField FTFLastName = new JFormattedTextField();
	private final JFormattedTextField FTFFirstName = new JFormattedTextField();
	private final JFormattedTextField FTFCity = new JFormattedTextField();
	private final JFormattedTextField FTFSpouseFirstName = new JFormattedTextField();
	private final JFormattedTextField FTFSpouseLastName = new JFormattedTextField();
	private final JFormattedTextField FTFReferredBy = new JFormattedTextField();
	private final JFormattedTextField FTFZipCode = new JFormattedTextField();
	private final JFormattedTextField FTFAssistanceRequested = new JFormattedTextField();
	private final JFormattedTextField FTFResidentFirstName_1 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentLastName_1 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentSocialSecurityNumber_1 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentSocialSecurityNumber_2 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentSocialSecurityNumber_3 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentSocialSecurityNumber_4 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentSocialSecurityNumber_5 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentSocialSecurityNumber_6 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentFirstName_2 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentLastName_2 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentFirstName_3 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentLastName_3 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentFirstName_4 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentLastName_4 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentFirstName_5 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentLastName_5 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentFirstName_6 = new JFormattedTextField();
	private final JFormattedTextField FTFResidentLastName_6 = new JFormattedTextField();
	private final JTextPane txtpnExplainIncome = new JTextPane();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JFormattedTextField FTFAddress = new JFormattedTextField();
	private final JMenuItem mntmApplicantInfoHelp = new JMenuItem("Applicant Info Help");
	private final JMenuItem mntmHouseholdDetails = new JMenuItem("Household Info Help");
	private final JMenuItem mntmFinancialInfoHelp = new JMenuItem("Financial Info Help");
	private final JLabel lblFinancialInfoApplicant = new JLabel("Applicant: <Name Goes Here>");
	private final JTextPane txtpnToWhomIt = new JTextPane();
	private final JTextField FTFDate = new JTextField();
	private final JLabel lblIncomeError = new JLabel("Fields cannot contain negative or alphabetical characters");
	private final JLabel lblExpenseError = new JLabel("Fields cannot contain negative or alpabetical characters");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BadiaSACAPframe frame = new BadiaSACAPframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MaskFormatter createFormatter(String s) {
	     MaskFormatter formatter = null;
	     try {
	          formatter = new MaskFormatter(s);
	         } 
	     catch (java.text.ParseException exc) {
		          System.err.println("formatter is bad: " + exc.getMessage());
		          System.exit(-1);
		      }
	      return formatter;
	}//createFormatter

	/**
	 * Create the frame.
	 */
	public BadiaSACAPframe() {
		jbInit();
	}
	
	private void jbInit() {
		setVisible(true);
		setTitle("Badia The Salvation Army Client Association Application");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1145, 1184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{
				FTFFirstName, FTFLastName, comboBoxMonth, comboBoxDay, comboBoxYear,
				formattedTextFieldSocialSecurityNumber, formattedTextFieldPhoneNumber,
				rdbtnWhite, rdbtnBlack,rdbtnHispanic, rdbtnAsian, rdbtnAmerican,
				rdbtnIndian, rdbtnOther, FTFAddress, FTFCity, comboBoxCounty, FTFZipCode,
				rdbtnYes, rdbtnNo, lblPlaceEmployed, comboBoxMonthsUnemployed,
				comboBoxDaysUnemployed, comboBoxYearsUnemployed, FTFSpouseFirstName,
				FTFSpouseLastName, comboBoxSpouseMonth, comboBoxSpouseDay, comboBoxSpouseYear,
				formattedTextFieldSpouseSocialSecurityNumber, rdbtnSpouseWhite,
				rdbtnSpouseBlack, rdbtnSpouseHispanic, rdbtnSpouseAsian, rdbtnSpouseAmerican,
				rdbtnSpouseIndian, rdbtnSpouseOther, rdbtnSpouseYes, rdbtnSpouseNo,
				lblSpouseIfYes, comboBoxSpouseMonthsUnemployed, comboBoxSpouseDaysUnemployed,
				comboBoxSpouseYearsUnemployed, FTFAssistanceRequested, FTFReferredBy, txtpnProblem, 
				FTFResidentFirstName_1, FTFResidentLastName_1, comboBoxRelationship_1, comboBoxAge_1, FTFResidentSocialSecurityNumber_1, 
				FTFResidentFirstName_2, FTFResidentLastName_2, comboBoxRelationship_2, comboBoxAge_2, FTFResidentSocialSecurityNumber_2,
				FTFResidentFirstName_3, FTFResidentLastName_3, comboBoxRelationship_3, comboBoxAge_3, FTFResidentSocialSecurityNumber_3,
				FTFResidentFirstName_4, FTFResidentLastName_4, comboBoxRelationship_4, comboBoxAge_4, FTFResidentSocialSecurityNumber_4,
				FTFResidentFirstName_5, FTFResidentLastName_5, comboBoxRelationship_5, comboBoxAge_5, FTFResidentSocialSecurityNumber_5,
				FTFResidentFirstName_6, FTFResidentLastName_6, comboBoxRelationship_6, comboBoxAge_6, FTFResidentSocialSecurityNumber_6,
				FTFSalary, FTFUnemployment, FTFtanf, FTFSocialSecurity, FTFDisability, FTFChildSupport,
				FTFUtilityAssistance, FTFFoodStamps, FTFOther, txtpnExplainIncome, FTFRent, FTFPhoneBill, FTFGasWater, FTFLightBill,
				FTFCarPayment, FTFFurnaceAppliances, FTFCableTV, FTFDoctorMedical, FTFOtherExpenses, txtpnExplainExpenses}));
	
		tabbedPane.setBounds(0, 26, 1129, 1035);
		
		moneyFormat.setMinimumFractionDigits(2);
		
		//Setting placeholder for masks
		socialSecurityMask.setPlaceholderCharacter('#');
		phoneNumberMask.setPlaceholderCharacter('#');
		zipCodeMask.setPlaceholderCharacter('#');
		spouseSocialSecurityMask.setPlaceholderCharacter('#');
		resident1SocialSecurityMask.setPlaceholderCharacter('#');
		resident2SocialSecurityMask.setPlaceholderCharacter('#');
		resident3SocialSecurityMask.setPlaceholderCharacter('#');
		resident4SocialSecurityMask.setPlaceholderCharacter('#');
		resident5SocialSecurityMask.setPlaceholderCharacter('#');
		resident6SocialSecurityMask.setPlaceholderCharacter('#');
		
		contentPane.add(tabbedPane);
		//Install the mask
		socialSecurityMask.install(formattedTextFieldSocialSecurityNumber);
		spouseSocialSecurityMask.install(formattedTextFieldSpouseSocialSecurityNumber);
		phoneNumberMask.install(formattedTextFieldPhoneNumber);
		zipCodeMask.install(FTFZipCode);
		applicantInfoPanel.setOpaque(true);
		applicantInfoPanel.setForeground(Color.WHITE);
		applicantInfoPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		applicantInfoPanel.setBackground(Color.WHITE);
		
		tabbedPane.addTab("Applicant Info", null, applicantInfoPanel, null);
		applicantInfoPanel.setLayout(null);
		
		
		lblFirstName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblFirstName.setBounds(33, 79, 143, 16);
		applicantInfoPanel.add(lblFirstName);
		
		applicantInfoPanel.add(lblLastName);
		lblLastName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblLastName.setBounds(33, 107, 134, 16);
		
		lblDateOfBirth.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblDateOfBirth.setBounds(33, 133, 143, 16);
		
		applicantInfoPanel.add(lblDateOfBirth);
		FTFDate.setToolTipText("Current Date");
		FTFDate.setHorizontalAlignment(SwingConstants.TRAILING);
		
		FTFDate.setFont(new Font("SansSerif", Font.PLAIN, 12));
		FTFDate.setBounds(763, 918, 105, 20);
		FTFDate.setColumns(10);
		FTFDate.setText("03//05/2020");
		
		//Applicant Social Security
		lblSocialSecurityNumber.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblSocialSecurityNumber.setBounds(33, 181, 143, 14);
		applicantInfoPanel.add(lblSocialSecurityNumber);
		
		//Applicant Address
		lblAddress.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblAddress.setBounds(33, 561, 143, 20);
		applicantInfoPanel.add(lblAddress);
		
		//Applicant City
		lblCity.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblCity.setBounds(33, 590, 143, 18);
		applicantInfoPanel.add(lblCity);
		
		//Applicant County
		lblCounty.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblCounty.setBounds(33, 619, 143, 20);
		applicantInfoPanel.add(lblCounty);
		lblZipCode.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//Applicant Zip Code
		lblZipCode.setBounds(33, 650, 143, 20);
		applicantInfoPanel.add(lblZipCode);
		
		//Applicant Phone Number
		lblPhoneNumber.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblPhoneNumber.setBounds(33, 213, 143, 14);
		applicantInfoPanel.add(lblPhoneNumber);
		
		//Header: Identification and Contact 
		lblAboutMe.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAboutMe.setBounds(23, 12, 231, 29);
		applicantInfoPanel.add(lblAboutMe);
		
		separator.setBounds(10, 39, 434, 2);
		applicantInfoPanel.add(separator);
		comboBoxDay.setToolTipText("Day");
		
		comboBoxDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_comboBoxDay_actionPerformed(arg0);
			}
		});

		comboBoxDay.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"D", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDay.setBackground(Color.WHITE);
		comboBoxDay.setBounds(274, 133, 40, 17);

		applicantInfoPanel.add(comboBoxDay);
		comboBoxMonth.setToolTipText("Month");

		comboBoxMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_comboBoxMonth_actionPerformed(arg0);
			}
		});

		
				comboBoxMonth.setBackground(Color.WHITE);
				comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"M", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
comboBoxMonth.setFont(new Font("SansSerif", Font.PLAIN, 12));
comboBoxMonth.setBounds(214, 133, 40, 17);

applicantInfoPanel.add(comboBoxMonth);
		comboBoxYear.setToolTipText("Year");

		comboBoxYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_comboBoxYear_actionPerformed(arg0);
			}
		});
		
		
				comboBoxYear.setBackground(Color.WHITE);
				comboBoxYear.setFont(new Font("SansSerif", Font.PLAIN, 12));
comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"Y", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
comboBoxYear.setBounds(334, 133, 77, 17);

applicantInfoPanel.add(comboBoxYear);
lblEthnicity.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblEthnicity.setBounds(33, 257, 271, 14);

applicantInfoPanel.add(lblEthnicity);
ethnicityButtonGroup.add(rdbtnWhite);
rdbtnWhite.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_rdbtnWhite_actionPerformed(arg0);
	}
});
rdbtnWhite.setFont(new Font("SansSerif", Font.PLAIN, 12));
rdbtnWhite.setBackground(Color.WHITE);
rdbtnWhite.setBounds(43, 278, 109, 23);

applicantInfoPanel.add(rdbtnWhite);
ethnicityButtonGroup.add(rdbtnBlack);
rdbtnBlack.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_rdbtnBlack_actionPerformed(arg0);
	}
});
rdbtnBlack.setFont(new Font("SansSerif", Font.PLAIN, 12));
rdbtnBlack.setBackground(Color.WHITE);
rdbtnBlack.setBounds(43, 304, 109, 23);

applicantInfoPanel.add(rdbtnBlack);
ethnicityButtonGroup.add(rdbtnHispanic);
rdbtnHispanic.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_rdbtnHispanic_actionPerformed(arg0);
	}
});
rdbtnHispanic.setFont(new Font("SansSerif", Font.PLAIN, 12));
rdbtnHispanic.setBackground(Color.WHITE);
rdbtnHispanic.setBounds(43, 330, 109, 23);

applicantInfoPanel.add(rdbtnHispanic);
ethnicityButtonGroup.add(rdbtnAsian);
rdbtnAsian.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_rdbtnAsian_actionPerformed(arg0);
	}
});
rdbtnAsian.setFont(new Font("SansSerif", Font.PLAIN, 12));
rdbtnAsian.setBackground(Color.WHITE);
rdbtnAsian.setBounds(43, 356, 109, 23);

applicantInfoPanel.add(rdbtnAsian);
ethnicityButtonGroup.add(rdbtnAmerican);
rdbtnAmerican.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_rdbtnAmerican_actionPerformed(arg0);
	}
});
rdbtnAmerican.setFont(new Font("SansSerif", Font.PLAIN, 12));
rdbtnAmerican.setBackground(Color.WHITE);
rdbtnAmerican.setBounds(43, 382, 109, 23);

applicantInfoPanel.add(rdbtnAmerican);
ethnicityButtonGroup.add(rdbtnIndian);
rdbtnIndian.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_rdbtnIndian_actionPerformed(arg0);
	}
});
rdbtnIndian.setFont(new Font("SansSerif", Font.PLAIN, 12));
rdbtnIndian.setBackground(Color.WHITE);
rdbtnIndian.setBounds(43, 408, 109, 23);

applicantInfoPanel.add(rdbtnIndian);
ethnicityButtonGroup.add(rdbtnOther);
rdbtnOther.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_rdbtnOther_actionPerformed(arg0);
	}
});
rdbtnOther.setFont(new Font("SansSerif", Font.PLAIN, 12));
rdbtnOther.setBackground(Color.WHITE);
rdbtnOther.setBounds(43, 434, 109, 23);

applicantInfoPanel.add(rdbtnOther);
lblLocation.setFont(new Font("SansSerif", Font.BOLD, 16));
lblLocation.setBounds(23, 492, 153, 30);

applicantInfoPanel.add(lblLocation);
separator_1.setBounds(10, 520, 434, 2);

applicantInfoPanel.add(separator_1);
comboBoxCounty.setToolTipText("New York State Counties Only");
comboBoxCounty.setFont(new Font("SansSerif", Font.PLAIN, 12));
comboBoxCounty.setBackground(Color.WHITE);
comboBoxCounty.setModel(new DefaultComboBoxModel(new String[] {"-Choose County-", "Albany County", "Allegany County", "Bronx County", "Broome County", "Cattaraugus County", "Cayuga County", "Chautauqua County", "Chemung County", "Chenango County", "Clinton County", "Columbia County", "Cortland County", "Delaware County", "Dutchess County", "Erie County", "Essex County", "Franklin County", "Fulton County", "Genesee County", "Greene County", "Hamilton County", "Herkimer County", "Jefferson County", "Kings County (Brooklyn)", "Lewis County", "Livingston County", "Madison County", "Monroe County", "Montgomery County", "Nassau County", "New York County (Manhattan)", "Niagara County", "Oneida County", "Onondaga County", "Ontario County", "Orange County", "Orleans County", "Oswego County", "Otsego County", "Putnam County", "Queens County", "Rensselaer County", "Richmond County (Staten Island)", "Rockland County", "Saint Lawrence County", "Saratoga County", "Schenectady County", "Schoharie County", "Schuyler County", "Seneca County", "Steuben County", "Suffolk County", "Sullivan County", "Tioga County", "Tompkins County", "Ulster County", "Warren County", "Washington County", "Wayne County", "Westchester County", "Wyoming County", "Yates County"}));
comboBoxCounty.setBounds(214, 620, 197, 20);

applicantInfoPanel.add(comboBoxCounty);
separator_4.setBounds(10, 690, 1, 2);

applicantInfoPanel.add(separator_4);
formattedTextFieldSocialSecurityNumber.addFocusListener(new FocusAdapter() {
	@Override
	public void focusLost(FocusEvent arg0) {
		do_formattedTextFieldSocialSecurityNumber_focusLost(arg0);
	}
});
formattedTextFieldSocialSecurityNumber.setBounds(214, 179, 197, 20);

applicantInfoPanel.add(formattedTextFieldSocialSecurityNumber);
formattedTextFieldPhoneNumber.addFocusListener(new FocusAdapter() {
	@Override
	public void focusLost(FocusEvent arg0) {
		do_formattedTextFieldPhoneNumber_focusLost(arg0);
	}
});
formattedTextFieldPhoneNumber.setBounds(214, 211, 197, 20);

applicantInfoPanel.add(formattedTextFieldPhoneNumber);
lblEmployment.setFont(new Font("SansSerif", Font.BOLD, 16));
lblEmployment.setBounds(23, 707, 129, 29);

applicantInfoPanel.add(lblEmployment);
separator_6.setBounds(10, 734, 434, 2);

applicantInfoPanel.add(separator_6);
lblEmployedQuestion.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblEmployedQuestion.setBounds(33, 790, 143, 19);

applicantInfoPanel.add(lblEmployedQuestion);
unemployedButtonGroup.add(rdbtnYes);
rdbtnYes.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_rdbtnYes_actionPerformed(arg0);
	}
});
rdbtnYes.setFont(new Font("SansSerif", Font.PLAIN, 12));
rdbtnYes.setBackground(Color.WHITE);
rdbtnYes.setBounds(214, 788, 56, 23);

applicantInfoPanel.add(rdbtnYes);
unemployedButtonGroup.add(rdbtnNo);
rdbtnNo.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_rdbtnNo_actionPerformed(arg0);
	}
});
rdbtnNo.setFont(new Font("SansSerif", Font.PLAIN, 12));
rdbtnNo.setBackground(Color.WHITE);
rdbtnNo.setBounds(355, 788, 56, 23);

applicantInfoPanel.add(rdbtnNo);
lblIfYes.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblIfYes.setBounds(43, 845, 171, 20);

applicantInfoPanel.add(lblIfYes);
lblPlaceEmployed.setEnabled(false);
lblPlaceEmployed.setFont(new Font("Serif", Font.PLAIN, 12));
lblPlaceEmployed.setColumns(10);
lblPlaceEmployed.setBounds(214, 845, 197, 20);

applicantInfoPanel.add(lblPlaceEmployed);
lblIfNo.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblIfNo.setBounds(43, 894, 133, 20);

applicantInfoPanel.add(lblIfNo);
comboBoxMonthsUnemployed.setToolTipText("Month");
comboBoxMonthsUnemployed.setEnabled(false);
comboBoxMonthsUnemployed.addFocusListener(new FocusAdapter() {
	@Override
	public void focusGained(FocusEvent arg0) {
		do_comboBoxMonthsUnemployed_focusGained(arg0);
	}
});

		comboBoxMonthsUnemployed.setBackground(Color.WHITE);
		comboBoxMonthsUnemployed.setModel(new DefaultComboBoxModel(new String[] {"M", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
comboBoxMonthsUnemployed.setFont(new Font("SansSerif", Font.PLAIN, 12));
comboBoxMonthsUnemployed.setBounds(214, 894, 40, 20);

applicantInfoPanel.add(comboBoxMonthsUnemployed);
comboBoxDaysUnemployed.setToolTipText("Day");
comboBoxDaysUnemployed.setEnabled(false);
comboBoxDaysUnemployed.addFocusListener(new FocusAdapter() {
	@Override
	public void focusGained(FocusEvent arg0) {
		do_comboBoxDaysUnemployed_focusGained(arg0);
	}
});

		comboBoxDaysUnemployed.setModel(new DefaultComboBoxModel(new String[] {"D", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232", "233", "234", "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245", "246", "247", "248", "249", "250", "251", "252", "253", "254", "255", "256", "257", "258", "259", "260", "261", "262", "263", "264", "265", "266", "267", "268", "269", "270", "271", "272", "273", "274", "275", "276", "277", "278", "279", "280", "281", "282", "283", "284", "285", "286", "287", "288", "289", "290", "291", "292", "293", "294", "295", "296", "297", "298", "299", "300", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310", "311", "312", "313", "314", "315", "316", "317", "318", "319", "320", "321", "322", "323", "324", "325", "326", "327", "328", "329", "330", "331", "332", "333", "334", "335", "336", "337", "338", "339", "340", "341", "342", "343", "344", "345", "346", "347", "348", "349", "350", "351", "352", "353", "354", "355", "356", "357", "358", "359", "360", "361", "362", "363", "364"}));
comboBoxDaysUnemployed.setForeground(Color.BLACK);
comboBoxDaysUnemployed.setFont(new Font("SansSerif", Font.PLAIN, 12));
comboBoxDaysUnemployed.setBackground(Color.WHITE);
comboBoxDaysUnemployed.setBounds(274, 894, 40, 20);

applicantInfoPanel.add(comboBoxDaysUnemployed);
comboBoxYearsUnemployed.setToolTipText("Year");
comboBoxYearsUnemployed.setEnabled(false);
comboBoxYearsUnemployed.addFocusListener(new FocusAdapter() {
	@Override
	public void focusGained(FocusEvent arg0) {
		do_comboBoxYearsUnemployed_focusGained(arg0);
	}
});

		comboBoxYearsUnemployed.setModel(new DefaultComboBoxModel(new String[] {"Y", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
comboBoxYearsUnemployed.setFont(new Font("SansSerif", Font.PLAIN, 12));
comboBoxYearsUnemployed.setBackground(Color.WHITE);
comboBoxYearsUnemployed.setBounds(334, 894, 77, 20);

applicantInfoPanel.add(comboBoxYearsUnemployed);
lblPresentProblem.setFont(new Font("SansSerif", Font.BOLD, 16));
lblPresentProblem.setBounds(582, 707, 166, 29);

applicantInfoPanel.add(lblPresentProblem);
separator_8.setBounds(572, 734, 439, 2);

applicantInfoPanel.add(separator_8);
lblAssistanceRequested.setBackground(Color.WHITE);
lblAssistanceRequested.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblAssistanceRequested.setBounds(600, 779, 182, 20);

applicantInfoPanel.add(lblAssistanceRequested);
lblReferredBy.setBackground(Color.WHITE);
lblReferredBy.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblReferredBy.setBounds(600, 810, 129, 25);

applicantInfoPanel.add(lblReferredBy);
separator_3.setBounds(562, 39, 449, 2);

applicantInfoPanel.add(separator_3);
lblSpouseIdentification.setFont(new Font("SansSerif", Font.BOLD, 16));
lblSpouseIdentification.setBounds(572, 10, 200, 33);

applicantInfoPanel.add(lblSpouseIdentification);
lblSpouseFirstName.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblSpouseFirstName.setBounds(585, 79, 119, 20);

applicantInfoPanel.add(lblSpouseFirstName);
lblSpouseLastName.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblSpouseLastName.setBounds(585, 110, 119, 20);

applicantInfoPanel.add(lblSpouseLastName);
lblSpouseDateOfBirth.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblSpouseDateOfBirth.setBounds(585, 141, 143, 20);

applicantInfoPanel.add(lblSpouseDateOfBirth);
lblSpouseSocialSecurityNumber.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblSpouseSocialSecurityNumber.setBounds(585, 198, 153, 18);

applicantInfoPanel.add(lblSpouseSocialSecurityNumber);
formattedTextFieldSpouseSocialSecurityNumber.setFont(new Font("SansSerif", Font.PLAIN, 12));
formattedTextFieldSpouseSocialSecurityNumber.setBounds(766, 197, 207, 20);

applicantInfoPanel.add(formattedTextFieldSpouseSocialSecurityNumber);
comboBoxSpouseMonth.setToolTipText("Month");
comboBoxSpouseMonth.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_comboBoxSpouseMonth_actionPerformed(arg0);
	}
});
comboBoxSpouseMonth.setModel(new DefaultComboBoxModel(new String[] {"M", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
comboBoxSpouseMonth.setFont(new Font("SansSerif", Font.PLAIN, 12));
comboBoxSpouseMonth.setBackground(Color.WHITE);
comboBoxSpouseMonth.setBounds(766, 141, 46, 20);

applicantInfoPanel.add(comboBoxSpouseMonth);
comboBoxSpouseDay.setToolTipText("Day");
comboBoxSpouseDay.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_comboBoxSpouseDay_actionPerformed(arg0);
	}
});
comboBoxSpouseDay.setBackground(Color.WHITE);
comboBoxSpouseDay.setModel(new DefaultComboBoxModel(new String[] {"D", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
comboBoxSpouseDay.setFont(new Font("SansSerif", Font.PLAIN, 12));
comboBoxSpouseDay.setBounds(830, 141, 40, 20);

applicantInfoPanel.add(comboBoxSpouseDay);
comboBoxSpouseYear.setToolTipText("Year");
comboBoxSpouseYear.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_comboBoxSpouseYear_actionPerformed(arg0);
	}
});
comboBoxSpouseYear.setBackground(Color.WHITE);
comboBoxSpouseYear.setModel(new DefaultComboBoxModel(new String[] {"Y", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
comboBoxSpouseYear.setFont(new Font("SansSerif", Font.PLAIN, 12));
comboBoxSpouseYear.setBounds(886, 141, 87, 20);

applicantInfoPanel.add(comboBoxSpouseYear);
separator_5.setBounds(562, 520, 449, 2);

applicantInfoPanel.add(separator_5);
lblSpouseEmployment.setFont(new Font("SansSerif", Font.BOLD, 16));
lblSpouseEmployment.setBounds(569, 492, 182, 29);

applicantInfoPanel.add(lblSpouseEmployment);
lblSpouseEmployedQuestion.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblSpouseEmployedQuestion.setBounds(585, 559, 143, 19);

applicantInfoPanel.add(lblSpouseEmployedQuestion);
spouseUnemployedButtonGroup.add(rdbtnSpouseYes);
rdbtnSpouseYes.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_rdbtnSpouseYes_actionPerformed(arg0);
	}
});

		rdbtnSpouseYes.setFont(new Font("SansSerif", Font.PLAIN, 12));
rdbtnSpouseYes.setBackground(Color.WHITE);
rdbtnSpouseYes.setBounds(772, 559, 56, 23);

applicantInfoPanel.add(rdbtnSpouseYes);
spouseUnemployedButtonGroup.add(rdbtnSpouseNo);
rdbtnSpouseNo.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_rdbtnSpouseNo_actionPerformed(arg0);
	}
});
rdbtnSpouseNo.setFont(new Font("SansSerif", Font.PLAIN, 12));
rdbtnSpouseNo.setBackground(Color.WHITE);
rdbtnSpouseNo.setBounds(917, 559, 56, 23);

applicantInfoPanel.add(rdbtnSpouseNo);
lblSpouseIfYes.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblSpouseIfYes.setBounds(601, 597, 171, 20);

applicantInfoPanel.add(lblSpouseIfYes);
textField_2.setEnabled(false);
textField_2.setFont(new Font("Serif", Font.PLAIN, 12));
textField_2.setColumns(10);
textField_2.setBounds(772, 598, 201, 20);

applicantInfoPanel.add(textField_2);
lblSpouseIfNo.setFont(new Font("SansSerif", Font.PLAIN, 12));
lblSpouseIfNo.setBounds(601, 628, 133, 20);

applicantInfoPanel.add(lblSpouseIfNo);
comboBoxSpouseMonthsUnemployed.setToolTipText("Month");
comboBoxSpouseMonthsUnemployed.setEnabled(false);
comboBoxSpouseMonthsUnemployed.setFont(new Font("SansSerif", Font.PLAIN, 12));
comboBoxSpouseMonthsUnemployed.addFocusListener(new FocusAdapter() {
	@Override
	public void focusGained(FocusEvent arg0) {
		do_comboBoxSpouseMonthsUnemployed_focusGained(arg0);
	}
});

		comboBoxSpouseMonthsUnemployed.setBackground(Color.WHITE);
		comboBoxSpouseMonthsUnemployed.setModel(new DefaultComboBoxModel(new String[] {"M", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
comboBoxSpouseMonthsUnemployed.setBounds(772, 629, 40, 20);

applicantInfoPanel.add(comboBoxSpouseMonthsUnemployed);
comboBoxSpouseDaysUnemployed.setToolTipText("Day");
comboBoxSpouseDaysUnemployed.setEnabled(false);
comboBoxSpouseDaysUnemployed.addFocusListener(new FocusAdapter() {
	@Override
	public void focusGained(FocusEvent arg0) {
		do_comboBoxSpouseDaysUnemployed_focusGained(arg0);
	}
});

		comboBoxSpouseDaysUnemployed.setModel(new DefaultComboBoxModel(new String[] {"D", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232", "233", "234", "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245", "246", "247", "248", "249", "250", "251", "252", "253", "254", "255", "256", "257", "258", "259", "260", "261", "262", "263", "264", "265", "266", "267", "268", "269", "270", "271", "272", "273", "274", "275", "276", "277", "278", "279", "280", "281", "282", "283", "284", "285", "286", "287", "288", "289", "290", "291", "292", "293", "294", "295", "296", "297", "298", "299", "300", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310", "311", "312", "313", "314", "315", "316", "317", "318", "319", "320", "321", "322", "323", "324", "325", "326", "327", "328", "329", "330", "331", "332", "333", "334", "335", "336", "337", "338", "339", "340", "341", "342", "343", "344", "345", "346", "347", "348", "349", "350", "351", "352", "353", "354", "355", "356", "357", "358", "359", "360", "361", "362", "363", "364"}));
		comboBoxSpouseDaysUnemployed.setForeground(Color.BLACK);
		comboBoxSpouseDaysUnemployed.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboBoxSpouseDaysUnemployed.setBackground(Color.WHITE);
		comboBoxSpouseDaysUnemployed.setBounds(836, 628, 40, 20);
		
		applicantInfoPanel.add(comboBoxSpouseDaysUnemployed);
		comboBoxSpouseYearsUnemployed.setToolTipText("Year");
		comboBoxSpouseYearsUnemployed.setEnabled(false);
		comboBoxSpouseYearsUnemployed.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboBoxSpouseYearsUnemployed.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_comboBoxSpouseYearsUnemployed_focusGained(arg0);
			}
		});
		comboBoxSpouseYearsUnemployed.setModel(new DefaultComboBoxModel(new String[] {"Y", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
		comboBoxSpouseYearsUnemployed.setBackground(Color.WHITE);
		comboBoxSpouseYearsUnemployed.setBounds(896, 629, 77, 20);
		
		applicantInfoPanel.add(comboBoxSpouseYearsUnemployed);
		separator_7.setBounds(1124, 647, 439, 2);
		
		applicantInfoPanel.add(separator_7);
		lblSpouseEthnicity.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblSpouseEthnicity.setBounds(585, 257, 271, 14);
		
		applicantInfoPanel.add(lblSpouseEthnicity);
		spouseEthnicityButtonGroup.add(rdbtnSpouseWhite);
		rdbtnSpouseWhite.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rdbtnSpouseWhite.setBackground(Color.WHITE);
		rdbtnSpouseWhite.setBounds(595, 278, 109, 23);
		
		applicantInfoPanel.add(rdbtnSpouseWhite);
		spouseEthnicityButtonGroup.add(rdbtnSpouseBlack);
		rdbtnSpouseBlack.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rdbtnSpouseBlack.setBackground(Color.WHITE);
		rdbtnSpouseBlack.setBounds(595, 304, 109, 23);
		
		applicantInfoPanel.add(rdbtnSpouseBlack);
		spouseEthnicityButtonGroup.add(rdbtnSpouseHispanic);
		rdbtnSpouseHispanic.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rdbtnSpouseHispanic.setBackground(Color.WHITE);
		rdbtnSpouseHispanic.setBounds(595, 330, 109, 23);
		
		applicantInfoPanel.add(rdbtnSpouseHispanic);
		spouseEthnicityButtonGroup.add(rdbtnSpouseAsian);
		rdbtnSpouseAsian.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rdbtnSpouseAsian.setBackground(Color.WHITE);
		rdbtnSpouseAsian.setBounds(595, 356, 109, 23);
		
		applicantInfoPanel.add(rdbtnSpouseAsian);
		spouseEthnicityButtonGroup.add(rdbtnSpouseAmerican);
		rdbtnSpouseAmerican.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rdbtnSpouseAmerican.setBackground(Color.WHITE);
		rdbtnSpouseAmerican.setBounds(595, 382, 109, 23);
		
		applicantInfoPanel.add(rdbtnSpouseAmerican);
		spouseEthnicityButtonGroup.add(rdbtnSpouseIndian);
		rdbtnSpouseIndian.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rdbtnSpouseIndian.setBackground(Color.WHITE);
		rdbtnSpouseIndian.setBounds(595, 408, 109, 23);
		
		applicantInfoPanel.add(rdbtnSpouseIndian);
		spouseEthnicityButtonGroup.add(rdbtnSpouseOther);
		rdbtnSpouseOther.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rdbtnSpouseOther.setBackground(Color.WHITE);
		rdbtnSpouseOther.setBounds(595, 434, 109, 23);
		
		applicantInfoPanel.add(rdbtnSpouseOther);
		separator_9.setOrientation(SwingConstants.VERTICAL);
		separator_9.setBounds(501, 25, 1, 889);
		
		applicantInfoPanel.add(separator_9);
		scrollPane.setBounds(600, 845, 364, 69);
		
		applicantInfoPanel.add(scrollPane);
		txtpnProblem.setToolTipText("Please type your problem here");

		txtpnProblem.setForeground(Color.gray);
		scrollPane.setViewportView(txtpnProblem);
		txtpnProblem.setText("Please type your problem here...");
		txtpnProblem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblidentificationAndContactErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblidentificationAndContactErrorMessage.setForeground(Color.RED);
		lblidentificationAndContactErrorMessage.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblidentificationAndContactErrorMessage.setBounds(23, 52, 409, 16);
		lblidentificationAndContactErrorMessage.setVisible(false);
		
		applicantInfoPanel.add(lblidentificationAndContactErrorMessage);
		lblLocationErrorMessage.setVisible(false);
		lblLocationErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocationErrorMessage.setForeground(Color.RED);
		lblLocationErrorMessage.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblLocationErrorMessage.setBounds(33, 533, 358, 17);
		
		applicantInfoPanel.add(lblLocationErrorMessage);
		lblEmploymentErrorMessage.setVisible(false);
		lblEmploymentErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmploymentErrorMessage.setForeground(Color.RED);
		lblEmploymentErrorMessage.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblEmploymentErrorMessage.setBounds(33, 747, 358, 22);
		
		applicantInfoPanel.add(lblEmploymentErrorMessage);
		lblPresentProblemErrorMessage.setVisible(false);
		lblPresentProblemErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresentProblemErrorMessage.setForeground(Color.RED);
		lblPresentProblemErrorMessage.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPresentProblemErrorMessage.setBounds(592, 747, 371, 22);
		
		applicantInfoPanel.add(lblPresentProblemErrorMessage);
		lblSpouseEmployementErrorMessage.setVisible(false);
		lblSpouseEmployementErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpouseEmployementErrorMessage.setForeground(Color.RED);
		lblSpouseEmployementErrorMessage.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSpouseEmployementErrorMessage.setBounds(582, 532, 371, 22);
		
		applicantInfoPanel.add(lblSpouseEmployementErrorMessage);
		lblSpouseIdentificationErrorMessage.setVisible(false);
		lblSpouseIdentificationErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpouseIdentificationErrorMessage.setForeground(Color.RED);
		lblSpouseIdentificationErrorMessage.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSpouseIdentificationErrorMessage.setBounds(582, 46, 371, 22);
		
		applicantInfoPanel.add(lblSpouseIdentificationErrorMessage);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(253, 897, 21, 14);
		
		applicantInfoPanel.add(lblNewLabel_3);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(314, 898, 21, 14);
		
		applicantInfoPanel.add(lblNewLabel_3_1);
		lblEmploymedOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmploymedOr.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblEmploymedOr.setBounds(296, 793, 21, 14);
		
		applicantInfoPanel.add(lblEmploymedOr);
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_3_3.setBounds(811, 631, 27, 14);
		
		applicantInfoPanel.add(lblNewLabel_3_3);
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_3_4.setBounds(876, 632, 21, 14);
		
		applicantInfoPanel.add(lblNewLabel_3_4);
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_5.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_3_5.setBounds(853, 564, 21, 14);
		
		applicantInfoPanel.add(lblNewLabel_3_5);
		FTFLastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_FTFLastName_focusGained(arg0);
			}
		});
		FTFLastName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		FTFLastName.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				do_FTFLastName_propertyChange(arg0);
			}
		});
		FTFLastName.setBounds(214, 106, 197, 20);
		FTFLastName.setText("Pelt");
		FTFLastName.setForeground(Color.gray);
		applicantInfoPanel.add(FTFLastName);
		FTFFirstName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_FTFFirstName_focusGained(arg0);
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				do_FTFFirstName_focusLost(arg0);
			}
		});
		FTFFirstName.setText("Linus");
		FTFFirstName.setForeground(Color.GRAY);
		FTFFirstName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		FTFFirstName.setBounds(214, 78, 197, 20);
		
		applicantInfoPanel.add(FTFFirstName);
		FTFCity.setText("Pawling");
		FTFCity.setForeground(Color.GRAY);
		FTFCity.setFont(new Font("SansSerif", Font.PLAIN, 12));
		FTFCity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_FTFCity_focusGained(arg0);
			}
		});
		FTFCity.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				do_FTFCity_propertyChange(arg0);
			}
		});
		FTFCity.setBounds(214, 590, 197, 20);
		
		applicantInfoPanel.add(FTFCity);
		FTFSpouseFirstName.setText("Lucy");
		FTFSpouseFirstName.setForeground(Color.GRAY);
		FTFSpouseFirstName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		FTFSpouseFirstName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_FTFSpouseFirstName_focusGained(arg0);
			}
		});
		FTFSpouseFirstName.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				do_FTFSpouseFirstName_propertyChange(arg0);
			}
		});
		FTFSpouseFirstName.setBounds(766, 78, 207, 20);
		
		applicantInfoPanel.add(FTFSpouseFirstName);
		FTFSpouseLastName.setForeground(Color.GRAY);
		FTFSpouseLastName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		FTFSpouseLastName.setText("Pelt");
		FTFSpouseLastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_FTFSpouseLastName_focusGained(arg0);
			}
		});
		FTFSpouseLastName.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				do_FTFSpouseLastName_propertyChange(arg0);
			}
		});
		FTFSpouseLastName.setBounds(766, 106, 207, 20);
		
		applicantInfoPanel.add(FTFSpouseLastName);
		FTFReferredBy.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				do_FTFReferredBy_propertyChange(arg0);
			}
		});
		FTFReferredBy.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_FTFReferredBy_focusGained(arg0);
			}
		});
		FTFReferredBy.setFont(new Font("SansSerif", Font.PLAIN, 12));
		FTFReferredBy.setBounds(776, 810, 187, 20);
		
		applicantInfoPanel.add(FTFReferredBy);
		FTFZipCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_FTFZipCode_focusLost(arg0);
			}
		});
		FTFZipCode.setFont(new Font("SansSerif", Font.PLAIN, 12));
		FTFZipCode.setBounds(214, 650, 197, 20);
		
		applicantInfoPanel.add(FTFZipCode);
		FTFAssistanceRequested.setFont(new Font("SansSerif", Font.PLAIN, 12));
		FTFAssistanceRequested.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_FTFAssistanceRequested_focusGained(arg0);
			}
		});
		FTFAssistanceRequested.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				do_FTFAssistanceRequested_propertyChange(arg0);
			}
		});
		FTFAssistanceRequested.setBounds(776, 780, 188, 20);
		
		applicantInfoPanel.add(FTFAssistanceRequested);
		FTFAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_FTFAddress_focusLost(arg0);
			}
		});
		FTFAddress.setBounds(214, 562, 197, 20);
		
		applicantInfoPanel.add(FTFAddress);
		resident1SocialSecurityMask.install(FTFResidentSocialSecurityNumber_1);
		resident2SocialSecurityMask.install(FTFResidentSocialSecurityNumber_2);
		resident3SocialSecurityMask.install(FTFResidentSocialSecurityNumber_3);
		resident4SocialSecurityMask.install(FTFResidentSocialSecurityNumber_4);
		resident5SocialSecurityMask.install(FTFResidentSocialSecurityNumber_5);
		resident6SocialSecurityMask.install(FTFResidentSocialSecurityNumber_6);
				householdInfoPanel.setToolTipText("First Name");
		
				
				householdInfoPanel.setBackground(Color.WHITE);
				
				tabbedPane.addTab("Household Info", null, householdInfoPanel, null);
				householdInfoPanel.setLayout(null);
				separator_10.setBounds(10, 38, 912, 2);
				
				householdInfoPanel.add(separator_10);
				lblHouseholdResidents.setFont(new Font("SansSerif", Font.BOLD, 16));
				lblHouseholdResidents.setBounds(23, 11, 191, 29);
				
				householdInfoPanel.add(lblHouseholdResidents);
				lblHouseholdDirections.setToolTipText("Instructions");
				lblHouseholdDirections.setFont(new Font("SansSerif", Font.ITALIC, 12));
				lblHouseholdDirections.setBounds(33, 49, 517, 14);
				
				householdInfoPanel.add(lblHouseholdDirections);
				lblResidentFirstName_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentFirstName_1.setBounds(43, 125, 98, 20);
				
				householdInfoPanel.add(lblResidentFirstName_1);
				lblResidentLastName_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentLastName_1.setBounds(43, 153, 109, 20);
				
				householdInfoPanel.add(lblResidentLastName_1);
				lblRelationship_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblRelationship_1.setBounds(43, 184, 131, 20);
				
				householdInfoPanel.add(lblRelationship_1);
				comboBoxRelationship_1.setToolTipText("Relationship");
				comboBoxRelationship_1.setBackground(Color.WHITE);
				comboBoxRelationship_1.setForeground(new Color(0, 0, 0));
				comboBoxRelationship_1.setModel(new DefaultComboBoxModel(new String[] {"Child", "GrandChild", "Sibling", "Parent", "GrandParent", "ExtendedFamily", "Other"}));
				comboBoxRelationship_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
				comboBoxRelationship_1.setBounds(214, 185, 177, 20);
				
				householdInfoPanel.add(comboBoxRelationship_1);
				lblAge_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblAge_1.setBounds(43, 215, 46, 20);
				
				householdInfoPanel.add(lblAge_1);
				comboBoxAge_1.setToolTipText("Age in years");
				comboBoxAge_1.setBackground(Color.WHITE);
				comboBoxAge_1.setModel(new DefaultComboBoxModel(new String[] {"Years Old", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121"}));
				comboBoxAge_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
				comboBoxAge_1.setBounds(214, 216, 177, 20);
				
				householdInfoPanel.add(comboBoxAge_1);
				lblResidentSocialSecurityNumber_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentSocialSecurityNumber_1.setBounds(43, 249, 153, 18);
				
				householdInfoPanel.add(lblResidentSocialSecurityNumber_1);
				lblResidentFirstName_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentFirstName_2.setBounds(43, 330, 98, 20);
				
				householdInfoPanel.add(lblResidentFirstName_2);
				lblResidentLastName_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentLastName_2.setBounds(43, 358, 109, 20);
				
				householdInfoPanel.add(lblResidentLastName_2);
				lblRelationship_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblRelationship_2.setBounds(43, 389, 131, 20);
				
				householdInfoPanel.add(lblRelationship_2);
				lblAge_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblAge_2.setBounds(43, 420, 46, 20);
				
				householdInfoPanel.add(lblAge_2);
				lblResidentSocialSecurityNumber_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentSocialSecurityNumber_2.setBounds(43, 454, 153, 18);
				
				householdInfoPanel.add(lblResidentSocialSecurityNumber_2);
				comboBoxAge_2.setToolTipText("Age in years");
				comboBoxAge_2.setBackground(Color.WHITE);
				comboBoxAge_2.setModel(new DefaultComboBoxModel(new String[] {"Years Old", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121"}));
				comboBoxAge_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
				comboBoxAge_2.setBounds(214, 421, 177, 20);
				
				householdInfoPanel.add(comboBoxAge_2);
				comboBoxRelationship_2.setToolTipText("Relationship");
				comboBoxRelationship_2.setBackground(Color.WHITE);
				comboBoxRelationship_2.setModel(new DefaultComboBoxModel(new String[] {"Child", "GrandChild", "Sibling", "Parent", "GrandParent", "ExtendedFamily", "Other"}));
				comboBoxRelationship_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
				comboBoxRelationship_2.setBounds(214, 390, 177, 20);
				
				householdInfoPanel.add(comboBoxRelationship_2);
				lblResidentFirstName_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentFirstName_3.setBounds(43, 541, 98, 20);
				
				householdInfoPanel.add(lblResidentFirstName_3);
				lblResidentLastName_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentLastName_3.setBounds(43, 569, 109, 20);
				
				householdInfoPanel.add(lblResidentLastName_3);
				lblRelationship_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblRelationship_3.setBounds(43, 600, 131, 20);
				
				householdInfoPanel.add(lblRelationship_3);
				lblAge_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblAge_3.setBounds(43, 631, 46, 20);
				
				householdInfoPanel.add(lblAge_3);
				lblResidentSocialSecurityNumber_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentSocialSecurityNumber_3.setBounds(43, 665, 153, 18);
				
				householdInfoPanel.add(lblResidentSocialSecurityNumber_3);
				comboBoxAge_3.setToolTipText("Age in years");
				comboBoxAge_3.setBackground(Color.WHITE);
				comboBoxAge_3.setModel(new DefaultComboBoxModel(new String[] {"Years Old", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121"}));
				comboBoxAge_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
				comboBoxAge_3.setBounds(214, 632, 177, 20);
				
				householdInfoPanel.add(comboBoxAge_3);
				comboBoxRelationship_3.setToolTipText("Relationship");
				comboBoxRelationship_3.setBackground(Color.WHITE);
				comboBoxRelationship_3.setModel(new DefaultComboBoxModel(new String[] {"Child", "GrandChild", "Sibling", "Parent", "GrandParent", "ExtendedFamily", "Other"}));
				comboBoxRelationship_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
				comboBoxRelationship_3.setBounds(214, 601, 177, 20);
				
				householdInfoPanel.add(comboBoxRelationship_3);
				lblResidentFirstName_4.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentFirstName_4.setBounds(551, 125, 98, 20);
				
				householdInfoPanel.add(lblResidentFirstName_4);
				lblResidentLastName_4.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentLastName_4.setBounds(551, 153, 109, 20);
				
				householdInfoPanel.add(lblResidentLastName_4);
				lblRelationship_3_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblRelationship_3_1.setBounds(551, 184, 131, 20);
				
				householdInfoPanel.add(lblRelationship_3_1);
				comboBoxRelationship_4.setToolTipText("Relationship");
				comboBoxRelationship_4.setBackground(Color.WHITE);
				comboBoxRelationship_4.setModel(new DefaultComboBoxModel(new String[] {"Child", "GrandChild", "Sibling", "Parent", "GrandParent", "ExtendedFamily", "Other"}));
				comboBoxRelationship_4.setFont(new Font("SansSerif", Font.PLAIN, 12));
				comboBoxRelationship_4.setBounds(722, 185, 177, 20);
				
				householdInfoPanel.add(comboBoxRelationship_4);
				lblAge_4.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblAge_4.setBounds(551, 215, 46, 20);
				
				householdInfoPanel.add(lblAge_4);
				comboBoxAge_4.setToolTipText("Age in years");
				comboBoxAge_4.setBackground(Color.WHITE);
				comboBoxAge_4.setModel(new DefaultComboBoxModel(new String[] {"Years Old", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121"}));
				comboBoxAge_4.setFont(new Font("SansSerif", Font.PLAIN, 12));
				comboBoxAge_4.setBounds(722, 216, 177, 20);
				
				householdInfoPanel.add(comboBoxAge_4);
				lblResidentSocialSecurityNumber_4.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentSocialSecurityNumber_4.setBounds(551, 249, 153, 18);
				
				householdInfoPanel.add(lblResidentSocialSecurityNumber_4);
				lblResidentFirstName_5.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentFirstName_5.setBounds(551, 328, 98, 20);
				
				householdInfoPanel.add(lblResidentFirstName_5);
				lblResidentLastName_5.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentLastName_5.setBounds(551, 356, 109, 20);
				
				householdInfoPanel.add(lblResidentLastName_5);
				lblRelationship_3_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblRelationship_3_2.setBounds(551, 387, 131, 20);
				
				householdInfoPanel.add(lblRelationship_3_2);
				comboBoxRelationship_5.setToolTipText("Relationship");
				comboBoxRelationship_5.setBackground(Color.WHITE);
				comboBoxRelationship_5.setModel(new DefaultComboBoxModel(new String[] {"Child", "GrandChild", "Sibling", "Parent", "GrandParent", "ExtendedFamily", "Other"}));
				comboBoxRelationship_5.setFont(new Font("SansSerif", Font.PLAIN, 12));
				comboBoxRelationship_5.setBounds(722, 388, 177, 20);
				
				householdInfoPanel.add(comboBoxRelationship_5);
				lblAge_5.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblAge_5.setBounds(551, 418, 46, 20);
				
				householdInfoPanel.add(lblAge_5);
				comboBoxAge_5.setToolTipText("Age in years");
				comboBoxAge_5.setBackground(Color.WHITE);
				comboBoxAge_5.setModel(new DefaultComboBoxModel(new String[] {"Years Old", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121"}));
				comboBoxAge_5.setFont(new Font("SansSerif", Font.PLAIN, 12));
				comboBoxAge_5.setBounds(722, 419, 177, 20);
				
				householdInfoPanel.add(comboBoxAge_5);
				lblResidentSocialSecurityNumber_5.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentSocialSecurityNumber_5.setBounds(551, 452, 153, 18);
				
				householdInfoPanel.add(lblResidentSocialSecurityNumber_5);
				lblResidentFirstName_6.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentFirstName_6.setBounds(551, 539, 98, 20);
				
				householdInfoPanel.add(lblResidentFirstName_6);
				lblResidentLastName_6.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentLastName_6.setBounds(551, 567, 109, 20);
				
				householdInfoPanel.add(lblResidentLastName_6);
				lblRelationship_3_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblRelationship_3_3.setBounds(551, 598, 131, 20);
				
				householdInfoPanel.add(lblRelationship_3_3);
				comboBoxRelationship_6.setToolTipText("Relationship");
				comboBoxRelationship_6.setBackground(Color.WHITE);
				comboBoxRelationship_6.setForeground(new Color(0, 0, 0));
				comboBoxRelationship_6.setModel(new DefaultComboBoxModel(new String[] {"Child", "GrandChild", "Sibling", "Parent", "GrandParent", "ExtendedFamily", "Other"}));
				comboBoxRelationship_6.setFont(new Font("SansSerif", Font.PLAIN, 12));
				comboBoxRelationship_6.setBounds(722, 599, 177, 20);
				
				householdInfoPanel.add(comboBoxRelationship_6);
				lblAge_6.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblAge_6.setBounds(551, 629, 46, 20);
				
				householdInfoPanel.add(lblAge_6);
				comboBoxAge_6.setToolTipText("Age in years");
				comboBoxAge_6.setModel(new DefaultComboBoxModel(new String[] {"Years Old", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121"}));
				comboBoxAge_6.setBackground(Color.WHITE);
				comboBoxAge_6.setFont(new Font("SansSerif", Font.PLAIN, 12));
				comboBoxAge_6.setBounds(722, 630, 177, 20);
				
				householdInfoPanel.add(comboBoxAge_6);
				lblResidentSocialSecurityNumber_6.setFont(new Font("SansSerif", Font.PLAIN, 12));
				lblResidentSocialSecurityNumber_6.setBounds(551, 663, 153, 18);
				
				householdInfoPanel.add(lblResidentSocialSecurityNumber_6);
				separator_11.setOrientation(SwingConstants.VERTICAL);
				separator_11.setBounds(470, 94, 2, 589);
				
				householdInfoPanel.add(separator_11);
				lblResident_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblResident_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblResident_1.setBounds(43, 94, 348, 20);
				
				householdInfoPanel.add(lblResident_1);
				lblResident_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblResident_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblResident_2.setBounds(43, 292, 348, 27);
				
				householdInfoPanel.add(lblResident_2);
				lblResident_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblResident_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblResident_3.setBounds(43, 501, 348, 29);
				
				householdInfoPanel.add(lblResident_3);
				lblResident_6.setHorizontalAlignment(SwingConstants.CENTER);
				lblResident_6.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblResident_6.setBounds(551, 501, 348, 29);
				
				householdInfoPanel.add(lblResident_6);
				lblResident_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblResident_5.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblResident_5.setBounds(551, 291, 348, 29);
				
				householdInfoPanel.add(lblResident_5);
				lblResident_5_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblResident_5_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblResident_5_1.setBounds(551, 92, 348, 29);
				
				householdInfoPanel.add(lblResident_5_1);
				lblHouseholdApplicant.setHorizontalAlignment(SwingConstants.RIGHT);
				lblHouseholdApplicant.setForeground(Color.GRAY);
				lblHouseholdApplicant.setBackground(Color.WHITE);
				lblHouseholdApplicant.setFont(new Font("SansSerif", Font.PLAIN, 14));
				lblHouseholdApplicant.setBounds(470, 21, 452, 14);
				
				householdInfoPanel.add(lblHouseholdApplicant);
				FTFResidentFirstName_1.setToolTipText("First Name");
				FTFResidentFirstName_1.setForeground(Color.GRAY);
				FTFResidentFirstName_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
				FTFResidentFirstName_1.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						do_FTFResidentFirstName_1_focusGained(arg0);
					}
				});
				FTFResidentFirstName_1.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						do_FTFResidentFirstName_1_propertyChange(arg0);
					}
				});
				FTFResidentFirstName_1.setBounds(214, 126, 177, 20);
				
				householdInfoPanel.add(FTFResidentFirstName_1);
				FTFResidentLastName_1.setToolTipText("Last Name");
				FTFResidentLastName_1.setForeground(Color.GRAY);
				FTFResidentLastName_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
				FTFResidentLastName_1.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						do_FTFResidentLastName_1_focusGained(arg0);
					}
				});
				FTFResidentLastName_1.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						do_FTFResidentLastName_1_propertyChange(arg0);
					}
				});
				FTFResidentLastName_1.setBounds(214, 154, 177, 20);
				
				householdInfoPanel.add(FTFResidentLastName_1);
				FTFResidentSocialSecurityNumber_1.setToolTipText("Social Security Number");
				FTFResidentSocialSecurityNumber_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
				FTFResidentSocialSecurityNumber_1.setBounds(214, 247, 177, 20);
				
				householdInfoPanel.add(FTFResidentSocialSecurityNumber_1);
				FTFResidentSocialSecurityNumber_2.setToolTipText("Social Security Number");
				FTFResidentSocialSecurityNumber_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
				FTFResidentSocialSecurityNumber_2.setBounds(214, 454, 177, 20);
				
				householdInfoPanel.add(FTFResidentSocialSecurityNumber_2);
				FTFResidentSocialSecurityNumber_3.setToolTipText("Social Security Number");
				FTFResidentSocialSecurityNumber_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
				FTFResidentSocialSecurityNumber_3.setBounds(214, 665, 177, 20);
				
				householdInfoPanel.add(FTFResidentSocialSecurityNumber_3);
				FTFResidentSocialSecurityNumber_4.setToolTipText("Social Security Number");
				FTFResidentSocialSecurityNumber_4.setBounds(722, 249, 177, 20);
				
				householdInfoPanel.add(FTFResidentSocialSecurityNumber_4);
				FTFResidentSocialSecurityNumber_5.setToolTipText("Social Security Number");
				FTFResidentSocialSecurityNumber_5.setBounds(722, 454, 177, 20);
				
				householdInfoPanel.add(FTFResidentSocialSecurityNumber_5);
				FTFResidentSocialSecurityNumber_6.setToolTipText("Social Security Number");
				FTFResidentSocialSecurityNumber_6.setBounds(722, 665, 177, 20);
				
				householdInfoPanel.add(FTFResidentSocialSecurityNumber_6);
				FTFResidentFirstName_2.setToolTipText("First Name");
				FTFResidentFirstName_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
				FTFResidentFirstName_2.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						do_FTFResidentFirstName_2_focusGained(arg0);
					}
				});
				FTFResidentFirstName_2.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						do_FTFResidentFirstName_2_propertyChange(arg0);
					}
				});
				FTFResidentFirstName_2.setBounds(214, 331, 177, 20);
				
				householdInfoPanel.add(FTFResidentFirstName_2);
				FTFResidentLastName_2.setToolTipText("Last Name");
				FTFResidentLastName_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
				FTFResidentLastName_2.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						do_FTFResidentLastName_2_focusGained(arg0);
					}
				});
				FTFResidentLastName_2.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						do_FTFResidentLastName_2_propertyChange(arg0);
					}
				});
				FTFResidentLastName_2.setBounds(214, 359, 177, 20);
				
				householdInfoPanel.add(FTFResidentLastName_2);
				FTFResidentFirstName_3.setToolTipText("First Name");
				FTFResidentFirstName_3.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						do_FTFResidentFirstName_3_focusGained(arg0);
					}
				});
				FTFResidentFirstName_3.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						do_FTFResidentFirstName_3_propertyChange(arg0);
					}
				});
				FTFResidentFirstName_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
				FTFResidentFirstName_3.setBounds(214, 542, 177, 20);
				
				householdInfoPanel.add(FTFResidentFirstName_3);
				FTFResidentLastName_3.setToolTipText("Last Name");
				FTFResidentLastName_3.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						do_FTFResidentLastName_3_focusGained(arg0);
					}
				});
				FTFResidentLastName_3.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						do_FTFResidentLastName_3_propertyChange(arg0);
					}
				});
				
						FTFResidentLastName_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
						FTFResidentLastName_3.setBounds(214, 570, 177, 20);
						
						householdInfoPanel.add(FTFResidentLastName_3);
						FTFResidentFirstName_4.setToolTipText("First Name");
						FTFResidentFirstName_4.addFocusListener(new FocusAdapter() {
							@Override
							public void focusGained(FocusEvent arg0) {
								do_FTFResidentFirstName_4_focusGained(arg0);
							}
						});
						FTFResidentFirstName_4.addPropertyChangeListener(new PropertyChangeListener() {
							public void propertyChange(PropertyChangeEvent arg0) {
								do_FTFResidentFirstName_4_propertyChange(arg0);
							}
						});
						FTFResidentFirstName_4.setBounds(722, 126, 177, 20);
						
						householdInfoPanel.add(FTFResidentFirstName_4);
						FTFResidentLastName_4.setToolTipText("Last Name");
						FTFResidentLastName_4.addFocusListener(new FocusAdapter() {
							@Override
							public void focusGained(FocusEvent arg0) {
								do_FTFResidentLastName_4_focusGained(arg0);
							}
						});
						FTFResidentLastName_4.addPropertyChangeListener(new PropertyChangeListener() {
							public void propertyChange(PropertyChangeEvent arg0) {
								do_FTFResidentLastName_4_propertyChange(arg0);
							}
						});
						FTFResidentLastName_4.setBounds(722, 154, 177, 20);
						
						householdInfoPanel.add(FTFResidentLastName_4);
						FTFResidentFirstName_5.setToolTipText("First Name");
						FTFResidentFirstName_5.addFocusListener(new FocusAdapter() {
							@Override
							public void focusGained(FocusEvent arg0) {
								do_FTFResidentFirstName_5_focusGained(arg0);
							}
						});
						FTFResidentFirstName_5.addPropertyChangeListener(new PropertyChangeListener() {
							public void propertyChange(PropertyChangeEvent arg0) {
								do_FTFResidentFirstName_5_propertyChange(arg0);
							}
						});
						FTFResidentFirstName_5.setBounds(722, 331, 177, 20);
						
						householdInfoPanel.add(FTFResidentFirstName_5);
						FTFResidentLastName_5.setToolTipText("Last Name");
						FTFResidentLastName_5.addFocusListener(new FocusAdapter() {
							@Override
							public void focusGained(FocusEvent arg0) {
								do_FTFResidentLastName_5_focusGained(arg0);
							}
						});
						FTFResidentLastName_5.addPropertyChangeListener(new PropertyChangeListener() {
							public void propertyChange(PropertyChangeEvent arg0) {
								do_FTFResidentLastName_5_propertyChange(arg0);
							}
						});
						FTFResidentLastName_5.setBounds(722, 359, 177, 20);
						
						householdInfoPanel.add(FTFResidentLastName_5);
						FTFResidentFirstName_6.setToolTipText("First Name");
						FTFResidentFirstName_6.addFocusListener(new FocusAdapter() {
							@Override
							public void focusGained(FocusEvent arg0) {
								do_FTFResidentFirstName_6_focusGained(arg0);
							}
						});
						FTFResidentFirstName_6.addPropertyChangeListener(new PropertyChangeListener() {
							public void propertyChange(PropertyChangeEvent arg0) {
								do_FTFResidentFirstName_6_propertyChange(arg0);
							}
						});
						FTFResidentFirstName_6.setBounds(722, 542, 177, 20);
						
						householdInfoPanel.add(FTFResidentFirstName_6);
						FTFResidentLastName_6.setToolTipText("Last Name");
						FTFResidentLastName_6.addFocusListener(new FocusAdapter() {
							@Override
							public void focusGained(FocusEvent arg0) {
								do_FTFResidentLastName_6_focusGained(arg0);
							}
						});
						FTFResidentLastName_6.addPropertyChangeListener(new PropertyChangeListener() {
							public void propertyChange(PropertyChangeEvent arg0) {
								do_FTFResidentLastName_6_propertyChange(arg0);
							}
						});
						FTFResidentLastName_6.setBounds(722, 570, 177, 20);
						
						householdInfoPanel.add(FTFResidentLastName_6);
		financialInfoPanel.setBackground(Color.WHITE);
		
		tabbedPane.addTab("Financial Info", null, financialInfoPanel, null);
		financialInfoPanel.setLayout(null);
		separator_2.setBounds(10, 42, 431, 2);
		
		financialInfoPanel.add(separator_2);
		lblIncome.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblIncome.setBounds(21, 11, 153, 33);
		
		financialInfoPanel.add(lblIncome);
		lblIncomedirections.setFont(new Font("SansSerif", Font.ITALIC, 12));
		lblIncomedirections.setBounds(31, 54, 408, 14);
		
		financialInfoPanel.add(lblIncomedirections);
		lblSalary.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblSalary.setBounds(41, 107, 115, 20);
		
		financialInfoPanel.add(lblSalary);
		lblUnemployment.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblUnemployment.setBounds(41, 138, 115, 20);
		
		financialInfoPanel.add(lblUnemployment);
		lbltanf.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lbltanf.setBounds(41, 167, 115, 20);
		financialInfoPanel.add(lbltanf);
		
		lblSocialsecurity.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblSocialsecurity.setBounds(41, 196, 115, 20);
		
		financialInfoPanel.add(lblSocialsecurity);
		lblDisability.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblDisability.setBounds(41, 225, 115, 20);
		
		financialInfoPanel.add(lblDisability);
		lblChildSupport.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblChildSupport.setBounds(41, 256, 115, 20);
		
		financialInfoPanel.add(lblChildSupport);
		lblUtilityAssistance.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblUtilityAssistance.setBounds(41, 287, 115, 20);
		
		financialInfoPanel.add(lblUtilityAssistance);
		lblFoodStamps.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblFoodStamps.setBounds(41, 318, 115, 20);
		
		financialInfoPanel.add(lblFoodStamps);
		lblOther.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblOther.setBounds(41, 349, 115, 20);
		
		financialInfoPanel.add(lblOther);
		FTFSalary.setToolTipText("Salary");
		FTFSalary.setForeground(Color.GRAY);
		FTFSalary.setFont(new Font("SansSerif", Font.PLAIN, 12));
		FTFSalary.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_FTFSalary_focusLost(arg0);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFSalary_focusGained(e);
			}
		});
		FTFSalary.setBounds(166, 108, 230, 20);
		financialInfoPanel.add(FTFSalary);
		FTFSalary.setText(moneyFormat.format(0.00));
		FTFUnemployment.setToolTipText("Unemployment");
		FTFUnemployment.setForeground(Color.GRAY);
		FTFUnemployment.setFont(new Font("SansSerif", Font.PLAIN, 12));
		FTFUnemployment.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFUnemployment_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFUnemployment_focusGained(e);
			}
		});

		FTFUnemployment.setBounds(166, 138, 230, 20);
		financialInfoPanel.add(FTFUnemployment);
		FTFUnemployment.setText(moneyFormat.format(0.00));
		FTFtanf.setToolTipText("TANF/AFDC");
		FTFtanf.setForeground(Color.GRAY);
		FTFtanf.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		FTFtanf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFtanf_FocusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFtanf_focusGained(e);
			}
		});
		FTFtanf.setBounds(166, 169, 230, 20);
		financialInfoPanel.add(FTFtanf);
		FTFtanf.setText(moneyFormat.format(0.00));
		FTFSocialSecurity.setToolTipText("Social Security");
		FTFSocialSecurity.setForeground(Color.GRAY);
		FTFSocialSecurity.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		FTFSocialSecurity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFSocialSecurity_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFSocialSecurity_focusGained(e);
			}
		});
		FTFSocialSecurity.setBounds(166, 196, 230, 20);
		financialInfoPanel.add(FTFSocialSecurity);
		FTFSocialSecurity.setText(moneyFormat.format(0.00));
		FTFDisability.setToolTipText("Disability");
		FTFDisability.setForeground(Color.GRAY);
		FTFDisability.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		FTFDisability.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFDisability_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFDisability_focusGained(e);
			}
		});
		FTFDisability.setBounds(166, 226, 230, 20);
		financialInfoPanel.add(FTFDisability);
		FTFDisability.setText(moneyFormat.format(0.00));
		FTFChildSupport.setToolTipText("Child Support");
		FTFChildSupport.setForeground(Color.GRAY);
		FTFChildSupport.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		FTFChildSupport.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFChildSupport_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFChildSupport_focusGained(e);
			}
		});
		FTFChildSupport.setBounds(166, 257, 230, 20);
		financialInfoPanel.add(FTFChildSupport);
		FTFChildSupport.setText(moneyFormat.format(0.00));
		FTFUtilityAssistance.setToolTipText("Utility Assistance");
		FTFUtilityAssistance.setForeground(Color.GRAY);
		FTFUtilityAssistance.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		FTFUtilityAssistance.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFUtilityAssistance_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFUtilityAssistance_focusGained(e);
			}
		});
		FTFUtilityAssistance.setBounds(166, 288, 230, 20);
		financialInfoPanel.add(FTFUtilityAssistance);
		FTFUtilityAssistance.setText(moneyFormat.format(0.00));
		FTFFoodStamps.setToolTipText("Food Stamps");
		FTFFoodStamps.setForeground(Color.GRAY);
		FTFFoodStamps.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		FTFFoodStamps.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFFoodStamps_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFFoodStamps_focusGained(e);
			}
		});
		FTFFoodStamps.setBounds(166, 319, 230, 20);
		financialInfoPanel.add(FTFFoodStamps);
		FTFFoodStamps.setText(moneyFormat.format(0.00));
		FTFOther.setToolTipText("Other");
		FTFOther.setForeground(Color.GRAY);
		FTFOther.setFont(new Font("SansSerif", Font.PLAIN, 12));
		FTFOther.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFOther_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFOther_focusGained(e);
			}
		});

		FTFOther.setBounds(166, 350, 230, 20);
		
		financialInfoPanel.add(FTFOther);
		FTFOther.setText(moneyFormat.format(0.00));
		separator_2_1.setBounds(579, 42, 440, 2);
		
		financialInfoPanel.add(separator_2_1);
		lblExpenses.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblExpenses.setBounds(589, 11, 279, 33);
		
		financialInfoPanel.add(scrollPane_1);
		txtpnExplainIncome.setToolTipText("Explain here...");
		txtpnExplainIncome.setForeground(Color.GRAY);
		txtpnExplainIncome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				do_txtpnExplainIncome_focusGained(e);
			}
		});
		txtpnExplainIncome.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(txtpnExplainIncome);
		txtpnExplainIncome.setText("Explain here...");
		txtpnExplainIncome.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		/*************************************************************************************************************************
		 **************************************************************************************************************************
		 * Financial: Expenses Components
		 **************************************************************************************************************************
		 *************************************************************************************************************************/
		financialInfoPanel.add(lblExpenses);
		lblExpenseDirections.setFont(new Font("SansSerif", Font.ITALIC, 12));
		lblExpenseDirections.setBounds(599, 54, 408, 14);
		
		//Label Expense
		financialInfoPanel.add(lblExpenseDirections);
		lblRent.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblRent.setBounds(610, 107, 115, 20);
		financialInfoPanel.add(lblRent);
		FTFRent.setToolTipText("Rent");
		FTFRent.setForeground(new Color(205, 92, 92));
		FTFRent.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//FTF Rent
		FTFRent.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFRent_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFRent_focusGained(e);
			}
		});
		FTFRent.setBounds(735, 107, 230, 20);
		financialInfoPanel.add(FTFRent);
		FTFRent.setText(moneyFormat.format(0.00));
		
		//Label Phone Bill
		lblPhoneBill.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblPhoneBill.setBounds(610, 138, 115, 20);
		financialInfoPanel.add(lblPhoneBill);
		FTFPhoneBill.setToolTipText("Phone Bill");
		FTFPhoneBill.setForeground(new Color(205, 92, 92));
		FTFPhoneBill.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//FTF Phone Bill
		FTFPhoneBill.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFPhoneBill_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFPhoneBill_focusGained(e);
			}
		});
		FTFPhoneBill.setBounds(735, 138, 230, 20);
		financialInfoPanel.add(FTFPhoneBill);
		FTFPhoneBill.setText(moneyFormat.format(0.00));
		
		//Label Gas Water
		lblGasWater.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblGasWater.setBounds(610, 167, 115, 20);
		financialInfoPanel.add(lblGasWater);
		FTFGasWater.setToolTipText("Gas/Water");
		FTFGasWater.setForeground(new Color(205, 92, 92));
		FTFGasWater.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//FTF Gas/Water
		FTFGasWater.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFGasWater_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFGasWater_focusGained(e);
			}
		});
		FTFGasWater.setBounds(735, 169, 230, 20);
		financialInfoPanel.add(FTFGasWater);
		FTFGasWater.setText(moneyFormat.format(0.00));
		
		//Label Light Bill
		lblLightBill.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblLightBill.setBounds(610, 196, 115, 20);
		financialInfoPanel.add(lblLightBill);
		FTFLightBill.setToolTipText("Light Bill");
		FTFLightBill.setForeground(new Color(205, 92, 92));
		FTFLightBill.setFont(new Font("SansSerif", Font.PLAIN, 12));
	
		//FTF Light Bill
		FTFLightBill.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFLightBill_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFLightBill_focusGained(e);
			}
		});
		FTFLightBill.setBounds(735, 197, 230, 20);
		financialInfoPanel.add(FTFLightBill);
		FTFLightBill.setText(moneyFormat.format(0.00));
		
		//Label Car Payment
		lblCarPayment.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblCarPayment.setBounds(610, 227, 115, 20);
		financialInfoPanel.add(lblCarPayment);
		FTFCarPayment.setToolTipText("Car Payment");
		FTFCarPayment.setForeground(new Color(205, 92, 92));
		FTFCarPayment.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//FTF Car Payment
		FTFCarPayment.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFCarPayment_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFCarPayment_focusGained(e);
			}
		});
		FTFCarPayment.setBounds(735, 228, 230, 20);
		financialInfoPanel.add(FTFCarPayment);
		FTFCarPayment.setText(moneyFormat.format(0.00));
		
		//Label Furnace Appliances
		lblFurnaceAppliances.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblFurnaceAppliances.setBounds(610, 258, 115, 20);
		financialInfoPanel.add(lblFurnaceAppliances);
		FTFFurnaceAppliances.setToolTipText("Furnace Appliances");
		FTFFurnaceAppliances.setForeground(new Color(205, 92, 92));
		FTFFurnaceAppliances.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//FTF Furnace Appliances
		FTFFurnaceAppliances.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFFurnaceAppliances_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFFurnaceAppliances_focusGained(e);
			}
		});
		FTFFurnaceAppliances.setBounds(735, 259, 230, 20);
		financialInfoPanel.add(FTFFurnaceAppliances);
		FTFFurnaceAppliances.setText(moneyFormat.format(0.00));
		
		//Label Cable TV
		lblCableTV.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblCableTV.setBounds(610, 287, 115, 20);
		financialInfoPanel.add(lblCableTV);
		FTFCableTV.setToolTipText("Cable TV");
		FTFCableTV.setForeground(new Color(205, 92, 92));
		FTFCableTV.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//FTF Cable TV
		FTFCableTV.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFCableTV_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFCableTV_focusGained(e);
			}
		});
		FTFCableTV.setBounds(735, 288, 230, 20);
		financialInfoPanel.add(FTFCableTV);
		FTFCableTV.setText(moneyFormat.format(0.00));
		
		//Label Doctor/Medical
		lblDoctorMedical.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblDoctorMedical.setBounds(610, 318, 115, 20);
		financialInfoPanel.add(lblDoctorMedical);
		FTFDoctorMedical.setToolTipText("Doctor/Medical");
		FTFDoctorMedical.setForeground(new Color(205, 92, 92));
		FTFDoctorMedical.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//FTF Doctor/Medical
		FTFDoctorMedical.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFDoctorMedical_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFDoctorMedical_focusGained(e);
			}
		});
		FTFDoctorMedical.setBounds(735, 319, 230, 20);
		financialInfoPanel.add(FTFDoctorMedical);
		FTFDoctorMedical.setText(moneyFormat.format(0.00));
		
		//Label Other Expenses
		lblOtherExpenses.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblOtherExpenses.setBounds(610, 347, 115, 20);
		financialInfoPanel.add(lblOtherExpenses);
		FTFOtherExpenses.setToolTipText("Other");
		FTFOtherExpenses.setForeground(new Color(205, 92, 92));
		FTFOtherExpenses.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//FTF Other Expenses
		FTFOtherExpenses.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_FTFOtherExpenses_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_FTFOtherExpenses_focusGained(e);
			}
		});
		FTFOtherExpenses.setBounds(735, 348, 230, 20);
		financialInfoPanel.add(FTFOtherExpenses);
		FTFOtherExpenses.setText(moneyFormat.format(0.00));
		
		//Text Pane Other Expenses
		scrollPane_2.setBounds(620, 378, 345, 99);
		financialInfoPanel.add(scrollPane_2);
		txtpnExplainExpenses.setToolTipText("Explain here...");
		txtpnExplainExpenses.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				do_txtpnExplainExpenses_focusGained(e);
			}
		});
		txtpnExplainExpenses.setForeground(Color.GRAY);
		txtpnExplainExpenses.setBackground(Color.WHITE);
		scrollPane_2.setViewportView(txtpnExplainExpenses);
		txtpnExplainExpenses.setText("Explain here...");
		txtpnExplainExpenses.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//Separators
		separator_2_2.setBounds(10, 562, 1009, 2);
		financialInfoPanel.add(separator_2_2);
		
		separator_12.setOrientation(SwingConstants.VERTICAL);
		separator_12.setBounds(495, 11, 2, 470);
		financialInfoPanel.add(separator_12);
		
		/*************************************************************************************************************************
		 *************************************************************************************************************************
		 * Financial: Financial Summary Components
		 *************************************************************************************************************************
		 *************************************************************************************************************************/
		//Header: financial summary
		lblFinancialSummary.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblFinancialSummary.setBounds(21, 531, 153, 33);
		financialInfoPanel.add(lblFinancialSummary);
		
		//Separator
		separator_13.setBounds(123, 727, 776, 2);
		financialInfoPanel.add(separator_13);
		
		//Label Total Income
		lblTotalIncome.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblTotalIncome.setBounds(166, 617, 115, 20);
		financialInfoPanel.add(lblTotalIncome);
		
		//Label Total Expenses
		lblTotalExpenses.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblTotalExpenses.setBounds(166, 670, 115, 20);
		financialInfoPanel.add(lblTotalExpenses);
		
		//Label Net Income
		lblNetIncome.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNetIncome.setBounds(166, 758, 115, 20);
		financialInfoPanel.add(lblNetIncome);
		
		//Label: Total Income Value
		lblTotalIncomeValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalIncomeValue.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblTotalIncomeValue.setBounds(571, 617, 279, 20);
		financialInfoPanel.add(lblTotalIncomeValue);
		
		//Label: Net Expenses Value
		lblTotalExpensesValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalExpensesValue.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblTotalExpensesValue.setBounds(571, 683, 279, 20);
		financialInfoPanel.add(lblTotalExpensesValue);
		
		//Label: Net Income Value
		lblNetIncomeValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNetIncomeValue.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNetIncomeValue.setBounds(571, 758, 279, 20);
		financialInfoPanel.add(lblNetIncomeValue);
		scrollPane_1.setBounds(51, 380, 345, 97);
		lblFinancialInfoApplicant.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFinancialInfoApplicant.setForeground(Color.GRAY);
		lblFinancialInfoApplicant.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblFinancialInfoApplicant.setBackground(Color.WHITE);
		lblFinancialInfoApplicant.setBounds(567, 543, 452, 14);
		
		financialInfoPanel.add(lblFinancialInfoApplicant);
		txtpnToWhomIt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtpnToWhomIt.setText("TO WHOM IT MAY CONCERN: I understand that the Salvation Army is a Christian and Charitable Organization, and that they are soley dedicated to the social and physical rehabilitation and/or spiritual regeneration of those persons who are in neew of uch assistance. I agree that any given personal information regarding me and my family, given to the Salvation Army, may be give to other agencies/individuals who may can help me with my needs. also I understand that a completed application does not guarentee assistance. This is only an assesment tool to understand need.");
		txtpnToWhomIt.setBounds(56, 828, 909, 79);
		
		financialInfoPanel.add(txtpnToWhomIt);
		
		financialInfoPanel.add(FTFDate);
		lblIncomeError.setVisible(false);
		lblIncomeError.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncomeError.setForeground(Color.RED);
		lblIncomeError.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblIncomeError.setBounds(41, 79, 345, 14);
		
		financialInfoPanel.add(lblIncomeError);
		lblExpenseError.setVisible(false);
		lblExpenseError.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpenseError.setForeground(Color.RED);
		lblExpenseError.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblExpenseError.setBounds(609, 79, 398, 14);
		
		financialInfoPanel.add(lblExpenseError);
		
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 1129, 24);
		
		contentPane.add(menuBar);
		mnFile.setForeground(Color.BLACK);
		mnFile.setBackground(Color.WHITE);
		
		menuBar.add(mnFile);
		mntmStartNewApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmStartNewApplication_actionPerformed(arg0);
			}
		});
		
		txtpnProblem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_txtpnProblem_focusGained(arg0);
			}
		});
		
		mnFile.add(mntmStartNewApplication);
		mnFile.add(mntmExit);
		mnHelp.setBackground(Color.WHITE);
		mnHelp.setForeground(Color.BLACK);
		menuBar.add(mnHelp);	
		mnHelp.add(mntmApplicantInfoHelp);
		mnHelp.add(mntmHouseholdDetails);
		mnHelp.add(mntmFinancialInfoHelp);
		
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmExit_actionPerformed(arg0);
			}
		});
		
		mntmApplicantInfoHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmApplicantInfoHelp_actionPerformed(arg0);
			}
		});
		
		mntmApplicantInfoHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmApplicantInfoHelp_actionPerformed(arg0);
			}
		});
		
		mntmFinancialInfoHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmFinancialInfoHelp_actionPerformed(arg0);
			}
		});
		
		mntmApplicantInfoHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmApplicantInfoHelp_actionPerformed(arg0);
			}
		});
		
		mntmHouseholdDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmHouseholdDetails_actionPerformed(arg0);
			}
		});
		
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				do_tabbedPane_stateChanged(arg0);
			}
		});
		
		
	}//jbInit
	
	/************************************************************************************************************************
	 ************************************************************************************************************************
	 ***************************************************Application Tab******************************************************
	 ************************************************************************************************************************
	 ************************************************************************************************************************/
	
	/*************************************************************************************************************************
	 * Identification And Contact
	 *************************************************************************************************************************/
	protected void do_FTFFirstName_focusLost(FocusEvent arg0) {
		if (!checkValidFormattedTextOnlyField(FTFFirstName, lblFirstName)){
			lblidentificationAndContactErrorMessage.setVisible(true);
			lblidentificationAndContactErrorMessage.setText("First name field cannot have numbers.");
			lblFirstName.setForeground(Color.red);
			FTFFirstName.grabFocus();
		} else if (isFTFEmpty(FTFFirstName, lblFirstName)) {
			lblidentificationAndContactErrorMessage.setVisible(true); 
			lblidentificationAndContactErrorMessage.setText("First name field is required.");
			FTFFirstName.grabFocus();
		} else {
			lblHouseholdApplicant.setText(FTFFirstName.getText().trim());
			lblFirstName.setForeground(Color.black);
			lblidentificationAndContactErrorMessage.setVisible(false);
		}
	}
	
	protected void do_FTFLastName_propertyChange(PropertyChangeEvent arg0) {
		if (!checkValidFormattedTextOnlyField(FTFLastName, lblLastName)){
			lblidentificationAndContactErrorMessage.setVisible(true);
			lblidentificationAndContactErrorMessage.setText("Last name field cannot have numbers.");
			lblLastName.setForeground(Color.red);
		} else if (isFTFEmpty(FTFLastName, lblLastName)) {
			lblidentificationAndContactErrorMessage.setVisible(true); 
			lblidentificationAndContactErrorMessage.setText("Last name field is required.");
		} else {
			String fname = FTFFirstName.getText().trim();
			String lname = FTFLastName.getText().trim();
			String fullName = fname + " " + lname;
			lblFinancialInfoApplicant.setText("Applicant: " + fullName);
			lblHouseholdApplicant.setText("Applicant: " + fullName);
			lblLastName.setForeground(Color.black);
			lblidentificationAndContactErrorMessage.setVisible(false);
		}
	}//do_FTFLastName_propertyChange
	
	protected void do_formattedTextFieldSocialSecurityNumber_focusLost(FocusEvent arg0) {
		if (formattedTextFieldSocialSecurityNumber.getText().contains("#")) {
			lblSocialSecurityNumber.setForeground(Color.red);
			lblidentificationAndContactErrorMessage.setVisible(true); 
			lblidentificationAndContactErrorMessage.setText("Social security number field is required.");
		} else {
			lblSocialSecurityNumber.setForeground(Color.black);
			lblidentificationAndContactErrorMessage.setVisible(false);}
	}//do_formattedTextFieldSocialSecurityNumber_focusLost
	
	protected void do_formattedTextFieldPhoneNumber_focusLost(FocusEvent arg0) {
		if (formattedTextFieldPhoneNumber.getText().contains("#")) {
			lblPhoneNumber.setForeground(Color.red);
			lblidentificationAndContactErrorMessage.setVisible(true);
			lblidentificationAndContactErrorMessage.setText("Phone number field is required.");
		} else {
			lblPhoneNumber.setForeground(Color.black);
			lblidentificationAndContactErrorMessage.setVisible(false);}
	}//do_formattedTextFieldPhoneNumber_focusLost

	protected void do_FTFLastName_focusGained(FocusEvent arg0) {
		clearFTF(FTFLastName);
	}//do_FTFLastName_focusGained
	
	protected void do_FTFFirstName_focusGained(FocusEvent arg0) {
		clearFTF(FTFFirstName);
	}//do_FTFFirstName_focusGained
	
	protected void do_comboBoxYear_actionPerformed(ActionEvent arg0) {
		getBirthDate(comboBoxYear, comboBoxMonth, comboBoxDay, comboBoxYear, lblDateOfBirth);
		if (comboBoxYear.getSelectedItem().toString() == "Y") {
			lblDateOfBirth.setForeground(Color.red);
		} else lblDateOfBirth.setForeground(Color.black);
	}//do_comboBoxYear_actionPerformed
	
	protected void do_comboBoxMonth_actionPerformed(ActionEvent arg0) {
		getBirthDate(comboBoxMonth, comboBoxMonth, comboBoxDay, comboBoxYear, lblDateOfBirth);
		if (comboBoxMonth.getSelectedItem().toString() == "M") {
			lblDateOfBirth.setForeground(Color.red);
		} else lblDateOfBirth.setForeground(Color.black);
	}//do_comboBoxMonth_actionPerformed
	
	protected void do_comboBoxDay_actionPerformed(ActionEvent arg0) {
		getBirthDate(comboBoxDay, comboBoxMonth, comboBoxDay, comboBoxYear, lblDateOfBirth);
		if (comboBoxDay.getSelectedItem().toString() == "D") {
			lblDateOfBirth.setForeground(Color.red);
		} else lblDateOfBirth.setForeground(Color.black);
	}//do_comboBoxDay_actionPerformed
	
	/*************************************************************************************************************************
	 * Employment
	 *************************************************************************************************************************/
	protected void do_rdbtnYes_actionPerformed(ActionEvent arg0) {
		lblPlaceEmployed.enable();
		lblPlaceEmployed.setBackground(Color.white);
		comboBoxMonthsUnemployed.setBackground(Color.lightGray);
		comboBoxDaysUnemployed.setBackground(Color.lightGray);
		comboBoxYearsUnemployed.setBackground(Color.lightGray);
		comboBoxMonthsUnemployed.disable();
		comboBoxDaysUnemployed.disable();
		comboBoxYearsUnemployed.disable();
		comboBoxMonthsUnemployed.setSelectedIndex(0);
		comboBoxDaysUnemployed.setSelectedIndex(0);
		comboBoxYearsUnemployed.setSelectedIndex(0);
	}//do_rdbtnYes_actionPerformed
	
	protected void do_rdbtnNo_actionPerformed(ActionEvent arg0) {
		lblPlaceEmployed.setText("");
		lblPlaceEmployed.disable();
		lblPlaceEmployed.setBackground(Color.lightGray);
		comboBoxMonthsUnemployed.enable();
		comboBoxMonthsUnemployed.setBackground(Color.white);
		comboBoxDaysUnemployed.enable();
		comboBoxDaysUnemployed.setBackground(Color.white);
		comboBoxYearsUnemployed.enable();
		comboBoxYearsUnemployed.setBackground(Color.white);
	}//do_rdbtnNo_actionPerformed
	
	protected void do_comboBoxDaysUnemployed_focusGained(FocusEvent arg0) {
		comboBoxDaysUnemployed.setBackground(Color.white);
		comboBoxMonthsUnemployed.setSelectedIndex(0);
		comboBoxYearsUnemployed.setSelectedIndex(0);
		comboBoxMonthsUnemployed.setBackground(Color.lightGray);
		comboBoxYearsUnemployed.setBackground(Color.lightGray);
	}//do_comboBoxDaysUnemployed_focusGained
	
	protected void do_comboBoxMonthsUnemployed_focusGained(FocusEvent arg0) {
		comboBoxMonthsUnemployed.setBackground(Color.white);
		comboBoxDaysUnemployed.setSelectedIndex(0);
		comboBoxYearsUnemployed.setSelectedIndex(0);
		comboBoxDaysUnemployed.setBackground(Color.lightGray);
		comboBoxYearsUnemployed.setBackground(Color.lightGray);
	}//do_comboBoxMonthsUnemployed_focusGained
	
	protected void do_comboBoxYearsUnemployed_focusGained(FocusEvent arg0) {
		comboBoxYearsUnemployed.setBackground(Color.white);
		comboBoxMonthsUnemployed.setSelectedIndex(0);
		comboBoxDaysUnemployed.setSelectedIndex(0);
		comboBoxMonthsUnemployed.setBackground(Color.lightGray);
		comboBoxDaysUnemployed.setBackground(Color.lightGray);
	}//do_comboBoxYearsUnemployed_focusGained
	
	/*************************************************************************************************************************
	 * Location
	 *************************************************************************************************************************/
	protected void do_FTFCity_propertyChange(PropertyChangeEvent arg0) {
		if (!checkValidFormattedTextOnlyField(FTFCity, lblCity)){
			lblLocationErrorMessage.setVisible(true);
			lblLocationErrorMessage.setText("City field cannot have numbers.");
			lblCity.setForeground(Color.red);
		} else if (isFTFEmpty(FTFCity, lblCity)) {
			lblLocationErrorMessage.setVisible(true); 
			lblLocationErrorMessage.setText("City field is required.");
		} else {
			lblCity.setForeground(Color.black);
			lblLocationErrorMessage.setVisible(false);
		}
	}//do_FTFCity_propertyChange
	
	protected void do_FTFCity_focusGained(FocusEvent arg0) {
		clearFTF(FTFCity);
	}//do_FTFCity_focusGained
	
	protected void do_FTFAddress_focusLost(FocusEvent arg0) {
		if (FTFAddress.getText().trim().isEmpty()) {
			lblAddress.setForeground(Color.red);
			lblLocationErrorMessage.setVisible(true);
			lblLocationErrorMessage.setText("Address is required");
		} else {
			lblLocationErrorMessage.setVisible(false);
			lblAddress.setForeground(Color.black);
		}//if-else
	}//do_FTFAddress_focusLost
	
	protected void do_FTFZipCode_focusLost(FocusEvent arg0) {
		if (FTFZipCode.getText().contains("#")) {
			lblZipCode.setForeground(Color.red);
			lblLocationErrorMessage.setVisible(true);
			lblLocationErrorMessage.setText("Zip code is required");
		} else {
			lblLocationErrorMessage.setVisible(false);
			lblZipCode.setForeground(Color.black);
		}//if-else
	}//do_FTFZipCode_focusLost
	
	/*************************************************************************************************************************
	 * Spouse Identification
	 *************************************************************************************************************************/
	protected void do_FTFSpouseFirstName_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFSpouseFirstName, lblSpouseFirstName);
	}//do_FTFSpouseFirstName_propertyChange
	
	protected void do_FTFSpouseLastName_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFSpouseLastName, lblSpouseLastName);
	}//do_FTFSpouseLastName_propertyChange
	
	protected void do_FTFSpouseFirstName_focusGained(FocusEvent arg0) {
		clearFTF(FTFSpouseFirstName);
	}//do_FTFSpouseFirstName_focusGained
	
	protected void do_FTFSpouseLastName_focusGained(FocusEvent arg0) {
		clearFTF(FTFSpouseLastName);
	}//do_FTFSpouseLastName_focusGained
	
	protected void do_comboBoxSpouseDay_actionPerformed(ActionEvent arg0) {
		getBirthDate(comboBoxSpouseDay, comboBoxSpouseMonth, comboBoxSpouseDay, comboBoxSpouseYear, lblSpouseDateOfBirth);
	}//do_comboBoxSpouseDay_actionPerformed
	
	protected void do_comboBoxSpouseYear_actionPerformed(ActionEvent arg0) {
		getBirthDate(comboBoxSpouseYear, comboBoxSpouseMonth, comboBoxSpouseDay, comboBoxSpouseYear, lblSpouseDateOfBirth);
	}//do_comboBoxSpouseYear_actionPerformed
	
	protected void do_comboBoxSpouseMonth_actionPerformed(ActionEvent arg0) {
		getBirthDate(comboBoxSpouseMonth, comboBoxSpouseMonth, comboBoxSpouseDay, comboBoxSpouseYear, lblSpouseDateOfBirth);
	}//do_comboBoxSpouseMonth_actionPerformed
	
	/*************************************************************************************************************************
	 * Spouse Employment
	 *************************************************************************************************************************/
	protected void do_rdbtnSpouseYes_actionPerformed(ActionEvent arg0) {
		textField_2.enable();
		textField_2.setBackground(Color.white);
		comboBoxSpouseMonthsUnemployed.setBackground(Color.lightGray);
		comboBoxSpouseDaysUnemployed.setBackground(Color.lightGray);
		comboBoxSpouseYearsUnemployed.setBackground(Color.lightGray);
		comboBoxSpouseMonthsUnemployed.disable();
		comboBoxSpouseDaysUnemployed.disable();
		comboBoxSpouseYearsUnemployed.disable();
		comboBoxSpouseMonthsUnemployed.setSelectedIndex(0);
		comboBoxSpouseDaysUnemployed.setSelectedIndex(0);
		comboBoxSpouseYearsUnemployed.setSelectedIndex(0);
			
	}//do_rdbtnSpouseYes_actionPerformed
	
	protected void do_rdbtnSpouseNo_actionPerformed(ActionEvent arg0) {
		textField_2.setText("");
		textField_2.disable();
		textField_2.setBackground(Color.lightGray);
		comboBoxSpouseMonthsUnemployed.enable();
		comboBoxSpouseMonthsUnemployed.setBackground(Color.white);
		comboBoxSpouseDaysUnemployed.enable();
		comboBoxSpouseDaysUnemployed.setBackground(Color.white);
		comboBoxSpouseYearsUnemployed.enable();
		comboBoxSpouseYearsUnemployed.setBackground(Color.white);
	}//do_rdbtnSpouseNo_actionPerformed
	
	protected void do_comboBoxSpouseMonthsUnemployed_focusGained(FocusEvent arg0) {
		comboBoxSpouseMonthsUnemployed.setBackground(Color.white);
		comboBoxSpouseDaysUnemployed.setSelectedIndex(0);
		comboBoxSpouseYearsUnemployed.setSelectedIndex(0);
		comboBoxSpouseDaysUnemployed.setBackground(Color.lightGray);
		comboBoxSpouseYearsUnemployed.setBackground(Color.lightGray);
	}//do_comboBoxSpouseMonthsUnemployed_focusGained
	
	protected void do_comboBoxSpouseDaysUnemployed_focusGained(FocusEvent arg0) {
		comboBoxSpouseDaysUnemployed.setBackground(Color.white);
		comboBoxSpouseMonthsUnemployed.setSelectedIndex(0);
		comboBoxSpouseYearsUnemployed.setSelectedIndex(0);
		comboBoxSpouseMonthsUnemployed.setBackground(Color.lightGray);
		comboBoxSpouseYearsUnemployed.setBackground(Color.lightGray);
	}//do_comboBoxSpouseDaysUnemployed_focusGained
	
	protected void do_comboBoxSpouseYearsUnemployed_focusGained(FocusEvent arg0) {
		comboBoxSpouseYearsUnemployed.setBackground(Color.white);
		comboBoxSpouseMonthsUnemployed.setSelectedIndex(0);
		comboBoxSpouseDaysUnemployed.setSelectedIndex(0);
		comboBoxSpouseMonthsUnemployed.setBackground(Color.lightGray);
		comboBoxSpouseDaysUnemployed.setBackground(Color.lightGray);
	}//do_comboBoxSpouseYearsUnemployed_focusGained
	
	/*************************************************************************************************************************
	 * Problem
	 *************************************************************************************************************************/
	protected void do_FTFReferredBy_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFReferredBy, lblReferredBy);
	}//do_FTFReferredBy_propertyChange
	
	protected void do_FTFAssistanceRequested_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFAssistanceRequested, lblAssistanceRequested);
	}//do_FTFAssistanceRequested_propertyChange
	
	protected void do_FTFReferredBy_focusGained(FocusEvent arg0) {
		clearFTF(FTFReferredBy);
	}//do_FTFReferredBy_focusGained
	
	protected void do_FTFAssistanceRequested_focusGained(FocusEvent arg0) {
		clearFTF(FTFAssistanceRequested);
	}//do_FTFAssistanceRequested_focusGained
	
	protected void do_txtpnProblem_focusGained(FocusEvent arg0) {
		if (txtpnProblem.getBackground() == Color.black || txtpnProblem.getBackground() == Color.red) {
			txtpnProblem.setText("");
			txtpnProblem.setBackground(Color.white);
		}//if
		if (txtpnProblem.getForeground() == Color.red || txtpnProblem.getForeground() == Color.gray) {
			txtpnProblem.setText("");
			txtpnProblem.setForeground(Color.black);
		}//if
	}//do_txtpnProblem_focusGained
	
	/************************************************************************************************************************
	 ************************************************************************************************************************
	 ****************************************************Household Tab*******************************************************
	 ************************************************************************************************************************
	 ************************************************************************************************************************/
	
	/************************************************************************************************
	 * Household First Name Property Change Methods
	 ************************************************************************************************/
	protected void do_FTFResidentFirstName_1_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFResidentFirstName_1, lblResidentFirstName_1);
	}//do_FTFResidentFirstName_1_propertyChange
	
	protected void do_FTFResidentFirstName_2_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFResidentFirstName_2, lblResidentFirstName_2);
	}//do_FTFResidentFirstName_2_propertyChange
	
	protected void do_FTFResidentFirstName_3_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFResidentFirstName_3, lblResidentFirstName_3);
	}//do_FTFResidentFirstName_3_propertyChange
	
	protected void do_FTFResidentFirstName_4_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFResidentFirstName_4, lblResidentFirstName_4);
	}//do_FTFResidentFirstName_4_propertyChange
	
	protected void do_FTFResidentFirstName_5_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFResidentFirstName_5, lblResidentFirstName_5);
	}//do_FTFResidentFirstName_5_propertyChange
	
	protected void do_FTFResidentFirstName_6_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFResidentFirstName_6, lblResidentFirstName_6);
	}//do_FTFResidentFirstName_6_propertyChange
	
	/************************************************************************************************
	 * Household Last Name Property Change Methods
	 ************************************************************************************************/
	protected void do_FTFResidentLastName_1_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFResidentLastName_1, lblResidentLastName_1);
	}//do_FTFResidentLastName_2_propertyChange
	
	protected void do_FTFResidentLastName_2_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFResidentLastName_2, lblResidentLastName_2);
	}//do_FTFResidentLastName_2_propertyChange
	
	protected void do_FTFResidentLastName_3_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFResidentLastName_3, lblResidentLastName_3);
	}//do_FTFResidentLastName_3_propertyChange
	
	protected void do_FTFResidentLastName_4_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFResidentLastName_4, lblResidentLastName_4);
	}//do_FTFResidentLastName_4_propertyChange
	
	protected void do_FTFResidentLastName_5_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFResidentLastName_5, lblResidentLastName_5);
	}//do_FTFResidentLastName_5_propertyChange
	
	protected void do_FTFResidentLastName_6_propertyChange(PropertyChangeEvent arg0) {
		checkValidFormattedTextOnlyField(FTFResidentLastName_6, lblResidentLastName_6);
	}//do_FTFResidentLastName_6_propertyChange
	
	/************************************************************************************************
	 * Household: First Name Focus Gained Methods
	 ************************************************************************************************/
	protected void do_FTFResidentFirstName_1_focusGained(FocusEvent arg0) {
		clearFTF(FTFResidentFirstName_1);
	}//do_FTFResidentFirstName_1_focusGained
	
	protected void do_FTFResidentFirstName_2_focusGained(FocusEvent arg0) {
		clearFTF(FTFResidentFirstName_2);
	}//do_FTFResidentFirstName_2_focusGained
	
	protected void do_FTFResidentFirstName_3_focusGained(FocusEvent arg0) {
		clearFTF(FTFResidentFirstName_3);
	}//do_FTFResidentFirstName_3_focusGained
	
	protected void do_FTFResidentFirstName_4_focusGained(FocusEvent arg0) {
		clearFTF(FTFResidentFirstName_4);
	}//do_FTFResidentFirstName_4_focusGained
	
	protected void do_FTFResidentFirstName_5_focusGained(FocusEvent arg0) {
		clearFTF(FTFResidentFirstName_5);
	}//do_FTFResidentFirstName_5_focusGained
	
	protected void do_FTFResidentFirstName_6_focusGained(FocusEvent arg0) {
		clearFTF(FTFResidentFirstName_6);
	}//do_FTFResidentFirstName_6_focusGained
	
	/************************************************************************************************
	 * Household: Last Name Focus Gained Methods
	 ************************************************************************************************/
	protected void do_FTFResidentLastName_1_focusGained(FocusEvent arg0) {
		clearFTF(FTFResidentLastName_1);
	}//do_FTFResidentLastName_2_focusGained
	
	protected void do_FTFResidentLastName_2_focusGained(FocusEvent arg0) {
		clearFTF(FTFResidentLastName_2);
	}//do_FTFResidentLastName_2_focusGained
	
	protected void do_FTFResidentLastName_3_focusGained(FocusEvent arg0) {
		clearFTF(FTFResidentLastName_3);
	}//do_FTFResidentLastName_3_focusGained
	
	protected void do_FTFResidentLastName_4_focusGained(FocusEvent arg0) {
		clearFTF(FTFResidentLastName_4);
	}//do_FTFResidentLastName_4_focusGained
	
	protected void do_FTFResidentLastName_5_focusGained(FocusEvent arg0) {
		clearFTF(FTFResidentLastName_5);
	}//do_FTFResidentLastName_5_focusGained
	
	protected void do_FTFResidentLastName_6_focusGained(FocusEvent arg0) {
		clearFTF(FTFResidentLastName_6);
	}//do_FTFResidentLastName_6_focusGained
	
	/************************************************************************************************************************
	 ************************************************************************************************************************
	 ****************************************************Financial Tab*******************************************************
	 ************************************************************************************************************************
	 ************************************************************************************************************************/
	
	/*************************************************************************************************************************
	 * Financial Tab: Income Focus Lost
	 *************************************************************************************************************************/
	protected void do_FTFSalary_focusLost(FocusEvent arg0) {
		if (isValidDollar(FTFSalary, lblSalary, Color.black)) {
			updateTotalIncome();
			lblIncomeError.setVisible(false);
		} else {lblIncomeError.setVisible(true);}
		resetNumberFTF(FTFSalary, lblSalary);
	}//do_FTFSalary_focusLost
	
	protected void do_FTFUnemployment_focusLost(FocusEvent e) {
		if (isValidDollar(FTFUnemployment, lblUnemployment, Color.black)) {
			updateTotalIncome();
			lblIncomeError.setVisible(false);
		} else {lblIncomeError.setVisible(true);}
		resetNumberFTF(FTFUnemployment, lblUnemployment);
	}//do_FTFUnemployment_focusLost
	
	protected void do_FTFtanf_FocusLost(FocusEvent e) {
		if (isValidDollar(FTFtanf, lbltanf, Color.black)) {
			updateTotalIncome();
			lblIncomeError.setVisible(false);
		}  else {lblIncomeError.setVisible(true);}
		resetNumberFTF(FTFtanf, lbltanf);
	}//do_FTFtanf_focusLost
	
	protected void do_FTFDisability_focusLost(FocusEvent e) {
		if (isValidDollar(FTFDisability, lblDisability, Color.black)) {
			updateTotalIncome();
			lblIncomeError.setVisible(false);
		}  else {lblIncomeError.setVisible(true);}
		resetNumberFTF(FTFDisability, lblDisability);
	}//do_FTFDisability_focusLost
	
	protected void do_FTFUtilityAssistance_focusLost(FocusEvent e) {
		if (isValidDollar(FTFUtilityAssistance, lblUtilityAssistance, Color.black)) {
			updateTotalIncome(); 
			lblIncomeError.setVisible(false);
		}  else {lblIncomeError.setVisible(true);}
		resetNumberFTF(FTFUtilityAssistance, lblUtilityAssistance);
	}//do_FTFUtilityAssistance_focusLost
	
	protected void do_FTFSocialSecurity_focusLost(FocusEvent e) {
		if (isValidDollar(FTFSocialSecurity, lblSocialsecurity, Color.black)) {
			updateTotalIncome();
			lblIncomeError.setVisible(false);
		}  else {lblIncomeError.setVisible(true);}
		resetNumberFTF(FTFSocialSecurity, lblSocialsecurity);
	}//do_FTFSocialSecurity_focusLost
	
	protected void do_FTFChildSupport_focusLost(FocusEvent e) {
		if (isValidDollar(FTFChildSupport, lblChildSupport, Color.black)) {
			updateTotalIncome();
			lblIncomeError.setVisible(false);
		}  else {lblIncomeError.setVisible(true);}
		resetNumberFTF(FTFChildSupport, lblChildSupport);
		
	}//do_FTFChildSupport_focusLost
	
	protected void do_FTFFoodStamps_focusLost(FocusEvent e) {
		if (isValidDollar(FTFFoodStamps, lblFoodStamps, Color.black)) {
			updateTotalIncome();
			lblIncomeError.setVisible(false);
		}  else {lblIncomeError.setVisible(true);}
		resetNumberFTF(FTFFoodStamps, lblFoodStamps);
	}//do_FTFFoodStamps_focusLost
	
	protected void do_FTFOther_focusLost(FocusEvent e) {
		if (isValidDollar(FTFOther, lblOther, Color.black)) {
			updateTotalIncome();
			lblIncomeError.setVisible(false);
		} else {lblIncomeError.setVisible(true);}
		resetNumberFTF(FTFOther, lblOther);
	}//do_FTFOther_focusLost
	
	/*************************************************************************************************************************
	 * Financial Tab: Expenses Focus Lost
	 *************************************************************************************************************************/
	protected void do_FTFGasWater_focusLost(FocusEvent e) {
		if (isValidDollar(FTFGasWater, lblGasWater, Color.red) ) {
			updateTotalExpenses();
			isExpenseGroupValid();
		} else {lblExpenseError.setVisible(true);}
		resetExpenseNumberFTF(FTFGasWater, lblGasWater);
	}//do_FTFGasWater_focusLost
	
	protected void do_FTFDoctorMedical_focusLost(FocusEvent e) {
		if (isValidDollar(FTFDoctorMedical, lblDoctorMedical, Color.red) ) {
			updateTotalExpenses();
			isExpenseGroupValid();
		} else {lblExpenseError.setVisible(true);}
		resetExpenseNumberFTF(FTFDoctorMedical, lblDoctorMedical);
	}//do_FTFDoctorMedical_focusLost
	
	protected void do_FTFCableTV_focusLost(FocusEvent e) {
		if (isValidDollar(FTFCableTV, lblCableTV, Color.red) ) {
			updateTotalExpenses();
			isExpenseGroupValid();
		} else {lblExpenseError.setVisible(true);}
		resetExpenseNumberFTF(FTFCableTV, lblCableTV);
	}//do_FTFCableTV_focusLost
	
	protected void do_FTFLightBill_focusLost(FocusEvent e) {
		if (isValidDollar(FTFLightBill, lblLightBill, Color.red) ) {
			updateTotalExpenses();
			isExpenseGroupValid();
		} else {lblExpenseError.setVisible(true);}
		resetExpenseNumberFTF(FTFLightBill, lblLightBill);
	}//do_FTFLightBill_focusLost
	
	protected void do_FTFFurnaceAppliances_focusLost(FocusEvent e) {
		if (isValidDollar(FTFFurnaceAppliances, lblFurnaceAppliances, Color.red) ) {
			updateTotalExpenses();
			isExpenseGroupValid();
		} else {lblExpenseError.setVisible(true);}
		resetExpenseNumberFTF(FTFFurnaceAppliances, lblFurnaceAppliances);
	}//do_FTFFurnaceAppliances_focusLost
	
	protected void do_FTFCarPayment_focusLost(FocusEvent e) {
		if (isValidDollar(FTFCarPayment, lblCarPayment, Color.red) ) {
			updateTotalExpenses();
			isExpenseGroupValid();
		} else {lblExpenseError.setVisible(true);}
		resetExpenseNumberFTF(FTFCarPayment, lblCarPayment);
	}//do_FTFCarPayment_focusLost
	
	protected void do_FTFOtherExpenses_focusLost(FocusEvent e) {
		if (isValidDollar(FTFOtherExpenses, lblOtherExpenses, Color.red) ) {
			updateTotalExpenses();
			isExpenseGroupValid();
		} else {lblExpenseError.setVisible(true);}
		resetExpenseNumberFTF(FTFOtherExpenses, lblOtherExpenses);
	}//do_FTFOtherExpenses_focusLost
	
	protected void do_FTFRent_focusLost(FocusEvent e) {
		if (isValidDollar(FTFRent, lblRent, Color.red) ) {
			updateTotalExpenses();
			isExpenseGroupValid();
		} else {lblExpenseError.setVisible(true);}
		resetExpenseNumberFTF(FTFRent, lblRent);
	}//do_FTFRent_focusLost
	
	protected void do_FTFPhoneBill_focusLost(FocusEvent e) {
		if (isValidDollar(FTFPhoneBill, lblPhoneBill, Color.red) ) {
			updateTotalExpenses();
			isExpenseGroupValid();
		} else {lblExpenseError.setVisible(true);}
		resetExpenseNumberFTF(FTFPhoneBill, lblPhoneBill);
	}//do_FTFPhoneBill_focusLost
	
	/*************************************************************************************************************************
	 * Financial Tab: Income Focus Gained
	 *************************************************************************************************************************/
	protected void do_FTFSocialSecurity_focusGained(FocusEvent e) {
		clearFTF(FTFSocialSecurity);
	}//do_FTFSocialSecurity_focusGained
	
	protected void do_FTFFoodStamps_focusGained(FocusEvent e) {
		clearFTF(FTFFoodStamps);
	}//do_FTFFoodStamps_focusGained
	
	protected void do_FTFChildSupport_focusGained(FocusEvent e) {
		clearFTF(FTFChildSupport);
	}//do_FTFFoodStamps_focusGained
	
	protected void do_FTFOther_focusGained(FocusEvent e) {
		clearFTF(FTFOther);
	}//do_FTFOther_focusGained
	
	protected void do_FTFtanf_focusGained(FocusEvent e) {
		clearFTF(FTFtanf);
	}//do_FTFtanf_focusGained
	
	protected void do_FTFUtilityAssistance_focusGained(FocusEvent e) {
		clearFTF(FTFUtilityAssistance);
	}//do_FTFUtilityAssistance_focusGained
	
	protected void do_FTFUnemployment_focusGained(FocusEvent e) {
		clearFTF(FTFUnemployment);
	}//do_FTFUnemployment_focusGained
	
	protected void do_FTFSalary_focusGained(FocusEvent e) {
		clearFTF(FTFSalary);
	}//do_FTFSalary_focusGained
	
	protected void do_FTFDisability_focusGained(FocusEvent e) {
		clearFTF(FTFDisability);
	}//do_FTFDisability_focusGained
	
	protected void do_txtpnExplainIncome_focusGained(FocusEvent e) {
		if (txtpnExplainIncome.getForeground() == Color.red || txtpnExplainIncome.getForeground() == Color.gray) {
			txtpnExplainIncome.setText("");
			txtpnExplainIncome.setForeground(Color.black);
		}//if
	}//do_txtpnExplainIncome_focusGained
	
	/*************************************************************************************************************************
	 * Financial Tab: Expenses Focus Gained
	 *************************************************************************************************************************/
	protected void do_FTFLightBill_focusGained(FocusEvent e) {
		clearExpenseFTF(FTFLightBill);
	}//do_FTFLightBill_focusGained
	
	protected void do_FTFCarPayment_focusGained(FocusEvent e) {
		clearExpenseFTF(FTFCarPayment);
	}//do_FTFCarPayment_focusGained
	
	protected void do_FTFPhoneBill_focusGained(FocusEvent e) {
		clearExpenseFTF(FTFPhoneBill);
	}//do_FTFPhoneBill_focusGained
	
	protected void do_FTFGasWater_focusGained(FocusEvent e) {
		clearExpenseFTF(FTFGasWater);
	}//do_FTFGasWater_focusGained
	
	protected void do_FTFFurnaceAppliances_focusGained(FocusEvent e) {
		clearExpenseFTF(FTFFurnaceAppliances);
	}//do_FTFFurnaceAppliances_focusGained
	
	protected void do_FTFDoctorMedical_focusGained(FocusEvent e) {
		clearExpenseFTF(FTFDoctorMedical);
	}//do_FTFDoctorMedical_focusGained
	
	protected void do_FTFOtherExpenses_focusGained(FocusEvent e) {
		clearExpenseFTF(FTFOtherExpenses);
	}//do_FTFOtherExpenses_focusGained
	
	protected void do_FTFRent_focusGained(FocusEvent e) {
		clearExpenseFTF(FTFRent);
	}//do_FTFRent_focusGained
	
	protected void do_FTFCableTV_focusGained(FocusEvent e) {
		clearExpenseFTF(FTFCableTV);
	}//do_FTFCableTV_focusGained
	
	protected void do_txtpnExplainExpenses_focusGained(FocusEvent e) {
		if (txtpnExplainExpenses.getForeground() == Color.red || txtpnExplainExpenses.getForeground() == Color.gray) {
			txtpnExplainExpenses.setText("");
			txtpnExplainExpenses.setForeground(Color.black);
		}//if
	}//do_txtpnExplainExpenses_focusGained
		
	protected void do_tabbedPane_stateChanged(ChangeEvent arg0) {
		
		////////////////////////////////////////////////////////////////////////
		////////////////////////////Check Applicants////////////////////////////
		////////////////////////////////////////////////////////////////////////
		ArrayList<JLabel> applicantErrors = new ArrayList<JLabel>();
		
		//Checking First and Last Names
		if (checkValidFormattedTextOnlyField(FTFFirstName, lblFirstName)) {
			try {applicantErrors.remove(lblFirstName);}
			catch(Exception e) { applicantErrors.add(lblFirstName);}
			
		} else applicantErrors.remove(lblFirstName);
		
		if (checkValidFormattedTextOnlyField(FTFLastName, lblLastName)) {
			try {applicantErrors.remove(lblLastName);}
			catch(Exception e) { applicantErrors.add(lblLastName);}
		} else applicantErrors.remove(lblLastName);
		
		if (isFTFEmpty(FTFFirstName, lblFirstName)) {
			try {applicantErrors.remove(lblFirstName);}
			catch(Exception e) { applicantErrors.add(lblFirstName);}
			
		} else applicantErrors.remove(lblFirstName);
		
		if (isFTFEmpty(FTFLastName, lblLastName)) {
			try {applicantErrors.remove(lblLastName);}
			catch(Exception e) { applicantErrors.add(lblLastName);}
		} else applicantErrors.remove(lblLastName);
		
		//Checking applicant DOB
		if (comboBoxYear.getSelectedItem().toString() == "Y" 
				|| comboBoxMonth.getSelectedItem().toString() == "M"
				|| comboBoxDay.getSelectedItem().toString() == "D") {
			lblDateOfBirth.setForeground(Color.red);
			try {applicantErrors.remove(lblDateOfBirth);}
			catch(Exception e) { applicantErrors.add(lblDateOfBirth);}
		} else applicantErrors.remove(lblDateOfBirth);
		
		//Checking applicant SSN
		if (formattedTextFieldSocialSecurityNumber.getText().contains("#")) {
			lblSocialSecurityNumber.setForeground(Color.red);
			try {applicantErrors.remove(lblSocialSecurityNumber);}
			catch(Exception e) { applicantErrors.add(lblSocialSecurityNumber);}
		} else {
			lblSocialSecurityNumber.setForeground(Color.black); 
			applicantErrors.remove(lblSocialSecurityNumber);}
		
		//Checking applicant phone number
		if (formattedTextFieldPhoneNumber.getText().contains("#")) {
			lblPhoneNumber.setForeground(Color.red);
			try {applicantErrors.remove(lblPhoneNumber);}
			catch(Exception e) { applicantErrors.add(lblPhoneNumber);}
		} else {
			lblPhoneNumber.setForeground(Color.black); 
			applicantErrors.remove(lblPhoneNumber);}
		
		//Checking ethnicityButtonGroup
		if(ethnicityButtonGroup.getSelection() == null) {
			lblEthnicity.setForeground(Color.red);
			try {applicantErrors.remove(lblEthnicity);}
			catch(Exception e) { applicantErrors.add(lblEthnicity);}
		} else {
			lblEthnicity.setForeground(Color.black); 
			applicantErrors.remove(lblEthnicity);}
		
		//Checking applicant location
		if (checkValidFormattedTextOnlyField(FTFAddress, lblAddress)) {
			try {applicantErrors.remove(lblAddress);}
			catch(Exception e) { applicantErrors.add(lblAddress);}
		} else applicantErrors.remove(lblAddress);
		
		if (isFTFEmpty(FTFAddress, lblAddress)) {
			try {applicantErrors.remove(lblAddress);}
			catch(Exception e) { applicantErrors.add(lblAddress);}
		} else applicantErrors.remove(lblAddress);
		
		//Checking city
		if (checkValidFormattedTextOnlyField(FTFCity, lblCity)) {
			try {applicantErrors.remove(lblCity);}
			catch(Exception e) { applicantErrors.add(lblCity);}
		} else applicantErrors.remove(lblCity);
			
		if (isFTFEmpty(FTFCity, lblCity)) {
			try {applicantErrors.remove(lblCity);}
			catch(Exception e) { applicantErrors.add(lblCity);}
		} else applicantErrors.remove(lblCity);
		
		//Checking Zip code
		if (FTFZipCode.getText().contains("#")) {
			lblZipCode.setForeground(Color.red);
			try {applicantErrors.remove(lblZipCode);}
			catch(Exception e) { applicantErrors.add(lblZipCode);}
		} else {
			lblZipCode.setForeground(Color.black); 
			applicantErrors.remove(lblZipCode);
		}//if-else
		
		//Checking County
		if (comboBoxCounty.getSelectedItem().toString().equalsIgnoreCase("-Choose County-")) {
			lblCounty.setForeground(Color.red);
		} else lblCounty.setForeground(Color.black);
				
		if (unemployedButtonGroup.getSelection() != null) {
			//If the applicant made a choice
			lblEmployedQuestion.setForeground(Color.black);
			applicantErrors.remove(lblEmployedQuestion);
			
			if (rdbtnNo.isSelected()) {
				//If not employed check to make sure one of the comboBoxes were filled out
				if (comboBoxDaysUnemployed.getSelectedItem().toString() == "D" && 
					comboBoxMonthsUnemployed.getSelectedItem().toString() == "M" && 
					comboBoxYearsUnemployed.getSelectedItem().toString() == "Y") {
					//If none of the comboBoxes were filled out make the "If No" question red
					lblIfYes.setForeground(Color.black);
					lblIfNo.setForeground(Color.red);
					lblEmployedQuestion.setForeground(Color.black);
					applicantErrors.remove(lblIfYes);
					try {applicantErrors.remove(lblIfNo);
					applicantErrors.remove(lblEmployedQuestion);
					} catch (Exception e) {applicantErrors.add(lblIfNo);}
				} else {
					lblIfNo.setForeground(Color.black); 
					applicantErrors.remove(lblIfNo); }//if-else
			} 
			else if (rdbtnYes.isSelected()){
				if (lblPlaceEmployed.getText().trim().isEmpty()) {
					lblIfYes.setForeground(Color.red);
					lblIfNo.setForeground(Color.black);
					lblEmployedQuestion.setForeground(Color.black);
					applicantErrors.remove(lblIfNo);
					applicantErrors.remove(lblEmployedQuestion);
					try {applicantErrors.remove(lblIfYes);
					} catch (Exception e) {applicantErrors.add(lblIfYes);}
				} else {lblIfYes.setForeground(Color.black); applicantErrors.remove(lblIfYes); }
			}//if-else
		} else {
			lblEmployedQuestion.setForeground(Color.red);
			try {applicantErrors.remove(lblEmployedQuestion); }
			catch(Exception e) {applicantErrors.add(lblEmployedQuestion);}
		}//else
		
		//Checking valid Assistance and Referred By Fields
		if (checkValidFormattedTextOnlyField(FTFAssistanceRequested, lblAssistanceRequested)){
			try {applicantErrors.remove(lblAssistanceRequested);}
			catch(Exception e) { applicantErrors.add(lblAssistanceRequested);}
		} else applicantErrors.remove(lblAssistanceRequested);
		
		if (checkValidFormattedTextOnlyField(FTFReferredBy, lblReferredBy)) {
			try {applicantErrors.remove(lblReferredBy);}
			catch(Exception e) { applicantErrors.add(lblReferredBy);}
		} else applicantErrors.remove(lblReferredBy);
		
		if (isFTFEmpty(FTFAssistanceRequested, lblAssistanceRequested)){
			try {applicantErrors.remove(lblAssistanceRequested);}
			catch(Exception e) { applicantErrors.add(lblAssistanceRequested);}
		} else applicantErrors.remove(lblAssistanceRequested);
			
		if (isFTFEmpty(FTFReferredBy, lblReferredBy)) {
			try {applicantErrors.remove(lblReferredBy);}
			catch(Exception e) { applicantErrors.add(lblReferredBy);}
		} else applicantErrors.remove(lblReferredBy);

		//Checking If the text pane was answered
		if ( (txtpnProblem.getText().trim().compareToIgnoreCase("Please type your problem here...".trim()) == 0) 
			|| (txtpnProblem.getText().trim()).isEmpty() )  {
			txtpnProblem.setBackground(Color.red);
			txtpnProblem.setForeground(Color.black);
		} else txtpnProblem.setForeground(Color.black);

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////Spouse Check/////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		isValidSpouse();
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////Applicant Error Page/////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		ArrayList<JLabel> errors = new ArrayList<JLabel>() {{add(lblFirstName); add(lblLastName); add(lblDateOfBirth);
			add(lblSocialSecurityNumber); add(lblPhoneNumber); add(lblEthnicity); add(lblAddress); add(lblCity); add(lblCounty);
			add(lblZipCode); add(lblEmployedQuestion); add(lblIfYes); add(lblIfNo); add(lblAssistanceRequested); add(lblReferredBy);
			add(lblSpouseFirstName); add(lblSpouseLastName); add(lblSpouseDateOfBirth); add(lblSpouseSocialSecurityNumber); 
			add(lblSpouseEthnicity); add(lblSpouseEmployedQuestion); add(lblSpouseIfYes); add(lblSpouseIfNo);}};
			
		ArrayList<JLabel> spouseErrors = new ArrayList<JLabel>() {{add(lblSpouseFirstName); add(lblSpouseLastName);
			add(lblSpouseDateOfBirth); add(lblSpouseSocialSecurityNumber); add(lblSpouseEthnicity); add(lblSpouseEmployedQuestion); add(lblSpouseIfYes); add(lblSpouseIfNo);}};
			
		int position = errors.size() -1 ;
		int lastErrorPosition = -1;
		boolean errorFound = false;
		while (position > 0 && errorFound != true){
			if (errors.get(position).getForeground() == Color.red) {
				errorFound = true;
				lastErrorPosition = position;
			} else position--;
		}//while
		
		if (errorFound){
			tabbedPane.setSelectedIndex(0);
			JOptionPane.showMessageDialog(this, "One or more data fields for the Applicant Page are missing or invalid.", "STOP", JOptionPane.ERROR_MESSAGE);
			errors.get(lastErrorPosition).grabFocus();
		}
			
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////Household Check//////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		boolean validResidents_1 = false;
		boolean validResidents_2 = false;
		boolean validResidents_3 = false;
		boolean validResidents_4 = false;
		boolean validResidents_5 = false;
		boolean validResidents_6 = false;
		
		if (isValidResident(lblResidentFirstName_1, FTFResidentFirstName_1, lblResidentLastName_1, 
				FTFResidentLastName_1, lblAge_1, comboBoxAge_1, lblResidentSocialSecurityNumber_1, FTFResidentSocialSecurityNumber_1 )) {validResidents_1 = true;}
		if (isValidResident(lblResidentFirstName_2, FTFResidentFirstName_2, lblResidentLastName_2, 
				FTFResidentLastName_2, lblAge_2, comboBoxAge_2, lblResidentSocialSecurityNumber_2, FTFResidentSocialSecurityNumber_2 )) {validResidents_2 = true;}
		if (isValidResident(lblResidentFirstName_3, FTFResidentFirstName_3, lblResidentLastName_3, 
				FTFResidentLastName_3, lblAge_3, comboBoxAge_3, lblResidentSocialSecurityNumber_3, FTFResidentSocialSecurityNumber_3 )) {validResidents_3 = true;}
		if (isValidResident(lblResidentFirstName_4, FTFResidentFirstName_4, lblResidentLastName_4, 
				FTFResidentLastName_4, lblAge_4, comboBoxAge_4, lblResidentSocialSecurityNumber_4, FTFResidentSocialSecurityNumber_4 )) {validResidents_4 = true;}
		if (isValidResident(lblResidentFirstName_5, FTFResidentFirstName_5, lblResidentLastName_5,
				FTFResidentLastName_5, lblAge_5, comboBoxAge_5, lblResidentSocialSecurityNumber_5, FTFResidentSocialSecurityNumber_5 )) {validResidents_5 = true;}
		if (isValidResident(lblResidentFirstName_6, FTFResidentFirstName_6, lblResidentLastName_6, 
				FTFResidentLastName_6, lblAge_6, comboBoxAge_6, lblResidentSocialSecurityNumber_6, FTFResidentSocialSecurityNumber_6 )) {validResidents_6 = true;} 
		if (!validResidents_1 || !validResidents_2 || !validResidents_3 || !validResidents_4 || !validResidents_5 || !validResidents_6) {
			tabbedPane.setSelectedIndex(1);
			JOptionPane.showMessageDialog(this, "One or more Resident(s) are missing or have invalid data.", "STOP", JOptionPane.ERROR_MESSAGE);
		}//if
	}//do_tabbedPane_stateChanged
	
	protected boolean isValidResident(
			JLabel fName, 
			JFormattedTextField fNameValue,
			JLabel lName, 
			JFormattedTextField lNameValue, 
			JLabel age, 
			JComboBox ageValue, 
			JLabel ssn, 
			JFormattedTextField ssnValue) {
		
		boolean ans = false;
		//if the user hasn't edited any fields, the resident is valid
		if ( (fNameValue.getText().isEmpty()) && (lNameValue.getText().isEmpty()) && ageValue.getSelectedItem().toString().equalsIgnoreCase("Years Old") && ssnValue.getText().trim().equalsIgnoreCase("###-##-####")) {
			ans = true;
			age.setForeground(Color.black);
			ssn.setForeground(Color.black);
		}  else {
			//if the user edited fields, check to ensure they are all valid and flag the ones that aren't
			//Check for valid name
			checkValidFormattedTextOnlyField(lNameValue, lName);
			checkValidFormattedTextOnlyField(fNameValue, fName);
			
			//check for empty names
			isFTFEmpty(lNameValue, lName);
			isFTFEmpty(fNameValue, fName);
			
			if (ssnValue.getText().contains("#")) {
				ssn.setForeground(Color.red);
			} else ssn.setForeground(Color.black);
			
			if (ageValue.getSelectedItem().toString().equalsIgnoreCase("Years Old")) {
				age.setForeground(Color.red);
			} else age.setForeground(Color.black);
			
			//Then check if any fields were flagged
			ArrayList<JLabel> errors = new ArrayList<JLabel>() {{ add(fName); add(lName); add(age); add(ssn); }};
			int position = errors.size() -1 ;
			int lastErrorPosition = -1;
			boolean errorFound = false;
			while (position > 0 && errorFound != true){
				if (errors.get(position).getForeground() == Color.red) {
					errorFound = true;
					lastErrorPosition = position;
				} else position--;
			}//while;
			if (!errorFound) {ans = true;}
		}
		return ans;
	}//isValidResident
	
	protected boolean isFTFEmpty(JFormattedTextField ftf, JLabel lbl) {
		if (ftf.getText().trim().isEmpty() || ftf.getForeground() == Color.gray) {
			lbl.setForeground(Color.red);
		} else lbl.setForeground(Color.black);
		
		return ftf.getText().trim().isEmpty();
	}//isEmpty
	
	protected boolean isValidSpouse () {
		ArrayList<JLabel> errors = new ArrayList<JLabel>();
		boolean ans = false;
		//Check if any of the spouse fields were modified
		if ( (FTFSpouseFirstName.getText().trim().isEmpty() || FTFSpouseFirstName.getForeground() == Color.gray) && (FTFSpouseLastName.getText().trim().isEmpty() || FTFSpouseLastName.getForeground() == Color.gray)
				&& comboBoxSpouseYear.getSelectedItem().toString() == "Y" && comboBoxSpouseMonth.getSelectedItem().toString() == "M" 
				&& comboBoxSpouseDay.getSelectedItem().toString() == "D" && formattedTextFieldSpouseSocialSecurityNumber.getText().contains("#")
				&& spouseEthnicityButtonGroup.getSelection() == null && spouseUnemployedButtonGroup.getSelection() == null) { ans = true;}//if
		else {
			//If any of the spouse fields were modified, go through and check which ones
			checkValidFormattedTextOnlyField(FTFSpouseFirstName, lblSpouseFirstName);
			checkValidFormattedTextOnlyField(FTFSpouseLastName, lblSpouseLastName);
			isFTFEmpty(FTFSpouseFirstName, lblSpouseFirstName);
			isFTFEmpty(FTFSpouseLastName, lblSpouseLastName);
				
			if (spouseEthnicityButtonGroup.getSelection() == null) {
				lblSpouseEthnicity.setForeground(Color.red);
			} else lblSpouseEthnicity.setForeground(Color.black);
			
			if(formattedTextFieldSpouseSocialSecurityNumber.getText().contains("#")) {
				lblSpouseSocialSecurityNumber.setForeground(Color.red);
			} else lblSpouseSocialSecurityNumber.setForeground(Color.black);
			
			if (comboBoxSpouseYear.getSelectedItem().toString() == "Y" 
					|| comboBoxSpouseMonth.getSelectedItem().toString() == "M" 
					|| comboBoxSpouseDay.getSelectedItem().toString() == "D") {
				lblSpouseDateOfBirth.setForeground(Color.red);
			} else lblSpouseDateOfBirth.setForeground(Color.black);
			
			if (spouseUnemployedButtonGroup.getSelection() != null) {
				//If the applicant made a choice
				lblSpouseEmployedQuestion.setForeground(Color.black);
				if (rdbtnSpouseNo.isSelected()) {
					//If not employed check to make sure one of the comboBoxes were filled out
					if (comboBoxSpouseDaysUnemployed.getSelectedItem().toString() == "D" && 
						comboBoxSpouseMonthsUnemployed.getSelectedItem().toString() == "M" && 
						comboBoxSpouseYearsUnemployed.getSelectedItem().toString() == "Y") {
						//If none of the comboBoxes were filled out make the "If No" question red
						lblSpouseIfYes.setForeground(Color.black);
						lblSpouseIfNo.setForeground(Color.red);
						lblSpouseEmployedQuestion.setForeground(Color.black);
					} else {lblSpouseIfNo.setForeground(Color.black);}//if-else
				} else if (rdbtnSpouseYes.isSelected()){
					if (textField_2.getText().trim().isEmpty()) {
						lblSpouseIfYes.setForeground(Color.red);
						lblSpouseIfNo.setForeground(Color.black);
						lblSpouseEmployedQuestion.setForeground(Color.black);
					} else {lblSpouseIfYes.setForeground(Color.black);}}//if-else
			} else {lblSpouseEmployedQuestion.setForeground(Color.red);}//else
		}//else
		return ans;
	}//isValidSpouse
	
	//Help Window
	protected void do_mntmApplicantInfoHelp_actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(this, 
				"The following is a description of each data field of the Application Info Page and how to complete them:\n"
				+ "\tFirst Name Field: Enter the first name of the applicant (person filling out the form).(REQUIRED)\n"
				+ "\tLast Name Field: Enter the last name of the applicant.(REQUIRED)\n"
				+ "\tDate Of Birth: Enter the date of birth of the applicant.(REQUIRED)\n"
				+ "\tSocial Security Number: Enter the social security number of the applicant.(REQUIRED)"
				+ "\tPreferred Phone Number: Enter the phone number that you want us to contact you with.(REQUIRED)\n"
				+ "\tEthincity: Choose the ethinicity that best represents the applicant.(REQUIRED)\n"
				+ "\tAddress: Enter the living address of the applicant.(REQUIRED)\n"
				+ "\tCity: Enter the city that the applicant currently lives in.(REQUIRED)\n"
				+ "\tCounty: Choose the New York county you currently live in.(REQUIRED)\n"
				+ "\tZip Code: Enter the zip code of the area you currently live in.(REQUIRED)\n"
				+ "\tAre you Employed: Select yes if you currently have a job and select no if you currently do not have a job.(REQUIRED)\n"
				+ "\tPlace of Employment: If you answered 'yes' to the question 'are you employed' enter the place you currently are employed at.(REQUIRED)\n"
				+ "\tHow Long: If you answered 'no' to the question 'are you employed' enter how long you currently have not been employed in days OR months OR years.(REQUIRED)\n"
				+ "\tSpouse First Name Field: Enter the first name of the applicant's spouse (spouse of person filling out the form).(NOT REQUIRED)\n"
				+ "\tSpouse Last Name Field: Enter the last name of the applicant's spouse.(NOT REQUIRED)\n"
				+ "\tSpouse Date Of Birth: Enter the date of birth of the applicant's spouse.(NOT REQUIRED)\n"
				+ "\tSpouse Social Security Number: Enter the social security number of the applicant's spouse.(NOT REQUIRED)"
				+ "\tSpouse Ethincity: Choose the ethinicity that best represents the applicant.(NOT REQUIRED)\n"
				+ "\tIs your Spouse Employed: Select yes if your (the applicant) spouse currently has a job and select no if your spouse currently does not have a job.(NOT REQUIRED)\n"
				+ "\tSpouse's place of Employment: If you answered 'yes' to the question 'is applicants spouse employed' enter the place the applicant's spouse currently are employed at.(NOT REQUIRED)\n"
				+ "\tSpouse How Long Unemployed: If you answered 'no' to the question 'is your spouse employed' enter how long your spouse has currently have not been employed in days OR months OR years.(NOT REQUIRED)\n"
				+ "\tAssistance your are requesting: enter the type of assistance you (the applicant) are requesting.\n"
				+ "\tReferred By: Enter the person the applicant was referred by.\n"
				+ "\tPlease type your problem here: Enter your problem in the text box given.\n",
		"Applicant Info Page Help", JOptionPane.INFORMATION_MESSAGE);
	}//do_mntmApplicantInfoHelp_actionPerformed
	
	protected void do_mntmHouseholdDetails_actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(this, 
				"The following is a description of each data field of the Household Info Page and how to complete them:\n"
				+ "Resident 1 First Name: Enter the first name of the first resident you (the applicant) are are currently with. Only enter alphabetical characters.\n"
				+ "Resident 1 Last Name: Enter the last name of the first resident you are currently living with. Only enter alphabetical characters.\n"
				+ "Resident 1 Relationship: Choose the relationship that best matches how the first resident is related to you (the applicant).\n"
				+ "Resident 1 Age: Select the age of the first resident you chose."
				+ "Resident 1 Social Security Number: Enter the social security number of the first resident you chose.\n"
				+ "Resident 2 First Name: Enter the first name of the second resident you (the applicant) are are currently with. Only enter alphabetical characters.\n"
				+ "Resident 2 Last Name: Enter the last name of the second resident you are currently living with. Only enter alphabetical characters.\n"
				+ "Resident 2 Relationship: Choose the relationship that best matches how the second resident is related to you (the applicant).\n"
				+ "Resident 2 Age: Select the age of the second resident you chose."
				+ "Resident 2 Social Security Number: Enter the social security number of the second resident you chose.\n"
				+ "Resident 3 First Name: Enter the first name of the third resident you (the applicant) are are currently with. Only enter alphabetical characters.\n"
				+ "Resident 3 Last Name: Enter the last name of the third resident you are currently living with. Only enter alphabetical characters.\n"
				+ "Resident 3 Relationship: Choose the relationship that best matches how the third resident is related to you (the applicant).\n"
				+ "Resident 3 Age: Select the age of the third resident you chose."
				+ "Resident 3 Social Security Number: Enter the social security number of the third resident you chose.\n"
				+ "Resident 4 First Name: Enter the first name of the fourth resident you (the applicant) are are currently with. Only enter alphabetical characters.\n"
				+ "Resident 4 Last Name: Enter the last name of the fourth resident you are currently living with. Only enter alphabetical characters.\n"
				+ "Resident 4 Relationship: Choose the relationship that best matches how the first resident is related to you (the applicant).\n"
				+ "Resident 4 Age: Select the age of the fourth resident you chose."
				+ "Resident 4 Social Security Number: Enter the social security number of the fourth resident you chose.\n"
				+ "Resident 5 First Name: Enter the first name of the fifth resident you (the applicant) are are currently with. Only enter alphabetical characters.\n"
				+ "Resident 5 Last Name: Enter the last name of the fifth resident you are currently living with. Only enter alphabetical characters.\n"
				+ "Resident 5 Relationship: Choose the relationship that best matches how the first resident is related to you (the applicant).\n"
				+ "Resident 5 Age: Select the age of the fifth resident you chose."
				+ "Resident 5 Social Security Number: Enter the social security number of the fifth resident you chose. \n"
				+ "Resident 6 First Name: Enter the first name of the sixth resident you (the applicant) are are currently with. Only enter alphabetical characters.\n"
				+ "Resident 6 Last Name: Enter the last name of the sixth resident you are currently living with. Only enter alphabetical characters.\n"
				+ "Resident 6 Relationship: Choose the relationship that best matches how the sixth resident is related to you (the applicant). \n"
				+ "Resident 6 Age: Select the age of the sixth resident you chose."
				+ "Resident 6 Social Security Number: Enter the social security number of the sixth resident you chose.\n", 
				"Household Page Help", JOptionPane.INFORMATION_MESSAGE);
	}//do_mntmHouseholdDetails_actionPerformed
	
	protected void do_mntmFinancialInfoHelp_actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(this, 
				"The following is a description of each data field of the Financial Info Page and how to complete them:\n"
				+ "Salary: enter the amount of money earned from a jobs combined by everyone currently living in your (the applicant's) household. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Unemployement: enter the total amount of money earned from unemployment combined by everyone currently living in your household.  ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "TANF/AFDC (temporary assistance for needy families/aid to familes with dependent children): enter the combined total of money from TANF/AFDC of everyone currently "
				+ "living in your household. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Disability: enter any disability claims that anyone is receiving in your household. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Child Support: enter the total child support that anyone is currently recieving in your household. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Utility Assistance: ente the total utility assistance that anyone currently living in your household is receiving. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Food Stamps: enter the total food stamp benefits everyone in currently living your household is receiving. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Other Income: enter the total amount of income everyone in the the household you currently live in is receiving. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Rent: enter the amount of monthly rent you (the applicant) pay. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Phone Bill: enter the amount of money your phone bill costs, monthly. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Car Payment: enter the amount of money your car payment cost, monthly. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Furnace/Appliances: enter the total amount of money it costs to run your furnace and appliances, monthly. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Cable TV: enter the total amount of money the cable TV bill cost, monthly. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Doctor/Medical: enter the total amount of money you spend on medical/doctors, mothly. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Other Expenses: enter the amount of extra money you spend monthly that is not already listed. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n"
				+ "Explain Fields: explain in detail how your are making the 'other' money or spending the 'oher' money. ONLY enter numbers greater or equal than to zero. (REQUIRED)\n",
				"Financial Info Page Help", JOptionPane.INFORMATION_MESSAGE);
	}//do_mntmFinancialInfoHelp_actionPerformed
	
	protected void do_mntmStartNewApplication_actionPerformed(ActionEvent arg0) {
		this.dispose();
		BadiaSACAPframe newFrame = new BadiaSACAPframe();
		newFrame.setVisible(true);
	}//do_mntmStartNewApplication_actionPerformed
	
	/************************************************************************************************************************
	 ************************************************************************************************************************
	 **************************************************Helper Methods********************************************************
	 ************************************************************************************************************************
	 ************************************************************************************************************************/
	//Method to close the program by doing File>Exit
		protected void do_mntmExit_actionPerformed(ActionEvent arg0) {
			this.dispose();
		}//do_mntmExit_actionPerformed
		
		protected boolean validTextOnly (String string) {
			char[] letters = string.toCharArray();
			int letterPos = 0;
			boolean digitNotFound = true;
			
			//Check if name is empty
			if (!string.trim().isEmpty()) {
				//Check if the name has any alphanumeric characters
			      while ( (letterPos < letters.length) && (digitNotFound == true) ) {
			         if(Character.isDigit(letters[letterPos])){
			            digitNotFound = false;
			         } else letterPos++;
			      }//while
			}//if
			return digitNotFound;
		}//validName
		
		protected boolean shallowValidBirthDate (int month, int day, int year) {
			boolean valid = false;
			
			if ( (month == 9) || (month == 4) || (month == 6) || (month == 11) ) {
				if (day > 0 && day < 31) {
					valid = true;
				}//if
			} 
			else if (month == 2) {
				//Check for leap years
				if (year % 4 == 0) {
					if (day > 0 && day < 30) {
						valid = true;
					}
				} else {
					if (day > 0 && day < 29) {
						valid = true;
					}//if
				}//if-else
			} else valid = true;
			
			return valid;
		}//validBirthDate
		
		public void getBirthDate (JComboBox comboBox, JComboBox newComboBoxMonth, JComboBox newComboBoxDay, JComboBox newComboBoxYear, JLabel label) {
			int chosenMonth = -1;
			int chosenDay = 1;
			int chosenYear = 2020;
			try {
				chosenMonth = Integer.parseInt(newComboBoxMonth.getSelectedItem().toString().trim()); 
			} catch (NumberFormatException e) {;}
			try {
				chosenDay = Integer.parseInt(newComboBoxDay.getSelectedItem().toString().trim()); 
			} catch (NumberFormatException e) {;}
			
			try {
				chosenYear = Integer.parseInt(newComboBoxYear.getSelectedItem().toString().trim()); 
			} catch (NumberFormatException e) {;}
			
			if (!shallowValidBirthDate(chosenMonth, chosenDay, chosenYear)) {
				//Show error message
					JOptionPane.showMessageDialog(this, "Please enter a valid birth date", "Invalid Birth Date", JOptionPane.ERROR_MESSAGE);
					comboBox.getFocusListeners();
					label.setForeground(Color.red);
			} else {
				label.setForeground(Color.black);
			}
		}//
		
		//Reset On Focus
		protected void clearFTF(JFormattedTextField ftf) {
			if (ftf.getForeground() == Color.gray || ftf.getForeground() == Color.red) {
				ftf.setText("");
				ftf.setForeground(Color.black);
			}//if
		}//clear field
		
		//Reset On Focus
		protected void clearExpenseFTF(JFormattedTextField ftf) {
			if (ftf.getForeground() == Color.gray || ftf.getForeground().equals(new Color(205, 92, 92)) ){
				ftf.setText("");
				ftf.setForeground(Color.black);
			}//if
		}//clear field
		
		//Reset On Focus
		protected void resetNumberFTF(JFormattedTextField ftf, JLabel lbl) {
			if(ftf.getText().isEmpty()) {
				ftf.setText(moneyFormat.format(0.00));
				ftf.setForeground(Color.black);
				lbl.setForeground(Color.black);
			}//if
		}//clearNumberField
		
		//Reset On Focus
		protected void resetExpenseNumberFTF(JFormattedTextField ftf, JLabel lbl) {
			if(ftf.getText().isEmpty()) {
				ftf.setText(moneyFormat.format(0.00));
				ftf.setForeground(Color.red);
				lbl.setForeground(Color.black);
			}//if
		}//clearNumberField
		
		public boolean checkValidFormattedTextOnlyField (JFormattedTextField ftf, JLabel ftfLabel ) {
			boolean ans = true;
			if (!validTextOnly(ftf.getText().trim())) {
				//Make formatted text field's label red
				ftfLabel.setForeground(Color.red);
				
				ans = false;
			} else ftfLabel.setForeground(Color.black); 
			
			return ans;
		}//checkValidFormattedTextOnlyField
		
		public boolean isValidDollar (JFormattedTextField ftf, JLabel ftfLabel, Color color ) {
			boolean ans = false;
			try {
				if (Double.parseDouble(ftf.getText().replace("$", "").replace(",", "").trim()) >= 0.00) {
					ftf.setText(moneyFormat.format(Double.parseDouble(ftf.getText().replace("$", "").replace(",", "").trim())));
					ftf.setForeground(color);
					ftfLabel.setForeground(Color.black);
					ans = true;}
				else {
					ftf.setForeground(Color.red);
					ftfLabel.setForeground(Color.red); }
			} catch (NumberFormatException e) {
				ftf.setForeground(Color.red);
				ftfLabel.setForeground(Color.red);
			}
			return ans;
		}//checkValidFormattedTextOnlyField
		
	protected void updateTotalIncome() {
		//Brute Force Method
		double total = 0;
		try {
			if (Double.parseDouble(FTFSalary.getText().replace("$", "").replace(",", "").trim()) >= 0.00) {
				total += Double.parseDouble(FTFSalary.getText().replace("$", "").replace(",", "").trim());
			} else total += 0;
			if (Double.parseDouble(FTFUnemployment.getText().replace("$", "").replace(",", "").trim()) >= 0 ) {
				total += Double.parseDouble(FTFUnemployment.getText().replace("$", "").replace(",", "").trim());
			} else total += 0;
			if (Double.parseDouble(FTFtanf.getText().replace("$", "").replace(",", "").trim()) >= 0 ) {
				total += Double.parseDouble(FTFtanf.getText().replace("$", "").replace(",", "").trim());
			} else total += 0;
			if (Double.parseDouble(FTFSocialSecurity.getText().replace("$", "").replace(",", "").trim()) >= 0) {
				total += Double.parseDouble(FTFSocialSecurity.getText().replace("$", "").replace(",", "").trim());
			} else total += 0;
			if (Double.parseDouble(FTFDisability.getText().replace("$", "").replace(",", "").trim()) >= 0) {
				total += Double.parseDouble(FTFDisability.getText().replace("$", "").replace(",", "").trim());
			} else total = 0;
			if (Double.parseDouble(FTFChildSupport.getText().replace("$", "").replace(",", "").trim()) >= 0) {
				total += Double.parseDouble(FTFChildSupport.getText().replace("$", "").replace(",", "").trim());
			} else total += 0;
			if (Double.parseDouble(FTFUtilityAssistance.getText().replace("$", "").replace(",", "").trim()) >= 0) {
				total += Double.parseDouble(FTFUtilityAssistance.getText().replace("$", "").replace(",", "").trim());
			} else total += 0;
			if (Double.parseDouble(FTFFoodStamps.getText().replace("$", "").replace(",", "").trim()) >= 0) {
				total += Double.parseDouble(FTFFoodStamps.getText().replace("$", "").replace(",", "").trim());
			} else total += 0;
			if (Double.parseDouble(FTFOther.getText().replace("$", "").replace(",", "").trim()) >= 0) {
				total += Double.parseDouble(FTFOther.getText().replace("$", "").replace(",", "").trim());
			} else total += 0;
		} catch (Exception e) {
			lblIncomeError.setVisible(true);
			lblIncomeError.setText("The fields below cannot be negative or contain alphabetical characters");}
		lblTotalIncomeValue.setText(moneyFormat.format(total));
		updateNetIncome();
	}//updateTotalIncome
		
	protected void updateTotalExpenses() {
		double total = 0;
		if(Double.parseDouble(FTFRent.getText().replace("$", "").replace(",", "").trim()) >= 0) { 
			total += Double.parseDouble(FTFRent.getText().replace("$", "").replace(",", "").trim());
		} else total += 0;
		if (Double.parseDouble(FTFPhoneBill.getText().replace("$", "").replace(",", "").trim()) >= 0) {
			total += Double.parseDouble(FTFPhoneBill.getText().replace("$", "").replace(",", "").trim());
		} else total += 0;
		if (Double.parseDouble(FTFGasWater.getText().replace("$", "").replace(",", "").trim()) >= 0) {
			total += Double.parseDouble(FTFGasWater.getText().replace("$", "").replace(",", "").trim());
		} else total += 0;
		if (Double.parseDouble(FTFLightBill.getText().replace("$", "").replace(",", "").trim()) >= 0) {
			total += Double.parseDouble(FTFLightBill.getText().replace("$", "").replace(",", "").trim());
		} else total += 0;
		if (Double.parseDouble(FTFCarPayment.getText().replace("$", "").replace(",", "").trim()) >= 0) {
			total += Double.parseDouble(FTFCarPayment.getText().replace("$", "").replace(",", "").trim());
		} else total += 0;
		if (Double.parseDouble(FTFFurnaceAppliances.getText().replace("$", "").replace(",", "").trim()) >= 0) {
			total += Double.parseDouble(FTFFurnaceAppliances.getText().replace("$", "").replace(",", "").trim());
		} else total += 0;
		if (Double.parseDouble(FTFCableTV.getText().replace("$", "").replace(",", "").trim()) >= 0) {
			total += Double.parseDouble(FTFCableTV.getText().replace("$", "").replace(",", "").trim());
		} else total += 0;
		if (Double.parseDouble(FTFDoctorMedical.getText().replace("$", "").replace(",", "").trim()) >= 0) {
			total += Double.parseDouble(FTFDoctorMedical.getText().replace("$", "").replace(",", "").trim());
		} else total += 0;
		if ( Double.parseDouble(FTFOtherExpenses.getText().replace("$", "").replace(",", "").trim()) >= 0) {
			total += Double.parseDouble(FTFOtherExpenses.getText().replace("$", "").replace(",", "").trim());
		} else total += 0;
		lblTotalExpensesValue.setText(moneyFormat.format(total));
		updateNetIncome();
	}//updateTotalExpenses
		
	protected void updateNetIncome () {
		//Initializing netIncome
		double netIncome = 0.00;
		netIncome += Double.parseDouble(lblTotalIncomeValue.getText().replace("$", "").replace(",", "").trim());
		netIncome -= Double.parseDouble(lblTotalExpensesValue.getText().replace("$", "").replace(",", "").trim());
		String output = "";
		if (netIncome > 0) {
			lblNetIncomeValue.setForeground(Color.black);
			lblNetIncome.setForeground(Color.black);
			output += "+ ";
			output += moneyFormat.format(netIncome);
			lblNetIncomeValue.setText(output);
		} //if
		else if (netIncome < 0) {
			lblNetIncomeValue.setForeground(Color.red);
			lblNetIncome.setForeground(Color.red);
			output += "- ";
			output += moneyFormat.format(netIncome);
			lblNetIncomeValue.setText(output);
		} else {
			 //Avoiding +/- Zero
			lblNetIncomeValue.setText("$0.00");
			lblNetIncomeValue.setForeground(Color.black);
			lblNetIncome.setForeground(Color.black);
		}//else
	}//updateNetIncome
	
	protected void isExpenseGroupValid () {
		//Remove error message if all fields are valid
		if (isValidDollar(FTFPhoneBill, lblPhoneBill, Color.red)
				&& isValidDollar(FTFRent, lblRent, Color.red)
				&& isValidDollar(FTFOtherExpenses, lblOtherExpenses, Color.red) 
				&& isValidDollar(FTFCarPayment, lblCarPayment, Color.red)
				&& isValidDollar(FTFFurnaceAppliances, lblFurnaceAppliances, Color.red) 
				&& isValidDollar(FTFLightBill, lblLightBill, Color.red)
				&& isValidDollar(FTFGasWater, lblGasWater, Color.red) 
				&& isValidDollar(FTFDoctorMedical, lblDoctorMedical, Color.red)
				&& isValidDollar(FTFOtherExpenses, lblDoctorMedical, Color.red)
				) {
			lblExpenseError.setVisible(false);
		}
	}//isAllFinancialFields Valid
	
	protected void isIncomeGroupValid () {
		//Remove error message if all fields are valid
		if (isValidDollar(FTFSalary, lblSalary, Color.red)
				&& isValidDollar(FTFUnemployment, lblUnemployment, Color.red)
				&& isValidDollar(FTFtanf, lbltanf, Color.red) 
				&& isValidDollar(FTFSocialSecurity, lblSocialsecurity, Color.red)
				&& isValidDollar(FTFDisability, lblDisability, Color.red) 
				&& isValidDollar(FTFChildSupport, lblChildSupport, Color.red)
				&& isValidDollar(FTFUtilityAssistance, lblUtilityAssistance, Color.red) 
				&& isValidDollar(FTFFoodStamps, lblFoodStamps, Color.red)
				&& isValidDollar(FTFOther, lblOther, Color.red)) {
			lblExpenseError.setVisible(false);
		}
	}//isAllFinancialFields Valid
	
	protected void do_rdbtnBlack_actionPerformed(ActionEvent arg0) {lblEthnicity.setForeground(Color.black);}
	protected void do_rdbtnAsian_actionPerformed(ActionEvent arg0) {lblEthnicity.setForeground(Color.black);}
	protected void do_rdbtnAmerican_actionPerformed(ActionEvent arg0) {lblEthnicity.setForeground(Color.black);}
	protected void do_rdbtnOther_actionPerformed(ActionEvent arg0) {lblEthnicity.setForeground(Color.black);}
	protected void do_rdbtnWhite_actionPerformed(ActionEvent arg0) {lblEthnicity.setForeground(Color.black);}
	protected void do_rdbtnIndian_actionPerformed(ActionEvent arg0) {lblEthnicity.setForeground(Color.black);}
	protected void do_rdbtnHispanic_actionPerformed(ActionEvent arg0) {lblEthnicity.setForeground(Color.black);}
}//BadiaSACAPframe
