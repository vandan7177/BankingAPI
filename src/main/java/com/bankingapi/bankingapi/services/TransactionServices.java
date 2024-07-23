package com.bankingapi.bankingapi.services;

import com.bankingapi.bankingapi.entities.Transaction;
import com.bankingapi.bankingapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServices {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> userTransactions(int accountNumber){
//        System.out.println(accountNumber + "*******");
        List<Transaction> ans =transactionRepository.findByAccountNumber(accountNumber);
//        System.out.println(accountNumber + ".......");
        return ans;
    }
}
