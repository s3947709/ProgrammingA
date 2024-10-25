package A2;

import java.io.Serializable;
import java.time.LocalDate;

public class TravelPackage implements Serializable{
    private Customer customer;
    private LocalDate startDate;
    private int duration;
    private boolean liftPass;
    private boolean lessons;
    private int packId;

    private static int nextId = 1;

    public TravelPackage(Customer customer, LocalDate startDate, int duration) {
        this.packId = nextId ++;
        this.customer = customer;
        this.startDate = startDate;
        this.duration = duration;
        this.liftPass = false;
        this.lessons = false;
    }

    public int getPackId(){
        return packId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addLiftPass() {
        liftPass = true;
    }

    public void addLesson() {
        lessons = true;
    }

    public String toString() {
        return "Travel Package for " + customer.getFirstName() + " " + customer.getLastName() + 
               " [Start Date: " + startDate + ", Duration: " + duration + " days, Lift Pass: " + liftPass + ", Lessons: " + lessons + "]";
    }
}
