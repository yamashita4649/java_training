import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;

public class ConstWindow extends Frame implements ActionListener {

    Frame mMayFrame;
    Class<?> myClass;
    Constructor[] mConss;
    ObjectWindow parentWindow;

    public ConstWindow(Class<?>  tClass,ObjectWindow window) {
        mMayFrame = new Frame();
        parentWindow = window;
        myClass = tClass;
        mMayFrame.setTitle(myClass.getName() + " Constructors");

        viewCreate();

        mMayFrame.addWindowListener(new MyWindowAdapter());
        mMayFrame.setVisible(true);
    }

    public void viewCreate() {

        mConss = myClass.getConstructors();

        GridLayout layout= new GridLayout(mConss.length,1);
        mMayFrame.setLayout(layout);
        mMayFrame.setSize(500, 500);
        System.out.println(myClass);
        int i = 0;
        for(Member constructor :mConss) {
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
        new ConstExecuteWindow(mConss[i],parentWindow);
    }

    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e)
        {
            mMayFrame.setVisible(false);
            dispose();
        }
    }
}
