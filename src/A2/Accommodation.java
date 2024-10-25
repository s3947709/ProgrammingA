package A2;

import java.io.Serializable;

public class Accommodation implements Serializable {
    private int accID;
    private String type;
    private double price;
    private boolean available;

    public Accommodation(int accID, String type, double price, boolean available) {
        this.accID = accID;
        this.type = type;
        this.price = price;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean getAvailable() {
        return available;
    }

    public String toString() {
        return "Accomodation ID: " + accID + " [" + type + ", Price: $" + price + ", Available: " + available + "]";
    }
}
