package org.example.step38.synchronizedTask;

import java.util.HashMap;
import java.util.Map;

public class UserRegistry {

    private final Map<String, String> user = new HashMap<>();

    public synchronized void addUser(String login, String password) {
        if (user.containsKey(login)) {
            System.out.println("Пользователь " + login + " уже существует");
        }
        user.put(login, password);
    }

    public synchronized String getUser(String login) {
        if (!user.containsKey(login)) {
            System.out.println("Пользователя не существует " + login);
        }
        return user.get(login);
    }

    public synchronized Map<String, String> getAllUsers() {
        return new HashMap<>(user);
    }

    public static void main(String[] args) throws InterruptedException {

        UserRegistry registry = new UserRegistry();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    registry.addUser("Dima", "1");
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    registry.addUser("Pasha", "2");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    registry.addUser("Pasha", "3");
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    registry.addUser("Sasha", "4");
                }
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(registry.getUser("Dima") + " Dima");
                }
            }
        });

        Thread thread5 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(registry.getUser("Pasha") + " Pasha");
                }
            }
        });

        Thread thread6 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(registry.getUser("Sasha") + " Sasha");
                }
            }
        });

        Thread thread7 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(registry.getUser("Ara") + " Ara");
                }
            }
        });

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread5.start();
        thread6.start();
        thread4.start();
        thread7.start();

        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();
        thread5.join();
        thread6.join();
        thread4.join();
        thread7.join();

        System.out.println(registry.getAllUsers());
    }
}
