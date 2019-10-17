package ch03.ex09;

public class Garage implements Cloneable{
    private  Vehicle[] mVehicleArray;
    private int top;

    public Garage clone() {
        try {
            Garage nObj = (Garage) super.clone();
            nObj.mVehicleArray = mVehicleArray.clone();
            return nObj;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void integerStack(int max) {
        mVehicleArray = new Vehicle[max];
        top = -1;
    }

    public void push(Vehicle vehicle) {
        mVehicleArray[++top] = vehicle;
    }

    public Vehicle pop() {
        return mVehicleArray[top--];
    }



    public static void main(String args[]){
        Garage garage = new Garage();
        garage.integerStack(5);
        garage.push(new Vehicle("jon"));
        garage.push(new Vehicle("ken"));
        garage.push(new Vehicle("masa"));

        Garage cloneGarage = garage.clone();

        System.out.println("garage");
        for(Vehicle vehicle : garage.mVehicleArray) {
            if (vehicle != null) {
                System.out.println(vehicle.toString());
            }
        }
        System.out.println("cloneGarage");
        for(Vehicle vehicle : cloneGarage.mVehicleArray) {
            if (vehicle != null) {
                System.out.println(vehicle.toString());
            }
        }

        garage.push(new Vehicle("takashi"));

        System.out.println("garage");
        for(Vehicle vehicle : garage.mVehicleArray) {
            if (vehicle != null) {
                System.out.println(vehicle.toString());
            }
        }

        System.out.println("cloneGarage");
        for(Vehicle vehicle : cloneGarage.mVehicleArray) {
            if (vehicle != null) {
                System.out.println(vehicle.toString());
            }
        }
    }
}
