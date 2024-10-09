package ATest1;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Airport {

    Scanner input = new Scanner(System.in);
    private ArrayList<Flight> flights; 

    public Airport(){
        flights = new ArrayList<>();
    }
    public static void main(String[]args){
        Airport apr = new Airport();
        apr.run();
    }    
    
    public void run(){
        populateList();
        int option = 0;
        while (option != 5) {
            System.out.println(
                "Flight Options: ------------------\n" +
                "1. Display All Flights \n" +
                "2. Add Flight \n" +
                "3. Save Flights \n" +
                "4. Read Flight Data \n" +
                "5. Quit");
            
            try {
                System.out.println("Please choose an option (1-5): ");
                option = input.nextInt();

                switch (option) {
                    case 1:
                        listFlights();
                        break;
                    case 2:
                        addFlight();
                        break;
                    case 3:
                        saveFlight();
                        break;
                    case 4:
                        readFlight();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid Option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        }
    }

    public void populateList(){
        flights.add (new Flight ("F1", "Brisbane", 151.00));
        flights.add (new Flight ("F2", "Sydney", 192.00));
        flights.add (new Flight ("F3", "Hong Kong", 387.00));
    }

    public void addFlight(){
        input.nextLine();
        
        System.out.println("What will the ID for this flight be? (user the next lowest available number with an F in front e.g F10)");
        String flightid = input.nextLine();

        System.out.println("What is the destination of the flight you would like to add? ");
        String flightin = input.nextLine();

        System.out.println("What is the cost of the flight going to be? (format like 10.00)");
        double flightcost = input.nextDouble();

        flights.add(new Flight(flightid, flightin, flightcost));
    }

    public void listFlights(){
        System.out.println("Flights: ");
        for (Flight f: flights){
            System.out.println(f.toString());
        }
    }

    public void saveFlight(){
        try{
            FileOutputStream fos = new FileOutputStream("flight.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Flight f :flights){
                oos.writeObject(f);
            }
            System.out.println("Successfully Saved!");
            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void readFlight(){
        flights.clear();
        try {
            FileInputStream fis = new FileInputStream("flight.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    Flight f = (Flight) ois.readObject();
                    flights.add(f);
                } catch (EOFException eof) {
                    break;
                }
            }
            System.out.println("Successfully Loaded!");
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}