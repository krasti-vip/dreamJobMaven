package org.example.step34.fileTask;

import java.io.File;

public class FileMain {
    /**
     * Отсутствуют проверки на пустую директорию и если ее не существует ты упадешь во мрак, шагай осторожно, мой юный падаван
     * Да и я понимаю, что майн выглядит как помойка и лучше переписать на тесты))) но я это так чтобы посмореть что работает
     * и как именно работает
     * @param args
     */
    public static void main(String[] args) {

        FileTask fileTask = new FileTask();

        String fileAndDirectory = "C:\\Users\\krast\\IdeaProjects\\dream-job\\src\\ru\\dream\\job\\SQL";

        fileTask.resultFileTask(fileAndDirectory);

        System.out.println();

        directoryTask();
        deleteTask();

    }

    public static void directoryTask() {
        FileTask fileTask = new FileTask();
        String newDirectory = "C:\\Users\\krast\\IdeaProjects\\dream-job\\src\\ru\\dream\\job\\SQL\\member";
        fileTask.creatureDirectory(newDirectory);
    }

    public static void deleteTask() {
        FileTask fileTask = new FileTask();
        String newDirectory = "C:\\Users\\krast\\IdeaProjects\\dream-job\\src\\ru\\dream\\job\\SQL\\member";
        fileTask.deleteDirectory(newDirectory);
    }
}
