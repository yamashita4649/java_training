package ch04.ex02;

public interface Sort {
    public SortMetrics sort(Object[] data);

    public SortMetrics getMetrics();
}
