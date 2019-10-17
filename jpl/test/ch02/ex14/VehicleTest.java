package ch02.ex14;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class VehicleTest {

    @Test
    public void setOwnerName() throws Exception {
        String name = "test1";
        Vehicle car = new Vehicle("satoh");
        car.setOwnerName(name);

        Field fieldId = car.getClass().getDeclaredField("ownerName");
        fieldId.setAccessible(true);
        String carOwnerName = String.valueOf(fieldId.get(car));
        assertEquals(name,carOwnerName);

    }

    @Test
    public void getOwnerName() throws Exception{
        String testName = "test1";
        Vehicle car = new Vehicle("satoh");

        Field fieldId = car.getClass().getDeclaredField("ownerName");
        fieldId.setAccessible(true);
        fieldId.set(car,testName);

        assertEquals(testName,car.getOwnerName());
    }

    @Test
    public void getSpeed() throws Exception{
        int testSpeed = 1000;
        Vehicle car = new Vehicle("satoh");

        Field fieldId = car.getClass().getDeclaredField("speed");
        fieldId.setAccessible(true);
        fieldId.set(car,testSpeed);

        assertEquals(testSpeed,car.getSpeed());

    }

    @Test
    public void getDirection() throws Exception{
        int testDirection = 80;
        Vehicle car = new Vehicle("satoh");

        Field fieldId = car.getClass().getDeclaredField("direction");
        fieldId.setAccessible(true);
        fieldId.set(car,testDirection);

        assertEquals(testDirection,car.getDirection());
    }

    @Test
    public void setSpeed()throws Exception {
        int testSpeed = 100;
        Vehicle car = new Vehicle("satoh");
        car.setSpeed(testSpeed);

        Field fieldId = car.getClass().getDeclaredField("speed");
        fieldId.setAccessible(true);
        int speed = (int) fieldId.get(car);
        assertEquals(testSpeed,speed);
    }

    @Test
    public void setDirection() throws Exception{
        int testDirection = 80;
        Vehicle car = new Vehicle("satoh");
        car.setDirection(testDirection);

        Field fieldId = car.getClass().getDeclaredField("direction");
        fieldId.setAccessible(true);
        int direction = (int) fieldId.get(car);
        assertEquals(testDirection,direction);
    }

    @Test
    public void getIdNumber() {
        Vehicle car = new Vehicle("satoh");

        Vehicle byke= new Vehicle("takahashi");
        assertEquals(0,car.getIdNumber());
        assertEquals(1,byke.getIdNumber());
    }

    @Test
    public void testToString() {
        Vehicle car = new Vehicle("satoh");
        assertEquals("0 (satoh) speed:0 direction:0",car.toString());



        Vehicle byke= new Vehicle("takahashi");
        assertEquals("1 (takahashi) speed:0 direction:0",byke.toString());
    }


    @Test
    public void dispStatus() {
        Vehicle car = new Vehicle("satoh");

        Vehicle byke= new Vehicle("takahashi");
        assertEquals("satoh",car.getOwnerName());
        assertEquals("takahashi",byke.getOwnerName());

        car.dispStatus();
        byke.dispStatus();
    }

    @Test
    public void main() {
        Vehicle car = new Vehicle("satoh");
        Vehicle byke= new Vehicle("takahashi");
        assertEquals("satoh",car.getOwnerName());
        assertEquals("takahashi",byke.getOwnerName());
    }
}