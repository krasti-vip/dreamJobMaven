package dream.jobMaven;

import org.example.quest20Name.NameDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class NameDAOTest {

    private NameDAO nameDAO;

    @BeforeEach
    public void setUp() {
        nameDAO = new NameDAO();
    }

    @Test
    @DisplayName("Проверка добавления, а так же уже ")
    public void addTest() {
        String newName = "Zara";
        nameDAO.save(newName);
        List<String> names = nameDAO.getNames();
        Assertions.assertTrue(names.contains(newName), "имя не добавлено");
    }

    @Test
    @DisplayName("Проверка существования имени и увелечение массива при этом")
    public void increaseListTest() {
        String newName = "Alice";
        nameDAO.save(newName);
        List<String> names = nameDAO.getNames();
        Assertions.assertEquals(20, names.size(), "Размер списка должен оставаться прежним!");
    }

    @Test
    @DisplayName("Поиск по первой букве")
    public void searchFirstLetterTest() {
        List<String> names = nameDAO.searchFirstLetter(nameDAO.getNames(), "A");
        List<String> expectedNames = Arrays.asList("Alice", "Atina");
        Assertions.assertEquals(expectedNames, names, "Что то не нашли");
    }

    @Test
    @DisplayName("Проверка поиска не существующей первой буквы")
    public void searchLetterTest() {
        List<String> names = nameDAO.searchFirstLetter(nameDAO.getNames(), "Z");
        List<String> expectedNames = Arrays.asList();
        Assertions.assertEquals(expectedNames, names, "Тут не должно быть имен");
    }

    @Test
    @DisplayName("Проверка изменения существующего имени")
    public void updateNameTest() {
        nameDAO.update("Alice", "Ali");
        List<String> names = nameDAO.getNames();
        Assertions.assertTrue(names.contains("Ali"), "Имя не обновлено на новое!");
        Assertions.assertFalse(names.contains("Alice"), "Старое имя не должно оставаться в списке!");
        nameDAO.update("Jon", "Joni");
        Assertions.assertFalse(names.contains("Joni"), "Несуществующее имя не должно было быть обновлено!");
    }

    @Test
    @DisplayName("Проверка удаления имени по первой букве")
    public void deleteFirstLetterTest() {
        List<String> names = nameDAO.getNames();

        boolean result = nameDAO.deleteFirstLetter(names, "A");
        Assertions.assertTrue(result, "Должно быть удалено хотя бы одно имя, начинающееся на 'A'!");
        Assertions.assertFalse(names.contains("Alice"), "Имя 'Alice' должно быть удалено!");

        result = nameDAO.deleteFirstLetter(names, "Z");
        Assertions.assertFalse(result, "Не должно быть имен, начинающихся на 'Z'!");
    }

    @Test
    @DisplayName("Проверка подсчета имен длиннее определенного значения")
    public void searchLengthTest() {
        int count = nameDAO.searchLength(4);
        Assertions.assertEquals(11, count, "Должно быть 13 имен длиной больше 4 символов!");

        count = nameDAO.searchLength(3);
        Assertions.assertEquals(17, count, "Должно быть 16 имен длиной больше 3 символов!");

        count = nameDAO.searchLength(10);
        Assertions.assertEquals(0, count, "Не должно быть имен длиной больше 10 символов!");
    }

    @Test
    @DisplayName("Проверка добавления имени на определенную позицию")
    public void savePositionTest() {
        List<String> names = nameDAO.getNames();

        String newName = "Charlie";
        int position = 2;
        nameDAO.savePosition(newName, position);
        Assertions.assertEquals(newName, names.get(position), "Имя должно быть добавлено на позицию " + position);

        String anotherName = "Tom";
        int endPosition = names.size();
        nameDAO.savePosition(anotherName, endPosition);
        Assertions.assertNotEquals(anotherName, names.get(names.size() - 1), "Имя должно быть добавлено в конец списка");

        String invalidName = "Invalid";
        int invalidPosition = -1;
        nameDAO.savePosition(invalidName, invalidPosition);
        Assertions.assertFalse(names.contains(invalidName), "Имя не должно быть добавлено на недопустимую позицию");

        int outOfBoundsPosition = names.size() + 5;
        nameDAO.savePosition(invalidName, outOfBoundsPosition);
        Assertions.assertFalse(names.contains(invalidName), "Имя не должно быть добавлено на недопустимую позицию");
    }

    @Test
    @DisplayName("Проверка поиска имен по последней букве")
    public void searchLastLetterTest() {
        List<String> names = nameDAO.getNames();

        List<String> result = nameDAO.searchLastLetter(names, "a");
        List<String> expected = Arrays.asList("Eva", "Kara", "Mona", "Nina", "Atina");
        Assertions.assertEquals(expected, result, "Список имен, оканчивающихся на 'a', неверный!");

        result = nameDAO.searchLastLetter(names, "e");
        expected = Arrays.asList("Alice", "Charlie", "Grace", "Charlie");
        Assertions.assertEquals(expected, result, "Список имен, оканчивающихся на 'e', неверный!");

        result = nameDAO.searchLastLetter(names, "z");
        Assertions.assertTrue(result.isEmpty(), "Список должен быть пустым, так как ни одно имя не заканчивается на 'z'!");

        result = nameDAO.searchLastLetter(names, "");
        Assertions.assertTrue(result.isEmpty(), "Список должен быть пустым, так как ни одно имя не заканчивается на пустую строку!");

        result = nameDAO.searchLastLetter(names, null);
        Assertions.assertTrue(result.isEmpty(), "Список должен быть пустым, так как передана null строка!");
    }

    @Test
    @DisplayName("Проверка обновления всех имен, содержащих определенную подстроку")
    public void updateSubstringTest() {
        String targetSubstring = "A";
        String replacement = "o";

        boolean updated = nameDAO.updateSubstring(targetSubstring, replacement);

        Assertions.assertTrue(updated, "Метод должен обновить хотя бы одно имя");

        for (String name : nameDAO.getNames()) {
            Assertions.assertFalse(name.contains(targetSubstring), "Имена не должны содержать подстроку " + targetSubstring);
        }
    }

    @Test
    @DisplayName("Проверка удаления всех имен, которые равны определенной строке")
    public  void deleteDefiniteTest() {
        boolean result = nameDAO.deleteDefinite("Charlie");
        Assertions.assertTrue(result, "Имя 'Charlie' должно быть удалено.");

        List<String> namesAfterDeletion = nameDAO.getNames();
        for (String name : namesAfterDeletion) {
            Assertions.assertNotEquals("Charlie", name, "Имя 'Charlie' не должно присутствовать в списке.");
        }

        Assertions.assertTrue(namesAfterDeletion.contains("Bob"), "Имя 'Bob' должно оставаться в списке.");

        result = nameDAO.deleteDefinite("NonExistentName");
        Assertions.assertFalse(result, "Имя 'NonExistentName' не должно существовать в списке, и удаление должно вернуть false.");
    }

    @Test
    @DisplayName("Проверка подсчета количества имен, содержащих определенную подстроку")
    public void searchSubstringTest() {
        int count = nameDAO.searchSubstring("Charlie");
        Assertions.assertEquals(2, count, "Количество имен, содержащих 'Charlie', должно быть 2.");

        count = nameDAO.searchSubstring("a");
        Assertions.assertEquals(16, count, "Количество имен, содержащих подстроку 'a', должно быть 16.");

        count = nameDAO.searchSubstring("z");
        Assertions.assertEquals(0, count, "Количество имен, содержащих подстроку 'z', должно быть 0.");
    }
}