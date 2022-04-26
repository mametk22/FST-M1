package activities;

public class Car {

    String color;
    String Transmission;
    int make;
    int tyre;
    int doors;
    Car(){
        tyre=4;
        doors=4;

    }
    public void displayCharacteristics(){
        System.out.println("Car has " + color + " color" );
        System.out.println("Car is " + make + " model" );
        System.out.println("Car has " + tyre + " tyre" );
        System.out.println("Car has " + doors + " doors" );

    }
    public void accelarate(){
        System.out.println("Car is moving forward");
    }

    public void brake(){
        System.out.println("Car has stopped");
    }


}
