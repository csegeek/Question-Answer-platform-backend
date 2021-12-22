package com.example.QAplatform.Dao;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AuthorDao {
    
    private Long user_Id;
    private String username;
    private String password;
    private String email;
    private Instant created;
    private boolean enabled;
}
