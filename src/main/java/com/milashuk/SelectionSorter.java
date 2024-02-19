package com.milashuk;

import java.util.Comparator;

public class SelectionSorter implements Sorter{
    @Override
    public <T> void sort(T[] arr, Comparator<T> comparator) {
        if ( arr == null || arr.length == 0) return;
        T temp;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i; j >= 0 ; j--) {
                if (j == 0 || comparator.compare(arr[j - 1], temp) < 0) {
                    arr[j] = temp;
                    break;
                }
                arr[j] = arr[j - 1];
            }
        }
    }
}
