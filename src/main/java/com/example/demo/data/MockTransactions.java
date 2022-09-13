package com.example.demo.data;

import com.example.demo.entity.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MockTransactions {

    private final HashMap<String, List<Transaction>> transactionRecords = new HashMap<>();

    public MockTransactions() {
        buildMockTransactions();
    }

    public List<Transaction> getTransactions(String email) {

        return transactionRecords.get(email);
    }

    private void buildMockTransactions() {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(LocalDate.of(2022, Month.AUGUST, 1), 55.00, 1));
        transactions.add(new Transaction(LocalDate.of(2022, Month.SEPTEMBER, 1), 45.00, 1));
        transactions.add(new Transaction(LocalDate.of(2022, Month.OCTOBER, 1), 250.25, 1));
        transactionRecords.put("email@email.com", transactions);

        transactions = new ArrayList<>();
        transactions.add(new Transaction(LocalDate.of(2022, Month.AUGUST, 31), 120.00, 4));
        transactionRecords.put("test@email.com", transactions);
    }
}
