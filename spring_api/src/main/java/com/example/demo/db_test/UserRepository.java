package com.example.demo.db_test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User getByEmail(String email);

    User findByToken(String token);

}
