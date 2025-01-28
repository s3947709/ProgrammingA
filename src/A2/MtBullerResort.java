package A2;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MtBullerResort {

    private List<Accommodation> accommodations;
    private List<Customer> customers;
    private List<TravelPackage> travelPackages;

    public MtBullerResort() {
        accommodations = new ArrayList<>();
        customers = new ArrayList<>();
        travelPackages = new ArrayList<>();

        // Initialize accommodations
        accommodations.add(new Accommodation(1,"Lodge (2ppl)", 295.00,true));
        accommodations.add(new Accommodation(2,"Hotel (4ppl)", 330.00,true));
        accommodations.add(new Accommodation(3,"Appartment (6ppl)", 802.00,true));
        accommodations.add(new Accommodation(4,"Lodge (4ppl)", 192.00,true));
        accommodations.add(new Accommodation(5,"Hotel (2ppl)", 260.00,true));
        accommodations.add(new Accommodation(6,"Appartment (4ppl)", 540.00,true));
        accommodations.add(new Accommodation(7,"Lodge (2ppl)", 210.00,true));
        accommodations.add(new Accommodation(8,"Lodge (5ppl)", 415.00,true));
        accommodations.add(new Accommodation(9,"Appartment Penthouse (8ppl)", 1858.00,true));
        accommodations.add(new Accommodation(10,"Hotel (4ppl)", 308.00,true));

        // Initialize customers
        customers.add(new Customer(1,"Jarrod", "Parker", "beginner", 25));
        customers.add(new Customer(2,"Xavier", "Smith", "intermediate", 36));
        customers.add(new Customer(3,"Allison", "Johnson", "expert", 19));
    }

    // Function to show all the given accommodations
    public void displayAllAccommodations(JTextArea outputArea) {
        outputArea.setText(""); // Clear the text area first
        outputArea.append("All Accommodations:\n");
        for (Accommodation accommodation : accommodations) {
            outputArea.append(accommodation.toString() + "\n");
        }
    }

    // Function to be able to show all the available accommodations
    public void displayAvailableAccommodations(JTextArea outputArea) {
        outputArea.setText(""); // Clear the text area first
        outputArea.append("Available Accommodations:\n");
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getAvailable()) {
                outputArea.append(accommodation.toString() + "\n");
            }
        }
    }

    // Function to add a customer
    public void addCustomer(String firstName, String lastName, String skillLevel, int age) {
        int newCustomerId = customers.size() + 1; // Generate a new ID
        Customer newCustomer = new Customer(newCustomerId, firstName, lastName, skillLevel, age);
        customers.add(newCustomer);
        System.out.println("Customer added: " + newCustomer);
    }

    // Function to display list of all customers
    public void displayAllCustomers(JTextArea outputArea) {
        outputArea.setText(""); 
        outputArea.append("Customers:\n");
        for (Customer customer : customers) {
            outputArea.append(customer.toString() + "\n");
        }
    }

    // Function to find the accommmodation through its ID
    private Accommodation findAccommodationById(int id) {
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getAccId() == id) {
                return accommodation;
            }
        }
        return null;
    }

    // Create Package function
    public void createPackage(int accid, int customerId, LocalDate startDate, int duration) {
        Customer customer = findCustomerById(customerId);
        Accommodation accommodation = findAccommodationById(accid);
        
        if (customer != null && accommodation != null) {
            TravelPackage travelPackage = new TravelPackage(customer, startDate, duration);
            travelPackage.setAccommodation(accommodation);
            travelPackages.add(travelPackage);
            System.out.println("Travel package created for: " + customer.getFirstName() + " " + customer.getLastName());
        } else {
            System.out.println("Customer or accommodation not found.");
        }
    }

    // Add Lift Pass function
    public void addLiftPass(int customerId) {
        TravelPackage travelPackage = findTravelPackageByCustomerId(customerId);
        if (travelPackage != null) {
            String[] options = {"Full Day Lift Pass", "5 Day Lift Pass", "Season Lift Pass"};
            String selectedOption = (String) JOptionPane.showInputDialog(null, 
                    "Choose a Lift Pass \nWARNING WILL OVERWRITE IF ALREADY HAVE ONE:", "Lift Pass Options",
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (selectedOption != null) {
                travelPackage.addLiftPass(selectedOption);
                System.out.println("Lift pass added for: " + travelPackage.getCustomer().getFirstName() +
                        " " + travelPackage.getCustomer().getLastName() + " with option: " + selectedOption);
            } else {
                System.out.println("Lift pass addition cancelled.");
            }
        } else {
            System.out.println("Travel package not found.");
        }
    }

    // Add Lesson function
    public void addLesson(int customerId) {
        TravelPackage travelPackage = findTravelPackageByCustomerId(customerId);
        if (travelPackage != null) {
            travelPackage.addLesson(travelPackage.getCustomer().getSkillLevel());
            System.out.println("Lesson added based on skill level for: " + travelPackage.getCustomer().getFirstName() +
                    " " + travelPackage.getCustomer().getLastName());
        } else {
            System.out.println("Travel package not found.");
        }
    }      

    // Displaying all packages function
    public void displayAllPackages(JTextArea outputArea) {
        outputArea.setText("");
        outputArea.append("Travel Packages:\n");
        for (TravelPackage travelPackage : travelPackages) {
            outputArea.append(travelPackage.toString() + "\n");
        }
    }

    // Function to find the customer through their id
    private Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getCustId() == id) {
                return customer;
            }
        }
        return null;
    }

    // Function for finding the travel package through a customers id
    private TravelPackage findTravelPackageByCustomerId(int customerId) {
        for (TravelPackage tp : travelPackages) {
            if (tp.getCustomer().getCustId() == customerId) {
                return tp;
            }
        }
        return null;
    }

    // Function to get all the available accommodations ready
    public List<String> getAvailableAccommodations() {
        List<String> availableAccommodations = new ArrayList<>();
        for (Accommodation accommodation : accommodations) {
            if (accommodation.isAvailable()) {
                availableAccommodations.add(accommodation.getAccId() + ": " + accommodation.getType());
            }
        }
        return availableAccommodations;
    }

    // Function to set the accommodations availability
    public void setAccommodationAvailability(int accommodationId, boolean availability) {
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getAccId() == accommodationId) {
                accommodation.setAvailable(availability);
                break;
            }
        }
    }

    // Function to save package
    public void savePackage(JTextArea travelPackageDisplay) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("packages.dat"));

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

    // Function to load package
    public void readPackage(JTextArea travelPackageDisplay) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("packages.dat"));
    
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
                            if (existingCustomer.getCustId() == customer.getCustId()) {
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
