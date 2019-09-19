public class ImprovedFibonacci {
    static final int MAX_INDEX = 9;
    public static void main(String args[]){
        int lo = 1;
        int hi = 1;
        String mark;
        boolean isMark;
        Fibonacci[] fibonacciArray = new Fibonacci[MAX_INDEX];
        fibonacciArray[0] = new Fibonacci(lo,false);
        for(int i = 1;i < MAX_INDEX; i++) {
            if (hi % 2 == 0) {
                isMark = true;
            } else {
                isMark = false;
            }
            fibonacciArray[i] = new Fibonacci(hi,isMark);
            hi = lo + hi;
            lo = hi - lo;
        }

        System.out.println(1 + ": " + fibonacciArray[0].number + "");
        for(int i = 1;i <MAX_INDEX; i++) {
            Fibonacci fibonacci = fibonacciArray[i];
            if (fibonacci.isEvenNumber) {
                mark = " *";
            } else {
                mark  = "";
            }
            System.out.println(i + ": " + fibonacci.number + mark);
        }
    }

    static class Fibonacci {
        public int number;
        public boolean isEvenNumber;

         Fibonacci(int number , boolean isEvenNumber) {
            this.number = number;
            this.isEvenNumber = isEvenNumber;
        }
    }
}
