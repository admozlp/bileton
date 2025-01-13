package com.ademozalp.bileton.service;

import com.ademozalp.bileton.repository.TripRepository;
import org.springframework.stereotype.Service;

@Service
public class TripService {
    private final TripRepository repository;

    public TripService(TripRepository repository) {
        this.repository = repository;
    }
}