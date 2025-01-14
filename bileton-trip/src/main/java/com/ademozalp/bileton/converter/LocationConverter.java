package com.ademozalp.bileton.converter;

import com.ademozalp.bileton.dto.location.LocationSearchResponse;
import com.ademozalp.bileton.model.Location;

public class LocationConverter {
    private LocationConverter() {
    }

    public static LocationSearchResponse toSearchResponse(Location location) {
        return new LocationSearchResponse(location.getId(), location.getName(), location.getParentId(), location.getLocationType());
    }
}
