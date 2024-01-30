package com.java.notification;


import com.java.amqp.RabbitMQMessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = {
        "com.java.notification",
        "com.java.amqp",
})
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.java.clients"
)
@AllArgsConstructor
//@Configuration
@Component
public class NotificationApplication {

//    @Autowired
//    private final NotificationConfig notificationConfig;
//    @Autowired
//    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public static void main(String[] args) {

        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer rabbitMQMessageProducer,
//                                        NotificationConfig notificationConfig) {
//        return args -> {
//            rabbitMQMessageProducer.publish("foo",
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingkey()
//            );
//        };
//    }


}