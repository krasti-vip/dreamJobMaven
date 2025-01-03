package org.example.servet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HumanDao implements Dao<Human> {

    private final List<Human> bd = new ArrayList<>();

    @Override
    public void save(Human human) {
        bd.add(human);
    }

    @Override
    public Optional<Human> findByName(String name) {
        return bd.stream()
                .filter(human -> human.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Human> findAll() {
        return new ArrayList<>(bd);
    }

    @Override
    public boolean update(Human human) {
        Optional<Human> existingHuman = findByName(human.getName());
        if (existingHuman.isPresent()) {
            bd.remove(existingHuman.get());
            bd.add(human);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String name) {
        return bd.removeIf(human -> human.getName().equals(name));
    }
}
