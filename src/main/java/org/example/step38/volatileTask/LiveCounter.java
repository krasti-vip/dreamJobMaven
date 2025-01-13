package org.example.step38.volatileTask;


public class LiveCounter {

    private volatile static int counter = 0;

    public static synchronized void incrementCounter() {
        counter++;
    }

    public static synchronized void resetCounter() {
        counter = 0;
    }

    public static synchronized int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    incrementCounter();
                    System.out.println(getCounter());
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                int resetCount = 0;
                while (resetCount < 10) {
                    System.out.println(getCounter() + " текущий счетчик");
                    resetCount++;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                int count = 0;
                while (count < 10) {
                    resetCounter();
                    System.out.println(getCounter() + " сброс счетчика");
                    count++;
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
        thread1.start();
        thread2.start();

        thread.join();
        thread1.join();
        thread2.join();

        System.out.println("Итоговое значение: " + getCounter());
    }
}
