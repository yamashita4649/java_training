package ch07.ex03;

public class PascalsTriangle {
    private int pascals[][];
    public  PascalsTriangle(int num){
        pascals = new int[num][];
        for(int i = 0; i < num; i++) {
            pascals[i] = new int[i+1];
            pascals[i][0]=1;
            pascals[i][i]=1;
        }
        for(int i = 2;i < num;i++) {
            for(int j = 1; j < pascals[i].length-1;j++) {
                pascals[i][j] = pascals[i-1][j-1] + pascals[i-1][j];
            }
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
