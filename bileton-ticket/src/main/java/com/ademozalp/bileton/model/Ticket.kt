package com.ademozalp.bileton.model

import com.ademozalp.bileton.util.DatabaseConstant
import com.ademozalp.bu_bilet.model.enums.GenderType
import com.ademozalp.bu_bilet.model.enums.TicketStatusType
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal


@Entity
@Table(name = DatabaseConstant.TICKET)
@EntityListeners(AuditingEntityListener::class)
data class Ticket @JvmOverloads constructor(
    @Column(nullable = false, unique = true)
    var pnr: String,
    @Column(nullable = false)
    var totalAmount: BigDecimal,

    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.EAGER)
    var seatNumbers: Set<Int>,

    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.EAGER, targetClass = GenderType::class)
    var genders: List<GenderType> = mutableListOf(),

    @Enumerated(EnumType.STRING)
    var status: TicketStatusType = TicketStatusType.PENDING,

//    @ManyToOne
//    @JoinColumn(name = DatabaseConstant.USER_ID, nullable = false)
//    var user: User,
//
//    @ManyToOne
//    @JoinColumn(name = DatabaseConstant.TRIP_ID, nullable = false)
//    var trip: Trip


) : BaseEntity() {
    constructor() : this(
        "", BigDecimal.ZERO, setOf(), mutableListOf(), TicketStatusType.PENDING
//        , User(), Trip()
    )

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}
