package org.example.baseJava.steep16.forTask;

import java.util.ArrayList;
import java.util.List;

    /**
    * Напишите метод, который принимает два числа (начальное и конечное) и с помощью цикла for выводит все четные числа
    * в этом диапазоне.
    */
public class ForTask {

    public int[] getEvenNumbersInRange(int a, int b) {
        List<Integer> evens = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            if (i % 2 == 0) {
                evens.add(i);
            }
        }
        return evens.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Создайте метод, который принимает целое число N и с помощью цикла for вычисляет его факториал.
     * @param n
     * @return
     */
    public long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Напишите метод, который принимает массив целых чисел и с помощью цикла for находит и возвращает максимальное
     * значение в массиве.
     * @param numbers
     * @return
     */
    public int findMax(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    /**
     * Создайте метод, который принимает массив чисел и с помощью цикла for-each возвращает сумму всех элементов массива.
     * @param numbers
     * @return
     */
    public int sumArray(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    /**
     *Напишите метод, который принимает строку и символ, и с помощью цикла for подсчитывает, сколько раз символ
     * встречается в строке.
     * @param str
     * @param ch
     * @return
     */
    public int countCharacterOccurrences(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
