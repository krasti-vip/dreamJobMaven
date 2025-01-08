package org.example.bankBalance.atomic;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class BankAccountAtomic {

    private AtomicLong balance = new AtomicLong(0);

    public long getBalance() {
        return balance.get();
    }

    public void deposit(long amount) {
        balance.addAndGet(amount);
    }

    public void withdraw(long amount) {
        if (amount > balance.get()) {
            System.out.println("Для вывода средств, пополните баланс");
        }
        balance.addAndGet(-amount);
    }

    public AtomicLong getAtomicBalance() {
        return balance;
    }
}
