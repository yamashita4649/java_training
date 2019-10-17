package ch04.ex01;

import ch03.ex06.Battery;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BatteryTest {

    @Test
    public void empty() {
        Battery battery = new Battery();
        assertEquals(true,battery.empty());
        battery.supplyEnergy();
        assertEquals(false,battery.empty());
    }

    @Test
    public void supplyEnergy() {
        Battery battery = new Battery();
        battery.supplyEnergy();
        assertEquals(false,battery.empty());
    }
}