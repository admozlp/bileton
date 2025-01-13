package com.ademozalp.bileton.model;

import com.ademozalp.bileton.model.base.BaseEntity;
import com.ademozalp.bileton.util.DBConstant;
import com.ademozalp.bu_bilet.model.enums.TripStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Duration;
import java.time.LocalDateTime;

import static com.ademozalp.bileton.util.DBConstant.*;

@Entity
@Table(name = DBConstant.TRIP)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trip extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = ORIGIN, nullable = false)
    private Location origin;
    @ManyToOne
    @JoinColumn(name = DESTINATION, nullable = false)
    private Location destination;
    @Column(name = DEPARTURE_TIME, nullable = false)
    private LocalDateTime departureTime;
    @Column(name = ARRIVAL_TIME, nullable = false)
    private LocalDateTime arrivalTime;
    @Formula("EXTRACT(EPOCH FROM (arrival_time - departure_time))")
    private Long durationInSeconds;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = TRIP_STATUS, nullable = false)
    private TripStatus tripStatus = TripStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = DBConstant.COMPANY_ID, nullable = false)
    private Company company;

    public Duration getDuration() {
        return Duration.ofSeconds(durationInSeconds);
    }
}