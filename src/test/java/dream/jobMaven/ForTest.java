package dream.jobMaven;

import org.example.baseJava.steep16.forTask.ForTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ForTest {

    @Test
    @DisplayName("Тест вывода четных чисел")
    public void getEvenNumbersInRangeTest() {
        ForTask task1 = new ForTask();
        int[] expected = {2, 4, 6, 8, 10};
        Assertions.assertArrayEquals(expected, task1.getEvenNumbersInRange(1, 10));
        int[] expected2 = {6, 8, 10, 12, 14};
        Assertions.assertArrayEquals(expected2, task1.getEvenNumbersInRange(5, 15));
        int[] expected3 = {-4, -2, 0, 2, 4};
        Assertions.assertArrayEquals(expected3, task1.getEvenNumbersInRange(-5, 5));
    }

    @Test
    @DisplayName("Тест факториала")
    public void factorialTest() {
        ForTask task2 = new ForTask();
        Assertions.assertEquals(1, task2.factorial(0));
        Assertions.assertEquals(120, task2.factorial(5));
        Assertions.assertEquals(3628800, task2.factorial(10));
    }

    @Test
    @DisplayName("Тест максимального числа")
    public void findMaxTest() {
        ForTask task3 = new ForTask();
        int[] numbers = {1, 3, 7, 0, 5};
        Assertions.assertEquals(7, task3.findMax(numbers));
        int[] numbers2 = {-1, -3, -7, -2, -5};
        Assertions.assertEquals(-1, task3.findMax(numbers2));
    }

    @Test
    @DisplayName("Тест суммы всех элементов в массиеве")
    public void sumArrayTest() {
        ForTask task4 = new ForTask();
        int[] numbers = {1, 2, 3, 4, 5};
        Assertions.assertEquals(15, task4.sumArray(numbers));
        int[] numbers2 = {-1, -2, -3, -4, -5};
        Assertions.assertEquals(-15, task4.sumArray(numbers2));
        int[] numbers3 = {};
        Assertions.assertEquals(0, task4.sumArray(numbers3));
    }

    @Test
    @DisplayName("Тест подсчета сколько элемент встречается в массиве")
    public void countCharacterOccurrencesTest() {
        ForTask task5 = new ForTask();
        Assertions.assertEquals(3, task5.countCharacterOccurrences("banana", 'a'));
        Assertions.assertEquals(0, task5.countCharacterOccurrences("", 'a'));
    }
}
