package Tutorial3_0;
import java.util.Scanner;

class Garage {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        
        Scanner doublesScanner = new Scanner(System.in);

        Car[] fleet = new Car[15];


        for (int i=0; i<1; i++){
            boolean isInGarage = false;

            System.out.println("What is the cars model: ");
            String model = input.nextLine();

            System.out.println("What is the cars make: ");
            String make = input.nextLine();

            System.out.println("What is the cars colour: ");
            String colour = input.nextLine();

            System.out.println("What is the cars cost in numbers: $");
            double cost = doublesScanner.nextDouble();

            System.out.println("Is the car in the garage? Y/N ");
            String ans = input.nextLine();

            if (ans=="Y"){
               isInGarage = true;
               System.out.println("YYY");
            }
          

            fleet[i] = new Car(isInGarage,model,make,colour,cost);


        }
        /*fleet[0] = new Car(true, "Suzuki", "Swift","Green",12000.13);
        fleet[1] = new Car(true, "Holden", "Swift","Green",12000.13);
        fleet[2] = new Car(true, "Mitsubushi", "Swift","Green",12000.13);
        fleet[3] = new Car(true, "Lambo", "Swift","Green",12000.13);
        fleet[4] = new Car(true, "Telsa", "Swift","Green",12000.13);
        fleet[5] = new Car(true, "Aldi", "Swift","Green",12000.13);
        fleet[6] = new Car(true, "Toyota", "Swift","Green",12000.13);
        fleet[7] = new Car(true, "BMW", "Swift","Green",12000.13);
        fleet[8] = new Car(true, "Audi", "Swift","Green",12000.13);
        fleet[9] = new Car(true, "Volkswagon", "Swift","Green",12000.13);
        fleet[10] = new Car(true, "Lotus", "Swift","Green",12000.13);
        fleet[11] = new Car(true, "Bugatti", "Swift","Green",12000.13);
        fleet[12] = new Car(true, "Mercedes", "Swift","Green",12000.13);
        fleet[13] = new Car(true, "Porche", "Swift","Green",12000.13);
        fleet[14] = new Car(true, "Coles", "Swift","Green",12000.13); */

        for (int i=0; i < fleet.length; i++){
            if (fleet[i]!=null){
                System.out.println(fleet[i].toString());
            }
        }
        input.close();
        doublesScanner.close();
    }
}
