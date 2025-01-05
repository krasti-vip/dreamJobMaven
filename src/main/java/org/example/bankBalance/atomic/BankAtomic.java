package org.example.bankBalance.atomic;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Data
public class BankAtomic {

    private ConcurrentHashMap<Long, BankAccountAtomic> bd = new ConcurrentHashMap<>();

    private AtomicLong idGenerator = new AtomicLong(1);

    public Long createBankAccount() {
        long id = idGenerator.getAndIncrement();
        BankAccountAtomic bankAccount = new BankAccountAtomic();
        bd.put(id, bankAccount);
        return id;
    }

    public BankAccountAtomic getBankAccount(long id) {
        return bd.get(id);
    }

    public void transferMoney(long from, long to, long amount) {
        BankAccountAtomic fromAccount = getBankAccount(from);
        BankAccountAtomic toAccount = getBankAccount(to);

        boolean success = false;
        while (!success) {
            long currentBalance = fromAccount.getBalance();
            if (currentBalance >= amount) {
                success = fromAccount.getAtomicBalance().compareAndSet(currentBalance, currentBalance - amount);
            } else {
                System.out.println("Недостаточно средств для перевода");
                return;
            }
        }

        toAccount.deposit(amount);
        System.out.println("Перевод выполнен");
    }
}
