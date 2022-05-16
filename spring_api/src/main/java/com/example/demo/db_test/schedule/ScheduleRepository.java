package com.example.demo.db_test.schedule;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    List<Schedule> findByUserId(int userId);
    
}
