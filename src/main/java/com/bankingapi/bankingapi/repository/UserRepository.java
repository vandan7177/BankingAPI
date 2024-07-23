package com.bankingapi.bankingapi.repository;

import com.bankingapi.bankingapi.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {

}
