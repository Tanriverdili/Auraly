package com.example.auraly.model.entity;

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

    @Column(nullable = false, unique = true)
    private String email;

    private String name;
    private String zodiac;

    private boolean dailyNotificationEnabled = true;
}






















//
//@Entity
//@Data
//@Table(name = "users")
//public class UserEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    private boolean dailyNotificationEnabled = true;
//
//}


