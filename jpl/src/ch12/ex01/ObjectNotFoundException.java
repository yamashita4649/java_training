package ch12.ex01;

public class ObjectNotFoundException extends Exception{
    public final String objectName;

    public ObjectNotFoundException(String name) {
        super("not found " + name);
        objectName = name;
    }
}
