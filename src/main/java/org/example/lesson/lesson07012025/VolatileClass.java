package org.example.lesson.lesson07012025;

public class VolatileClass {

    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    System.out.println(1);
                }
            }
        });

        thread.start();
        Thread.sleep(3_000);

        Thread thread1 = new Thread(() -> flag = false);

        thread1.start();

        thread.join();
        thread1.join();
    }
}
