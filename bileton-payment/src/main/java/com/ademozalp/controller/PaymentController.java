package com.ademozalp.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    List<String> ipList = new ArrayList<>();

    @GetMapping("/health")
    public String health(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        ipList.add(ipAddress);
        return "OK";
    }

    @GetMapping("/ip")
    public List<String> getIpList() {
        return ipList;
    }
}
