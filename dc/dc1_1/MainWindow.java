import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * MainWindowクラス
 * メイン画面の構築と描画を行う。
 * */
public class MainWindow extends Frame {

    String mDateString = "";
    ClockCanvas mClockCanvas;
    Clock mClock;

    public MainWindow() {
        Frame f = new Frame();
        f.setSize(300, 200);
        f.addWindowListener(new MyWindowAdapter());
        f.setVisible(true);
        mClockCanvas = new ClockCanvas();
        f.add(mClockCanvas);
        mClock = new Clock();
        mClock.init(this);
    }

    public void startDrawClock() {
        mClock.start();
    }

    public void drawClockCanvas(String dateString) {
        this.mDateString = dateString;
        mClockCanvas.repaint();
    }

    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            mClock.stop();
            System.exit(0);
        }
    }
    class ClockCanvas extends Canvas {
        public void paint(Graphics g) {
            g.setColor(Color.blue);
            g.drawString(mDateString,50,80);
        }
    }

}
