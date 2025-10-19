package demo;

//package com.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount("98765", 1000.0);
    }

    @Test
    void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), "Balance after deposit should be correct");
    }

    @Test
    void testWithdraw() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), "Balance after withdrawal should be correct");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(2000.0));
    }

    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
    }

    @Test
    void testBalanceInquiry() {
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void testTransactionHistory() {
        account.deposit(200);
        account.withdraw(100);
        List<String> history = account.getTransactionHistory();
        assertTrue(history.stream().anyMatch(s -> s.contains("Deposited")));
        assertTrue(history.stream().anyMatch(s -> s.contains("Withdrew")));
    }
}
