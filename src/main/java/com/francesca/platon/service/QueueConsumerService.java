package com.francesca.platon.service;

import com.francesca.platon.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class QueueConsumerService {

    @RabbitListener(queues = {"${spring.rabbitmq.template.default-receive-queue}"})
    public void receive(@Payload Message message) {
        System.out.println("Received message from queue:" + message);
    }
}