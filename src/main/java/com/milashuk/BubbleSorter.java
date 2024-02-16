package com.milashuk;

import java.util.Comparator;

public class BubbleSorter implements Sorter {
    @Override
    public <T> void sort(T[] arr, Comparator<T> comparator) {
        int count = 0;
        boolean isSorted = false;
        T temp;
        while (!isSorted || count < arr.length - 1) {
            isSorted = true;
            for (int i = 1; i < arr.length - count; i++) {
                if (comparator.compare(arr[i - 1], arr[i]) > 0) {
                    isSorted = false;
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
            count ++;
        }
    }
}
