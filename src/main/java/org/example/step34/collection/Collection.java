package org.example.step34.collection;


import java.util.*;

import static java.util.Collections.sort;

/**
 * Написать метод, который принимает на вход список имён (с дубликатами) и возвращает множество уникальных имён.
 * Подсказка: Использовать HashSet.
 * Пример: ["Аня", "Петя", "Аня"] -> {"Аня", "Петя"}.
 * <p>
 * Задача "Фильтр повторений":
 * Дано множество слов. Реализовать функцию, которая принимает произвольный массив слов и удаляет из него все те, что
 * уже встречались ранее, возвращая результат в виде HashSet.
 * Пример: Вход: ["apple","banana","apple","orange"] -> Выход: {"apple","banana","orange"}.
 */
public class Collection {

    public Set<String> addElement(List<String> targetList) {

        return new LinkedHashSet<>(targetList);
    }

    /**
     * Задача "Кросс-множество":
     * Даны два массива целых чисел, нужно получить множество чисел, которые присутствуют в обоих массивах. Использовать HashSet для решения.
     * Пример: [1,2,3], [3,4,5] -> {3}.
     */
    public Set<Integer> retainElement(List<Integer> targetList1, List<Integer> targetList2) {
        Set<Integer> result = new LinkedHashSet<>(targetList1);
        result.retainAll(targetList2);

        return result;
    }

    /**
     * Задача "Сортировка уникальных слов":
     * Получив список слов, вернуть их в виде отсортированного множества (TreeSet).
     * Пример: ["delta","alpha","charlie","alpha"] -> {"alpha","charlie","delta"}.
     */

    public Set<String> addSortElement(List<String> targetList) {
        Set<String> result = new TreeSet<>(targetList);
        targetList.clear();
        targetList.addAll(result);

        return result;
    }

    /**
     * Дан набор уникальных оценок (целые числа). Нужно вставить их в TreeSet и вывести минимальную, максимальную оценку
     * и оценку, ближайшую по значению к заданной.
     * Пример: Оценки {5,3,8,10}, заданное число 7 -> min=3,max=10, ближ. к 7 - 8.
     *
     * @param targetList
     * @param target
     * @return
     */
    public Set<Integer> evaluationsSort(TreeSet<Integer> targetList, int target) {
        Set<Integer> result = new TreeSet<>();
        int min = targetList.first();
        int max = targetList.last();

        Integer low = targetList.floor(target);
        Integer high = targetList.ceiling(target);

        int closest = (low == null) ? high : (high == null) ? low :
                (Math.abs(target - low) <= Math.abs(target - high)) ? low : high;

        result.add(closest);
        result.add(min);
        result.add(max);

        return result;
    }

    /**
     * Даны два отсортированных множества (TreeSet). Нужно объединить их в одно, сохранив сортировку и уникальность.
     * Пример: {1,3,5}, {2,4,6} -> {1,2,3,4,5,6}.
     */

    public Set<Integer> mergSort(TreeSet<Integer> targetList1, TreeSet<Integer> targetList2) {
        Set<Integer> result = new TreeSet<>(targetList1);
        result.addAll(targetList2);

        return result;
    }

    /**
     * Дан список целых чисел, вернуть новый ArrayList содержащий только чётные числа в том же порядке.
     * Пример: [1,2,3,4,5] -> [2,4].
     */

    public List<Integer> evenNumbers(List<Integer> targetList) {
        List<Integer> result = new ArrayList<>();
        for (int i : targetList) {
            if (i % 2 == 0) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Дан список строк, вернуть новый список, где каждый элемент будет продублирован.
     * Пример: ["a","b","c"] -> ["a","a","b","b","c","c"].
     */

    public List<Integer> doubleNumbers(List<Integer> targetList) {
        List<Integer> result = new ArrayList<>();
        for (int i : targetList) {
            result.add(i);
            result.add(i);
        }

        return result;
    }

    /**
     * Даны два отсортированных списка, объединить их в один отсортированный ArrayList.
     * Пример: [1,3,5], [2,4,6] -> [1,2,3,4,5,6].
     *
     * @param targetList1
     * @param targetList2
     * @return
     */
    public List<Integer> sortList(List<Integer> targetList1, List<Integer> targetList2) {
        List<Integer> result = new ArrayList<>(targetList1);
        result.addAll(targetList2);
        sort(result);
        return result;
    }

    /**
     * Дано LinkedList строк, проверить, является ли он "палиндромом" (читается одинаково слева направо и справа налево).
     * Пример: ["a","b","a"] -> true.
     */

    public boolean palidrom(LinkedList<String> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public LinkedList<Integer> reverseList(LinkedList<Integer> targetList) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i : targetList) {
            result.addFirst(i);
        }
        return result;
    }

    /**
     * Дан LinkedList слов. Удалить из него каждый второй элемент.
     * Пример: ["alpha","beta","gamma","delta","epsilon"] -> ["alpha","gamma","epsilon"].
     *
     * @param list
     * @return
     */
    public LinkedList<String> everySecond(LinkedList<String> list) {
        Iterator<String> iterator = list.iterator();
        boolean remove = false;

        while (iterator.hasNext()) {
            iterator.next();
            if (remove) {
                iterator.remove();
            }
            remove = !remove;
        }

        return list;
    }


    /**
     * Дана ArrayDeque строк, развернуть очередь в обратном порядке.
     * Пример: [A,B,C] -> [C,B,A].
     *
     * @param list
     * @return
     */
    public Deque<String> reversAbc(Deque<String> list) {
        Deque<String> result = new ArrayDeque<>();
        for (String i : list) {
            result.addFirst(i);
        }
        return result;
    }

    /**
     * Имея ArrayDeque, нужно добавить элементы так, чтобы более важные добавлялись в начало, менее важные – в конец.
     * Написать метод, который по типу приоритета добавляет элемент спереди или сзади очереди.
     */

    public void priorityList(Deque<String> list, String element, boolean highPriority) {
        if (highPriority) {
            list.addFirst(element);
        } else {
            list.addLast(element);
        }
    }

    /**
     * Задача "Сортировка чисел через очередь":
     * Дан массив чисел, используя PriorityQueue, выдать их в отсортированном порядке путем последовательного извлечения.
     *
     * @param numbers
     * @return
     */

    public int[] sortUsingQueue(int[] numbers) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int number : numbers) {
            queue.add(number);
        }

        int[] sortedNumbers = new int[numbers.length];
        int index = 0;
        while (!queue.isEmpty()) {
            sortedNumbers[index++] = queue.poll();
        }

        return sortedNumbers;
    }

    /**
     * Задача "Топ-K наименьших элементов":
     * Дан массив чисел и число K. Используя PriorityQueue, найти K наименьших элементов.
     * Пример: Массив [5,1,9,2], K=2 -> [1,2].
     */

    public int[] findTopKSmallest(int[] numbers, int i) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : numbers) {
            maxHeap.add(num);
            if (maxHeap.size() > i) {
                maxHeap.poll();
            }
        }

        int[] result = new int[i];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            result[index++] = maxHeap.poll();
        }
        Arrays.sort(result);
        return result;
    }

    /**
     * !!!!!!!!!!!!!!!!НЕ ВЫПОЛНИЛ!!!!!!!!!!!!!!!!!!
     * Задача "Система заданий с приоритетом":
     * Создать класс Task с полем приоритета. Поместить несколько задач в PriorityQueue и извлечь их в порядке возрастания приоритета.
     */


}








