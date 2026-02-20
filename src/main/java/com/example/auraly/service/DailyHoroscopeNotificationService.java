package com.example.auraly.service;

import com.example.auraly.enums.ZodiacSign;
import com.example.auraly.model.entity.HoroscopeEntity;
import com.example.auraly.model.entity.UserEntity;
import com.example.auraly.repository.HoroscopeRepository;
import com.example.auraly.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.ZoneId;
import java.util.*;
import java.util.List;
import java.time.LocalDate;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class DailyHoroscopeNotificationService {

    private final UserRepository userRepository;
    private final HoroscopeRepository horoscopeRepository;
    private final PushNotificationService pushNotificationService;

    public record UserHoroscopeResponse(Long id, String name, String zodiac, String message) {}

    @Transactional
    public List<UserHoroscopeResponse> sendDailyPushes() {

        LocalDate today = LocalDate.now(ZoneId.of("Asia/Baku"));
        horoscopeRepository.updateAllDates(today);




        List<HoroscopeEntity> horoscopeList = horoscopeRepository.findAllByDate(today);

        if (horoscopeList.isEmpty()) {
            log.warn("Bugün üçün horoskop tapılmadı");
            return Collections.emptyList();
        }

        Map<ZodiacSign, String> horoscopeMap = horoscopeList.stream()
                .collect(Collectors.toMap(HoroscopeEntity::getZodiacSign, HoroscopeEntity::getMessage));

        List<UserEntity> users = userRepository.findAll();
        List<UserHoroscopeResponse> responseList = new ArrayList<>();

        for (UserEntity user : users) {
            ZodiacSign zodiac = user.getZodiacSign();
            if (zodiac == null) continue;

            String message = horoscopeMap.get(zodiac);
            if (message == null) continue;


            pushNotificationService.sendPush(
                    user.getName(),
                    "Daily Horoscope - " + zodiac,
                    message
            );

            responseList.add(new UserHoroscopeResponse(
                    user.getId(),
                    user.getName(),
                    zodiac.name(),
                    message
            ));
        }

        log.info("Bugünkü bürc bildirişləri göndərildi");

        return responseList;
    }
}









































































































































































































































































































































































































































































































