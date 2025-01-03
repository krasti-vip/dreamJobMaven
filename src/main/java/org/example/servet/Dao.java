package org.example.servet;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    void save(T human);
    Optional<T> findByName(String name);
    List<T> findAll();
    boolean update(T name);
    boolean delete(String name);
}
