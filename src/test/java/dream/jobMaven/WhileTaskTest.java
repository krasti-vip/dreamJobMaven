package dream.jobMaven;

import org.example.baseJava.steep16.whileTask.WhileTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WhileTaskTest {

    @Test
    @DisplayName("Проверка суммы чисел цикла")
    public void sumTest() {
        WhileTask task1 = new WhileTask();
        Assertions.assertEquals(6, task1.sumNumber(3));
        Assertions.assertEquals(0, task1.sumNumber(0));
        Assertions.assertEquals(1, task1.sumNumber(1));
        Assertions.assertEquals(0, task1.sumNumber(-5));
    }

    @Test
    @DisplayName("Проверки простых чисел")
    public void primeTest() {
        WhileTask task2 = new WhileTask();
        Assertions.assertEquals(true,task2.primeNumber(2));
        Assertions.assertEquals(true,task2.primeNumber(17));
        Assertions.assertEquals(false,task2.primeNumber(8));
        Assertions.assertEquals(false,task2.primeNumber(0));
        Assertions.assertEquals(false,task2.primeNumber(1));
        Assertions.assertEquals(false,task2.primeNumber(-3));
    }

    @Test
    @DisplayName("Проверка чисел Фибоначи")
    public void fibonachiTest() {
        WhileTask task4 = new WhileTask();
        int[] expected = {0, 1, 1, 2, 3};
        Assertions.assertArrayEquals(expected, task4.fibonacci(5));
        int[] expected2 = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        Assertions.assertArrayEquals(expected2, task4.fibonacci(10));
        int[] expected3 = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181};
        Assertions.assertArrayEquals(expected3, task4.fibonacci(20));
    }

    @Test
    @DisplayName("Проверка чисел в обратном порядке")
    public void reverseNumberTest() {
        WhileTask task5 = new WhileTask();
        Assertions.assertEquals("12345", task5.reverseNumber(54321));
        Assertions.assertEquals("-12345", task5.reverseNumber(-54321));
        Assertions.assertEquals("1", task5.reverseNumber(1));
        Assertions.assertEquals("-1", task5.reverseNumber(-1));
        Assertions.assertEquals("0", task5.reverseNumber(0));

    }
}
