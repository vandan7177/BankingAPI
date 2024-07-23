package com.bankingapi.bankingapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Admin")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Admin {
    @Id
    private int adminId;
    private String firstName;
    private String secondName;
}
