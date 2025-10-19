package demo;
//package com.bankapp;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (amount > balance)
            throw new IllegalStateException("Insufficient balance");
        balance -= amount;
        transactionHistory.add("Withdrew: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
