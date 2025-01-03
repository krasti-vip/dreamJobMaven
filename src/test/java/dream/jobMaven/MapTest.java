package dream.jobMaven;

import org.example.step34.map.CacheMap;
import org.example.step34.map.MapTask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MapTest {

    @Test
    @DisplayName("Тест счетчика слов")
    public void countWordTest() {
        MapTask map = new MapTask();

        String text = "Java, о прекрасная, прекрасная и неповторимая jaVa";
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("java", 2);
        expected.put("прекрасная", 2);
        expected.put("неповторимая", 1);
        expected.put("и", 1);
        expected.put("о", 1);

        HashMap<String, Integer> actual = map.countWord(text);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест пустой строки")
    public void countWordTest2() {
        MapTask map = new MapTask();
        String text2 = "  ";
        HashMap<String, Integer> expected = new HashMap<>();

        HashMap<String, Integer> actual = map.countWord(text2);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест замены идентификаторов на новые")
    public void replaceIdsTest() {
        MapTask map = new MapTask();
        HashMap<String, String> idMap = new HashMap<>();
        idMap.put("old1", "new1");
        idMap.put("old2", "new2");

        List<String> oldIds = Arrays.asList("old1", "old2", "old1", "unknown");
        List<String> expected = Arrays.asList("new1", "new2", "new1", "unknown");

        List<String> actual = map.replaceId(oldIds, idMap);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест преобразования списка продуктов")
    public void countProductsTest() {
        MapTask map = new MapTask();
        List<String> productList = Arrays.asList(
                "Яблоки -> 10",
                "Апельсины -> 5",
                "Яблоки -> 15",
                "Бананы -> 7",
                "Апельсины -> 3"
        );

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Яблоки", 25);
        expected.put("Апельсины", 8);
        expected.put("Бананы", 7);
        HashMap<String, Integer> actual = map.countProducts(productList);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест алфавитного порядка номеров телефона")
    public void abcNumberTest() {
        MapTask map = new MapTask();
        HashMap<String, Integer> current = new HashMap<>();
        current.put("Богданов", 555123);
        current.put("Японский", 555124);
        current.put("Абрикосов", 555125);
        System.out.println(current);
        Map<String, Integer> expected = new TreeMap<>();
        expected.put("Богданов", 555123);
        expected.put("Японский", 555124);
        expected.put("Абрикосов", 555125);
        System.out.println(expected);
        assertEquals(expected, map.AbcNumberTelefon(current));
    }

    @Test
    @DisplayName("Тест поиска минимального среднего и максимального студента")
    public void minMaxStudentTest() {
        MapTask map = new MapTask();
        TreeMap<String, Integer> current = new TreeMap<>();
        current.put("Васильченчо", 8);
        current.put("Дмитриенко", 7);
        current.put("Японских", 10);
        current.put("Полянский", 6);
        current.put("Бойко", 2);
        current.put("Шмонькин", 5);

        Map<String, String> actual = new TreeMap<>();
        actual.put("Бойко", "minStudent");
        actual.put("Дмитриенко", "Ближайший");
        actual.put("Японских", "maxStudent");

        String necessary = "Николаев";

        assertEquals(actual, map.minMaxStudent(current, necessary) );
    }

    @Test
    @DisplayName("Тест если минимальное и ближайшее равно")
    public void minMaxStudentTest2() {
        MapTask map = new MapTask();
        TreeMap<String, Integer> current = new TreeMap<>();
        current.put("Васильченчо", 8);
        current.put("Дмитриенко", 7);
        current.put("Японских", 10);
        current.put("Полянский", 6);
        current.put("Бойко", 2);
        current.put("Шмонькин", 5);

        Map<String, String> actual = new TreeMap<>();
        actual.put("Бойко", "Ближайший");
        actual.put("Японских", "maxStudent");

        String necessary = "Аплонов";

        assertEquals(actual, map.minMaxStudent(current, necessary) );
    }

    @Test
    @DisplayName("Тест если максимальное и ближайшее равно")
    public void minMaxStudentTest3() {
        MapTask map = new MapTask();
        TreeMap<String, Integer> current = new TreeMap<>();
        current.put("Васильченчо", 8);
        current.put("Дмитриенко", 7);
        current.put("Японских", 10);
        current.put("Полянский", 6);
        current.put("Бойко", 2);
        current.put("Шмонькин", 5);

        Map<String, String> actual = new TreeMap<>();
        actual.put("Бойко", "minStudent");
        actual.put("Японских", "Ближайший");

        String necessary = "Яяшкин";

        assertEquals(actual, map.minMaxStudent(current, necessary) );
    }

    @Test
    @DisplayName("Тест поиска ближайшего ордера заказа")
    public void orderTest() {
        MapTask map = new MapTask();
        TreeMap<Integer, String> current = new TreeMap<>();
        current.put(1, "Построить дом");
        current.put(99, "Залить бетон в фундамент");
        current.put(982, "Срубить дерево");
        current.put(12, "Вывезти холодильник");
        current.put(112, "Ограбить соседей");

        TreeMap<Integer, String> current2 = new TreeMap<>();
        int search = 150;
        int search2 = 1000;
        int search3 = 050;


        assertEquals(112, map.nearest(current, search));
        assertEquals(982, map.nearest(current, search2));
        assertEquals(12, map.nearest(current, search3));
        assertEquals(000, map.nearest(current2, search));
    }

    @Test
    @DisplayName("Тест кэша")
    public void cacheTest() {
        CacheMap<Integer, String> cacheMap = new CacheMap<>(5);
        cacheMap.put(1, "A");
        cacheMap.put(2, "B");
        cacheMap.put(3, "C");
        cacheMap.put(4, "D");
        cacheMap.put(5, "E");

        assertEquals(5, cacheMap.size(), "Кеш должен содержать 5 элементов");

        cacheMap.put(6, "F");

        assertEquals(5, cacheMap.size(), "Кеш не должен превышать 5 элементов");
        assertNull(cacheMap.get(1), "Первый элемент (1, A) должен быть удален из кеша");
        assertEquals("F", cacheMap.get(6), "Новый элемент (6, F) должен быть в кеше");
    }

    @Test
    @DisplayName("Тест обновления карты")
    public void updatedMapTest() {
        MapTask map = new MapTask();
        LinkedHashMap<String, Integer> lm = new LinkedHashMap<>();
        lm.put("Дима", 178);
        lm.put("Вася", 168);
        lm.put("Рома", 175);

        map.updatedMap(lm, "Вася", 170);
        LinkedHashMap<String, Integer> lm2 = new LinkedHashMap<>();
        lm2.put("Дима", 178);
        lm2.put("Вася", 170);
        lm2.put("Рома", 175);
        assertEquals(lm2, lm);

        map.updatedMap(lm, "Жора", 186);
        lm2.put("Жора", 186);
        assertEquals(lm2, lm);
        map.updatedMap(lm, "", 5);
    }


}
