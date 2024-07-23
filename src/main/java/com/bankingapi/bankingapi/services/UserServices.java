package com.bankingapi.bankingapi.services;

import com.bankingapi.bankingapi.entities.Transaction;
import com.bankingapi.bankingapi.entities.TransactionType;
import com.bankingapi.bankingapi.entities.User;
import com.bankingapi.bankingapi.repository.TransactionRepository;
import com.bankingapi.bankingapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public User adduser(User user){
        return userRepository.save(user);
    }
    public User myInfo(int accountNumber){
        return userRepository.findById(accountNumber).orElse(new User(-1,"N/A","N/A",0));
    }

    public List<User> allAccounts(){
        return userRepository.findAll();
    }
    public String addMoney(int amount,int accountNumber){
        if(userRepository.findById(accountNumber).isEmpty()){
            return "wrong account number";
        }
        User acc = userRepository.findById(accountNumber).get();
        acc.setAccountBalance(acc.getAccountBalance()+amount);
        userRepository.save(acc);

        //add transaction details
        Transaction transaction = new Transaction(accountNumber,new Date(),TransactionType.DEPOSIT,-1,amount,true);
        transactionRepository.save(transaction);
        return "Amount added successfully";
    }

    public String withdrawMoney(int amount,int accountNumber){
        if(userRepository.findById(accountNumber).isEmpty()){
            return "wrong account number";
        }
        User acc = userRepository.findById(accountNumber).get();

        if(acc.getAccountBalance()<amount){
            //transaction here
            Transaction transaction = new Transaction(accountNumber,new Date(),TransactionType.WITHDRAW,-1,amount,false);
            transactionRepository.save(transaction);
            return "insufficient amount!!";
        }
        acc.setAccountBalance(acc.getAccountBalance()-amount);
        userRepository.save(acc);

        //transaction here
        Transaction transaction = new Transaction(accountNumber,new Date(),TransactionType.WITHDRAW,-1,amount,true);
        transactionRepository.save(transaction);
        return "Amount withdraw successfully";
    }

    public String transferMoney(int amount,int accountNumberSender,int accountNumberReceiver){
        if(!(userRepository.findById(accountNumberSender).isPresent() || userRepository.findById(accountNumberReceiver).isPresent())){
            return "wrong account numbers";
        }

        User sender = userRepository.findById(accountNumberSender).get();
        User receiver = userRepository.findById(accountNumberReceiver).get();

        if(sender.getAccountBalance()<amount){
            //transaction here
            Transaction recv = new Transaction(accountNumberReceiver,new Date(),TransactionType.RECEIVE,accountNumberSender,amount,false);
            Transaction send = new Transaction(accountNumberSender,new Date(),TransactionType.SEND,accountNumberReceiver,amount,false);
            transactionRepository.save(recv);
            transactionRepository.save(send);

            return "insufficient amount!!";
        }

        sender.setAccountBalance(sender.getAccountBalance()-amount);
        receiver.setAccountBalance(receiver.getAccountBalance()+amount);
        userRepository.save(sender);
        userRepository.save(receiver);

        //transaction here
        Transaction recv = new Transaction(accountNumberReceiver,new Date(),TransactionType.RECEIVE,accountNumberSender,amount,true);
        Transaction send = new Transaction(accountNumberSender,new Date(),TransactionType.SEND,accountNumberReceiver,amount,true);
        transactionRepository.save(recv);
        transactionRepository.save(send);
        //
        return "Transaction Completed Successfully";
    }

    public String deleteUser(int accountNumber){
        if(!userRepository.findById(accountNumber).isPresent()){
            return "User Not Found, Can't delete this account";
        }
        userRepository.deleteById(accountNumber);
        return "account removed successfully";
    }
}
