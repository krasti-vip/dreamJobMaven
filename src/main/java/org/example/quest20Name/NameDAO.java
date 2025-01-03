package org.example.quest20Name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameDAO implements DAO {

    List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva",
                "Frank", "Grace", "Hannah", "Ivan", "Jack",
                "Kara", "Leo", "Mona", "Nina", "Oliver",
                "Paul", "Quincy", "Rachel", "Charlie", "Atina"
    ));

    @Override
    public void save(String name) {
        for (String n : names) {
            if (n.equals(name)) {
                System.out.println("Имя уже существует!!!");

                return;
            }
        }

        names.add(name);
        System.out.println("Имя добавлено!");
    }

    @Override
    public List<String> searchFirstLetter(List<String> names, String letter) {
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith(letter)) {
                result.add(name);
            }
        }

        return result;
    }

    @Override
    public void update(String oldName, String newName) {
        boolean updated = false;

        for (int i = 0; i < names.size(); i++) {

            if(names.get(i).equals(oldName)) {
                names.set(i, newName);
                System.out.println("Имя обновлено");
                updated = true;
                break;
            }
        }
        if(!updated) {
            System.out.println("имя не обновлено");
        }
    }

    @Override
    public boolean deleteFirstLetter(List<String> names, String letter) {
        boolean isDeleted = false;
        for(int n = 0; n < names.size(); n++) {
            if(names.get(n).startsWith(letter)) {
                names.remove(n);
                n--;
                isDeleted = true;
            }
        }

        return isDeleted;
    }

    @Override
    public int searchLength(int quantity) {
        int count = 0;

        for (String name : names) {
            if (name.length() > quantity) {
                count++;
            }
        }
        System.out.println("Количество имен длиннее " + quantity + " символов: " + count);
        return count;
    }

    @Override
    public void savePosition(String name, int position) {
        if (position < 0 || position > names.size()) {
            System.out.println("Неверная позиция. Пожалуйста, укажите позицию от 0 до " + names.size());

            return;
        }

        int currentIndex = 0;
        while (currentIndex < position) {
            currentIndex++;
        }
        if (currentIndex == position) {
            if (position < names.size()) {
                names.set(position, name); // Вставка имени на указанную позицию, сдвигая элементы вправо
                System.out.println("Имя добавлено на позицию " + position);
            } else {
                System.out.println("Имя не добавлено в конец списка.");
            }
        }
    }

    @Override
    public List<String> searchLastLetter(List<String> names, String letter) {
        List<String> result = new ArrayList<>();
        if (letter == null || letter.isEmpty()) {

            return result;
        }
        int index = 0;

        while (index < names.size()) {
            String name = names.get(index);
            if (name.endsWith(letter)) {
                result.add(name);
            }
            index++;
        }

        return result;
    }

    @Override
    public boolean updateSubstring(String targetSubstring, String replacement) {
        if (targetSubstring == null || targetSubstring.isEmpty()) {
            System.out.println("Подстрока для замены не может быть пустой или null.");

            return false;
        }

        boolean updated = false;
        int currentIndex = 0;

        while (currentIndex < names.size()) {
            String name = names.get(currentIndex);
            if (name.contains(targetSubstring)) {
                String updatedName = name.replace(targetSubstring, replacement);
                names.set(currentIndex, updatedName);
                updated = true;
            }
            currentIndex++;
        }

        return updated;
    }

    @Override
    public boolean deleteDefinite(String nameToDelete) {
        if (nameToDelete == null) {
            System.out.println("Имя для удаления не может быть null.");
            return false;
        }
        boolean deleted = false;
        int index = 0;

        while (index < names.size()) {
            if (names.get(index).equals(nameToDelete)) {
                names.remove(index);
                deleted = true;
            } else {
                index++;
            }
        }

        return deleted;
    }

    @Override
    public int searchSubstring(String substring) {
        if (substring == null || substring.isEmpty()) {
            throw new IllegalArgumentException("Подстрока не может быть пустой или null.");
        }

        int count = 0;
        int index = 0;
        String lowerCaseSubstring = substring.toLowerCase();

        while (index < names.size()) {
            String lowerCaseName = names.get(index).toLowerCase();
            if (lowerCaseName.contains(lowerCaseSubstring)) {
                count++;
            }
            index++;
        }

        return count;
    }

    public List<String> getNames() {
        return new ArrayList<>(names);
    }
}
