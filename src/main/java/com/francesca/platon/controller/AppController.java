package com.francesca.platon.controller;

import com.francesca.platon.model.Message;
import com.francesca.platon.service.RabbitMQSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class AppController {

    private final RabbitMQSenderService rabbitMQSenderService;

    @GetMapping(value = "/send")
    public ResponseEntity<String> producer(@RequestParam("body") String body) {
        rabbitMQSenderService.send(Message.builder()
                .createdAt(LocalDate.now())
                .body(body)
                .build());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
