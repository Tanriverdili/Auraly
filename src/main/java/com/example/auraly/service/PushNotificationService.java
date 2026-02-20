package com.example.auraly.service;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {


    public void sendPush(String name, String title, String message) {
        System.out.println("PUSH to " + name + ": [" + title + "] " + message);
    }
    }











