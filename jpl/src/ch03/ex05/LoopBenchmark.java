package ch03.ex05;

abstract class Benchmark {
    abstract void benchmark();

    public final long repeat(int count) {
        long start = System.nanoTime();
        for (int i = 0; i < count; i++)
            benchmark();
        return (System.nanoTime() - start);
    }
}

public class LoopBenchmark extends Benchmark{

    private int mLoopCount;

    @Override
    void benchmark() {
        for (int i = 0; i < mLoopCount; i++);
    }

    LoopBenchmark(int loopCount) {
        mLoopCount = loopCount;
    }

    public static void main(String[] args) {
        int benchCount = Integer.parseInt(args[0]);
        int loopCount = Integer.parseInt(args[1]);
        long time = new LoopBenchmark(loopCount).repeat(benchCount);
        System.out.println("benchCount:"+ benchCount + "  loopCount:"  +loopCount +"   "  + time + "nanoseconds");
    }
}

//public class MethodBenchmark extends Benchmark{
//
//    @Override
//    void benchmark() {
//    }
//
//    public static void main(String[] args) {
//        int count = Integer.parseInt(args[0]);
//        long time = new MethodBenchmark().repeat(count);
//        System.out.println(count + "methods in " + time + "nanoseconds");
//    }
//}
