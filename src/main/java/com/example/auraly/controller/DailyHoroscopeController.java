package com.example.auraly.controller;
import com.example.auraly.service.DailyHoroscopeNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DailyHoroscopeController {

    private final DailyHoroscopeNotificationService horoscopeService;

    @GetMapping("/daily/horoscope")
    public List<DailyHoroscopeNotificationService.UserHoroscopeResponse> getDailyHoroscope() {
        return horoscopeService.sendDailyPushes();
    }
}
























































































