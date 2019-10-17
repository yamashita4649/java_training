package ch02.ex07;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {


    @Test
    public void dispStatus() {
        Vehicle car = new Vehicle("satoh");

        Vehicle byke= new Vehicle("takahashi");
        assertEquals("satoh",car.ownerName);
        assertEquals("takahashi",byke.ownerName);
        assertEquals(2,Vehicle.nextVehicleId);

        car.dispStatus();
        byke.dispStatus();
    }

    @Test
    public void main() {
        Vehicle car = new Vehicle();
        car.ownerName = "satoh";
        Vehicle byke= new Vehicle("takahashi");
        assertEquals("satoh",car.ownerName);
        assertEquals("takahashi",byke.ownerName);
        assertEquals(2,Vehicle.nextVehicleId);
    }
}