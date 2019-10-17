package ch03.ex02;

public class X {
    protected int xMask = 0x00ff;
    protected int fullMask;

    public X(){
        System.out.printf("fullMask = %x xMask = %x%n" ,fullMask,xMask);
        fullMask = xMask;
        System.out.printf("fullMask = %x xMask = %x%n" ,fullMask,xMask);
    }

    public int mask(int orig) {
        return (orig & fullMask);
    }
}


