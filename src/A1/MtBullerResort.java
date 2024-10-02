package A1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.*;
import java.time.LocalDate;

class MtBullerResort {
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    private ArrayList<Customer> customers;
    private ArrayList<Accommodation> accommodations;
    private ArrayList<TravelPackage> travelPackages;

    Scanner input = new Scanner(System.in);

    public Customer getCustomerByID(int customerID) {
        for (Customer customer : customers) {
            if (customer.getCustID() == customerID) {
                return customer;
            }
        }
        return null;
    }

    public MtBullerResort() {
        travelPackages = new ArrayList<TravelPackage>();
        customers = InitialData.getInitialCustomers();
        accommodations = InitialData.getInitialAccommodations();
    }

    public void run() {
        int option = 0;
        while (option != 11) {
            System.out.println(
                "Mt Buller Options: ------------------\n" +
                "1. Display All Accommodation \n" +
                "2. Display Available Accommodation \n" +
                "3. Add Customer \n" + 
                "4. List Customers \n" +
                "5. Create a package \n" +
                "6. List packages \n" +
                "7. Add a lift pass to package \n" +
                "8. Add lesson fees to package \n" +
                "9. Save package to file \n" +
                "10. Read package from file \n" +
                "11. Quit");
            
            try {
                System.out.println("Please choose an option (1-11): ");
                option = input.nextInt();

                switch (option) {
                    case 1:
                        allAccommodation();
                        break;
                    case 2:
                        availableAccommodation();
                        break;
                    case 3:
                        addCustomer();
                        break;
                    case 4:
                        listCustomer();
                        break;
                    case 5:
                        createPackage();
                        break;
                    case 6:
                        listPackage();
                        break;
                    case 7:
                        addLiftPass();
                        break;
                    case 8:
                        addLesson();
                        break;
                    case 9:
                        savePackage();
                        break;
                    case 10:
                        readPackage();
                        break;
                    case 11:
                        return;
                    default:
                        System.out.println("Invalid Option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        }
    }

    public void allAccommodation() {
        System.out.println("Accommodation: ");
        for (Accommodation a : accommodations) {
            System.out.println(a.toString());
        }
    }

    public void availableAccommodation() {
        System.out.println("Available Accommodation: ");
        for (Accommodation a : accommodations) {
            if (a.getAvailable() == true) {
                System.out.println(a);
            }
        }
    }

    public void addCustomer() {
        input.nextLine();
        try {
            System.out.println("What is your name? ");
            String fname = input.nextLine();

            System.out.println("What is your last name? ");
            String lname = input.nextLine();

            System.out.println("Are your skills at Beginner, Intermediate, or Expert level for skiing? ");
            String skillevel = input.nextLine().toLowerCase();

            Customer customer = new Customer(fname, lname, skillevel);
            customers.add(customer);

            System.out.println("Customer Added! Your user ID is " + customer.getCustID());
        } catch (Exception e) {
            System.out.println("Error adding customer. Please try again.");
        }
    }

    public void listCustomer() {
        System.out.println("Customers: ");
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public void createPackage() {
        try {
            System.out.println("What is your customer ID? ");
            int customerID = input.nextInt();
            input.nextLine();   

            Customer sCustomer = getCustomerByID(customerID);
            if (sCustomer == null) {
                System.out.println("Customer cannot be found.");
                return;
            }

            System.out.println("Enter the start date (YYYY-MM-DD): ");
            String startDateStr = input.nextLine();
            LocalDate startDate;

            try {
                startDate = LocalDate.parse(startDateStr);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                return;
            }

            System.out.println("Enter the duration in days: ");
            int duration = input.nextInt();
            input.nextLine();

            TravelPackage newPackage = new TravelPackage(sCustomer, startDate, duration);

            System.out.println("Available accommodations:");
            Accommodation selectedAccommodation = null;
            for (Accommodation a : accommodations) {
                if (a.getAvailable()) {
                    System.out.println(a);
                }
            }

            System.out.println("Enter room number for accommodation you'd like: ");
            int roomNum = input.nextInt();
            input.nextLine();

            for (Accommodation a : accommodations) {
                if (a.getAvailable() && a.getRoomNum() == roomNum) {
                    selectedAccommodation = a;
                    break;
                }
            }

            if (selectedAccommodation != null) {
                newPackage.setAccommodation(selectedAccommodation);
                selectedAccommodation.setAvailable(false);
                System.out.println("Accommodation assigned to the package.");
            } else {
                System.out.println("Accommodation not found or not available.");
                return;
            }

            travelPackages.add(newPackage);
            System.out.println("Package created successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            input.nextLine();
        }
    }

    public void listPackage() {
        for (TravelPackage t : travelPackages) {
            System.out.println(t);
        }
    }

    public void addLiftPass() {
        try {
            System.out.println("Enter your customer ID to add a lift pass: ");
            int customerID = input.nextInt();
            input.nextLine();

            Customer customer = getCustomerByID(customerID);
            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }

            if (travelPackages.isEmpty()) {
                System.out.println("No packages found for this customer.");
                return;
            }

            TravelPackage travelPackage = null;
            for (TravelPackage tp : travelPackages) {
                if (tp.getCustomer().getCustID() == customerID) {
                    travelPackage = tp;
                    break;
                }
            }
            if (travelPackage == null) {
                System.out.println("No travel package found for this customer.");
                return;
            }

            System.out.println("Choose a lift pass option:");
            System.out.println("1. Full day pass ($26)");
            System.out.println("2. 5-day pass (10% discount on 5-day total)");
            System.out.println("3. Season pass ($200)");

            int choice = input.nextInt();
            double liftPassCost = 0;

            switch (choice) {
                case 1:
                    liftPassCost = 26.00;
                    System.out.println("Added a full day lift pass costing $26.00.");
                    break;
                case 2:
                    liftPassCost = 26.00 * 5 * 0.90;
                    System.out.println("Added a 5-day lift pass with 10% discount. Total cost: $" + liftPassCost);
                    break;
                case 3:
                    liftPassCost = 200.00;
                    System.out.println("Added a season lift pass costing $200.00.");
                    break;
                default:
                    System.out.println("Invalid option. No lift pass added.");
                    return;
            }

            travelPackage.setLiftPassCost(liftPassCost);
            System.out.println("Lift pass successfully added to the package.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            input.nextLine();
        }
    }

    public void addLesson() {
        try {
            System.out.println("Enter your customer ID: ");
            int customerID = input.nextInt();
            input.nextLine();

            Customer customer = getCustomerByID(customerID);
            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }

            System.out.println("Adding a lesson based on your skill level...");
            String skillevel = customer.getSkillevel().toLowerCase();

            TravelPackage travelPackage = null;
            for (TravelPackage tp : travelPackages) {
                if (tp.getCustomer().getCustID() == customerID) {
                    travelPackage = tp;
                    break;
                }
            }

            if (travelPackage == null) {
                System.out.println("No travel package found for this customer.");
                return;
            }

            switch (skillevel) {
                case "beginner":
                    travelPackage.setLessonCost(15.00);
                    System.out.println("Added a Beginner lesson package costing $15.00.");
                    break;
                case "intermediate":
                    travelPackage.setLessonCost(20.00);
                    System.out.println("Added an Intermediate lesson package costing $20.00.");
                    break;
                case "expert":
                    travelPackage.setLessonCost(25.00);
                    System.out.println("Added an Expert lesson package costing $25.00.");
                    break;
                default:
                    System.out.println("Invalid skill level entered. No package added.");
                    return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            input.nextLine();
        }
    }

    public void savePackage() {
        try {
            oos = new ObjectOutputStream(new FileOutputStream("packages.dat"));

            oos.writeInt(travelPackages.size());
            for (TravelPackage travelPackage : travelPackages) {
                oos.writeObject(travelPackage);
            }

            oos.writeInt(customers.size());
            for (Customer customer : customers) {
                oos.writeObject(customer);
            }

            oos.writeInt(accommodations.size());
            for (Accommodation accommodation : accommodations){
                oos.writeObject(accommodation);
            }

            oos.close();
            System.out.println("Packages and customers have been saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving packages and customers.");
            e.printStackTrace();
        }
    }


    public void readPackage() {
        try {
            ois = new ObjectInputStream(new FileInputStream("packages.dat"));
    
            int numTravelPackages = ois.readInt();
            for (int i = 0; i < numTravelPackages; i++) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof TravelPackage) {
                        TravelPackage travelPackage = (TravelPackage) obj;
                        travelPackages.add(travelPackage);
                    } else {
                        System.out.println("Unexpected object type found while reading TravelPackage.");
                    }
                } catch (ClassCastException e) {
                    System.out.println("ClassCastException while reading TravelPackage.");
                }
            }

            int numCustomers = ois.readInt();
            for (int i = 0; i < numCustomers; i++) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Customer) {
                        Customer customer = (Customer) obj;
                        boolean exists = false;
                        
                        for (Customer existingCustomer : customers) {
                            if (existingCustomer.getCustID() == customer.getCustID()) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            customers.add(customer);
                        }
                    } else {
                        System.out.println("Unexpected object type found while reading Customer.");
                    }
                } catch (ClassCastException e) {
                    System.out.println("ClassCastException while reading Customer.");
                }
            }

            ois.close();
            System.out.println("Packages and customers have been loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading packages and customers.");
            e.printStackTrace();
        }
    }
}
