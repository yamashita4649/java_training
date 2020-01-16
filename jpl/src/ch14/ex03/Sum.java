package ch14.ex03;

public class Sum {

    private int value;

    Sum() {
        value = 0;
    }

    public synchronized void addValue(int i) {
        value += i;
        System.out.println("value:" + value);
    }


}
