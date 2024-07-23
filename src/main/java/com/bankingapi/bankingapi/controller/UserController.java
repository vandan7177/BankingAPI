package com.bankingapi.bankingapi.controller;

import com.bankingapi.bankingapi.entities.User;
import com.bankingapi.bankingapi.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User addUser(@RequestBody User user){
        return userServices.adduser(user);
    }

    @GetMapping("/{accountNumber}")
    public User myAccount(@PathVariable int accountNumber){
        return userServices.myInfo(accountNumber);
    }

    @GetMapping("/all")
    public List<User> findAllAccount(){
        return userServices.allAccounts();
    }
    @PutMapping("/add/{amount}/{accountNumber}")
    public String addMoney(@PathVariable int amount,@PathVariable int accountNumber){
        return userServices.addMoney(amount,accountNumber);
    }

    @PutMapping("/withdraw/{amount}/{accountNumber}")
    public String withdrawMoney(@PathVariable int amount,@PathVariable int accountNumber){
        return userServices.withdrawMoney(amount,accountNumber);
    }

    @PutMapping("/transfer/{amount}/{accountNumberSender}/{accountNumberReceiver}")
    public String transfer(@PathVariable int amount,@PathVariable int accountNumberSender,@PathVariable int accountNumberReceiver){
        return userServices.transferMoney(amount,accountNumberSender,accountNumberReceiver);
    }

    @DeleteMapping("/{accountNumber}")
    public String deleteUser(@PathVariable int accountNumber){
        return userServices.deleteUser(accountNumber);
    }
}
