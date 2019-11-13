import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 時計クラス
 * 定期的な時間の取得、描画指示を行う。
 * */
public class Clock implements Runnable{

    private Thread mClockThread;
    private Date mDate;
    private MainWindow mMainWindow;

    private static final String DATE_FORMAT = "yyyy/MM/dd kk:mm:ss";

    public void init(MainWindow mMainWindow) {
        this.mMainWindow = mMainWindow;
    }

    public void start() {
        if(mClockThread == null) {
            mClockThread = new Thread(this);
            mClockThread.start();
        }
    }

    public void stop() {
        if(mClockThread != null) {
            mClockThread.interrupt();
            mClockThread = null;
        }
    }

    public String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }

    public void run() {
        while(true) {
            mDate = new Date();
            mMainWindow.drawClockCanvas(formatDate(mDate));
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

}
