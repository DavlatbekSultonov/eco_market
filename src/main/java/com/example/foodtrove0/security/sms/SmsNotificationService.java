package com.example.foodtrove0.security.sms;

public interface SmsNotificationService {
    void sendNotification(String phoneNumber, String message);
}
