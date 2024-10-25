package A2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDate;

public class ResortGUI extends JFrame implements ActionListener {

    private JTabbedPane JtabbedPane;
    private JTextField AccommodationIDInput, DateInput, DurationInput, CustIdInput, FNameInput, LNameInput;
    private JButton addLiftPassButton, addLessonsButton, viewTravelPackagesButton1, createTravelPackageButton;
    private JButton readSavedPackagesButton, savePackageButton, listCustomersButton, addCustomerButton;
    private JButton viewAllAccommodationsButton, viewAvailableAccommodationsButton;
    private JTextArea AccommodationDisplayBox, CustomerDisplayBox, TravelPackageDisplay;
    private JComboBox<String> SkillLevelOption;
    private JPanel AccommodationsTab, CustomerTab, TravelPackageTab;

    private MtBullerResort resort;

    public ResortGUI() {
        resort = new MtBullerResort(); // Linking the GUI with the MtBullerResort class

        // Setting up the JFrame
        setTitle("Mt Buller Resort Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creating the JTabbedPane
        JtabbedPane = new JTabbedPane();

        // Initializing the Tabs
        initializeAccommodationsTab();
        initializeCustomerTab();
        initializeTravelPackageTab();

        // Adding the tabs to the JTabbedPane
        JtabbedPane.addTab("Accommodations", AccommodationsTab);
        JtabbedPane.addTab("Customers", CustomerTab);
        JtabbedPane.addTab("Travel Packages", TravelPackageTab);

        // Adding the JTabbedPane to the JFrame
        add(JtabbedPane, BorderLayout.CENTER);
    }

    // Initialize the AccommodationsTab
    private void initializeAccommodationsTab() {
        AccommodationsTab = new JPanel();
        AccommodationsTab.setLayout(new BorderLayout());

        // Buttons for viewing accommodations
        viewAllAccommodationsButton = new JButton("View All Accommodations");
        viewAvailableAccommodationsButton = new JButton("View Available Accommodations");
        viewAllAccommodationsButton.addActionListener(this);
        viewAvailableAccommodationsButton.addActionListener(this);

        // Display box for accommodation listings
        AccommodationDisplayBox = new JTextArea();
        AccommodationDisplayBox.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(AccommodationDisplayBox);

        // Adding components to AccommodationsTab
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewAllAccommodationsButton);
        buttonPanel.add(viewAvailableAccommodationsButton);

        AccommodationsTab.add(buttonPanel, BorderLayout.NORTH);
        AccommodationsTab.add(scrollPane, BorderLayout.CENTER);
    }

    // Initialize the CustomerTab
    private void initializeCustomerTab() {
        CustomerTab = new JPanel();
        CustomerTab.setLayout(new GridLayout(5, 2));

        // Labels and text fields for customer information
        JLabel FNameLabel = new JLabel("First Name:");
        JLabel LNameLabel = new JLabel("Last Name:");
        JLabel SkillL = new JLabel("Skill Level:");

        FNameInput = new JTextField();
        LNameInput = new JTextField();

        // Skill level options
        String[] skillLevels = {"Beginner", "Intermediate", "Expert"};
        SkillLevelOption = new JComboBox<>(skillLevels);

        // Buttons for customer operations
        addCustomerButton = new JButton("Add Customer");
        listCustomersButton = new JButton("List Customers");
        addCustomerButton.addActionListener(this);
        listCustomersButton.addActionListener(this);

        // Display box for customer listings
        CustomerDisplayBox = new JTextArea();
        CustomerDisplayBox.setEditable(false);
        JScrollPane customerScrollPane = new JScrollPane(CustomerDisplayBox);

        // Adding components to CustomerTab
        CustomerTab.add(FNameLabel);
        CustomerTab.add(FNameInput);
        CustomerTab.add(LNameLabel);
        CustomerTab.add(LNameInput);
        CustomerTab.add(SkillL);
        CustomerTab.add(SkillLevelOption);
        CustomerTab.add(addCustomerButton);
        CustomerTab.add(listCustomersButton);
        CustomerTab.add(customerScrollPane);
    }

