package ch06.ex02;

import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    @Test
    public void turn() {
        Vehicle test = new Vehicle("jon");
        test.turn(Vehicle.Turn.TURN_LEFT);
        assertEquals(-90,test.getDirection());
        test.turn(Vehicle.Turn.TURN_RIGHT);
        assertEquals(90,test.getDirection());
    }
}