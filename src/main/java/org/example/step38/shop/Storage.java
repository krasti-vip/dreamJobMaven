package org.example.step38.shop;

/**
 * Задача 1.
 * Условие:
 * Необходимо реализовать модель работы небольшого магазина с использованием многопоточности и механизмов wait(), notify(), notifyAll().
 *
 * В магазине есть склад с ограниченным количеством товара (например, 5 единиц).
 *
 *     Производитель (поставщик) добавляет товар на склад, если там есть свободное место.
 *     Покупатели забирают товар со склада. Если товара нет, покупатель ждёт, пока появится новый товар.
 *     Если склад заполнен, производитель должен ждать, пока покупатели не заберут товар.
 *
 * Требования:
 *
 *     Реализовать класс Store, который содержит:
 *         Максимальный размер склада.
 *         Методы put() (добавить товар) и get() (забрать товар).
 *     Использовать wait() и notify() для корректной синхронизации потоков.
 *     Создать несколько потоков-покупателей и один поток-производитель.
 */
public class Storage {

    private final String[] array = new String[5];

    public synchronized boolean put(String product) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = product;
                return true;
            }
            notifyAll();
        }
        return false;
    }

    public synchronized boolean get() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[i] = null;
                notifyAll();
                return true;
            }
        }
        notifyAll();
        return false;
    }

    public int arrayLength() {
        return array.length;
    }
}
