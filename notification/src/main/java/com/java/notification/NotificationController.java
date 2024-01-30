package com.java.notification;

import com.java.clients.fraud.FraudCheckResponse;
import com.java.clients.notification.NotificationClient;
import com.java.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = {"api/v1/notification-check/"})
@AllArgsConstructor
public class NotificationController {

    @Autowired
    private final NotificationService notificationService;


    //    @GetMapping(path = {"api/v1/notification-check/{customerId}/{customerName}/{email}"})
//    public FraudCheckResponse sendNotification(@PathVariable("customerId") Integer customerId,
//                                               @PathVariable("customerName") String name,
//                                               @PathVariable("email") String email) {
    @PostMapping(path = {"send"})
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        Notification notification = new Notification();
        notification.setCustomerId(notificationRequest.getCustomerId());
        notification.setMessage(notificationRequest.getName());
        notification.setToCustomerEmail(notificationRequest.getEmail());

        System.out.println("notification bean: " + notification);
        System.out.println("click");
        notificationService.sendNotification(notification);

//        return new ResponseEntity<Object>(notification, HttpStatus.CREATED);

    }
}
