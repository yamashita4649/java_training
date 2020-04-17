import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class FieldWindow extends Frame implements ActionListener {

    Frame mMayFrame;
    TextField[] mTextField;
    Field[] mFields;
    ObjectWindow parentWindow;
    Class myClass;

    public FieldWindow(Class myClass,ObjectWindow window) {
        mMayFrame = new Frame();
        parentWindow = window;
        this.myClass = myClass;

        mMayFrame.setTitle(myClass.getName() + " Fields");

        viewCreate();

        mMayFrame.addWindowListener(new MyWindowAdapter());
        mMayFrame.setVisible(true);
    }

    public void viewCreate() {

        mFields = myClass.getDeclaredFields();
        mTextField = new TextField[mFields.length];

        GridLayout layout= new GridLayout(mFields.length+1,2);
        mMayFrame.setLayout(layout);
        mMayFrame.setSize(500, 500);
        int i = 0;
        for(Field tempClass :mFields) {
            Label l = new Label(tempClass.toString());
            TextField t = (TextField)add(new TextField(20));


            if(Modifier.isFinal(tempClass.getModifiers())) {
//                try {
//                    Field modifiersField = null;          // Fieldクラスはmodifiersでアクセス対象のフィールドのアクセス判定を行っているのでこれを更新する。
//                    try {
//                        modifiersField = Field.class.getDeclaredField("modifiers");
//                        modifiersField.setAccessible(true);
//                        modifiersField.setInt(tempClass,
//                                tempClass.getModifiers() & ~Modifier.FINAL);
//                    } catch (NoSuchFieldException e) {
//                        e.printStackTrace();
//                    }
//
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
                tempClass.setAccessible(true);
            }

            if(Modifier.isPrivate(tempClass.getModifiers())) {
                tempClass.setAccessible(true);
            }



            try {
                t.setText(tempClass.get(parentWindow.getMyObject()).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
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
        Object[] obj;
        if(mFields.length > 0) {
            obj = new Object[mFields.length];
            for (Field tempClass : mFields) {
                if (tempClass.getType().getTypeName().equals(int.class.getName())) {
                    obj[i] = Integer.parseInt(mTextField[i].getText());
                } else if (tempClass.getType().getTypeName().equals(int.class.getName())) {
                    obj[i] = Integer.parseInt(mTextField[i].getText());
                } else if (tempClass.getType().getTypeName().equals(short.class.getName())) {
                    obj[i] = Short.parseShort(mTextField[i].getText());
                } else if (tempClass.getType().getTypeName().equals(byte.class.getName())) {
                    obj[i] = Byte.parseByte(mTextField[i].getText());
                } else if (tempClass.getType().getTypeName().equals(long.class.getName())) {
                    obj[i] = Long.parseLong(mTextField[i].getText());
                } else if (tempClass.getType().getTypeName().equals(float.class.getName())) {
                    obj[i] = Float.parseFloat(mTextField[i].getText());
                } else if (tempClass.getType().getTypeName().equals(double.class.getName())) {
                    obj[i] = Double.parseDouble(mTextField[i].getText());
                } else if (tempClass.getType().getTypeName().equals(String.class.getName())) {
                    obj[i] = mTextField[i].getText();
                } else {
                    obj[i] = null;
                }
                try {
                    if (obj[i] != null) {
                        tempClass.set(parentWindow.getMyObject(),obj[i] );
                    }
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }

                i++;
            }

        } else {
            obj = null;
        }
        System.out.println("actionPerformed");
    }

    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e)
        {
            mMayFrame.setVisible(false);
            dispose();
        }
    }
}
