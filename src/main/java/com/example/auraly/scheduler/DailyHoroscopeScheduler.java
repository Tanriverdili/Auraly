package com.example.auraly.scheduler;

import com.example.auraly.service.DailyHoroscopeNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DailyHoroscopeScheduler {

    private final DailyHoroscopeNotificationService horoscopeService;

    @Scheduled(cron = "0 0 12 * * ?", zone = "Asia/Baku")
    public void runDailyPushes() {
        List<DailyHoroscopeNotificationService.UserHoroscopeResponse> responses =
                horoscopeService.sendDailyPushes();


    }
}


















































































































