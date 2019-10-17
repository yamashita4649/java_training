package ch02.ex18;

public class Vehicle {
    private int speed;
    private int direction;
    private String ownerName;
    private final long idNumber;
    private static long nextVehicleId = 0;
    public static final int TURN_LEFT = -90;
    public static final int TURN_RIGHT = 90;

    Vehicle() {
        idNumber = nextVehicleId++;
    }

    Vehicle(String ownerName) {
        this();
        this.ownerName = ownerName;
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

    public void turn(int turn) {
        setDirection(turn);
    }

    static long getMaxId() {
        return nextVehicleId-1;
    }

    public void turn(boolean isTurnLight) {
        if(isTurnLight) {
            turn(TURN_RIGHT);
        } else {
            turn(TURN_LEFT);
        }
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
        if(args != null) {
            for (String name : args) {
                Vehicle v = new Vehicle(name);
                System.out.println(v.toString());
            }
        }
    }
}
