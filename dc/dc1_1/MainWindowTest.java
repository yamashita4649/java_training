import org.junit.Test;

public class MainWindowTest {

    @Test
    public void startDrawClock() {
        new MainWindow().startDrawClock();
    }

    @Test
    public void drawClockCanvas() {
        new MainWindow().drawClockCanvas("aaaaa");
    }
}