package com.ademozalp.bileton.model

import com.ademozalp.bileton.util.DatabaseConstant
import com.ademozalp.bu_bilet.model.enums.TripStatusType
import com.ademozalp.bu_bilet.model.enums.VehicleType
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity
@Table(name = DatabaseConstant.TRIP)
@EntityListeners(AuditingEntityListener::class)
data class Trip @JvmOverloads constructor(

    @Column(nullable = false)
    var price: BigDecimal,
    @Column(nullable = false)
    var duration: String,

    @Enumerated(EnumType.STRING)
    var status: TripStatusType? = TripStatusType.ACTIVE,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var vehicleType: VehicleType,

    @Column(nullable = false)
    var departureDate: LocalDateTime,

//    @ManyToOne
//    @JoinColumn(name = DatabaseConstant.DEPARTURE_CITY_ID, nullable = false)
//    var departureCity: City,
//
//    @ManyToOne
//    @JoinColumn(name = DatabaseConstant.DESTINATION_CITY_ID, nullable = false)
//    var destinationCity: City,
//
//    @ManyToOne
//    @JoinColumn(name = DatabaseConstant.COMPANY_ID, nullable = false)
//    var company: Company,
//
//
//    @OneToMany(mappedBy = "trip", cascade = [CascadeType.REMOVE], fetch = FetchType.EAGER)
//    var tickets: List<Ticket> = mutableListOf()


) : BaseEntity() {
    constructor() : this(
        BigDecimal.ZERO,
        "0:0",
        TripStatusType.ACTIVE,
        VehicleType.BUS,
        LocalDateTime.now(),
//        City(),
//        City(),
//        Company()
    )


    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}
