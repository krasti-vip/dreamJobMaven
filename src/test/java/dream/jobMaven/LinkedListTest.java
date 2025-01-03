package dream.jobMaven;


import org.example.ArrayListAndLinkedList.CustomLinkedList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LinkedListTest {

    private CustomLinkedList list;

    @BeforeEach
    public void setUp() {
        list = new CustomLinkedList();
    }

    @Test
    @DisplayName("Проверка добавления и размера списка")
    public void addTest() {
        list.add(10);
        assertEquals(10, list.get(0));
        assertEquals(1, list.getSize());
    }

    @Test
    @DisplayName("Проверяет добавление нескольких элементов в непустой список")
    public void addThreeTest() {
        list.add(5);
        list.add(15);
        list.add(25);
        assertEquals(5, list.get(0));
        assertEquals(15, list.get(1));
        assertEquals(25, list.get(2));
        assertEquals(3, list.getSize());

    }

    @Test
    @DisplayName("Проверка получение значения по индексу")
    public void getIndexTest() {
        list.add(3);
        list.add(7);
        list.add(5);
        assertEquals(7, list.get(1));
    }

    @Test
    @DisplayName("Проверка выбрасывание исключения при попытке получить элемент по недопустимому индексу")
    public void exceptionTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertThrows(IllegalArgumentException.class, () -> list.get(4));
    }

    @Test
    @DisplayName("Проверка удаления значения по индексу")
    public void removeIndexTest() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(1); // Удаляем элемент по индексу 1 (элемент 20)
        assertEquals(2, list.getSize());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1)); // Теперь элемент 30 стоит на индексе 1
    }

    @Test
    @DisplayName("Удаление первого элемента")
    public void removeFirstElemTest() {
        list.add(100);
        list.add(200);
        list.remove(0); // Удаляем первый элемент (100)
        assertEquals(1, list.getSize());
        assertEquals(200, list.get(0));
    }

    @Test
    @DisplayName("Удаление вне диапазона")
    public void removeNotIndexTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(5); // Индекс за пределами диапазона
        assertEquals(3, list.getSize()); // Размер списка не изменился
    }

    @Test
    @DisplayName("Обновление элемента")
    public void updateTest() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.update(1, 99); // Обновляем элемент по индексу 1 на значение 99
        assertEquals(99, list.get(1));
    }

    @Test
    @DisplayName("Обновление вне диапазона")
    public void updateNotIndexTest() {
        list.add(1);
        list.add(2);
        list.update(5, 99); // Индекс за пределами диапазона
        assertEquals(2, list.getSize()); // Размер списка не изменился
        assertEquals(2, list.get(1)); // Элемент не был обновлен
    }

    @Test
    @DisplayName("Передача размера")
    public void getSizeTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.getSize());
    }

    @Test
    @DisplayName("Передача пустого листа")
    public void getSizeNullTest() {
        assertEquals(0, list.getSize());
    }
}