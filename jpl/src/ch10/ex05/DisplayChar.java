package ch10.ex05;

public class DisplayChar {
    static void disprayBetweenTwoChar(char c1,char c2) {
        char smallChar;
        char largeChar;
        if(c1 < c2) {
            smallChar = c1;
            largeChar = c2;
        }  else if(c2 < c1) {
            smallChar = c2;
            largeChar = c1;
        } else {
            return;
        }

        for(int i = smallChar+1;i<largeChar;i++) {
            System.out.printf("%c" ,i);
        }
        System.out.printf("\r\n");

    }
    public static void main(String[] args) {

        DisplayChar.disprayBetweenTwoChar('d','x');
        DisplayChar.disprayBetweenTwoChar('x','d');
        DisplayChar.disprayBetweenTwoChar('x','1');
        DisplayChar.disprayBetweenTwoChar('1','x');
        DisplayChar.disprayBetweenTwoChar('x','x');
    }
}
