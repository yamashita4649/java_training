package ch03.ex08;

public class PassengerVehicle extends Vehicle {

    /** 座席数*/
    private int seatCount;
    /** 搭乗人数*/
    private int rideCount;


    PassengerVehicle(String ownerName,int seatCount) {
        super(ownerName);
        this.seatCount = seatCount;
    }

    public void setRideCount(int count) {
        rideCount = count;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public int getRideCount() {
        return rideCount;
    }

    @Override
    public String toString() {
        String desc = getIdNumber() + " ("+ getOwnerName() + ") " + "speed:" + getSpeed() + " direction:" + getDirection() + " seatCount:" + seatCount + " rideCount" + rideCount;

        return desc;
    }

    public static void main(String args[]){
        if(args != null) {
            int i = 0;
            for (String name : args) {
                i++;
                PassengerVehicle v = new PassengerVehicle(name,i);
                System.out.println(v.toString());
            }
        }
    }
}
