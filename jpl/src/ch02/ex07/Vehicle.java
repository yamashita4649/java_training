package ch02.ex07;

public class Vehicle {
    public int speed;
    public int direction;
    public String ownerName;
    public long idNumber;
    public static long nextVehicleId = 0;

    Vehicle() {
        idNumber = nextVehicleId++;
    }

    Vehicle(String ownerName) {
        this();
        this.ownerName = ownerName;
    }


    public void dispStatus() {
        System.out.println("--------------------------");
        System.out.println("idNumber:" + idNumber);
        System.out.println("ownerName:" + ownerName);
        System.out.println("speed:" + speed);
        System.out.println("direction:" + direction);
    }

    public static void main(String args[]){
        Vehicle car = new Vehicle();
        car.ownerName = "satoh";
        car.dispStatus();

        Vehicle byke= new Vehicle("takahashi");
        byke.dispStatus();

    }
}
