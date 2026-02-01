package com.example.auraly.repository;

import com.example.auraly.model.entity.DailyHoroscope;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;



public interface DailyHoroscopeRepository extends JpaRepository<DailyHoroscope, Long> {
    List<DailyHoroscope> findByDate(LocalDate date);
}



