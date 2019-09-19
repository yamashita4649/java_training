public class ImprovedFibonacci {
    static final int MAX_INDEX = 9;
    public static void main(String args[]){
        int lo = 1;
        int hi = 1;
        String mark;
        String[] dispStringArray = new String[MAX_INDEX];
        dispStringArray[0] = "1: " + lo;
        for(int i = 2;i <= MAX_INDEX; i++) {
            if (hi % 2 == 0)
                mark = " *";
            else
                mark = "";
            dispStringArray[i-1] = i + ": " + hi + mark;
            hi = lo + hi;
            lo = hi - lo;
        }

        for(String str : dispStringArray) {
            System.out.println(str);
        }
    }
}
