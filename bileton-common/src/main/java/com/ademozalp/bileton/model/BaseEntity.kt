package com.ademozalp.bileton.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    open var id: Long = 0
        protected set

    @CreatedDate
    @Column(nullable = false, updatable = false)
    open var createdDate: LocalDateTime? = null
        protected set

    @LastModifiedDate
    @Column(insertable = false, updatable = true)
    open var lastModifiedDate: LocalDateTime? = null
        protected set


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        other as BaseEntity
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}