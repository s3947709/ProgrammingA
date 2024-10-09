package A1;
import java.io.Serializable;

class Booking implements Serializable{
    private int bookingID;
    private int duration;
    private double cost;

    static int prebookID = 100; 

    public Booking (int duration, double cost){
        this.bookingID = prebookID++;
        this.duration = duration;
        this.cost = cost;
    }

    public String toString() {
        return "Booking Details [Booking ID: " + bookingID + ", Duration: " + duration + " days, Total Cost: $" + cost +"]";
    }
    
}
