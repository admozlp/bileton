package com.ademozalp.bileton.dto.location;

import com.ademozalp.bileton.model.enums.LocationType;


public record LocationSearchResponse(Integer id, String name, Integer parentId, LocationType locationType) {
}
