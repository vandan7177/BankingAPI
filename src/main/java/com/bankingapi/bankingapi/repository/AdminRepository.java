package com.bankingapi.bankingapi.repository;

import com.bankingapi.bankingapi.entities.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, Integer> {

}
