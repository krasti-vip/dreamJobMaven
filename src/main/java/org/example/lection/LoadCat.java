package org.example.lection;

import java.io.*;

public class LoadCat {

    public static void main(String[] args) {
/**
 * Генирация локальной дате для сохранения в новый файл, Date.get///
 */
        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream
                             ("C:\\Users\\krast\\IdeaProjects\\dream-job\\src\\ru\\dream\\job\\save.txt"))) {

            Cat cat = (Cat) objectInputStream.readObject();

            System.out.println(cat);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
