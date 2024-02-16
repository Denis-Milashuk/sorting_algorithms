package com.milashuk;

import java.util.Comparator;

// 2 times slower than BubbleSorter
public class BubbleAltSorter1 implements Sorter{
    @Override
    public <T> void sort(T[] arr, Comparator<T> comparator) {
        boolean isSorted = false;
        T temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if(comparator.compare(arr[i], arr[i + 1]) > 0){
                    isSorted = false;

                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
}
