package A2;
import java.io.Serializable;
import java.time.LocalDate;

public class TravelPackage implements Serializable {
    private Customer customer;
    private LocalDate startDate;
    private int duration;
    private boolean liftPass;
    private String liftPassType;
    private boolean lessons;
    private int bookingId;
    private String lessonType;

    private Accommodation accommodation;

    private double lessonCost;
    private double liftPassCost;

    private static int nextId = 1;

    public TravelPackage(Customer customer, LocalDate startDate, int duration) {
        this.bookingId = nextId++;
        this.customer = customer;
        this.startDate = startDate;
        this.duration = duration;
        this.liftPass = false;
        this.liftPassType = ""; 
        this.lessons = false;
        this.liftPassCost = 0.0;
        this.lessonCost = 0.0;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addLiftPass(String liftPassType) {
        this.liftPass = true;
        this.liftPassType = liftPassType;
        this.liftPassCost = calculateLiftPassCost(liftPassType);
    }

    public void addLesson(String skillLevel) {
        this.lessons = true;
        this.lessonType = skillLevel;
        this.lessonCost = calculateLessonCost(skillLevel);
    }

    private double calculateLiftPassCost(String liftPassType) {
        double cost = 0.0;
        switch (liftPassType) {
            case "Full Day Lift Pass":
                cost = 26.00;
                break;
            case "5 Day Lift Pass":
                cost = 26.00 * 5 * 0.90;
                break;
            case "Season Lift Pass":
                cost = 200.00;
                break;
            default:
                System.out.println("Invalid lift pass type selected");
                break;
        }
        return cost;
    }

    private double calculateLessonCost(String lessonType){
        double cost = 0.0;
        switch (lessonType) {
            case "beginner":
                cost = 15.00;
                break;
            case "intermediate":
                cost = 20.00;
                break;
            case "expert":
                cost = 25.00;
                break;
            default:
                System.out.println("Invalid lesson type selected");
                break;
        }
        return cost;
    }

    public double calculateTotalCost() {
        double accommodationCost = (accommodation != null) ? duration * accommodation.getPrice() : 0.0;
        return accommodationCost + liftPassCost + lessonCost;
    }

    public String toString() {
        return "Travel Package for " + customer.getFirstName() + " " + customer.getLastName() +
                " [Start Date: " + startDate + ", Duration: " + duration + " days, Lift Pass: " + liftPass + 
                " (" + liftPassType + " costing $" + liftPassCost + "), Lessons: " + lessons + " level: " + 
                lessonType + ", Total Cost: $" + calculateTotalCost() + "]";
    }
}
