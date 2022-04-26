package activities;

public class Activity1 {

    public static void main(String[] args) {

        Car carname = new Car();
        carname.color= "black";
        carname.make= 2014;
        carname.Transmission= "manual";
        carname.displayCharacteristics();
        carname.accelarate();
        carname.brake();
    }
}
