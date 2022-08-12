package com.francesca.platon.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Message {

    private String body;
    private LocalDate createdAt;
}
