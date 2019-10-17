package ch06.ex02;

/**
 * 引数をEnumに変えることで、Enumで未定義の値をコンパイル時点で除ける。
 * */

public class Vehicle {
    private int speed;
    private int direction;
    private String ownerName;
    private final long idNumber;
    private static long nextVehicleId = 0;

    enum Turn{
        TURN_LEFT,
        TURN_RIGHT
    }


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

    public void turn(Turn turn) {
     switch (turn) {
         case TURN_LEFT:
             setDirection(-90);
             break;
         case TURN_RIGHT:
             setDirection(90);
             break;
         default:
             break;
     }
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
        car.dispStatus();

        Vehicle byke= new Vehicle("takahashi");
        byke.dispStatus();

    }
}
