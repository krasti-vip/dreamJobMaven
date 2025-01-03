package dream.jobMaven;

import org.example.ArrayListAndLinkedList.CustomArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListTest {

    private CustomArrayList list;

    @BeforeEach
    void setUp() {
        list = new CustomArrayList();
    }

    @Test
    @DisplayName("Тест на добавление элемента в список")
    public void addTest() {
        list.add(10);
        assertEquals(1, list.getSize());
        assertEquals(10, list.get(0));
    }

    @Test
    @DisplayName("Тест на увеличение массива при добавлении элементов")
    public void addAndRessize() {
        for(int i =0; i < 15; i++) {
            list.add(i);
        }
        assertEquals(15, list.getSize());
        assertEquals(14, list.get(14));
    }

    @Test
    @DisplayName("Тест на получение элемента по индексу")
    public void getIndexTest() {
        list.add(10);
        list.add(12);
        list.add(18);

        assertEquals(10, list.get(0));
        assertEquals(12, list.get(1));
        assertEquals(18, list.get(2));
    }

    @Test
    @DisplayName("Тест на исключение при некорректном индексе в методе get()")
    public void exceptionTest() {
        list.add(5);
        assertThrows(IllegalArgumentException.class, () -> list.get(1),
                "Ожидается IllegalArgumentException при доступе к несуществующему индексу");
    }

    @Test
    @DisplayName("Тест на получение размера списка")
    public void getSizeTest() {
        list.add(5);
        list.add(10);
        list.add(15);

        assertEquals(3, list.getSize());
    }

    @Test
    @DisplayName("Тест на удаление элемента по индексу")
    public void removeIndexTest() {
        list.add(12);
        list.add(15);
        list.add(18);

        list.remove(1);

        assertEquals(2, list.getSize());
        assertEquals(12, list.get(0));
        assertEquals(18, list.get(1));
    }

    @Test
    @DisplayName("Тест на исключение при удалении с некорректным индексом")
    public void removeInvalidIndexTest() {
        list.add(5);

        assertThrows(IllegalArgumentException.class, () -> list.remove(2),
                "Ожидается IllegalArgumentException при удалении по несуществующему индексу");
    }

    @Test
    @DisplayName("Тест на обновление элемента по индексу")
    public void updateIndexTest() {
        list.add(1);
        list.add(5);
        list.add(10);

        list.update(2, 555);

        assertEquals(555, list.get(2));
    }

    @Test
    @DisplayName("Тест на исключение при обновлении с некорректным индексом")
    public void updateInvalidIndexTest() {
        list.add(88);

        assertThrows(IllegalArgumentException.class, () -> list.update(2, 20),
                "Ожидается IllegalArgumentException при обновлении по несуществующему индексу");
    }

    @Test
    @DisplayName("Тест на добавление всех элементов из массива")
    public void getAllTest() {
        int[] elements = {1,2,3,4,5};
        list.addAll(elements);

        assertEquals(5, list.getSize());
        assertEquals(2, list.get(1));
        assertEquals(5, list.get(4));
    }
}