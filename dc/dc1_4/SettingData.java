import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class SettingData {


    private static int mFontSize = 20;
    private static String mFontType = "Serif";
    private static Color mBackColor = Color.red;
    private static Color mStringColor = Color.blue;

    private static String mSelectedFontSizeKey = "20";
    private static String mSelectedFontTypeKey = "Serif";
    private static String mSelectedBackColorKey = "red";
    private static String mSelectedStringColorKey = "blue";

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

    private static Map<String, Color> mColorListMap = new LinkedHashMap<String,Color>() {};
    static {
        mColorListMap.put("red",Color.red);
        mColorListMap.put("blue",Color.blue);
        mColorListMap.put("yellow",Color.yellow);
        mColorListMap.put("black",Color.black);
        mColorListMap.put("white",Color.white);
    }



    public static Map<String, Integer> getmFontSizeMap() {
        return mFontSizeMap;
    }

    public static Map<String, String> getmFontListMap() {
        return mFontListMap;
    }

    public static Map<String, Color> getmColorListMap() {
        return mColorListMap;
    }

    public static int getmFontSize() {
        return mFontSize;
    }

    public static void setmFontSize(String size) {
        mSelectedFontSizeKey = size;
        mFontSize = mFontSizeMap.get(size);
    }

    public static String getmFontType() {
        return mFontType;
    }

    public static void setmFontType(String fontType) {
        mSelectedFontTypeKey = fontType;
        mFontType = mFontListMap.get(fontType);
    }

    public static Color getmBackColor() {
        return mBackColor;
    }

    public static void setmBackColor(String color) {
        mSelectedBackColorKey = color;
        mBackColor = mColorListMap.get(color);
    }

    public static Color getmStringColor() {
        return mStringColor;
    }

    public static void setmStringColor(String color) {
        mSelectedStringColorKey = color;
        mStringColor = mColorListMap.get(color);
    }

    public static String getmSelectedFontSizeKey() {
        return mSelectedFontSizeKey;
    }

    public static String getmSelectedFontTypeKey() {
        return mSelectedFontTypeKey;
    }

    public static String getmSelectedBackColorKey() {
        return mSelectedBackColorKey;
    }

    public static String getmSelectedStringColorKey() {
        return mSelectedStringColorKey;
    }
}
