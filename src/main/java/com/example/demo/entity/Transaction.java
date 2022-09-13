package com.example.demo.entity;

import java.time.LocalDate;

public class Transaction {
    private LocalDate transactionDate;
    private Double transactionAmount;
    private Integer customerId;

    public Transaction(LocalDate transactionDate, Double transactionAmount, Integer customerId) {
        super();
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.customerId = customerId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
