import java.awt.*;
import java.awt.event.*;
import java.util.Set;

/**
 * MainWindowクラス
 * メイン画面の構築と描画を行う。
 * */
public class MainWindow extends Window implements ActionListener{

    String mDateString = "";
    ClockCanvas mClockCanvas;
    Clock mClock;
    Frame mMayFrame;
    private Dialog mSettingDialog;
    Window myWindow;

    private int x=0;
    private int y=0;

    private int mouseX = 0;
    private int mouseY = 0;

    private boolean rightMouseClicked = false;

    PopupMenu popup;

    public MainWindow() {
        super(new Frame());
        mClock = new Clock();
        mClock.init(this);
        addMouseMotionListener(new moveEventListener());
        addMouseListener(new myListener());

        setSize(300, 200);


        popup = new PopupMenu("Edit");

        Menu m1 = new Menu("FontSize");
        ActionListener fontSizeAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO 正常値かチェックする仕組みが必要
                SettingData.setmFontSize(e.getActionCommand());
                resizeFrame();
            }
        };
        popup.add(createPopup(m1,SettingData.getmFontSizeMap().keySet(),fontSizeAction));

        Menu m2 = new Menu("FontType");
        ActionListener fontTypeAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO 正常値かチェックする仕組みが必要
                SettingData.setmFontType(e.getActionCommand());
                resizeFrame();
            }
        };
        popup.add(createPopup(m2,SettingData.getmFontListMap().keySet(),fontTypeAction));

        Menu m3 = new Menu("BackColor");
        ActionListener backColorAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO 正常値かチェックする仕組みが必要
                SettingData.setmBackColor(e.getActionCommand());
            }
        };
        popup.add(createPopup(m3,SettingData.getmColorListMap().keySet(),backColorAction));

        Menu m4 = new Menu("StringColor");
        ActionListener stringColorAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO 正常値かチェックする仕組みが必要
                SettingData.setmStringColor(e.getActionCommand());
            }
        };
        popup.add(createPopup(m4,SettingData.getmColorListMap().keySet(),stringColorAction));

        add(popup);

        show();
        toFront();
    }

    public void resizeFrame(){

        int width = getFontMetrics(new Font(SettingData.getmFontType(),Font.BOLD,SettingData.getmFontSize())).stringWidth(mDateString);
        int hight = getFontMetrics(new Font(SettingData.getmFontType(),Font.BOLD,SettingData.getmFontSize())).getHeight();
        setSize(width+50,hight*3);
        System.out.printf("%d  ",width);
    }

    public void startDrawClock() {
        mClock.start();
    }

    public void paint(Graphics g) {
        Dimension size = getSize();
        Image back = createImage(size.width, size.height);
        Graphics buffer = back.getGraphics();

        buffer.setColor(SettingData.getmBackColor());
        buffer.fillRect(0, 0, size.width - 1, size.height - 1);
        buffer.setFont(new Font(SettingData.getmFontType(),Font.BOLD,SettingData.getmFontSize()));
        buffer.setColor(SettingData.getmStringColor());
        int hight = buffer.getFontMetrics().getHeight();
        buffer.drawString(mDateString, 0,hight);
        g.drawImage(back, 0, 0, mMayFrame);
    }

    public void drawClockCanvas(String dateString) {
        this.mDateString = dateString;
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        mSettingDialog = new PropertyDialog(this);
//        mSettingDialog.show();
    }

    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            mClock.stop();
            System.exit(0);
        }
    }
    class ClockCanvas extends Canvas {
        public void paint(Graphics g) {
            Dimension size = getSize();
            Image back = createImage(size.width, size.height);
            Graphics buffer = back.getGraphics();

            buffer.setColor(SettingData.getmBackColor());
            buffer.fillRect(0, 0, size.width - 1, size.height - 1);
            buffer.setFont(new Font(SettingData.getmFontType(),Font.BOLD,SettingData.getmFontSize()));
            buffer.setColor(SettingData.getmStringColor());
            int hight = buffer.getFontMetrics().getHeight();
            buffer.drawString(mDateString, 0,hight);
            g.drawImage(back, 0, 0, mMayFrame);
        }
    }
    public class myListener implements MouseListener {
        public void mouseClicked(MouseEvent e){
            if (e.getClickCount() >= 2){
                // ダブルクリック
                mClock.stop();
                System.exit(0);
            }
        }

        public void mouseEntered(MouseEvent e){
//            System.out.println("mouseEntered");
            /* 処理したい内容をここに記述する */
        }

        public void mouseExited(MouseEvent e){
//            System.out.println("mouseExited");
            /* 処理したい内容をここに記述する */
        }

        public void mousePressed(MouseEvent e){
            switch (e.getButton()) {
                case MouseEvent.BUTTON1:
                    Point point = e.getPoint();
                    mouseX = point.x;
                    mouseY = point.y;
                    rightMouseClicked = true;
                    break;
                case MouseEvent.BUTTON3:
                    popup.show(e.getComponent(), e.getX(), e.getY());
                    break;
            }
            System.out.println("mousePressed");

        }

        public void mouseReleased(MouseEvent e){
            rightMouseClicked = false;
            System.out.println("mouseReleased");
            /* 処理したい内容をここに記述する */
        }
    }

    public class moveEventListener implements MouseMotionListener{
        public void mouseDragged(MouseEvent e){
//            System.out.println("mouseDragged");
            if(rightMouseClicked) {
                Point point = e.getPoint();
                x = x + point.x - mouseX;
                y = y + point.y - mouseY;
                setBounds(x,y,getSize().width,getSize().height);
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
//            System.out.println("mouseMoved");

        }
    }


    private Menu createPopup(Menu menu, Set<String> set,ActionListener listener) {
        for(String key : set) {
            MenuItem mi = new MenuItem(key);
            mi.addActionListener(listener);
            menu.add(mi);
        }
        return menu;
    }
}
