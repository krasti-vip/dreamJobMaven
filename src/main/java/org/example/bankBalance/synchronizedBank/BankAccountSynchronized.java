package org.example.bankBalance.synchronizedBank;

public class BankAccountSynchronized {

    private Long balance = 0L;

    public void deposit(long amount) {
        synchronized (this) {
            this.balance += amount;
        }
    }

    public void withdraw(long amount) {
        synchronized (this) {
            if (amount > this.balance) {
                System.out.println("Для снятия пополните баланс");
            }
            this.balance -= amount;
        }
    }

    public synchronized Long getBalance() {
        return this.balance;
    }
}
