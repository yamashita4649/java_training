import org.junit.Test;

import static org.junit.Assert.*;

public class UseMapLookupTest {

    @Test
    public void find() {
        UseMapLookup test = new UseMapLookup();
        test.add("testName","testValue");
        assertEquals("testValue",test.find("testName"));
    }

    @Test
    public void add() {
        UseMapLookup test = new UseMapLookup();
        test.add("testName1","testValue1");
        test.add("testName2","testValue2");
        test.add("testName3","testValue3");
        assertEquals(3,test.mMap.size());

    }

    @Test
    public void remove() {
        UseMapLookup test = new UseMapLookup();
        test.add("testName1","testValue1");
        test.add("testName2","testValue2");
        test.add("testName3","testValue3");
        test.remove("testName1");
        test.remove("testName4");
        assertEquals(2,test.mMap.size());
    }
}