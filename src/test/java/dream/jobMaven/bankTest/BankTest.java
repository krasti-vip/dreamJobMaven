package dream.jobMaven.bankTest;

import org.example.bankBalance.lock.Bank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    Bank bank = new Bank();

    @Test
    @DisplayName("Тест создания аккаунтов, пополнения, снятия и перевода, включая некорректные суммы")
    void bankTest() {

        Long ac1 = bank.createBankAccount();
        Long ac2 = bank.createBankAccount();
        Long ac3 = bank.createBankAccount();

        bank.getBankAccount(ac1).deposit(1000L);
        bank.getBankAccount(ac2).deposit(2000L);
        bank.getBankAccount(ac3).deposit(3000L);

        assertEquals(1000L, bank.getBankAccount(ac1).getBalance());
        assertEquals(2000L, bank.getBankAccount(ac2).getBalance());
        assertEquals(3000L, bank.getBankAccount(ac3).getBalance());

        bank.getBankAccount(ac1).deposit(500L);
        bank.getBankAccount(ac2).deposit(500L);
        bank.getBankAccount(ac3).deposit(500L);

        assertEquals(1500L, bank.getBankAccount(ac1).getBalance());
        assertEquals(2500L, bank.getBankAccount(ac2).getBalance());
        assertEquals(3500L, bank.getBankAccount(ac3).getBalance());

        bank.getBankAccount(ac1).withdraw(200L);
        bank.getBankAccount(ac2).withdraw(200L);
        bank.getBankAccount(ac3).withdraw(300L);

        assertEquals(1300L, bank.getBankAccount(ac1).getBalance());
        assertEquals(2300L, bank.getBankAccount(ac2).getBalance());
        assertEquals(3200L, bank.getBankAccount(ac3).getBalance());

        bank.getBankAccount(ac1).withdraw(5000L);

        assertEquals(1300L, bank.getBankAccount(ac1).getBalance());

        bank.transferMoneyCheck(ac3, ac1, 800L);
        bank.transferMoneyCheck(ac3, ac2, 8000L);
        bank.transferMoneyCheck(ac3, ac2, 0L);

        assertEquals(2100L, bank.getBankAccount(ac1).getBalance());
        assertEquals(2300L, bank.getBankAccount(ac2).getBalance());
        assertEquals(2400L, bank.getBankAccount(ac3).getBalance());
    }
}
