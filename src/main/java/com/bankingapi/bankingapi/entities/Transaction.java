package com.bankingapi.bankingapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "TransactionHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Transaction {
    private int accountNumber;
    private Date date;
    private TransactionType type;
    private int peerAccountNumber;
    private int amount;
    private boolean status;
}
