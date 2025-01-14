package com.ademozalp.bileton.service;

import com.ademozalp.bileton.converter.LocationConverter;
import com.ademozalp.bileton.dto.location.CreateLocationRequest;
import com.ademozalp.bileton.dto.location.LocationSearchResponse;
import com.ademozalp.bileton.model.Location;
import com.ademozalp.bileton.model.enums.LocationType;
import com.ademozalp.bileton.model.specification.LocationSpecification;
import com.ademozalp.bileton.repository.LocationRepository;
import org.springframework.data.jpa.domain.Specification;
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
                    .id(locationRequest.id())
                    .name(locationRequest.name())
                    .build();

            location.setParentId(locationRequest.parentId() != null ? locationRequest.parentId() : locationRequest.id());
            location.setLocationType(locationRequest.parentId() != null ? LocationType.DISTRICT : LocationType.CITY);

            locations.add(location);
        }
        repository.saveAll(locations);
    }

    public List<LocationSearchResponse> searchLocations(String locationName) {
        Specification<Location> specification = LocationSpecification.likeName(locationName);
        List<Location> locations = repository.findAll(specification);
        return locations.stream().map(LocationConverter::toSearchResponse).toList();
    }
}
