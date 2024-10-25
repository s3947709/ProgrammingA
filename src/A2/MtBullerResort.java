package A2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class MtBullerResort {

    private List<Accommodation> accommodations;
    private List<Customer> customers;
    private List<TravelPackage> travelPackages;

    public MtBullerResort() {
        accommodations = new ArrayList<>();
        customers = new ArrayList<>();
        travelPackages = new ArrayList<>();

        // Initialize some default accommodations
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

        // Initialize some default customers
        customers.add(new Customer(1,"Jarrod", "Parker", "beginner"));
        customers.add(new Customer(2,"Xavier", "Smith", "intermediate"));
        customers.add(new Customer(3,"Allison", "Johnson", "expert"));
    }

    // Accommodation-related methods
    public void displayAllAccommodations(JTextArea outputArea) {
        outputArea.setText(""); // Clear the text area first
        outputArea.append("All Accommodations:\n");
        for (Accommodation accommodation : accommodations) {
            outputArea.append(accommodation.toString() + "\n");
        }
    }

    // Method to display available accommodations in a JTextArea
    public void displayAvailableAccommodations(JTextArea outputArea) {
        outputArea.setText(""); // Clear the text area first
        outputArea.append("Available Accommodations:\n");
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getAvailable()) {
                outputArea.append(accommodation.toString() + "\n");
            }
        }
    }

    // Customer-related methods
    public void addCustomer(String firstName, String lastName, String skillLevel) {
        int newCustomerId = customers.size() + 1; // Generate a new ID
        Customer newCustomer = new Customer(newCustomerId, firstName, lastName, skillLevel);
        customers.add(newCustomer);
        System.out.println("Customer added: " + newCustomer);
    }

    public void displayAllCustomers(JTextArea outputArea) {
        outputArea.setText(""); // Clear the text area first
        outputArea.append("Customers:\n");
        for (Customer customer : customers) {
            outputArea.append(customer.toString() + "\n");
        }
    }

    // Travel Package-related methods
    public void createPackage(int customerId, LocalDate startDate, int duration) {
        Customer customer = findCustomerById(customerId);
        if (customer != null) {
            TravelPackage travelPackage = new TravelPackage(customer, startDate, duration);
            travelPackages.add(travelPackage);
            System.out.println("Travel package created for: " + customer.getFirstName() + " " + customer.getLastName());
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void addLiftPass(int customerId) {
        TravelPackage travelPackage = findTravelPackageByCustomerId(customerId);
        if (travelPackage != null) {
            travelPackage.addLiftPass();
            System.out.println("Lift pass added for: " + travelPackage.getCustomer().getFirstName() + " " + travelPackage.getCustomer().getLastName());
        } else {
            System.out.println("Travel package not found.");
        }
    }

    public void addLesson(int customerId) {
        TravelPackage travelPackage = findTravelPackageByCustomerId(customerId);
        if (travelPackage != null) {
            travelPackage.addLesson();
            System.out.println("Lesson added for: " + travelPackage.getCustomer().getFirstName() + " " + travelPackage.getCustomer().getLastName());
        } else {
            System.out.println("Travel package not found.");
        }
    }

    // Method to display all travel packages in a JTextArea
    public void displayAllPackages(JTextArea outputArea) {
        outputArea.setText(""); // Clear the text area first
        outputArea.append("Travel Packages:\n");
        for (TravelPackage travelPackage : travelPackages) {
            outputArea.append(travelPackage.toString() + "\n");
        }
    }

    // Helper methods
    private Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getCustId() == id) {
                return customer;
            }
        }
        return null;
    }

    private TravelPackage findTravelPackageByCustomerId(int customerId) {
        for (TravelPackage tp : travelPackages) {
            if (tp.getCustomer().getCustId() == customerId) {
                return tp;
            }
        }
        return null;
    }

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
