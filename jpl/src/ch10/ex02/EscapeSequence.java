package ch10.ex02;

public class EscapeSequence {

    static String convetWSString(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(char c : charArray ) {
            String temp;
            switch (c) {
                case '"':
                    temp = "\\\"";
                    break;
                case '\b':
                    temp = "\\b";
                    break;
                case '\t':
                    temp = "\\t";
                    break;
                case '\r':
                    temp = "\\r";
                    break;
                case '\f':
                    temp = "\\f";
                    break;
                case '\\':
                    temp = "\\\\";
                    break;
                case '\'':
                    temp = "\\'";
                    break;
                case '\n':
                    temp = "\\n";
                    break;
                default:
                    temp = String.valueOf(c);
            }
            builder.append(temp);
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        String str1 = "aaa\baa\t\r\n\f\\\'\"aaa\naa";
        System.out.printf("%s = %s",str1, EscapeSequence.convetWSString(str1));
    }

}
