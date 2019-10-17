package ch06.ex04;

import ch06.ex04.TrafficLightColor;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrafficLightColorTest {

    @Test
    public void getColor() {
        assertEquals(TrafficLightColor.BLUE.getColor().toString(),"BLUE");
        assertEquals(TrafficLightColor.YELLOW.getColor().toString(),"YELLOW");
        assertEquals(TrafficLightColor.RED.getColor().toString(),"RED");
        System.out.println("BLUE:" + TrafficLightColor.BLUE.getColor().toString());
        System.out.println("YELLOW:" + TrafficLightColor.YELLOW.getColor().toString());
        System.out.println("RED:" + TrafficLightColor.RED.getColor().toString());
    }
}