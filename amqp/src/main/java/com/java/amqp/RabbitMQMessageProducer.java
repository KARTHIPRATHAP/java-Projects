package com.java.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {

//    @Autowired
    private final AmqpTemplate amqpTemplate;

//    @Bean
    public void publish(Object payLoad, String exchange, String routingkey) {
        log.info("publishing to {} using routingkey {}. Payload: {}", exchange, routingkey, payLoad);
//        amqpTemplate.convertSendAndReceive(exchange, routingkey, payLoad);
        amqpTemplate.convertAndSend(exchange, routingkey, payLoad);
        log.info("published to {} using routingkey {}. Payload: {}", exchange, routingkey, payLoad);

    }
}
