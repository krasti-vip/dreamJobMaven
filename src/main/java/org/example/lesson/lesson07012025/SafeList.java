package org.example.lesson.lesson07012025;

import java.util.ArrayList;
import java.util.List;

public class SafeList {

    private static final List<String> list = new ArrayList<>();

    public static synchronized void add(String value) {
        list.add(value);
    }

    /**
     * не безопасно - нет проверки на null и тд, смотри метод
     * @param index
     */
    public static synchronized void get(int index) {
        for (int i = index; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Dima());
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 400; i++) {
                SafeList.add("Дима");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 400; i++) {
                    SafeList.add("Дима");
                }
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    System.out.println(list.size());
                }
        });

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}
