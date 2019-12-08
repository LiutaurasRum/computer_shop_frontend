package com.computer.shop.interfaces;

public interface TestInterface {
    int MINIMUM = 10;
    int MAXIMUM = 1000;

    default int getGenerateMinimum() {
        return MINIMUM;
    }

    default int getGenerateMaximum() {
        return MAXIMUM;
    }

    static boolean isFirstMinimumBigger(final int minimum, final int maximum) {
        return minimum > maximum;
    }
}
