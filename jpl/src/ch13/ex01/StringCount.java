package ch13.ex01;

public class StringCount {
    static int coundChar(String str, char c) {
        char[] charList = str.toCharArray();
        int i = 0;
        for(char charValue : charList) {
            if(c == charValue) {
                i++;
            }
        }
        return i;
    }
    public static void main(String args[]){
        String str = "aaaaaa";

        System.out.println(str + " have " + coundChar(str,'a') +" " + "a" );

        String str1 = "dklsahjgk;lafjg";
        System.out.println(str1 + " have " + coundChar(str1,'a') +" " + "a" );

    }


}
