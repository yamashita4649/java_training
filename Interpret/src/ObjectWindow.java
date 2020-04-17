import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ObjectWindow extends Frame implements ActionListener {

    Frame mMayFrame;
    Class<?> myClass;
    Object myObject;

    public ObjectWindow(Class<?>  tClass) {
        mMayFrame = new Frame();

        myClass = tClass;
        mMayFrame.setTitle(myClass.getName());

        viewCreate();

        mMayFrame.addWindowListener(new MyWindowAdapter());
        mMayFrame.setVisible(true);
    }

    private void viewCreate() {
        GridBagLayout layout=new GridBagLayout();
        GridBagConstraints c=new GridBagConstraints();
        mMayFrame.setLayout(layout);
        mMayFrame.setSize(500, 500);

        Button constButton = new Button("コンストラクタ");
        constButton.addActionListener(this);
        constButton.setActionCommand("const");
        layout.setConstraints(constButton,c);
        mMayFrame.add(constButton);

        Button methodButton = new Button("メソッド");
        methodButton.addActionListener(this);
        methodButton.setActionCommand("method");
        layout.setConstraints(methodButton,c);
        mMayFrame.add(methodButton);

        Button fieldButton = new Button("変数");
        fieldButton.addActionListener(this);
        fieldButton.setActionCommand("field");
        layout.setConstraints(fieldButton,c);
        mMayFrame.add(fieldButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch(cmd) {
            case "const":
                new ConstWindow(myClass,this);
                break;
            case "method":
                new MethodListWindow(myClass,this);
                break;
            case "field":
                new FieldWindow(myClass,this);
                break;
            default:
                break;
        }
    }

    public void setObject(Object obj) {
        myObject = obj;
    }

    public Object getMyObject() {
        return myObject;
    }

    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e)
        {
            mMayFrame.setVisible(false);
            dispose();
        }
    }
}
