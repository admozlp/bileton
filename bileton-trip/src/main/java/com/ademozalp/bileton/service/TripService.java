package com.ademozalp.bileton.service;

import com.ademozalp.bileton.model.Trip;
import com.ademozalp.bileton.repository.TripRepository;
import com.ademozalp.bu_bilet.model.enums.VehicleType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TripService implements CommandLineRunner {
    private final TripRepository repository;
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Trip(new BigDecimal("100.0"), "Istanbul", VehicleType.BUS, LocalDateTime.now()));
        List<Trip> all = repository.findAll();

        System.out.println("All trips: " + all);
        System.out.println("DataSource URL: " + dataSourceUrl);



    }
}
