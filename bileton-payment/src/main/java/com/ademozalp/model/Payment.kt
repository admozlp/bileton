package com.ademozalp.model

import com.ademozalp.bu_bilet.model.enums.PaymentStatusType
import com.ademozalp.model.base.BaseEntity
import jakarta.persistence.Column
import java.math.BigDecimal
import java.time.LocalDate

data class Payment(
    @Column(nullable = false)
    val totalAmount: BigDecimal,
    @Column(nullable = false)
    val cardNumber: String,
    @Column(nullable = false)
    val cardHolderName: String,
    @Column(nullable = false)
    val expirationDate: LocalDate,
    val cvv: String,
    @Column(nullable = false)
    val status: PaymentStatusType,

    @Column(nullable = false)
    val ticketId: Long
) : BaseEntity() {
}