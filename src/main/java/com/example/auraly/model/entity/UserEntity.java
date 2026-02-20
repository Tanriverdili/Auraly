package com.example.auraly.model.entity;

import com.example.auraly.enums.ZodiacSign;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "zodiac_sign", nullable = false)
    private ZodiacSign zodiacSign;
}
























