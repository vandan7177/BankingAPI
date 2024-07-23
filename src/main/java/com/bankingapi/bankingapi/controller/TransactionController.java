package com.bankingapi.bankingapi.controller;

import com.bankingapi.bankingapi.entities.Transaction;
import com.bankingapi.bankingapi.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionServices transactionServices;

    @GetMapping("/{accountNumber}")
    public List<Transaction> userTransaction(@PathVariable int accountNumber){
//        System.out.println(accountNumber + "______");
        return transactionServices.userTransactions(accountNumber);
    }
}
