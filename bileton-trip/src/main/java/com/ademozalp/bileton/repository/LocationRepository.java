package com.ademozalp.bileton.repository;

import com.ademozalp.bileton.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
