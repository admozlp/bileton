package com.ademozalp.bileton.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trip")
public class TripController {

    @GetMapping("/health")
    public String health() {
        return "Trip is running";
    }
}
