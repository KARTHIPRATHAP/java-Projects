package com.java.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor

public class NotificationConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queues.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingkey;

    @Bean
    public TopicExchange internalTopicExchanage() {

        return new TopicExchange(this.internalExchange);
    }

    @Bean
    public Queue notificationQueue() {

        return new Queue(this.notificationQueue);
    }

    @Bean
    public Binding internalNotificatinBinding() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(internalTopicExchanage())
                .with(this.internalNotificationRoutingkey);
    }
}
