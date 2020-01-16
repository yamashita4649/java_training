import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * MainWindowクラス
 * メイン画面の構築と描画を行う。
 * */
public class MainWindow extends Frame implements ActionListener {


    Frame mMayFrame;

    TextField fd;
    TextArea b1;
    TextField fieldNameTxt;
    TextField fieldValueTxt;
    TextField methodNameTxt;
    TextField visivbleTxt;
    TextField titleTxt;
    TextField sizeXTxt;
    TextField sizeYTxt;
    TextField backGroundTxt;

    Class<?> createClass;
    Object  classObj;

//    ClockCanvas mClockCanvas;

    public MainWindow() {
        mMayFrame = new Frame();
        GridBagLayout layout=new GridBagLayout();
        GridBagConstraints c=new GridBagConstraints();
        mMayFrame.setLayout(layout);
        mMayFrame.setSize(500, 500);
        mMayFrame.addWindowListener(new MyWindowAdapter());
        mMayFrame.setVisible(true);
//        mMayFrame.add(mClockCanvas);


        Label l1 = new Label("クラス名");
        c.gridy =1;
        layout.setConstraints(l1,c);
        mMayFrame.add(l1);

        fd = (TextField)add(new TextField(20));
        layout.setConstraints(fd,c);
        mMayFrame.add(fd);

        Button createButton = new Button("create");
        createButton.addActionListener(this);
        createButton.setActionCommand("create");
        layout.setConstraints(createButton,c);
        mMayFrame.add(createButton);

        Label l3 = new Label("フィールド名");
        c.gridy =2;
        layout.setConstraints(l3,c);
        mMayFrame.add(l3);

        fieldNameTxt = (TextField)add(new TextField(20));
        layout.setConstraints(fieldNameTxt,c);
        mMayFrame.add(fieldNameTxt);

        Label l4 = new Label("値");
        c.gridy =3;
        layout.setConstraints(l4,c);
        mMayFrame.add(l4);

        fieldValueTxt = (TextField)add(new TextField(20));
        layout.setConstraints(fieldValueTxt,c);
        mMayFrame.add(fieldValueTxt);

        Button setButton = new Button("set");
        setButton.addActionListener(this);
        setButton.setActionCommand("set");
        layout.setConstraints(setButton,c);
        mMayFrame.add(setButton);

        Label l5 = new Label("メソッド名");
        c.gridy =4;
        layout.setConstraints(l5,c);
        mMayFrame.add(l5);

        methodNameTxt = (TextField)add(new TextField(20));
        layout.setConstraints(methodNameTxt,c);
        mMayFrame.add(methodNameTxt);

        Button MethodButton = new Button("method");
        MethodButton.addActionListener(this);
        MethodButton.setActionCommand("method");
        layout.setConstraints(MethodButton,c);
        mMayFrame.add(MethodButton);



        c.gridy =9;
        visivbleTxt = (TextField)add(new TextField(20));
        layout.setConstraints(visivbleTxt,c);
        mMayFrame.add(visivbleTxt);

        Button setVisibleBtn = new Button("setVisible");
        setVisibleBtn.addActionListener(this);
        setVisibleBtn.setActionCommand("setVisible");
        layout.setConstraints(setVisibleBtn,c);
        mMayFrame.add(setVisibleBtn);

        c.gridy =8;
        titleTxt = (TextField)add(new TextField(20));
        layout.setConstraints(titleTxt,c);
        mMayFrame.add(titleTxt);

        Button titleBtn = new Button("setTitle");
        titleBtn.addActionListener(this);
        titleBtn.setActionCommand("setTitle");
        layout.setConstraints(titleBtn,c);
        mMayFrame.add(titleBtn);

        c.gridy =7;
        backGroundTxt = (TextField)add(new TextField(20));
        layout.setConstraints(backGroundTxt,c);
        mMayFrame.add(backGroundTxt);

        Button buckGroundBtn = new Button("setBuckGround");
        buckGroundBtn.addActionListener(this);
        buckGroundBtn.setActionCommand("setBuckGround");
        layout.setConstraints(buckGroundBtn,c);
        mMayFrame.add(buckGroundBtn);

        Label l6 = new Label("wight");
        c.gridy =10;
        layout.setConstraints(l6,c);
        mMayFrame.add(l6);

        sizeXTxt = (TextField)add(new TextField(20));
        layout.setConstraints(sizeXTxt,c);
        mMayFrame.add(sizeXTxt);

        Label l7 = new Label("wight");
        c.gridy =11;
        layout.setConstraints(l7,c);
        mMayFrame.add(l7);

        sizeYTxt = (TextField)add(new TextField(20));
        layout.setConstraints(sizeYTxt,c);
        mMayFrame.add(sizeYTxt);

        Button sizeButton = new Button("setSize");
        sizeButton.addActionListener(this);
        sizeButton.setActionCommand("setSize");
        layout.setConstraints(sizeButton,c);
        mMayFrame.add(sizeButton);

        //result
        c.gridy =12;

        Label l2 = new Label("結果");
        layout.setConstraints(l2,c);
        mMayFrame.add(l2);

        b1 = new TextArea("Hello World!!", 5, 50);
        layout.setConstraints(b1,c);
        mMayFrame.add(b1);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("create")) {
            String clsName = fd.getText();
            try {
                createClass = Class.forName(clsName);
                classObj = createClass.newInstance();
                b1.setText("create:"+ clsName);
            } catch (ClassNotFoundException ex) {
                displayException(ex);
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                displayException(ex);
                ex.printStackTrace();
            } catch (InstantiationException ex) {
                displayException(ex);
                ex.printStackTrace();
            }
        } else if("set".equals(cmd)) {
            try {
                Field field = createClass.getField(fieldNameTxt.getText());
                field.setAccessible(true);
                field.set(createClass,fieldValueTxt.getText());
                b1.setText("set:"+ fieldValueTxt.getText());
            } catch (NoSuchFieldException ex) {
                displayException(ex);
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                displayException(ex);
                ex.printStackTrace();
            }
        } else if("method".equals(cmd)) {
            try {
                Method meth = createClass.getMethod(methodNameTxt.getText());
                Object ret = meth.invoke(classObj);
                b1.setText("exec:"+ methodNameTxt.getText()+"\r\n return:"+ ret.toString());
            } catch (NoSuchMethodException ex) {
                displayException(ex);
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                displayException(ex);
                ex.printStackTrace();
            } catch (InvocationTargetException ex) {
                displayException(ex);
                ex.printStackTrace();
            }
        } else if("setVisible".equals(cmd)) {
            mMayFrame.setVisible(Boolean.valueOf(visivbleTxt.getText()));
        } else if("setTitle".equals(cmd)) {
            mMayFrame.setTitle(titleTxt.getText());
        } else if("setBuckGround".equals(cmd)) {
            mMayFrame.setBackground(new Color(Integer.valueOf(backGroundTxt.getText())));
        } else if("setSixe".equals(cmd)) {
            mMayFrame.setSize(Integer.valueOf(sizeXTxt.getText()),Integer.valueOf(sizeYTxt.getText()));
            mMayFrame.repaint();
        }
    }

    public void displayException(Exception e){
        StackTraceElement[] steList = e.getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.getClass().getName() + ":" + e.getMessage()+"\r\n");

        for(StackTraceElement ste : steList) {
            stringBuilder.append(ste.toString());
            stringBuilder.append("\r\n");
        }
        b1.setText(stringBuilder.toString());
    }

    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

//    class ClockCanvas extends Canvas {
//        public void paint(Graphics g) {
//            Dimension size = getSize();
//            Image back = createImage(size.width, size.height);
//            Graphics buffer = back.getGraphics();
//
//            buffer.setColor(Color.WHITE);
//            buffer.fillRect(0, 0, size.width - 1, size.height - 1);
//            int hight = buffer.getFontMetrics().getHeight();
//            g.drawImage(back, 0, 0, this);
//        }
//    }
}
