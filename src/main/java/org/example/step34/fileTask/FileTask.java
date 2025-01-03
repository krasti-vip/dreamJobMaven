package org.example.step34.fileTask;

import java.io.File;

public class FileTask {

    public static void resultFileTask(String fileName) {
        File directory = new File(fileName);
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("Файл " + file.getName());
                System.out.println("Размер в байтах " + file.length());
            } else if (file.isDirectory()) {
                System.out.println("Директория " + file.getName());
                System.out.println("Размер в байтах " + file.length());
            }
        }
    }

    public static void creatureDirectory(String fileName) {
        File directory = new File(fileName);

        if (!directory.exists()) {
            boolean result = directory.mkdir();
            if (result) {
                System.out.println("Директория создана " + fileName);
            } else {
                System.out.println("Не удалось создать директорию " + fileName);
            }
        } else {
            System.out.println("Директорию уже существует");
        }
    }

    public static void deleteDirectory(String fileName) {
        File directory = new File(fileName);
        if (directory.exists()) {
            System.out.println("Директория существует, готовлюсь к удалению ");
            directory.delete();
            System.out.println("Директория удалена " + fileName);
        } else {
            System.out.println("Директория не существует");
        }
    }
}
