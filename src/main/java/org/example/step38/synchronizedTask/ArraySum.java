package org.example.step38.synchronizedTask;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Задача 2: «Параллельное суммирование массива»
 * Создайте класс ArraySum с массивом чисел и полем int totalSum.
 * Реализуйте метод addPartialSum(int partialSum), который прибавляет partialSum к totalSum и объявлен как synchronized.
 * Разбейте большой массив на несколько частей и запустите столько же потоков, каждому потоку дайте свою часть массива для суммирования.
 * В конце выведите итоговый результат totalSum и сравните его с результатом, полученным обычным последовательным суммированием.
 * FIX
 * /**
 * * Мерзкая задача!!!
 * * Переписать логику задачи с распаралеливонием массива и поиском суммы, убрав дублирующие логику создания тредов(где у нас много ифов)
 * * И задача сделать так что бы логику работала корректно для любого массива, а не только с 80 элементами
 */

public class ArraySum {

    private static final long[] array = new long[100_000_000];

    private static long totalSum = 0;

    public static synchronized void addPartialSum(long partialSum) {
        totalSum += partialSum;
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int division = 12;

        int size = array.length / division;
        int remains = array.length % division;

        List<Thread> threads = new ArrayList<>();

        int start = 0;

        for (int i = 0; i < division; i++) {
            int end = start + size + (remains > 0 ? 1 : 0);
            remains = Math.max(0, remains - 1);

            long[] subArray = Arrays.copyOfRange(array, start, end);
            start = end;

            Thread thread = new Thread(() -> {
                long sum = Arrays.stream(subArray).sum();
                addPartialSum(sum);
            });

            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(totalSum);

        long sequence = Arrays.stream(array).sum();

        System.out.println(sequence);
    }
}
