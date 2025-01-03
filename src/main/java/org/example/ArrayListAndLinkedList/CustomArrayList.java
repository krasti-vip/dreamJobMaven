package org.example.ArrayListAndLinkedList;

/**
 * Коллекция на основе ArrayList хранит числа в массиеве, капасити 10, размер по умолчанию 0, содержит методы: add(int elem),
 * addAll(int[] elements), get(int index), getSize(), remove(int index), update(int index, int elem)
 */
public class CustomArrayList implements CustomList {


    private static final int DEFAULT_CAPACITY = 10;

    private int capacity; // 10

    private int size = 0;

    private int[] elements;

    /**
     * Конструктор создает пустой список с начальной ёмкостью 10
     */
    public CustomArrayList() {
        capacity = DEFAULT_CAPACITY;
        elements = new int[DEFAULT_CAPACITY]; // 10
    }

    /**
     * Конструктор позволяет пользователю задать начальную емкость списка при создании объекта. Если ожидается,
     * что список будет содержать много элементов, можно сразу задать большое значение capacity,
     * чтобы избежать расширений массива
     * @param capacity
     */
    public CustomArrayList(int capacity) { // 1_000_000
        this.capacity = capacity;
        elements = new int[capacity];
    }

    /**
     * Метод добавляет новый элемент в конец списка: 1. увеличение размера: Сначала увеличивается счетчик размера size.
     * Это нужно, чтобы показать, что список увеличивается на один элемент.
     * Проверка емкости: Если после увеличения size равно capacity (то есть список заполнен), то емкость массива
     * удваивается (массив увеличивается вдвое). Создается новый массив с удвоенной емкостью, и все элементы из старого
     * массива копируются в новый с помощью метода System.arraycopy().
     * Добавление элемента: После проверки и возможного увеличения емкости новый элемент elem добавляется в массив на
     * позицию size - 1.
     * @param elem
     */
    @Override
    public void add(int elem) {
        if (++size == capacity) {
            capacity *= 2;

            int[] newElements = new int[capacity];

            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }

        elements[size - 1] = elem;
    }

    /**
     * Метод добавляет все элементы из массива elements в текущий список, используя метод add().
     * Он перебирает переданный массив и добавляет каждый его элемент в список.
     * @param elements
     */

    public void addAll(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }
    }

    /**
     * Метод позволяет получить элемент по индексу: Проверка индекса: сначала проверяется, находится ли индекс в пределах текущего
     * размера списка (index < size). Если индекс выходит за границы, выбрасывается исключение IllegalArgumentException.
     * Возврат элемента: Если индекс корректен, метод возвращает элемент по этому индексу.
     * @param index
     * @return
     */

    @Override
    public int get(int index) {
        // [1] [] [] [] [] [] [] [] [] []
        if (index < size) {
            return elements[index];
        } else {
            throw new IllegalArgumentException("Такого индекса не существует: " + index);
        }
    }

    /**
     * Метод просто возвращает количество элементов в списке, которое хранится в переменной size.
     * @return
     */

    @Override
    public int getSize() {
        return size;
    }

    /**
     * Метод позволяет удалить элемент по индексу: проверка индекса: как и в методе get(), проверяется, является ли индекс допустимым.
     * Сдвиг элементов: все элементы, следующие за удаленным, сдвигаются влево. Это происходит в цикле, начиная с
     * удаляемого индекса и заканчивая предпоследним элементом.
     * Обнуление последнего элемента: Последний элемент массива (который был продублирован после сдвига) обнуляется.
     * Уменьшение размера: Размер списка уменьшается на 1, чтобы отразить удаление элемента.
     * @param index
     */

    @Override
    public void remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Индекса " + index + " не существует");
        }
        for (int i = index; i < size-1; i++) {
            elements[i] = elements [i + 1];
        }
        elements[size-1] = 0;
        size--;
    }

    /**
     * Метод производит обновление элемента по индексу: проверка индекса: проверяется, что индекс находится в пределах списка.
     * Если индекс выходит за пределы списка, выбрасывается исключение.
     * Замена элемента: Если индекс корректен, элемент в массиве заменяется на новое значение elem.
     * @param index
     * @param elem
     */

    @Override
    public void update(int index, int elem) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Индекса " + index + " не существует");
        }
        elements[index] = elem;
    }
}
