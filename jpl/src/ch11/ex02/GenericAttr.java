package ch11.ex02;

public class GenericAttr<E> {
    private final String name;
    private E value = null;

    public GenericAttr(String name) {
        this.name = name;
    }

    public GenericAttr(String name,E value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public Object setValue(E newValue) {
        Object oldVal = value;
        value = newValue;
        return oldVal;
    }

    public String toString() {
        return name + "='" + value + "'";
    }
}
