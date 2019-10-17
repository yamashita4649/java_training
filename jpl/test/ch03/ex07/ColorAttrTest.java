package ch03.ex07;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorAttrTest {

    @Test
    public void testHashCode() {
        ColorAttr colorAttr1 = new ColorAttr("red",new ScreenColor("red"));
        ColorAttr colorAttr2 = new ColorAttr("red",new ScreenColor("red"));
        assertEquals(colorAttr1.hashCode(),colorAttr2.hashCode());
    }

    @Test
    public void testEquals() {
        ColorAttr colorAttr = new ColorAttr("red",new ScreenColor("red"));
        assertEquals(false,colorAttr.equals("red"));
        assertEquals(false,colorAttr.equals(new ColorAttr("blue",new ScreenColor("blue"))));
        assertEquals(true,colorAttr.equals(new ColorAttr("red",new ScreenColor("red"))));

    }
}