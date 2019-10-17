import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ClockTest {

    @Test
    public void formatDate() {
        Date date = new Date();
        Clock clock = new Clock();
        System.out.println(clock.formatDate(date));
    }
}