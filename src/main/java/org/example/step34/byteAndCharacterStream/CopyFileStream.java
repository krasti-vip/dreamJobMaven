package org.example.step34.byteAndCharacterStream;

import java.io.*;

public class CopyFileStream {

    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\krast\\IdeaProjects\\dreamJobMaven\\src\\main\\java\\org\\example\\SQL\\foto\\IMG_E8789.JPG";
        String destinationFile = "C:\\Users\\krast\\IdeaProjects\\dreamJobMaven\\src\\main\\java\\org\\example\\SQL\\new\\files\\task\\Copy_IMG_E8789.JPG";
        String destinationFileBuf = "C:\\Users\\krast\\IdeaProjects\\dreamJobMaven\\src\\main\\java\\org\\example\\SQL\\new\\files\\task\\Copy_Buf_IMG_E8789.JPG";

        try {
            long startTime = System.currentTimeMillis();
            copyFile(sourceFile, destinationFile);
            long endTime = System.currentTimeMillis();

            long startTime2 = System.currentTimeMillis();
            copyFilesBuffer(sourceFile, destinationFileBuf);
            long endTime2 = System.currentTimeMillis();

            long timeNoBuffer = endTime - startTime;
            long timeBuffer = endTime2 - startTime2;

            System.out.println("Время копирования без буферов: " + timeNoBuffer);
            System.out.println("Время копирования с буферами: " + timeBuffer);
            System.out.println("Разница: " + ((timeNoBuffer - timeBuffer) / 1000 + " секунды"));

        } catch (IOException e) {
            System.err.println("Ошибка при копировании файла: " + e.getMessage());
        }
        sizeFile(destinationFile);

    }

    public static void copyFile(String sourceFile, String destinationFile) throws IOException {

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("Файл успешно скопирован.");
        }
    }

    public static void copyFilesBuffer(String sourceFile, String destinationFileBuf) throws IOException {

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFileBuf))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void sizeFile(String fileName) {

        try (FileInputStream fis = new FileInputStream(fileName)) {
            int byteCount = 0;
            while (fis.read() != -1) {
                byteCount++;
            }
            System.out.println("Размер файла: " + byteCount + " байт(а)");

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}

