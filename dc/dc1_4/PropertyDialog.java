import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PropertyDialog extends Dialog implements ActionListener {

    private MainWindow mOnewr;
    private Choice mFontSizeList;
    private Choice mFontList;
    private Choice mStringColorList;
    private Choice mBackColorList;



    private Choice addListLabel(Set<String> map) {
        Choice ret = new Choice();
        for(String key : map) {
            ret.add(key);
        }
        return ret;
    }

    public PropertyDialog(MainWindow owner) {
        super(owner,true);
        mOnewr = owner;
        GridBagLayout layout=new GridBagLayout();
        GridBagConstraints c=new GridBagConstraints();
        setLayout(layout);
        setTitle("Setting");
        setSize(300, 300);
        addWindowListener(new MyWindowAdapter());

        mFontSizeList = addListLabel(SettingData.getmFontSizeMap().keySet());
        Label l1 = new Label("FontSize");
        c.gridy =1;
        c.ipady =10;
        c.anchor = GridBagConstraints.WEST;
        layout.setConstraints(l1,c);
        add(l1);
        c.anchor = GridBagConstraints.EAST;
        layout.setConstraints(mFontSizeList,c);
        add(mFontSizeList);
        mFontSizeList.select(SettingData.getmSelectedFontSizeKey());


        Label l2 = new Label("Font");
        c.gridy =3;
        c.anchor = GridBagConstraints.WEST;
        mFontList = addListLabel(SettingData.getmFontListMap().keySet());
        layout.setConstraints(l2,c);
        add(l2);
        mFontList.select(SettingData.getmSelectedFontTypeKey());

        c.anchor = GridBagConstraints.EAST;
        layout.setConstraints(mFontList,c);
        add(mFontList);

        Label l3 = new Label("TextColor");
        mStringColorList = addListLabel(SettingData.getmColorListMap().keySet());
        c.gridy =5;
        c.anchor = GridBagConstraints.WEST;
        layout.setConstraints(l3,c);
        add(l3);
        c.anchor = GridBagConstraints.EAST;
        layout.setConstraints(mStringColorList,c);
        add(mStringColorList);
        mStringColorList.select(SettingData.getmSelectedStringColorKey());

        Label l4 = new Label("BackColor");
        mBackColorList = addListLabel(SettingData.getmColorListMap().keySet());
        c.gridy =7;
        c.anchor = GridBagConstraints.WEST;
        layout.setConstraints(l4,c);
        add(l4);
        c.anchor = GridBagConstraints.EAST;
        layout.setConstraints(mBackColorList,c);
        add(mBackColorList);
        mBackColorList.select(SettingData.getmSelectedBackColorKey());

        Button ok = new Button("OK");
        ok.addActionListener(this);
        ok.setActionCommand("ok");
        c.gridy =9;
        c.gridx = 2;
        c.anchor = GridBagConstraints.SOUTHEAST;
        layout.setConstraints(ok,c);
        add(ok);

        Button calcel = new Button("CANCEL");
        calcel.addActionListener(this);
        c.gridy =9;
        c.gridx = 1;
        c.anchor = GridBagConstraints.SOUTHEAST;
        layout.setConstraints(calcel,c);
        add(calcel);
    }



    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            mOnewr.resizeFrame();
            dispose();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ok")) {
            mOnewr.setFontSize(SettingData.getmFontSizeMap().get(mFontSizeList.getSelectedItem()));
            SettingData.setmFontSize(mFontSizeList.getSelectedItem());
            mOnewr.setFontName(SettingData.getmFontListMap().get(mFontList.getSelectedItem()));
            SettingData.setmFontType(mFontList.getSelectedItem());
            mOnewr.setBackColor(SettingData.getmColorListMap().get(mBackColorList.getSelectedItem()));
            SettingData.setmBackColor(mBackColorList.getSelectedItem());
            mOnewr.setStringColor(SettingData.getmColorListMap().get(mStringColorList.getSelectedItem()));
            SettingData.setmStringColor(mStringColorList.getSelectedItem());
            mOnewr.resizeFrame();
            dispose();
        } else {
            mOnewr.resizeFrame();
            dispose();
        }
    }
}
