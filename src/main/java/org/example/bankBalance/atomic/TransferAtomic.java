package org.example.bankBalance.atomic;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TransferAtomic {

    public static void main(String[] args) throws InterruptedException {

        BankAtomic bankAtomic = new BankAtomic();

        Long ac1 = bankAtomic.createBankAccount();
        Long ac2 = bankAtomic.createBankAccount();
        Long ac3 = bankAtomic.createBankAccount();
        Long ac4 = bankAtomic.createBankAccount();

        bankAtomic.getBankAccount(ac1).deposit(2500L);
        bankAtomic.getBankAccount(ac2).deposit(2500L);
        bankAtomic.getBankAccount(ac3).deposit(2500L);
        bankAtomic.getBankAccount(ac4).deposit(2500L);

        System.out.println("Начальные балансы: " + (bankAtomic.getBankAccount(ac1).getBalance() + bankAtomic.getBankAccount(ac2)
                .getBalance() + bankAtomic.getBankAccount(ac3).getBalance() + bankAtomic.getBankAccount(ac4).getBalance()));
        System.out.println("ac1: " + bankAtomic.getBankAccount(ac1).getBalance());
        System.out.println("ac2: " + bankAtomic.getBankAccount(ac2).getBalance());
        System.out.println("ac3: " + bankAtomic.getBankAccount(ac3).getBalance());
        System.out.println("ac4: " + bankAtomic.getBankAccount(ac4).getBalance());

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable transfer1 = () -> bankAtomic.transferMoney(ac1, ac4, 200L);
        Runnable transfer2 = () -> bankAtomic.transferMoney(ac2, ac1, 100L);
        Runnable transfer3 = () -> bankAtomic.transferMoney(ac4, ac2, 50L);

        for (int i = 0; i < 100; i++) {
            executorService.submit(transfer1);
            executorService.submit(transfer2);
            executorService.submit(transfer3);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Итоговые балансы: " + (bankAtomic.getBankAccount(ac1).getBalance() + bankAtomic.getBankAccount(ac2)
                .getBalance() + bankAtomic.getBankAccount(ac3).getBalance() + bankAtomic.getBankAccount(ac4).getBalance()));
        System.out.println("ac1: " + bankAtomic.getBankAccount(ac1).getBalance());
        System.out.println("ac2: " + bankAtomic.getBankAccount(ac2).getBalance());
        System.out.println("ac3: " + bankAtomic.getBankAccount(ac3).getBalance());
        System.out.println("ac4: " + bankAtomic.getBankAccount(ac4).getBalance());
    }
}

