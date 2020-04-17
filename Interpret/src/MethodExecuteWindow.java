import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodExecuteWindow extends Frame implements ActionListener {

    Frame mMayFrame;
    Method mMethod;
    TextField[] mTextField;
    Class<?>[] mClasss;
    ObjectWindow parentWindow;
    TextField resultTxt;

    public MethodExecuteWindow(Method method, ObjectWindow window) {
        mMayFrame = new Frame();
        mMethod = method;
        parentWindow = window;

        mMayFrame.setTitle(method.getName() + " Execute");

        viewCreate();

        mMayFrame.addWindowListener(new MyWindowAdapter());
        mMayFrame.setVisible(true);
    }

    public void viewCreate() {

        mClasss = mMethod.getParameterTypes();
        mTextField = new TextField[mClasss.length];

        GridLayout layout= new GridLayout(mClasss.length+2,2);
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

        resultTxt = (TextField)add(new TextField(20));
        mMayFrame.add(resultTxt);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int i = 0;
        Object[] obj;
        if(mClasss.length > 0) {
            obj = new Object[mClasss.length];
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

        } else {
            obj = null;
        }
        Object result = null;
        Object parent;
        if(Modifier.isStatic(mMethod.getModifiers())) {
            parent = null;
        } else {
            parent = parentWindow.getMyObject();
        }

        try {
            result =mMethod.invoke(parent,obj);
            if(result == null) {
                result = "null";
            }
            resultTxt.setText(result.toString());
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            resultTxt.setText(ex.toString());
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
            resultTxt.setText(ex.toString());
        }
        System.out.println("actionPerformed");
    }

    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            mMayFrame.setVisible(false);
            dispose();
//            System.exit(0);
        }
    }
}
