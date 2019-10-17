package ch03.ex12;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortHarnessTest {
    @Test
    public void compare() {
        SortHarness testObj = new SortHarness();
        Integer[] intArray = {1,6,4,4};
        testObj.sort(intArray);

        assertTrue(0>testObj.compare(0,1));
        assertTrue(0 == testObj.compare(2,1));
        assertTrue(0 < testObj.compare(3,1));

        String[] strArray = {"D","C","C","A"};
        testObj.sort(strArray);
        assertTrue(0 > testObj.compare(0,1));
        assertTrue(0 == testObj.compare(2,1));
        assertTrue(0 < testObj.compare(3,1));
    }

    @Test
    public void main() {
        SortHarness.main(null);
    }
}