package com.example.demo.service;

import com.example.demo.data.MockTransactions;
import com.example.demo.entity.Rewards;
import com.example.demo.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardsService {

    @Autowired
    MockTransactions mockTransactions;

    public Rewards calculateTotalRewards(String email) {

        List<Transaction> allTransactions = mockTransactions.getTransactions(email);

        Rewards rewards = new Rewards();
        Integer total = 0;

        if (allTransactions != null && allTransactions.size() > 0) {
            for (Transaction transaction : allTransactions) {

                Integer transactionAmount = transaction.getTransactionAmount().intValue();

                if (transactionAmount > 50 && transactionAmount < 100) {
                    total += transactionAmount - 50;
                }

                if (transactionAmount >= 100) {
                    total += 50 + (transactionAmount - 100) * 2;
                }
            }
        }

        rewards.setCustomerEmail(email);
        rewards.setCustomerRewards(total);

        return rewards;
    }


//	Input value for month is numerical value starting with January = 0;

    public Rewards calculateRewardsForMonth(String email, int month) {

        List<Transaction> allTransactions = mockTransactions.getTransactions(email);

        Rewards rewards = new Rewards();
        Integer total = 0;
        if (allTransactions != null && allTransactions.size() > 0) {
            for (Transaction transaction : allTransactions) {

                if (transaction.getTransactionDate().getMonthValue() == month) {

                    Integer transactionAmount = transaction.getTransactionAmount().intValue();

                    if (transactionAmount > 50 && transactionAmount < 100) {
                        total += transactionAmount - 50;
                    }

                    if (transactionAmount >= 100) {
                        total += 50 + (transactionAmount - 100) * 2;
                    }
                }
            }
        }

        rewards.setCustomerEmail(email);
        rewards.setCustomerRewards(total);

        return rewards;
    }
}
