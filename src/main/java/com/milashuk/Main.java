package com.milashuk;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

import static java.lang.StringTemplate.STR;

public class Main {
    private final Comparator<Integer> longComparator = (Integer v1, Integer v2) -> {
        try {
            Thread.sleep(0, 500_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return v1.compareTo(v2);
    };

    public static void main(String[] args) {

        var main = new Main();
        main.runWithExecutionTime(main.getRandomIntArr(), new BubbleAltSorter1());
        main.runWithExecutionTime(main.getRandomIntArr(), new BubbleSorter());
        main.runWithExecutionTime(main.getRandomIntArr(), new SelectionSorter());
    }

    private void runWithExecutionTime(Integer[] arr, Sorter sorter) {
        System.out.println(Arrays.toString(arr));
        var startTime = System.nanoTime();
        sorter.sort(arr, this.longComparator);
        var endTime = System.nanoTime();
        System.out.format(STR."Execution time of \{sorter.getClass().getName()}: \{TimeUnit.NANOSECONDS.toMillis(endTime - startTime)} milliseconds");
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    private Integer[] getRandomIntArr() {
        var randomGenerator = RandomGenerator.getDefault();
        return randomGenerator.ints(0, 500).limit(200).boxed().toArray(Integer[]::new);
    }
}