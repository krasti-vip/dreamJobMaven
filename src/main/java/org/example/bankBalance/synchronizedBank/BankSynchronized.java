package org.example.bankBalance.synchronizedBank;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class BankSynchronized {

    private HashMap<Long, BankAccountSynchronized> accounts = new HashMap();

    private AtomicLong idGenerator = new AtomicLong();

    public long createAccount() {
        long id = idGenerator.incrementAndGet();
        BankAccountSynchronized bankAcSynchronized = new BankAccountSynchronized();
        accounts.put(id, bankAcSynchronized);
        return id;
    }

    public BankAccountSynchronized getAccount(long id) {
        return accounts.get(id);
    }

    public void transfer(long from, long to, long amount) {
        BankAccountSynchronized acFrom = accounts.get(from);
        BankAccountSynchronized acTo = accounts.get(to);
        if (acFrom != null && acTo != null && acFrom.getBalance() > amount) {
            acFrom.withdraw(amount);
            acTo.deposit(amount);
            System.out.println("Перевод выполнен");
        } else {
            System.out.println("Для перевода пополните баланс");
        }
    }
}
