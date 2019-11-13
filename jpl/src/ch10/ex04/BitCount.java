package ch10.ex04;

public class BitCount {
//ch09ex02
    //ループ回数がIntの最大ビット桁数分行われるため。do whileにできるが、する必要なし
    public static int culcBitCount(Integer bit) {
        int count = 0;
        int i = 0;

        while(i<bit.SIZE) {
            count += (bit & 1);
            bit = bit >>> 1;
            i++;
        }
//        do {
//            System.out.println("i=" + i);
//            count += (bit & 1);
//            bit = bit >>> 1;
//            i++;
//        } while (i<bit.SIZE);
        return count;
    }


    public static void main(String[] args) {
        System.out.println("12のbit数=" + BitCount.culcBitCount(12));
        System.out.println("5のbit数=" + BitCount.culcBitCount(5));
        System.out.println("30のbit数=" + BitCount.culcBitCount(30));
        System.out.println("20のbit数=" + BitCount.culcBitCount(20));
    }
}
