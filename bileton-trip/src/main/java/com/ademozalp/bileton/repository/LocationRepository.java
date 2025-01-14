package com.ademozalp.bileton.repository;

import com.ademozalp.bileton.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocationRepository extends JpaRepository<Location, Integer>, JpaSpecificationExecutor<Location> {
}
