package ch02.ex09;

import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    @Test
    public void getMaxId() {
        Vehicle car = new Vehicle();
        car.ownerName = "satoh";
        car.dispStatus();

        Vehicle byke= new Vehicle("takahashi");
        byke.dispStatus();

        assertEquals("satoh",car.ownerName);
        assertEquals(0,car.idNumber);
        assertEquals("takahashi",byke.ownerName);
        assertEquals(1,byke.idNumber);
        assertEquals(1,Vehicle.getMaxId());
    }

    @Test
    public void dispStatus() {
        Vehicle car = new Vehicle("satoh");

        Vehicle byke= new Vehicle("takahashi");
        assertEquals("satoh",car.ownerName);
        assertEquals("takahashi",byke.ownerName);

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
}
}