    // Initialize the TravelPackageTab
    private void initializeTravelPackageTab() {
        TravelPackageTab = new JPanel();
        TravelPackageTab.setLayout(new GridLayout(7, 2));

        // Labels and text fields for travel package information
        JLabel AccommodationIDLabel = new JLabel("Accommodation ID:");
        JLabel DateLabel = new JLabel("Start Date (YYYY-MM-DD):");
        JLabel DurationLabel = new JLabel("Duration (Days):");
        JLabel CustIdLabel = new JLabel("Customer ID:");

        AccommodationIDInput = new JTextField();
        DateInput = new JTextField();
        DurationInput = new JTextField();
        CustIdInput = new JTextField();

        // Buttons for travel package operations
        createTravelPackageButton = new JButton("Create Travel Package");
        viewTravelPackagesButton1 = new JButton("View Travel Packages");
        addLiftPassButton = new JButton("Add Lift Pass");
        addLessonsButton = new JButton("Add Lessons");
        savePackageButton = new JButton("Save Packages");
        readSavedPackagesButton = new JButton("Read Saved Packages");

        createTravelPackageButton.addActionListener(this);
        viewTravelPackagesButton1.addActionListener(this);
        addLiftPassButton.addActionListener(this);
        addLessonsButton.addActionListener(this);
        savePackageButton.addActionListener(this);
        readSavedPackagesButton.addActionListener(this);

        // Display box for travel package listings
        TravelPackageDisplay = new JTextArea();
        TravelPackageDisplay.setEditable(false);
        JScrollPane travelPackageScrollPane = new JScrollPane(TravelPackageDisplay);

        // Adding components to TravelPackageTab
        TravelPackageTab.add(AccommodationIDLabel);
        TravelPackageTab.add(AccommodationIDInput);
        TravelPackageTab.add(DateLabel);
        TravelPackageTab.add(DateInput);
        TravelPackageTab.add(DurationLabel);
        TravelPackageTab.add(DurationInput);
        TravelPackageTab.add(CustIdLabel);
        TravelPackageTab.add(CustIdInput);
        TravelPackageTab.add(createTravelPackageButton);
        TravelPackageTab.add(viewTravelPackagesButton1);
        TravelPackageTab.add(addLiftPassButton);
        TravelPackageTab.add(addLessonsButton);
        TravelPackageTab.add(savePackageButton);
        TravelPackageTab.add(readSavedPackagesButton);
        TravelPackageTab.add(travelPackageScrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Accommodations-related actions
        if (e.getSource() == viewAllAccommodationsButton) {
            AccommodationDisplayBox.setText("");
            resort.displayAllAccommodations(AccommodationDisplayBox); // Fetch and display all accommodations
        } else if (e.getSource() == viewAvailableAccommodationsButton) {
            AccommodationDisplayBox.setText("");
            resort.displayAvailableAccommodations(AccommodationDisplayBox); // Fetch and display available accommodations

        // Customer-related actions
        } else if (e.getSource() == addCustomerButton) {
            String firstName = FNameInput.getText();
            String lastName = LNameInput.getText();
            String skillLevel = (String) SkillLevelOption.getSelectedItem();
            resort.addCustomer(firstName, lastName, skillLevel);
        } else if (e.getSource() == listCustomersButton) {
            CustomerDisplayBox.setText("");
            resort.displayAllCustomers(CustomerDisplayBox); // Fetch and display all customers

        // Travel package-related actions
        } else if (e.getSource() == createTravelPackageButton) {
            int customerId = Integer.parseInt(CustIdInput.getText());
            LocalDate startDate = LocalDate.parse(DateInput.getText());
            int duration = Integer.parseInt(DurationInput.getText());
            resort.createPackage(customerId, startDate, duration);
        } else if (e.getSource() == viewTravelPackagesButton1) {
            TravelPackageDisplay.setText("");
            resort.displayAllPackages(TravelPackageDisplay); // Fetch and display all travel packages
        } else if (e.getSource() == addLiftPassButton) {
            int customerId = Integer.parseInt(CustIdInput.getText());
            resort.addLiftPass(customerId);
        } else if (e.getSource() == addLessonsButton) {
            int customerId = Integer.parseInt(CustIdInput.getText());
            resort.addLesson(customerId);
        } else if (e.getSource() == savePackageButton) {
            resort.savePackage(TravelPackageDisplay);
        } else if (e.getSource() == readSavedPackagesButton) {
            resort.readPackage(TravelPackageDisplay);
        }
    }
}
