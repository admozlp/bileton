package com.ademozalp.bileton.service;

import com.ademozalp.bileton.dto.location.CreateLocationRequest;
import com.ademozalp.bileton.model.Location;
import com.ademozalp.bileton.model.enums.LocationType;
import com.ademozalp.bileton.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class LocationService {
    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public void importLocations(List<CreateLocationRequest> locationRequests) {
        LinkedList<Location> locations = new LinkedList<>();
        for (CreateLocationRequest locationRequest : locationRequests) {
            Location location = Location.builder()
                    .id(locationRequest.getId())
                    .name(locationRequest.getName())
                    .build();

            location.setParentId(locationRequest.getParentId() != null ? locationRequest.getParentId() : locationRequest.getId());
            location.setLocationType(locationRequest.getParentId() != null ? LocationType.DISTRICT : LocationType.CITY);

            locations.add(location);
        }
        repository.saveAll(locations);
    }
}
