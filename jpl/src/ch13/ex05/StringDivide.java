package ch13.ex05;

public class StringDivide {

    public static String stringDivide(String str){
        int strSize = str.length();
        StringBuilder retString = new StringBuilder(strSize+ str.length()/3);

        int dividerCount = 0;
        for(int i = 0; i < strSize;i++) {
            retString.append(str.charAt(i));
            dividerCount++;
            if(dividerCount == 3) {
                dividerCount = 0;
                retString.append(',');

            }
        }

        return retString.toString();
    }

    public static void main(String args[]){
        System.out.println(stringDivide("gdafdasfdfas"));
        System.out.println(stringDivide("がｄっがｄさｄｆｆさ"));
        System.out.println(stringDivide("ｄｇふぁｆｄｓｄさｆdfas"));



    }
}
