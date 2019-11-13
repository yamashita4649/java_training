package ch09.ex02;

public class BitCount {

    public static int culcBitCount(Integer bit) {
        int count = 0;

        for(int i = 0;i<bit.SIZE;i++) {

            count += (bit & 1);
            bit = bit >>> 1;
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println("12のbit数=" + BitCount.culcBitCount(12));
        System.out.println("5のbit数=" + BitCount.culcBitCount(5));
        System.out.println("30のbit数=" + BitCount.culcBitCount(30));
        System.out.println("20のbit数=" + BitCount.culcBitCount(20));
    }
}
