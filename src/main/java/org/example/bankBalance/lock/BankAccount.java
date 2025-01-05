package org.example.bankBalance.lock;

import java.util.concurrent.atomic.AtomicLong;

public class BankAccount {

    private AtomicLong balance = new AtomicLong(0);

    /**
     * Метод пополнения баланса потока безопасен благодаря атомарной операции через метод addAndGet()
     *
     * @param amount
     */
    public void deposit(Long amount) {
        if (amount != null && amount > 0) {
            balance.addAndGet(amount);
        } else {
            System.out.println("Сумма пополнения баланса не корректна!");
        }
    }

    /**
     * Метод уменьшения баланса потока безопасен благодаря атомарной операции через метод addAndGet()
     *
     * @param amount
     */
    public void withdraw(Long amount) {
        if (getBalance() < amount) {
            System.out.println("Не хватает денег на балансе");
        } else if (amount != null && amount > 0) {
            balance.addAndGet(-amount);
        } else {
            System.out.println("Введено не корректное значение снятия");
        }
    }

    public long getBalance() {
        return balance.get();
    }
}
