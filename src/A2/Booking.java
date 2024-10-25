package A2;

import java.io.Serializable;

class Booking implements Serializable {
    private int bookingID;
    private int duration;
    private double cost;
    private boolean liftPass;
    private boolean lessons;

    static int prebookID = 100; 

    public Booking(int duration) {
        this.bookingID = prebookID++;
        this.duration = duration;
        this.cost = calculateCost();
        this.liftPass = false;
        this.lessons = false;
    }

    private double calculateCost() {
        double baseCost = duration * 100; 
        return baseCost;
    }

    public void addLiftPass() {
        if (!liftPass) {
            liftPass = true;
            cost += 5.00;
        }
    }

    public void addLesson() {
        if (!lessons) {
            lessons = true;
            cost += 5.00;
        }
    }

    public double getTotalCost() {
        return cost;
    }

    public int getDuration() {
        return duration;
    }

    public String toString() {
        return "Booking Details [Booking ID: " + bookingID + ", Duration: " + duration + " days, Total Cost: $" + cost + "]";
    }
}
