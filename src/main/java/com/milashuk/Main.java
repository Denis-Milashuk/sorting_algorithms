package com.milashuk;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        var randomGenerator = RandomGenerator.getDefault();
        Integer[] arr = randomGenerator.ints(0, 500).limit(150).boxed().toArray(Integer[]::new);
        Comparator<Integer> longComparator = (Integer v1, Integer v2) -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return v1.compareTo(v2);
        };
        var main = new Main();
        System.out.println(Arrays.toString(arr));

        main.runWithExecutionTime(() -> new BubbleSorter().sort(arr, longComparator), BubbleSorter.class.getName());
        System.out.println(Arrays.toString(arr));
    }

    public void runWithExecutionTime(Runnable runnable, String name) {
        var startTime = System.nanoTime();
        runnable.run();
        var endTime = System.nanoTime();
        System.out.format(STR."Execution time of \{name}: \{TimeUnit.NANOSECONDS.toMillis(endTime - startTime)} milliseconds");
        System.out.println();
    }
}