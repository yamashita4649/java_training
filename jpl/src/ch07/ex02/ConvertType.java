package ch07.ex02;

public class ConvertType {
    public static void main(String[] args) {
        int i=0;
        long l=0;



        System.out.println(i=(int)3.5f);
        System.out.println(3.5f);
        System.out.println(i=(int)9223372036854775807L);
        System.out.println(9223372036854775807L);
    }
}
