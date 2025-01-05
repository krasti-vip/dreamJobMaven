package org.example.bankBalance.synchronizedBank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TransferSynchronized {

    public static void main(String[] args) throws InterruptedException {

        BankSynchronized bankSynchronized = new BankSynchronized();

        Long ac1 = bankSynchronized.createAccount();
        Long ac2 = bankSynchronized.createAccount();
        Long ac3 = bankSynchronized.createAccount();
        Long ac4 = bankSynchronized.createAccount();

        bankSynchronized.getAccount(ac1).deposit(2500L);
        bankSynchronized.getAccount(ac2).deposit(2500L);
        bankSynchronized.getAccount(ac3).deposit(2500L);
        bankSynchronized.getAccount(ac4).deposit(2500L);

        System.out.println("Начальные балансы: " + (bankSynchronized.getAccount(ac1).getBalance() + bankSynchronized.getAccount(ac2)
                .getBalance() + bankSynchronized.getAccount(ac3).getBalance() + bankSynchronized.getAccount(ac4).getBalance()));
        System.out.println("ac1: " + bankSynchronized.getAccount(ac1).getBalance());
        System.out.println("ac2: " + bankSynchronized.getAccount(ac2).getBalance());
        System.out.println("ac3: " + bankSynchronized.getAccount(ac3).getBalance());
        System.out.println("ac4: " + bankSynchronized.getAccount(ac4).getBalance());

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable transfer1 = () -> bankSynchronized.transfer(ac1, ac4, 200L);
        Runnable transfer2 = () -> bankSynchronized.transfer(ac2, ac1, 100L);
        Runnable transfer3 = () -> bankSynchronized.transfer(ac4, ac2, 50L);

        for (int i = 0; i < 2000; i++) {
            executorService.submit(transfer1);
            executorService.submit(transfer2);
            executorService.submit(transfer3);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Итоговые балансы: " + (bankSynchronized.getAccount(ac1).getBalance() + bankSynchronized.getAccount(ac2)
                .getBalance() + bankSynchronized.getAccount(ac3).getBalance() + bankSynchronized.getAccount(ac4).getBalance()));
        System.out.println("ac1: " + bankSynchronized.getAccount(ac1).getBalance());
        System.out.println("ac2: " + bankSynchronized.getAccount(ac2).getBalance());
        System.out.println("ac3: " + bankSynchronized.getAccount(ac3).getBalance());
        System.out.println("ac4: " + bankSynchronized.getAccount(ac4).getBalance());
    }
}

