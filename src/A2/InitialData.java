package A2;

import java.util.ArrayList;

public class InitialData {
    public static ArrayList<Customer> getInitialCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        customers.add(new Customer("Jarrod", "Parker", "beginner"));
        customers.add(new Customer("Xavier", "Smith", "intermediate"));
        customers.add(new Customer("Allison", "Johnson", "expert"));

        return customers;
    }

    public static ArrayList<Accommodation> getInitialAccommodations() {
        ArrayList<Accommodation> accommodations = new ArrayList<>();

        accommodations.add(new Accommodation("Lodge (2ppl)", 295.00,true));
        accommodations.add(new Accommodation("Hotel (4ppl)", 330.00,true));
        accommodations.add(new Accommodation("Appartment (6ppl)", 802.00,true));
        accommodations.add(new Accommodation("Lodge (4ppl)", 192.00,true));
        accommodations.add(new Accommodation("Hotel (2ppl)", 260.00,true));
        accommodations.add(new Accommodation("Appartment (4ppl)", 540.00,true));
        accommodations.add(new Accommodation("Lodge (2ppl)", 210.00,true));
        accommodations.add(new Accommodation("Lodge (5ppl)", 415.00,true));
        accommodations.add(new Accommodation("Appartment Penthouse (8ppl)", 1858.00,true));
        accommodations.add(new Accommodation("Hotel (4ppl)", 308.00,true));

        return accommodations;
    }
}
