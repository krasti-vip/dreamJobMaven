package org.example.step34.map;

import java.util.*;

public class MapTask {

    /**
     * Дана строка текста, посчитать сколько раз каждое слово встречается, результат вернуть в HashMap.
     * @param text
     * @return
     */
    public HashMap<String, Integer> countWord(String text) {
        if(text == null || text.isEmpty()) {
            return new HashMap<>();
        }

        HashMap<String, Integer> wordCounts = new HashMap<>();
        String[] words = text.toLowerCase().split("\\s+");

        for(String word : words) {
            word = word.replaceAll("[^a-zA-Zа-яА-ЯёЁ]", "");
            if(!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
        return wordCounts;
    }

    /**
     * Дана карта (HashMap) старых идентификаторов на новые. Дана коллекция старых идентификаторов, заменить их на новые, используя карту.
     * Пример: map={old1->new1, old2->new2}, список [old1,old2,old1] -> [new1,new2,new1].
     * @param oldId
     * @param idMap
     * @return
     */
    public List<String> replaceId(List<String> oldId, HashMap<String, String> idMap) {
        if (oldId == null || idMap == null) {
            throw new IllegalArgumentException("Значение null");
        }

        List<String> newId = new ArrayList<>();
        for (String id : oldId) {

            newId.add(idMap.getOrDefault(id, id));
        }

        return newId;
    }

    /**
     * Дано: список "Продукт -> количество". Записать в HashMap и вывести суммарное количество каждого продукта.
     * @param productList
     * @return
     */
    public HashMap<String, Integer> countProducts(List<String> productList) {
        HashMap<String, Integer> productCounts = new HashMap<>();

        for (String entry : productList) {

            String[] parts = entry.split("->");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Некорректный формат строки: " + entry);
            }

            String product = parts[0].trim();
            int count = Integer.parseInt(parts[1].trim());

            productCounts.put(product, productCounts.getOrDefault(product, 0) + count);
        }

        return productCounts;
    }

    /**
     * Хранить номера телефонов по ключу - имя человека, в TreeMap. Вывести все пары в алфавитном порядке ключей.
     * @param mapa
     * @return
     */
    public Map<String, Integer> AbcNumberTelefon(HashMap<String, Integer> mapa) {
        Map<String, Integer> numberTelefon = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            numberTelefon.put(entry.getKey(), entry.getValue());
        }

        return numberTelefon;
    }

    /**
     * В TreeMap хранить оценки студентов по их фамилиям в отсортированном порядке. Найти минимального и максимального
     * по фамилии студента, а также студента с фамилией ближайшей к заданной.
     * Подсказка: Использовать методы floorKey, ceilingKey.
     */

    public Map<String, String> minMaxStudent(TreeMap<String, Integer> map, String student) {
        Map<String, String> stud = new TreeMap<>();

        String floorKey = map.floorKey(student);
        String ceilKey = map.ceilingKey(student);
        String minKey = map.firstKey();
        String maxKey = map.lastKey();
        stud.put(minKey, "minStudent");
        stud.put(maxKey, "maxStudent");

        if (floorKey != null) {
            stud.put(floorKey, "Ближайший");
        } else {
            stud.put(ceilKey, "Ближайший");
        }

        return stud;
        }

    /**
     * Заполнить TreeMap парой (числовой ключ -> значение). Вывести в порядке ключей и найти ключ ближайший к данному числу.
     */

    public Integer nearest(TreeMap<Integer, String> map, Integer order) {

        if(map == null || map.isEmpty()) {
            return 000;
        }

        Integer floorKey = map.floorKey(order);
        Integer ceilKey = map.ceilingKey(order);

        if (floorKey != null) {
            return floorKey;
        } else {
            return ceilKey;
        }
    }

    /**
     * Наполнить LinkedHashMap парами (номер события -> описание). Вывести их в порядке добавления.
     */


    /**
     * Дан LinkedHashMap ключей (строки) и значений (числа). Обновить значения для определённых ключей, вывести
     * финальный порядок и значения.
     */

    public LinkedHashMap<String, Integer> updatedMap(LinkedHashMap<String, Integer> linkedMapa, String key, Integer value) {
        LinkedHashMap<String, Integer> map = linkedMapa;
        if (map.containsKey(key)) {
            map.put(key, value);
            System.out.println("Значение обновленно");
            System.out.println(map);
        } else {
            map.put(key, value);
            System.out.println("Значение не найдено, новая запись добавлена");
            System.out.println(map);
        }
        map.put(key, value);
        return map;
    }
}
