package ch04.ex02;

public class SortHarness implements Sort{
    private Object[] values;
    private final SortMetrics curMetrics = new SortMetrics();

    public final SortMetrics sort(Object[] data) {
        values = data;
        curMetrics.init();
        doSort();
        return getMetrics();
    }

    public final SortMetrics getMetrics() {
        return curMetrics.clone();
    }

    protected final int getDataLength() {
        return values.length;
    }

    protected final Object porbe(int i) {
        curMetrics.probeCnt++;
        return values[i];
    }

    protected final int compare(int i ,int j) {
        curMetrics.compareCnt++;
        Object d1 = values[i];
        Object d2 = values[j];
        int ret;
        if(d1 instanceof Comparable) {
            Comparable compD1 = (Comparable)d1;
            Comparable compD2 = (Comparable)d2;
            ret = compD1.compareTo(compD2);
        } else {
            String d1Str = d1.toString();
            String d2Str = d2.toString();
            ret = d1Str.compareTo(d1Str);
        }

        return ret;
    }

    protected final void swap(int i,int j) {
        curMetrics.swapCnt++;
        Object temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    protected void doSort(){
        for(int i = 0; i < getDataLength(); i++){
            for(int j = i + 1; j < getDataLength(); j++){
                if(compare(i,j)>0)
                    swap(i,j);
            }
        }
    }

    public static void main(String args[]){
        String[] arrayString = {"C","A","B","D"};
        Integer[] intArray = {11,4,7,1,4};
        SortHarness sortHarness = new SortHarness();
        sortHarness.sort(arrayString);
        for(String str : arrayString) {
            System.out.println(str);
        }
        sortHarness.sort(intArray);
        for(Integer integer : intArray) {
            System.out.println(integer);
        }

    }
}

final class SortMetrics implements Cloneable {
    public long probeCnt,
            compareCnt,
            swapCnt;
    public void init() {
        probeCnt = swapCnt = compareCnt = 0;
    }

    public String toString() {
        return probeCnt + " probes" + compareCnt + " compares " + swapCnt + " swaps";
    }

    public SortMetrics clone() {
        try {
            return (SortMetrics) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }
}