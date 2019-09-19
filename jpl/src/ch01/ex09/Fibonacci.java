public class Fibonacci {
    private static final int MAX_SIZE = 50;
    public static void main(String args[]){
        int lo = 1;
        int hi = 1;
        int count = 1;
        int[] fibonacciArray = new int[1];

        fibonacciArray[0] = lo;
        System.out.println("Fibonacci Number");
        while(hi < MAX_SIZE) {
            count++;
            int[] newArray = new int[count];
            for(int i = 0; i < fibonacciArray.length;i++) {
                newArray[i] = fibonacciArray[i];
            }
            newArray[count-1] = hi;
            fibonacciArray = newArray;
            hi = lo + hi;
            lo = hi - lo;
        }

        for(int i = 0;i <  fibonacciArray.length; i++) {
            System.out.println(fibonacciArray[i]);
        }
    }
}
