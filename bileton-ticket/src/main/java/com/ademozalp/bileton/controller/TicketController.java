package com.ademozalp.bileton.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

    @GetMapping("/health")
    public String health() {
        return "Payment is running";
    }
}
