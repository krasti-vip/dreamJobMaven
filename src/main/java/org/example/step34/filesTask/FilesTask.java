package org.example.step34.filesTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


public class FilesTask {

    public static List<String> readFile(String strings) throws IOException {
        Path path = Paths.get(strings);
        return Files.readAllLines(path);
    }

    public static void copyFile(String source, String destination) {

        try {
            Files.copy(Paths.get(source), Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Копирование " + source + "\nпроизведено в " + destination);
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }

    public static void lineFile(String strings) throws IOException {
        Path path = Paths.get(strings);
        System.out.println("Количество строк в файле " + path.getFileName() + " - " + Files.lines(path).count());
    }
}
