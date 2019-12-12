package ch13.ex06;

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

    public static String stringDivide(String str,char divideStr,int separateCnt){
        if (separateCnt <= 0) {
            return "";
        }
        int strSize = str.length();
        StringBuilder retString = new StringBuilder(strSize+ str.length()/separateCnt);

        int dividerCount = 0;
        for(int i = 0; i < strSize;i++) {
            retString.append(str.charAt(i));
            dividerCount++;
            if(dividerCount == separateCnt) {
                dividerCount = 0;
                retString.append(divideStr);

            }
        }
        return retString.toString();
    }

    public static void main(String args[]){
        System.out.println(stringDivide("gdafdasfdfas",'.',2));
        System.out.println(stringDivide("がｄっがｄさｄｆｆさ",'1',3));
        System.out.println(stringDivide("ｄｇふぁｆｄｓｄさｆdfas",'0',0));



    }
}
