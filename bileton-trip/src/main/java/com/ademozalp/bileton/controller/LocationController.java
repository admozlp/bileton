package com.ademozalp.bileton.controller;

import com.ademozalp.bileton.dto.location.CreateLocationRequest;
import com.ademozalp.bileton.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService service;

    @PostMapping("/import")
    public ResponseEntity<Void> importLocations(@RequestBody @Valid List<CreateLocationRequest> locationRequests) {
        service.importLocations(locationRequests);
        return ResponseEntity.ok().build();
    }

}
