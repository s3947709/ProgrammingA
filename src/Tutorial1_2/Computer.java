package Tutorial1_2;
import java.util.Scanner;

class Computer {

    Scanner input = new Scanner(System.in);
    // "-" means private  ,  "+" means public
    private String make;
    private String processor;
    private int memory;
    private int year;
    private double price;

    public static final int MIN_RAM = 4;
    public static final int MAX_RAM = 20;
    
    public Computer(String make, String processor){
        this.make = make;
        this.processor = processor;
        this.memory = 0;
    }

    public Computer(String make, String processor, int memory){
        this.price = 0.0;
        this.year = 0;
    }

    public void setMemory(int memory){
        if (memory <MIN_RAM || memory > MAX_RAM){
            this.memory = 0;
        } else{
            this.memory=memory;
        }
    }

    public void setYear(int year){
        System.out.println("What year was it made in? ");
        year = input.nextInt();
        return;
    }

    public void setPrice(double price){
        
    }

    public String toString(){
        return "Make: " + make + " Processor: " + processor + " Memory: " + memory + " Year: " + year + " Price: $" + price;
    }

}
