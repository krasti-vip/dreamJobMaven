package org.example.step38.synchronizedTask;

public class SafePiggyMain {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    SafePiggyBank.deposit(100);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    SafePiggyBank.withdraw(100);
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 201; i++) {
                SafePiggyBank.deposit(100);
            }
        });

        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                SafePiggyBank.withdraw(100);
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

        System.out.println("Итоговый баланс + 100 тугриков: " + SafePiggyBank.getCoins());
    }
}
