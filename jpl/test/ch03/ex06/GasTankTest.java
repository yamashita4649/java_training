package ch03.ex06;

import org.junit.Test;

import static org.junit.Assert.*;

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