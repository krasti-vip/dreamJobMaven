package org.example.step38.volatileTask;

import java.util.Random;

public class ModeSwitcher {

    private volatile int mode = 0;

    public synchronized int setMode() {
        Random random = new Random();
        int newMode = random.nextInt(4);
        mode = newMode;
        return newMode;
    }

    public static void main(String[] args) throws InterruptedException {
        ModeSwitcher modeSwitcher = new ModeSwitcher();

        Thread writerThread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    int newMode = modeSwitcher.setMode();
                    System.out.println("Mode изменен на: " + newMode);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread writerThread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    int newMode = modeSwitcher.setMode();
                    System.out.println("Mode изменен на: " + newMode);
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread readerThread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Текущий mode: " + modeSwitcher.mode);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread readerThread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Текущий mode: " + modeSwitcher.mode);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        writerThread1.start();
        readerThread1.start();
        writerThread2.start();
        readerThread2.start();

        writerThread1.join();
        readerThread1.join();
        writerThread2.join();
        readerThread2.join();
    }
}
