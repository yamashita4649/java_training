import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * MainWindowクラス
 * メイン画面の構築と描画を行う。
 * */
public class MainWindow extends Frame implements ActionListener {

    String mDateString = "yyyyy/mm/dd hh:mm:ss";
    ClockCanvas mClockCanvas;
    Clock mClock;
    Frame mMayFrame;
    private Color mBackColor=Color.red;
    private Color mStringColor=Color.blue;
    private Preferences prefs;

    public Color getBackColor() {
        return mBackColor;
    }

    public Color getStringColor() {
        return mStringColor;
    }

    public String getFontName() {
        return mFontName;
    }

    public int getFontSize() {
        return mFontSize;
    }

    private String mFontName="Serif";
    private int mFontSize =20;
    private Dialog mSettingDialog;

    public MainWindow() {
        prefs = Preferences.userNodeForPackage(this.getClass());
        load();

        mMayFrame = new Frame();
        mMayFrame.setSize(300, 200);
        mMayFrame.addWindowListener(new MyWindowAdapter());
        mMayFrame.setVisible(true);

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem item1 = new MenuItem("setting");
        item1.addActionListener(this);
        menuFile.add(item1);
        menuBar.add(menuFile);
        mMayFrame.setMenuBar(menuBar);
        mClockCanvas = new ClockCanvas();
        mMayFrame.add(mClockCanvas);
        mClock = new Clock();
        mClock.init(this);
        resizeFrame();
        dispose();
    }

    public void setBackColor(Color backColor) {
        this.mBackColor = backColor;
    }

    public void setStringColor(Color stringColor) {
        this.mStringColor = stringColor;
    }

    public void setFontName(String fontName) {
        this.mFontName = fontName;
    }

    public void setFontSize(int fontSize) {
        this.mFontSize = fontSize;
    }

    public void load() {
        System.out.println("load");
        setFontSize(SettingData.getmFontSizeMap().get(prefs.get("fontSize","20")));
        SettingData.setmFontSize(prefs.get("fontSize","20"));
        setFontName(SettingData.getmFontListMap().get(prefs.get("fontType","Serif")));
        SettingData.setmFontType(prefs.get("fontType","Serif"));
        setBackColor(SettingData.getmColorListMap().get(prefs.get("BackColor","red")));
        SettingData.setmBackColor(prefs.get("BackColor","red"));
        setStringColor(SettingData.getmColorListMap().get(prefs.get("stringColor","blue")));
        SettingData.setmStringColor(prefs.get("stringColor","blue"));
    }

    public void save() {
        System.out.println("save");
        prefs.put("BackColor",SettingData.getmSelectedBackColorKey());
        prefs.put("fontSize",SettingData.getmSelectedFontSizeKey());
        prefs.put("fontType",SettingData.getmSelectedFontTypeKey());
        prefs.put("stringColor",SettingData.getmSelectedStringColorKey());
        try {
            prefs.flush();
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }

    }

    public void resizeFrame(){

        int width = getFontMetrics(new Font(mFontName,Font.BOLD,mFontSize)).stringWidth(mDateString);
        int hight = getFontMetrics(new Font(mFontName,Font.BOLD,mFontSize)).getHeight();
        mMayFrame.setSize(width+50,hight*3);
        System.out.printf("%d  ",width);
    }

    public void startDrawClock() {
        mClock.start();
    }

    public void drawClockCanvas(String dateString) {
        this.mDateString = dateString;
        mClockCanvas.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mSettingDialog = new PropertyDialog(this);
        mSettingDialog.show();
    }

    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            mClock.stop();
            save();
            System.exit(0);
        }
    }
    class ClockCanvas extends Canvas {
        public void paint(Graphics g) {
            Dimension size = getSize();
            Image back = createImage(size.width, size.height);
            Graphics buffer = back.getGraphics();

            buffer.setColor(mBackColor);
            buffer.fillRect(0, 0, size.width - 1, size.height - 1);
            buffer.setFont(new Font(mFontName,Font.BOLD,mFontSize));
            buffer.setColor(mStringColor);
            int hight = buffer.getFontMetrics().getHeight();
            buffer.drawString(mDateString, 0,hight);
            g.drawImage(back, 0, 0, this);
        }
    }

}
