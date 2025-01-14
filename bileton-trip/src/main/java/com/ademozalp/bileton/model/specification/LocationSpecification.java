package com.ademozalp.bileton.model.specification;

import com.ademozalp.bileton.model.Location;
import org.springframework.data.jpa.domain.Specification;

public class LocationSpecification {
    private LocationSpecification() {
    }

    public static Specification<Location> likeName(String locationName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + locationName.toUpperCase() + "%");
    }
}
