package org.example.quest20Name;

import java.util.List;

public interface DAO {

    void save(String name);
    List<String> searchFirstLetter (List<String> names, String letter);
    void update(String oldName, String newName);
    boolean deleteFirstLetter(List<String> names, String letter);
    int searchLength (int quantity);
    void savePosition(String name, int position);
    List<String> searchLastLetter(List<String> names, String letter);
    boolean updateSubstring(String targetSubstring, String replacement);
    boolean deleteDefinite(String nameToDelete);
    int searchSubstring(String substring);
}
