package org.example.step38.synchronizedTask;

import lombok.Data;

@Data
public class SafePiggyBank {

    private static int coins = 150;

    public static synchronized void deposit(int value) {
        SafePiggyBank.coins += value;
        SafePiggyBank.class.notifyAll();
    }

    public static synchronized void withdraw(int value) {
        while (SafePiggyBank.coins < value) {
            System.out.println("Не достаточно денег на балансе");
            try {
                SafePiggyBank.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        SafePiggyBank.coins -= value;
    }

    public static int getCoins() {
        return coins;
    }
}
