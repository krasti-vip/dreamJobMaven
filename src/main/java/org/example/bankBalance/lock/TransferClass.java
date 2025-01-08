package org.example.bankBalance.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TransferClass {

    public static void main(String[] args) throws InterruptedException {

        Bank bank = new Bank();

        Long ac1 = bank.createBankAccount();
        Long ac2 = bank.createBankAccount();
        Long ac3 = bank.createBankAccount();
        Long ac4 = bank.createBankAccount();

        bank.getBankAccount(ac1).deposit(1500L);
        bank.getBankAccount(ac2).deposit(1500L);
        bank.getBankAccount(ac3).deposit(1500L);
        bank.getBankAccount(ac4).deposit(1500L);

        System.out.println("Начальные балансы: " + (bank.getBankAccount(ac1).getBalance()+bank.getBankAccount(ac2)
                .getBalance()+bank.getBankAccount(ac3).getBalance()+bank.getBankAccount(ac4).getBalance()));
        System.out.println("ac1: " + bank.getBankAccount(ac1).getBalance());
        System.out.println("ac2: " + bank.getBankAccount(ac2).getBalance());
        System.out.println("ac3: " + bank.getBankAccount(ac3).getBalance());
        System.out.println("ac4: " + bank.getBankAccount(ac4).getBalance());

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable transfer1 = () -> bank.transferMoneyCheck(ac1, ac4, 200L);
        Runnable transfer2 = () -> bank.transferMoneyCheck(ac2, ac1, 100L);
        Runnable transfer3 = () -> bank.transferMoneyCheck(ac4, ac2, 50L);

        for (int i = 0; i < 40; i++) {
            executorService.submit(transfer1);
            executorService.submit(transfer2);
            executorService.submit(transfer3);
        }

        executorService.shutdown();
        executorService.awaitTermination(5L, TimeUnit.SECONDS);

        System.out.println("Итоговые балансы: " + (bank.getBankAccount(ac1).getBalance()+bank.getBankAccount(ac2)
                .getBalance()+bank.getBankAccount(ac3).getBalance()+bank.getBankAccount(ac4).getBalance()));
        System.out.println("ac1: " + bank.getBankAccount(ac1).getBalance());
        System.out.println("ac2: " + bank.getBankAccount(ac2).getBalance());
        System.out.println("ac3: " + bank.getBankAccount(ac3).getBalance());
        System.out.println("ac4: " + bank.getBankAccount(ac4).getBalance());
    }
}
