package Tutorial1_1;

class Car {
    private String make;
    private String model;
    private int year;
    private int carID;
    
    //underscore value
    static int nextID = 0;    

    public Car (String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
        nextID += 1;
        this.carID = nextID;
    }

    public String toString(){
        return "Make: " + make + "\nModel: " + model + "\nYear: " + year + "\nCarID: " + carID;
    }
}
