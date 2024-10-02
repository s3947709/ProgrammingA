package A1;
import java.io.Serializable;
import java.time.LocalDate;

class TravelPackage implements Serializable {
    private double lesson;
    private double liftPassCost;
    private LocalDate startDate;
    private int duration;
    private Accommodation accommodation;
    private Customer customer;
    private double accommodationCost;

    public TravelPackage(Customer customer, LocalDate startDate, int duration) {
        this.customer = customer;
        this.startDate = startDate;
        this.duration = duration;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TravelPackage(double lesson) {
        this.lesson = lesson;
    }

    public TravelPackage(double lesson, double liftPassCost) {
        this.lesson = lesson;
        this.liftPassCost = liftPassCost;
    }

    public TravelPackage(double liftPassCost, int duration) {
        this.liftPassCost = liftPassCost;
        this.duration = duration;
    }

    public double getLiftPassCost() {
        return liftPassCost;
    }

    public void setLiftPassCost(double liftPassCost) {
        this.liftPassCost = liftPassCost;
    }

    public double getLessonCost() {
        return lesson;
    }

    public void setLessonCost(double lesson) {
        this.lesson = lesson;
    }

    public double getAccommodationCost() {
        return accommodationCost;
    }

    public void setAccommodationCost(double accommodationCost) {
        this.accommodationCost = accommodationCost;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
        this.accommodationCost = accommodation.getCost();
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public double getTotalCost() {
        double totalCost = 0;
        totalCost = lesson + liftPassCost + accommodationCost * duration;
        return totalCost;
    }

    public String toStringA() {
        return "Accommodation [Customer ID: " + customer.getCustID() + 
               ", Start Date: " + startDate + 
               ", Duration: " + duration + " days, " + 
               "Room Type: " + accommodation.getType() + ", Room Number: " + accommodation.getRoomNum() + "]";
    }

    public String toStringB() {
        return "Travel Package [Lesson cost: $" + lesson + ", Lift Pass cost: $" + liftPassCost + "]";
    }

    public String toString() {
        return "Travel Package for Customer: " + customer.getFname() + " " + customer.getLname() + 
               "\n" + toStringA() + 
               "\n" + toStringB() + 
               "\nWhole Package [Total Cost: $" + getTotalCost() + "]";
    }
}
