package com.ademozalp.bileton.controller;

import com.ademozalp.bileton.dto.base.APIResponse;
import com.ademozalp.bileton.dto.enums.ResponseMessage;
import com.ademozalp.bileton.dto.location.CreateLocationRequest;
import com.ademozalp.bileton.dto.location.LocationSearchResponse;
import com.ademozalp.bileton.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService service;

    @PostMapping("/import")
    public APIResponse<Void> importLocations(@RequestBody @Valid List<CreateLocationRequest> locationRequests) {
        service.importLocations(locationRequests);
        return APIResponse.<Void>builder()
                .code(ResponseMessage.IMPORTED.code())
                .message(ResponseMessage.IMPORTED.message())
                .build();
    }

    @GetMapping("/search")
    public APIResponse<List<LocationSearchResponse>> searchLocations(@RequestParam String name) {
        return APIResponse.<List<LocationSearchResponse>>builder()
                .code(ResponseMessage.LISTED.code())
                .message(ResponseMessage.LISTED.message())
                .data(service.searchLocations(name))
                .build();
    }
}
