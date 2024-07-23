package com.bankingapi.bankingapi.repository;

import com.bankingapi.bankingapi.entities.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction,Integer> {
    List<Transaction> findByAccountNumber(int accountNumber);
}
