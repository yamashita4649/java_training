package ch14.ex05;

public class Sum {

    private static int value;

    Sum() {
        value = 0;
    }

    public static synchronized void addValue(int i) {
        value += i;
        System.out.println("value:" + value);
    }

    public synchronized void removeValue(int i) {
        value -= i;
        System.out.println("value:" + value);
    }


}
