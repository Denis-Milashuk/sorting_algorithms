package com.milashuk;

import java.util.Comparator;

public class BubbleSorter implements Sorter {
    @Override
    public <T> void sort(T[] arr, Comparator<T> comparator) {
        int count = 0;
        while (count < arr.length - 1) {
            for (int i = 1; i < arr.length - count; i++) {
                if (comparator.compare(arr[i - 1], arr[i]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
            count ++;
        }
    }
}
