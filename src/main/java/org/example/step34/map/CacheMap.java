package org.example.step34.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Использовать LinkedHashMap для реализации простого кеша, который хранит последние N добавленных элементов,
 * удаляя самые старые при добавлении новых.
 *
 * @param <K>
 * @param <V>
 */
public class CacheMap<K, V> {

    private final int capacity;
    private final Map<K, V> cache;

    public CacheMap(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > CacheMap.this.capacity;
            }
        };
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void displeyCache() {
        System.out.println(cache);
    }

    public int size() {
        return cache.size();
    }
}
