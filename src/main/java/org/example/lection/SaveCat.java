package org.example.lection;

import lombok.Data;

import java.io.*;

@Data
public class SaveCat {

    /**
     * Генирация локаль дате для сохранения в новый файл, Date.get///
     */

    public static void main(String[] args) {

        Cat cat = new Cat("Вася", 16);

        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream
                             ("C:\\Users\\krast\\IdeaProjects\\dream-job\\src\\ru\\dream\\job\\save.txt"))) {
            objectOutputStream.writeObject(cat);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
