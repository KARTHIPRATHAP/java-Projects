package com.java.clients.notification;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("notification")

public interface NotificationClient {
//    @PostMapping(path = {"api/v1/notification-check/{customerId}/{customerName}/{email}"})
//    void sendNotification(@PathVariable("customerId") Integer customerId,
//                                   @PathVariable("customerName") String name,
//                                   @PathVariable("email") String email);
@PostMapping(path = {"api/v1/notification-check/send"})
void sendNotification(NotificationRequest notificationRequest);
}
