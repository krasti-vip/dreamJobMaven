package dream.jobMaven;

import org.example.baseJava.steep16.ternalOperatorTask.TernalOperator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TernalOperatorTest {

    @Test
    @DisplayName("Проверка возрата тернальным оператором четности числа")
    public void parityTest() {
        TernalOperator task1 = new TernalOperator();
        Assertions.assertEquals("Even", task1.parity(2));
        Assertions.assertEquals("Odd", task1.parity(7));
        Assertions.assertEquals("Even", task1.parity(0));
        Assertions.assertEquals("Odd", task1.parity(-9));
    }

    @Test
    @DisplayName("Проверка возрата большего числа")
    public void maxTest() {
        TernalOperator task2 = new TernalOperator();
        Assertions.assertEquals(8, task2.max(7, 8));
        Assertions.assertEquals(3, task2.max(3, 2));
        Assertions.assertEquals(0, task2.max(0, -1));
        Assertions.assertEquals(8, task2.max(8, 8));
    }

    @Test
    @DisplayName("Проверка совершенолетия")
    public void comingAgeTest() {
        TernalOperator task3 = new TernalOperator();
        Assertions.assertEquals("Access Granted", task3.comingAge(21));
        Assertions.assertEquals("Access Denied", task3.comingAge(17));
        Assertions.assertEquals("Access Granted", task3.comingAge(18));
    }

    @Test
    @DisplayName("Проверка преобозования оценок в строки")
    public void estimationTest() {
        TernalOperator task4 = new TernalOperator();
        Assertions.assertEquals("Poor", task4.estimation(1));
        Assertions.assertEquals("Fair", task4.estimation(2));
        Assertions.assertEquals("Good", task4.estimation(3));
        Assertions.assertEquals("Very Good", task4.estimation(4));
        Assertions.assertEquals("Excellent", task4.estimation(5));
        Assertions.assertEquals("Invalid grade", task4.estimation(0));
    }

    @Test
    @DisplayName("Проверка скидки в магазине")
    public void saleTest() {
        TernalOperator task5 = new TernalOperator();
        Assertions.assertEquals(110, task5.sale(100, true));
        Assertions.assertEquals(78, task5.sale(78, false));
    }


}
