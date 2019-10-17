package ch03.ex02;

class Y extends X {
    protected int yMask = 0xff00;

    public Y() {
        System.out.printf("fullMask = %x yMask = %x xMask = %x%n" ,fullMask,yMask,xMask);
        fullMask |= yMask;
        System.out.printf("fullMask = %x yMask = %x xMask = %x%n" ,fullMask,yMask,xMask);
    }

    public static void main(String args[]){
        new Y();
    }
}