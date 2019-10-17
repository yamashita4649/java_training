package ch03.ex01;

import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerVehicleTest {
    final int seatCount = 3;
    PassengerVehicle mTestPassengerVehicle = new PassengerVehicle("komatsj",seatCount );

    @Test
    public void setRideCount() {
    }

    @Test
    public void getSeatCount() {
    }

    @Test
    public void getRideCount() {
    }

    @Test
    public void testToString() {
        mTestPassengerVehicle.toString();
    }

    @Test
    public void main() {
        String[] arg = {"tanaka","satoh"};
        PassengerVehicle.main(arg);
    }
}