package ch04.ex01;

import ch03.ex06.GasTank;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GasTankTest {

    @Test
    public void empty() {
        GasTank gasTank = new GasTank();
        assertEquals(true,gasTank.empty());
        gasTank.supplyEnergy();
        assertEquals(false,gasTank.empty());
    }

    @Test
    public void supplyEnergy() {
        GasTank gasTank = new GasTank();
        gasTank.supplyEnergy();
        assertEquals(false,gasTank.empty());
    }
}