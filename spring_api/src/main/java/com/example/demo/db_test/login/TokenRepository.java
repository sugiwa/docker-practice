package com.example.demo.db_test.login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    Token getByToken(String token);
    
}
