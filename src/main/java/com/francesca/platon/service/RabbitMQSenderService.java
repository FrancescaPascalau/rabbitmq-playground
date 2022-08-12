package com.francesca.platon.service;

import com.francesca.platon.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQSenderService {

    private final AmqpTemplate amqpTemplate;

    @Value("${spring.rabbitmq.template.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingKey;

    public void send(Message message) {
        amqpTemplate.convertAndSend(exchange, routingKey, message);

        System.out.println("Sending message to queue: " + message);
    }
}