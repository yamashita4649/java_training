package ch09.ex01;

public class Infinity {
    public static void main(String[] args) {
        Double pI = Double.POSITIVE_INFINITY;
        Double nI = Double.NEGATIVE_INFINITY;

        System.out.println("∞ + ∞  = " + (pI + pI));
        System.out.println("∞ + -∞ = " + (pI + nI));
        System.out.println("∞ - ∞  = " + (pI - pI));
        System.out.println("∞ - -∞ = " + (pI - nI));
        System.out.println("∞ * ∞  = " + (pI * pI));
        System.out.println("∞ * -∞ = " + (pI * nI));
        System.out.println("∞ / ∞  = " + (pI / pI));
        System.out.println("∞ / -∞ = " + (pI / nI));
    }
}
