package org.example.step34.filesTask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.example.step34.filesTask.FilesTask.readFile;


public class FilesMain {

    public static void main(String[] args) throws IOException {

        String fileString = "C:\\Users\\krast\\IdeaProjects\\dream-job\\src\\ru\\dream\\job\\SQL\\reportGitAndHtmlCSS.md";

        List<String> lines = readFile(fileString);
        for (String line : lines) {
            System.out.println(line);
        }
        String source = "C:\\Users\\krast\\IdeaProjects\\dream-job\\src\\ru\\dream\\job\\SQL\\reportGitAndHtmlCSS.md";
        String destination = "C:\\Users\\krast\\IdeaProjects\\dream-job\\src\\ru\\dream\\job\\SQL\\new.md";
        FilesTask.copyFile(source, destination);
        FilesTask.lineFile(destination);

        String filePath = "src\\ru\\dream\\job\\SQL\\new.md";
        Path path = Paths.get(filePath);
        System.out.println("Абсолютный путь - " + path.toAbsolutePath());
        System.out.println("Родительский путь - " + path.getParent());

        String newFilePath = "C:\\Users\\krast\\IdeaProjects\\dream-job\\src\\ru\\dream\\job\\SQL\\new\\files\\task";
        Path newPath = Paths.get(newFilePath);
        try {
            Files.createDirectories(newPath);
            System.out.println("Директория создана - " + newPath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка создания" + e.getMessage());
        }

        String source2 = "C:\\Users\\krast\\IdeaProjects\\dream-job\\src\\ru\\dream\\job\\SQL\\new.md";
        String destination2 = "C:\\Users\\krast\\IdeaProjects\\dream-job\\src\\ru\\dream\\job\\SQL\\new\\files\\task\\new.md";
        File file = new File(source2);

        try {
            Files.move(Paths.get(source2), Paths.get(destination2), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл " + file.getName() + " перемещен");
        } catch (IOException e) {
            System.out.println("Ошибка перемещения " + e.getMessage());
        }
    }
}
