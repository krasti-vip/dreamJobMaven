package org.example.step38.shop;


import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * Задача 1.
 * Условие:
 * Необходимо реализовать модель работы небольшого магазина с использованием многопоточности и механизмов wait(), notify(), notifyAll().
 * <p>
 * В магазине есть склад с ограниченным количеством товара (например, 5 единиц).
 * <p>
 * Производитель (поставщик) добавляет товар на склад, если там есть свободное место.
 * Покупатели забирают товар со склада. Если товара нет, покупатель ждёт, пока появится новый товар.
 * Если склад заполнен, производитель должен ждать, пока покупатели не заберут товар.
 * <p>
 * Требования:
 * <p>
 * Реализовать класс Store, который содержит:
 * Максимальный размер склада.
 * Методы put() (добавить товар) и get() (забрать товар).
 * Использовать wait() и notify() для корректной синхронизации потоков.
 * Создать несколько потоков-покупателей и один поток-производитель.
 */
@Data
public class Storage {

    private final List<String> array = Arrays.asList(new String[500]);

    public synchronized boolean put(String product) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == null) {
                array.set(i, product);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean getProduct() {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != null) {
                array.set(i, null);
                return true;
            }
        }
        return false;
    }

    public synchronized int arraySize() {
        return array.size();
    }

    public int getRemainingProducts() {
        int count = 0;
        for (String item : array) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }
}
