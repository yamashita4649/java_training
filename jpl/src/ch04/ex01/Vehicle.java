package ch04.ex01;

public class Vehicle {
    private int speed;
    private int direction;
    private String ownerName;
    private final long idNumber;
    private static long nextVehicleId = 0;
    private EnergySource mEnergySource;

    Vehicle() {
        idNumber = nextVehicleId++;
    }

    Vehicle(String ownerName, EnergySource energySource) {
        this();
        this.ownerName = ownerName;
        this.mEnergySource = energySource;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void stop() {
        setSpeed(0);
    }

    public void changeSpeed(int speed) {
        setSpeed(speed);
    }

    public String toString() {
        String desc = idNumber + " ("+ ownerName + ") " + "speed:" + speed + " direction:" + direction;

        return desc;
    }

    public void start() {
        if(mEnergySource.empty()) {
            mEnergySource.supplyEnergy();
        }
    }

    public void dispStatus() {
        System.out.println("--------------------------");
        System.out.println("idNumber:" + idNumber);
        System.out.println("ownerName:" + ownerName);
        System.out.println("speed:" + speed);
        System.out.println("direction:" + direction);
    }

    public static void main(String args[]){
        Battery battery = new Battery();
        GasTank gasTank = new GasTank();
        Vehicle v1 = new Vehicle("tanaka",battery);
        Vehicle v2 = new Vehicle("ikeda",gasTank);
        v1.start();
        v2.start();
        System.out.println(v1.toString());
        System.out.println(v2.toString());

    }
}
