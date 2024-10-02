package Tutorial3_0;

class Car {
    private boolean isInGarage;
    private String model;
    private String make;
    private String colour;
    private double cost;
    
    public Car(boolean isInGarage, String model, String make, String colour, double cost){
        this.isInGarage = isInGarage;
        this.model = model;
        this.make = make;
        this.colour = colour;
        this.cost = cost;
    }

    
    public String toString(){
        return "\nIs the " + colour +" "+ model +" "+ make + " is worth $" + cost 
        + " and it is located in the garage: " + isInGarage;
    }
}
