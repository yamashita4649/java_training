public class Vehicle {
    public int speed;
    public int direction;
    public String ownerName;
    public long idNumber;
    public static long nextVehicleId = 0;

    public void dispStatus() {
        System.out.println("--------------------------");
        System.out.println("idNumber:" + idNumber);
        System.out.println("ownerName:" + ownerName);
        System.out.println("speed:" + speed);
        System.out.println("direction:" + direction);
    }

//    public static void main(String args[]){
//        Vehicle car = new Vehicle();
//        car.idNumber = Vehicle.nextVehicleId++;
//        car.ownerName = "satoh";
//        car.dispStatus();
//
//        Vehicle byke= new Vehicle();
//        byke.idNumber = Vehicle.nextVehicleId++;
//        byke.ownerName = "takahashi";
//        byke.dispStatus();
//
//    }
}
