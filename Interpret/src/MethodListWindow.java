import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class MethodListWindow extends Frame implements ActionListener {
    Frame mMayFrame;

    Class<?> myClass;
    ObjectWindow parentWindow;
    Method[] mMethods;

    public MethodListWindow(Class mClass,ObjectWindow window) {
        myClass = mClass;
        parentWindow = window;

        mMayFrame = new Frame();
        mMayFrame.setTitle(myClass.getName() + " Methods");

        viewCreate();

        mMayFrame.addWindowListener(new MyWindowAdapter());
        mMayFrame.setVisible(true);
    }

    public void viewCreate() {
        mMethods = myClass.getMethods();

        GridLayout layout= new GridLayout(mMethods.length,1);
        mMayFrame.setLayout(layout);
        mMayFrame.setSize(500, 500);
        int i = 0;
        for(Member constructor :mMethods) {
            Button methodButton = new Button(constructor.toString());
            methodButton.addActionListener(this);
            methodButton.setActionCommand(Integer.toString(i));
            mMayFrame.add(methodButton);
            i++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        System.out.println("actionPerformed:"+cmd);
        int i = Integer.valueOf(cmd).intValue();
        new MethodExecuteWindow(mMethods[i],parentWindow);
    }

    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            mMayFrame.setVisible(false);
            dispose();
//            System.exit(0);
        }
    }
}
