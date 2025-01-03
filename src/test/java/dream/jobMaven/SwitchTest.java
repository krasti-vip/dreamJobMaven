package dream.jobMaven;

import org.example.baseJava.steep16.switchTask.SwitchTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SwitchTest {

    @Test
    @DisplayName("Проверка передачи от 1го до 7го дня недели, а так же значения 0 и 8")
    public void dayTest() {
        SwitchTask task1 = new SwitchTask();
        Assertions.assertEquals("Monday", task1.getDay(1));
        Assertions.assertEquals("Tuesday", task1.getDay(2));
        Assertions.assertEquals("Wednesday", task1.getDay(3));
        Assertions.assertEquals("Thursday", task1.getDay(4));
        Assertions.assertEquals("Friday", task1.getDay(5));
        Assertions.assertEquals("Saturday", task1.getDay(6));
        Assertions.assertEquals("Sunday", task1.getDay(7));
        Assertions.assertEquals("Invalid day", task1.getDay(0));
        Assertions.assertEquals("Invalid day", task1.getDay(8));
    }

    @Test
    @DisplayName("Проверка соответствия месяца сезону, а так же неверного месяца")
    public void monthTest() {
        SwitchTask task2 = new SwitchTask();
        Assertions.assertEquals("Winter", task2.getSeason("December"));
        Assertions.assertEquals("Winter", task2.getSeason("january"));
        Assertions.assertEquals("Winter", task2.getSeason("february"));
        Assertions.assertEquals("Spring", task2.getSeason("march"));
        Assertions.assertEquals("Spring", task2.getSeason("april"));
        Assertions.assertEquals("Spring", task2.getSeason("may"));
        Assertions.assertEquals("Summer", task2.getSeason("june"));
        Assertions.assertEquals("Summer", task2.getSeason("july"));
        Assertions.assertEquals("Summer", task2.getSeason("august"));
        Assertions.assertEquals("Autumn", task2.getSeason("september"));
        Assertions.assertEquals("Autumn", task2.getSeason("october"));
        Assertions.assertEquals("Autumn", task2.getSeason("november"));
        Assertions.assertEquals("Invalid month", task2.getSeason("null"));
    }

    @Test
    @DisplayName("Проверка работы калькулятора, а так же проверка деления на ноль или не правильного оператора")
    public void calculatorTest() {
        SwitchTask task3 = new SwitchTask();
        Assertions.assertEquals(10, task3.result(5,5,'+'));
        Assertions.assertEquals(10, task3.result(15,5,'-'));
        Assertions.assertEquals(10, task3.result(2,5,'*'));
        Assertions.assertEquals(10, task3.result(20,2,'/'));
        Assertions.assertTrue(Double.isNaN(task3.result(5.0, 0.0, '/')));
        Assertions.assertThrows(IllegalArgumentException.class, () -> task3.result(5.0,
                3.0, '%'));
    }

    @Test
    @DisplayName("Проверка работы систкмы оценок")
    public void estimationTest() {
        SwitchTask task4 = new SwitchTask();
        Assertions.assertEquals("Poor", task4.getEstimation(1));
        Assertions.assertEquals("Fair", task4.getEstimation(2));
        Assertions.assertEquals("Good", task4.getEstimation(3));
        Assertions.assertEquals("Very Good", task4.getEstimation(4));
        Assertions.assertEquals("Excellent", task4.getEstimation(5));
        Assertions.assertEquals("Invalid Estimation", task4.getEstimation(9));
    }

    @Test
    @DisplayName("Проверка передачи данных по фигуре")
    public void aigureTest() {
        SwitchTask task5 = new SwitchTask();
        Assertions.assertEquals("Треуголник", task5.getАigure(3));
        Assertions.assertEquals("Квадрат", task5.getАigure(4));
        Assertions.assertEquals("Пятиугольник", task5.getАigure(5));
        Assertions.assertEquals("Шестиуголник", task5.getАigure(6));
        Assertions.assertEquals("Invalid sides", task5.getАigure(0));
    }


}
