package activities;

public class Activity6 {

    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(35);

        plane.onboard("Ramesh");
        plane.onboard("Suresh");
        plane.onboard("Mitesh");
        System.out.println("Plane took off at: " + plane.takeOff());

        System.out.println("People on the plane: " + plane.getPassengers());

        Thread.sleep(15000);

        plane.land();

        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
    }
}
