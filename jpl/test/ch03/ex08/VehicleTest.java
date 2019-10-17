package ch03.ex08;

import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    @Test
    public void testClone() {
        Vehicle vehicle = new Vehicle("tanaka");
        System.out.println(vehicle.toString());
        System.out.println(vehicle.clone().toString());
        PassengerVehicle passengerVehicle = new PassengerVehicle("kimura",4);
        System.out.println(passengerVehicle.toString());
        System.out.println(passengerVehicle.clone().toString());
    }
}