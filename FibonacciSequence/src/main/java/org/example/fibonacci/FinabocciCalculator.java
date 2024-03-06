package org.example.fibonacci;

public class FinabocciCalculator {
    private int number = 1; //первое и второе число
    public Long getValue(Integer index) {
        long[] x = new long[index];
        x[0] = number;
        x[1] = number;
        long value = 0;
        for (int i = 2; i < x.length; i++) {
            x[i] = x[i-2] + x[i-1];
        }
        for (int i = 0; i < x.length; i++) {
            value += x[i];
        }
        return value;
    }
}
