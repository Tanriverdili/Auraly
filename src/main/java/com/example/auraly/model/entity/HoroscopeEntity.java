package com.example.auraly.model.entity;

import com.example.auraly.enums.ZodiacSign;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;

@Entity
@Table(name = "horoscopes", uniqueConstraints = @UniqueConstraint(columnNames = {"zodiac_sign", "date"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoroscopeEntity {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "zodiac_sign", nullable = false)
    private ZodiacSign zodiacSign;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, length = 500)
    private String message;


}

















































