package com.ademozalp.bileton.model;

import com.ademozalp.bileton.model.base.BaseEntity;
import com.ademozalp.bileton.util.DBConstant;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import static com.ademozalp.bileton.util.DBConstant.*;

@Entity
@Table(name = DBConstant.LEG)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Leg extends BaseEntity {
    @Column(name = START_LOCATION, nullable = false)
    private Integer startLocation;
    @Column(name = END_LOCATION, nullable = false)
    private Integer endLocation;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(name = DEPARTURE_TIME, nullable = false)
    private LocalDateTime departureTime;
    @Column(name = ARRIVAL_TIME, nullable = false)
    private LocalDateTime arrivalTime;
    @Formula("EXTRACT(EPOCH FROM (arrival_time - departure_time))")
    private Long durationInSeconds;

    @ManyToOne
    @JoinColumn(name = TRIP_ID, nullable = false)
    private Trip trip;

    public Duration getDuration() {
        return Duration.ofSeconds(durationInSeconds);
    }
}
