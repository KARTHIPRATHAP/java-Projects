package com.java.notification;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    @Autowired
    private final NotificatonRepository notificatonRepository;

    public void sendNotification(Notification notification) {
        Notification notificat = Notification.builder()
                .customerId(notification.getCustomerId())
                .message("Hi " + notification.getMessage() + ", welcome to JavaMicroservice")
                .sender("JavaMicroservice")
                .sendAt(LocalDateTime.now())
                .toCustomerEmail(notification.getToCustomerEmail())
                .build();
        System.out.println("notification bean: " + notification);
        System.out.println(notificat);
        System.out.println("click");

        notificatonRepository.save(notificat);

    }


}
