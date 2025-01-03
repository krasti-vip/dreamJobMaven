package dream.jobMaven;

import org.example.step34.collection.BrouserNavigator;
import org.example.step34.collection.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionTest {

    @Test
    @DisplayName("Тест имен")
    public void nameTest() {
       org.example.step34.collection.Collection collection = new org.example.step34.collection.Collection();
        List<String> names = new ArrayList<>(Arrays.asList("Дима", "Дима", "Вася", "Ира", "Вася"));
        Set<String> actualSet = collection.addElement(names);

        assertEquals(3, actualSet.size());
        List<String> filtrNames = new ArrayList<>(Arrays.asList("Дима", "Вася", "Ира"));
        assertEquals(new ArrayList<>(filtrNames), new ArrayList<>(actualSet));
    }

    @Test
    @DisplayName("Тест фруктов")
    public void fruitTest2 () {
        org.example.step34.collection.Collection collection = new org.example.step34.collection.Collection();
        List<String> fruit = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange", "banana", "kiwi"));
        Set<String> actualSet2 = collection.addElement(fruit);

        assertEquals(4, actualSet2.size());
        List<String> filtrFruict = new ArrayList<>(Arrays.asList("apple","banana","orange", "kiwi"));
        assertEquals(new ArrayList<>(filtrFruict), new ArrayList<>(actualSet2));
    }

    @Test
    @DisplayName("Тест цифр")
    public void numbersTest() {
       Collection collection = new Collection();
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1,20,4,5,12,6,7,8,10));
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(20,3,4,5,6, 15,8,9,10));
        Set<Integer> resultFruict = collection.retainElement(numbers1, numbers2);

        List<Integer> actualNambers = new ArrayList<>(Arrays.asList(20, 4, 5, 6, 8, 10));
        assertEquals(actualNambers, new ArrayList<>(resultFruict));
    }

    @Test
    @DisplayName("Тест добавления с сортировкой")
    public void addSortElementTest() {
        Collection collection = new Collection();
        List<String> elements = new ArrayList<>(Arrays.asList("delta","alpha","charlie","alpha"));
        Set<String> resultSort = collection.addSortElement(elements);
        List<String> actualSort = new ArrayList<>(Arrays.asList("alpha", "charlie", "delta"));

        assertEquals(actualSort, new ArrayList<>(resultSort));
    }

    @Test
    @DisplayName("Тест Ранги оценок")
    public void evaluationsSortTest() {
        Collection collection = new Collection();
        TreeSet<Integer> numbers = new TreeSet<>(Arrays.asList(5,3,8,10));
        int target = 7;
        Set<Integer> resultSort = collection.evaluationsSort(numbers, target);
        List<Integer> actualSort = new ArrayList<>(Arrays.asList(3,8,10));
        assertEquals(actualSort, new ArrayList<>(resultSort));
    }

    @Test
    @DisplayName("Тест слияния отсортированных списков")
    public void mergSortTest() {
        Collection collection = new Collection();
        TreeSet<Integer> numbers1 = new TreeSet<>(Arrays.asList(1, 3, 5));
        TreeSet<Integer> numbers2 = new TreeSet<>(Arrays.asList(2, 4, 6));
        TreeSet<Integer> numbersActual = new TreeSet<>(Arrays.asList(1,2,3,4,5,6));
        assertEquals(numbersActual, collection.mergSort(numbers1, numbers2));
    }

    @Test
    @DisplayName("Тест сортировки четных чисел и дублирования списка")
    public void evenNumbersTest() {
        Collection collection = new Collection();
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> resulSort = new ArrayList<>(Arrays.asList(2,4,6,8));
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(1,2,5,9));
        List<Integer> resultDouble = new ArrayList<>(Arrays.asList(1,1,2,2,5,5,9,9));
        assertEquals(resulSort, collection.evenNumbers(numbers1));
        assertEquals(resultDouble, collection.doubleNumbers(numbers2));
    }

    @Test
    @DisplayName("Тест объединенния двух списков с сортировкой")
    public void sortListTest() {
        Collection collection = new Collection();
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1,3,5));
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(2,4,6));
        List<Integer> numbersActual = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        assertEquals(numbersActual, collection.sortList(numbers1, numbers2));
    }

    @Test
    @DisplayName("Тест палидрома")
    public void palidromTest() {
        Collection collection = new Collection();
        LinkedList<String> list1 = new LinkedList<>(Arrays.asList("apple", "banana", "orange", "banana", "apple"));
        LinkedList<String> list2 = new LinkedList<>(Arrays.asList("apple", "kiwi", "orange", "banana", "apple"));

        assertTrue(collection.palidrom(list1));
        assertFalse(collection.palidrom(list2));
    }

    @Test
    @DisplayName("Тест реверса")
    public void reverseTest() {
        Collection collection = new Collection();
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        LinkedList<Integer> resultRevers = new LinkedList<>(Arrays.asList(9,8,7,6,5,4,3,2,1));
        assertEquals(resultRevers, collection.reverseList(list));
    }

    @Test
    @DisplayName("Тест удаления каждого второго элемента")
    public void everySecondTest() {
        Collection collection = new Collection();
        LinkedList<String> list = new LinkedList<>(Arrays.asList("alpha","beta","gamma","delta","epsilon"));
        LinkedList<String> actualList = new LinkedList<>(Arrays.asList("alpha","gamma","epsilon"));

        assertEquals(actualList, collection.everySecond(list));
    }

    @Test
    @DisplayName("Тест deque обратный порядок")
    public void abcTest() {
        Collection collection = new Collection();
        Deque<String> list = new ArrayDeque<>(Arrays.asList("A","B","C","D","F"));
        Deque<String> actualList = new ArrayDeque<>(Arrays.asList("F", "D", "C", "B", "A"));

        assertEquals(new ArrayList<>(actualList), new ArrayList<>(collection.reversAbc(list)));
    }

    @Test
    @DisplayName("Тест навигатора")
    public void brouserNavigatorTest() {
        BrouserNavigator navigator = new BrouserNavigator();
        navigator.visit("google.com");
        navigator.visit("stackoverflow.com");
        navigator.visit("github.com");

        assertEquals("github.com", navigator.getCurrentPage());

        navigator.back();

        assertEquals("stackoverflow.com", navigator.getCurrentPage());
    }

    @Test
    @DisplayName("Тест приоритета добавления")
    public void priorityListTest() {
        Collection collection = new Collection();
        Deque<String> result = new ArrayDeque<>();

        collection.priorityList(result, "one-", false);
        collection.priorityList(result, "two+", true);
        collection.priorityList(result, "three+", true);
        collection.priorityList(result, "four-", false);
        collection.priorityList(result, "five-", false);
        collection.priorityList(result, "six+", true);

        Deque<String> actualList = new ArrayDeque<>();
        actualList.add("six+");
        actualList.add("three+");
        actualList.add("two+");
        actualList.add("one-");
        actualList.add("four-");
        actualList.add("five-");

        assertEquals(new ArrayList<>(actualList), new ArrayList<>(result));
    }

    @Test
    @DisplayName("Тест сортировки чисел через PriorityQueue")
    public void sortUsingQueueTest() {
        Collection collection = new Collection();
        int[] numbers = {5, 2, 9, 1, 6};
        int[] expected = {1, 2, 5, 6, 9};

        int[] result = collection.sortUsingQueue(numbers);

        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Тест для нахождения K наименьших элементов")
    public void testFindTopKSmallest() {
        Collection collection = new Collection();
        int[] numbers = {5, 1, 9, 2};
        int k = 2;
        int[] expected = {1, 2};
        int[] result = collection.findTopKSmallest(numbers, k);

        assertArrayEquals(expected, result);
    }




}
