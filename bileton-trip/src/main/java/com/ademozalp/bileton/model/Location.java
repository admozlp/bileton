package com.ademozalp.bileton.model;

import com.ademozalp.bileton.model.enums.LocationType;
import jakarta.persistence.*;
import lombok.*;

import static com.ademozalp.bileton.util.DBConstant.LOCATION;

@Entity
@Table(name = LOCATION)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    @Id
    private Integer id;
    @Column(nullable = false)
    private String name;
    private Integer parentId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LocationType locationType;
}
