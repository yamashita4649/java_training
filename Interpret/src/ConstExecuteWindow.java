import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;

public class ConstExecuteWindow extends Frame implements ActionListener {

    Frame mMayFrame;
    Constructor mConst;
    TextField[] mTextField;
    Class<?>[] mClasss;
    ObjectWindow parentWindow;


    public ConstExecuteWindow(Constructor constructor,ObjectWindow window) {
        mMayFrame = new Frame();
        mConst = constructor;
        parentWindow = window;

        mMayFrame.setTitle(constructor.getName() + " Execute");

        viewCreate();

        mMayFrame.addWindowListener(new MyWindowAdapter());
        mMayFrame.setVisible(true);
    }

    public void viewCreate() {

        mClasss = mConst.getParameterTypes();
        mTextField = new TextField[mClasss.length];

        GridLayout layout= new GridLayout(mClasss.length+1,2);
        mMayFrame.setLayout(layout);
        mMayFrame.setSize(500, 500);
        int i = 0;
        for(Class tempClass :mClasss) {
            Label l = new Label(tempClass.toString());
            TextField t = (TextField)add(new TextField(20));
            mMayFrame.add(l);
            mMayFrame.add(t);
            mTextField[i] = t;
            i++;
        }
        Button methodButton = new Button("execute");
        methodButton.addActionListener(this);
        methodButton.setActionCommand("execute");
        mMayFrame.add(methodButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = 0;
        if(mClasss.length > 0) {
            Object[] obj = new Object[mClasss.length];
            for (Class tempClass : mClasss) {
                if (tempClass.getTypeName().equals(int.class.getName())) {
                    obj[i] = Integer.parseInt(mTextField[i].getText());
                } else if (tempClass.getTypeName().equals(int.class.getName())) {
                    obj[i] = Integer.parseInt(mTextField[i].getText());
                } else if (tempClass.getTypeName().equals(short.class.getName())) {
                    obj[i] = Short.parseShort(mTextField[i].getText());
                } else if (tempClass.getTypeName().equals(byte.class.getName())) {
                    obj[i] = Byte.parseByte(mTextField[i].getText());
                } else if (tempClass.getTypeName().equals(long.class.getName())) {
                    obj[i] = Long.parseLong(mTextField[i].getText());
                } else if (tempClass.getTypeName().equals(float.class.getName())) {
                    obj[i] = Float.parseFloat(mTextField[i].getText());
                } else if (tempClass.getTypeName().equals(double.class.getName())) {
                    obj[i] = Double.parseDouble(mTextField[i].getText());
                } else if (tempClass.getTypeName().equals(String.class.getName())) {
                    obj[i] = mTextField[i].getText();
                } else {
                    obj[i] = null;
                }
                i++;
            }
            try {
                parentWindow.setObject(mConst.newInstance(obj));
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (InvocationTargetException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                parentWindow.setObject(mConst.newInstance());
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (InvocationTargetException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("actionPerformed");
        mMayFrame.setVisible(false);
        dispose();


    }

    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            mMayFrame.setVisible(false);
            dispose();
//            System.exit(0);
        }
    }
}
