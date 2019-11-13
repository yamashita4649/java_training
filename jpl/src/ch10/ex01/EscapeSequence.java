package ch10.ex01;

public class EscapeSequence {

    static String convetWSString(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(char c : charArray ) {
            String temp;
            if(c == '"') {
                temp = "\\\"";
            } else if(c == '\t') {
                temp = "\\t";
            }else if(c == '\b') {
                temp = "\\b";
            }else if(c == '\r') {
                temp = "\\r";
            }else if(c == '\f') {
                temp = "\\f";
            }else if(c == '\\') {
                temp = "\\\\";
            }else if(c == '\'') {
                temp = "\\\'";
            }else if(c == '\n') {
                temp = "\\n";
            }else{
                temp = String.valueOf(c);
            }
            builder.append(temp);
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        String str1 = "aaa\baa\t\r\n\f\\\'\"aaa\naa";
        System.out.printf("%s = %s",str1,EscapeSequence.convetWSString(str1));


    }

}
