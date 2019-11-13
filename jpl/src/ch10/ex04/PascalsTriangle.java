package ch10.ex04;
//ch09ex01

public class PascalsTriangle {
    private int pascals[][];
    //引数が0の場合はループに入ってはいけないため、do whileにすべきではない。
    public PascalsTriangle(int num){
        pascals = new int[num][];
        int i = 0;
        while(i < num) {
            pascals[i] = new int[i+1];
            pascals[i][0]=1;
            pascals[i][i]=1;
            if(i >= 2) {
                int j = 1;
                while(j < pascals[i].length-1) {
                    pascals[i][j] = pascals[i-1][j-1] + pascals[i-1][j];
                    j++;
                }
            }
            i++;
        }
    }

    public void show() {
        for(int[] array : pascals) {
            for(int i:array) {
                System.out.printf(" %d ", i);
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        PascalsTriangle pas = new PascalsTriangle(13);
        pas.show();
    }
}
