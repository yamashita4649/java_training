package ch03.ex07;

public class ColorAttr extends Attr{
    private ScreenColor myColor;

    public ColorAttr(String name, Object value) {
        super(name, value);
        decodeColor();
    }

    public ColorAttr(String name) {
        this(name,"transparent");
    }

    public ColorAttr(String name, ScreenColor value) {
        super(name, value.toString());
        myColor = value;
    }

    public Object setValue(Object newValue) {
        Object retval = super.setValue(newValue);
        decodeColor();
        return retval;
    }

    public ScreenColor setValue(ScreenColor newValue) {
        super.setValue(newValue.toString());
        ScreenColor oldValue = myColor;
        myColor = newValue;
        return oldValue;
    }

    public ScreenColor getColor() {
        return myColor;
    }

    private void decodeColor() {
        if(getValue() == null)
            myColor = null;
        else
            myColor = new ScreenColor(getValue());
    }

    @Override
    public int hashCode() {
return this.getValue().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }

        if(!(obj instanceof ColorAttr)) {
            return false;
        }

        ColorAttr colorObj = (ColorAttr) obj;
        if(this.getValue().equals(colorObj.getValue())) {
            return true;
        }
        return false;

    }

}

class ScreenColor {
    String value;
    public ScreenColor(Object value) {
        if(value instanceof String) {
            this.value = (String) value;
        } else {
            this.value = value.toString();
        }
    }

    @Override
    public String toString() {
        return value;
    }
}

class Attr {
    private final String name;
    private Object value = null;

    public Attr(String name) {
        this.name = name;
    }

    public Attr(String name,Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public Object setValue(Object newValue) {
        Object oldVal = value;
        value = newValue;
        return oldVal;
    }

    public String toString() {
        return name + "='" + value + "'";
    }
}