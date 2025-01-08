package org.example.bankBalance.lock;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Bank {

    private ConcurrentHashMap<Long, BankAccount> bd = new ConcurrentHashMap<>();

    private ConcurrentHashMap<Long, Lock> lockMap = new ConcurrentHashMap<>();

    private AtomicLong idGenerator = new AtomicLong(1);

    public Long createBankAccount() {
        long id = idGenerator.getAndIncrement();
        BankAccount bankAccount = new BankAccount();
        bd.put(id, bankAccount);
        lockMap.put(id, new ReentrantLock());
        return id;
    }

    public void transferMoneyCheck(long from, long to, long amount) {

        if (amount > 0) {
            BankAccount fromAccount = bd.get(from);
            BankAccount toAccount = bd.get(to);

            if (fromAccount != null && toAccount != null) {
                Lock firstLock = lockMap.get(from);
                Lock secondLock = lockMap.get(to);

                if (from < to) {
                    firstLock.lock();
                    secondLock.lock();
                } else {
                    secondLock.lock();
                    firstLock.lock();
                }
                transferMoney(from, to, amount);

                firstLock.unlock();
                secondLock.unlock();

            } else {
                System.out.println("Один из аккаунтов не существует");
            }
        } else {
            System.out.println("Сумма перевода должна быть положительной");
        }
    }

    public void transferMoney(long from, long to, long amount) {
        BankAccount fromAccount = bd.get(from);
        BankAccount toAccount = bd.get(to);

        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);

            System.out.println("Перевод " + amount + " рублей, выполнен успешно");

        } else {
            System.out.println("Баланса не хватает для перевода");
        }
    }

    public BankAccount getBankAccount(long id) {
        return bd.get(id);
    }
}
