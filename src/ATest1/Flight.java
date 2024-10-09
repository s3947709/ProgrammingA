package ATest1;
import java.io.Serializable;

class Flight implements Serializable{
    private String flightID;
    private String destination;
    private double cost;
    
    public Flight(){

    }

    public Flight(String flightID, String destination, double cost){
        this.flightID = flightID;
        this.destination = destination;
        this.cost = cost;
    }

    public String getFlightID() {
        return flightID;
    }

    public String getDestination() {
        return destination;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toString(){
        return "Flight Details [Flight ID: " + flightID + " Flight Destination: " + destination + " Flight Cost $" + cost +"]";
    }
}
