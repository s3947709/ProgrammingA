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

    public Accommodation(int accID){
        this.accID = accID;
        this.available = false;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean availability){
        this.available = availability;
    }

    public int getAccId() {
        return accID;
    }

    public String getType(){
        return type;
    }

    public double getPrice(){
        return price;
    }

    public String toString() {
        return "Accomodation ID: " + accID + " [" + type + ", Price: $" + price + ", Available: " + available + "]";
    }
}
