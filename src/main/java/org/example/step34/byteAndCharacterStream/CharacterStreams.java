package org.example.step34.byteAndCharacterStream;

import java.io.*;

public class CharacterStreams {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\krast\\IdeaProjects\\dreamJobMaven\\src\\main\\java\\org\\example\\SQL\\reportGitAndHtmlCSS.md";
        String newCoderFiles = "C:\\Users\\krast\\IdeaProjects\\dreamJobMaven\\src\\main\\java\\org\\example\\SQL\\newCoderReportGitAndHtmlCSS.md";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        writesText(filePath);
        safeNewCoder(filePath, newCoderFiles);
    }

    public static void writesText(String filePath) {

        String[] lines = {
                "\nЁба боба!",
                "пишем текс",
                "много строк",
        };

        try (FileWriter writer = new FileWriter(filePath, true)) {
            for (String line : lines) {
                writer.write(line + System.lineSeparator());
            }
            System.out.println("Данные успешно добавлены в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public static void safeNewCoder(String filePath, String newCoderFileName) {

        String inputEncoding = "UTF-8";
        String outputEncoding = "UTF-16";

        try (
                InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), inputEncoding);
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(newCoderFileName), outputEncoding)
        ) {
            char[] buffer = new char[1024];
            int charsRead;

            while ((charsRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, charsRead);
            }

            System.out.println("Файл успешно конвертирован из " + inputEncoding + " в " + outputEncoding);
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}

