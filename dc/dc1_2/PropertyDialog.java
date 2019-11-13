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

    private static Map<String,Integer> mFontSizeMap = new LinkedHashMap<String,Integer>() {};
    static {
        mFontSizeMap.put("20",20);
        mFontSizeMap.put("24",24);
        mFontSizeMap.put("28",28);
        mFontSizeMap.put("32",32);
        mFontSizeMap.put("36",36);
    }

    private static Map<String,String> mFontListMap = new LinkedHashMap<String,String>() {};
    static {
        mFontListMap.put("Serif","Serif");
        mFontListMap.put("SansSerif","SansSerif");
        mFontListMap.put("Monospaced","Monospaced");
    }

    private static Map<String,Color> mColorListMap = new LinkedHashMap<String,Color>() {};
    static {
        mColorListMap.put("red",Color.red);
        mColorListMap.put("blue",Color.blue);
        mColorListMap.put("yellow",Color.yellow);
        mColorListMap.put("black",Color.black);
        mColorListMap.put("white",Color.white);
    }

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
        setLayout(new FlowLayout());
        setTitle("Setting");
        setSize(600, 300);
        addWindowListener(new MyWindowAdapter());

        mFontSizeList = addListLabel(mFontSizeMap.keySet());
        Label l1 = new Label("FontSize");
        add(l1);
        add(mFontSizeList);



        Label l2 = new Label("Font");
        add(l2);
        mFontList = addListLabel(mFontListMap.keySet());
        add(mFontList);

        Label l3 = new Label("TextColor");
        add(l3);
        mStringColorList = addListLabel(mColorListMap.keySet());
        add(mStringColorList);

        Label l4 = new Label("BackColor");
        add(l4);
        mBackColorList = addListLabel(mColorListMap.keySet());
        add(mBackColorList);
    }



    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            mOnewr.setFontSize(mFontSizeMap.get(mFontSizeList.getSelectedItem()));
            mOnewr.setFontName(mFontListMap.get(mFontList.getSelectedItem()));
            mOnewr.setBackColor(mColorListMap.get(mBackColorList.getSelectedItem()));
            mOnewr.setStringColor(mColorListMap.get(mStringColorList.getSelectedItem()));
            mOnewr.resizeFrame();
            dispose();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
