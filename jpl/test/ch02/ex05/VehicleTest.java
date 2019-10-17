package ch02.ex05;

import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    @Test
    public void main() {
    }

    @Test
    public void dispStatus() {
        Vehicle car = new Vehicle();
        car.idNumber = Vehicle.nextVehicleId++;
        car.ownerName = "satoh";

        Vehicle byke= new Vehicle();
        byke.idNumber = Vehicle.nextVehicleId++;
        byke.ownerName = "takahashi";
        assertEquals("satoh",car.ownerName);
        assertEquals("takahashi",byke.ownerName);
        assertEquals(2,Vehicle.nextVehicleId);

        car.dispStatus();
        byke.dispStatus();
    }
}