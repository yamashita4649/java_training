package ch13.ex02;

public class StringCount {
    static int coundChar(String str, String CountString) {
        int start=0;
        int i = 0;

        while(true) {
            start = str.indexOf(CountString,start);
            if(start == -1) {
                break;
            }
            start++;
            i++;
        }

        return i;
    }
    public static void main(String args[]){
        String str = "aaaaaa";

        System.out.println(str + " have " + coundChar(str,"aa") +" " + "aa" );

        String str1 = "dklsahjgk;lafjg";
        System.out.println(str1 + " have " + coundChar(str1,"dkls") +" " + "dkls" );

    }


}
