package A2;
import java.io.Serializable;

class Accommodation implements Serializable {
    private int roomNum;
    private boolean available = true;
    private String type;
    private double cost;

    static int nextNum = 1;

    public Accommodation(String type, double cost, boolean available) {
        this.type = type;
        this.cost = cost;
        this.available = available;
        this.roomNum = nextNum++;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getType() {
        return type;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public double getCost() {
        return cost;
    }

    public String toString() {
        return "Details [Room Number: " + roomNum + 
               " Room Type: " + type + 
               " Price Per Night: $" + cost + 
               " Available: " + available + "]";
    }
}
