package com.example.auraly.repository;
import com.example.auraly.model.entity.HoroscopeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
@Transactional
@Repository
public interface HoroscopeRepository extends JpaRepository<HoroscopeEntity, Long> {

    @Modifying
    @Query("UPDATE HoroscopeEntity h SET h.date = :today")
    void updateAllDates(@Param("today") LocalDate today);
    List<HoroscopeEntity> findAllByDate(LocalDate date);



}











