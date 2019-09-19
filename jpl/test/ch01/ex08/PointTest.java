import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void setPoint() {
        Point testPoint = new Point();
        Point inPoint = new Point();
        inPoint.x = 1.0;
        inPoint.y = 2.0;
        testPoint.setPoint(inPoint);
        assertEquals(inPoint.x,testPoint.x,0.1);
        assertEquals(inPoint.y,testPoint.y,0.1);
    }
}