package ch14.ex04;

public class Sum {

    private static int value;

    Sum() {
        value = 0;
    }

    public static synchronized void addValue(int i) {
        value += i;
        System.out.println("value:" + value);
    }
}
