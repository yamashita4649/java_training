public class Vehicle {
    public int speed;
    public int direction;
    public String ownerName;
    public long idNumber;
    private static long nextVehicleId = 0;

    Vehicle() {
        idNumber = nextVehicleId++;
    }

    Vehicle(String ownerName) {
        this();
        this.ownerName = ownerName;
    }

    static long getMaxId() {
        return nextVehicleId-1;
    }

    public String toString() {
        String desc = idNumber + " ("+ ownerName + ") " + "speed:" + speed + " direction:" + direction;

        return desc;
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
        System.out.println(car.toString());

        Vehicle byke= new Vehicle("takahashi");
        System.out.println(byke.toString());

    }
}
