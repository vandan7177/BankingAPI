package com.bankingapi.bankingapi.services;

import com.bankingapi.bankingapi.entities.User;
import com.bankingapi.bankingapi.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServices {
    @Autowired
    private AdminRepository adminRepository;

}
