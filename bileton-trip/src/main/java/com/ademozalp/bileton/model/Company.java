package com.ademozalp.bileton.model;

import com.ademozalp.bileton.model.base.BaseEntity;
import com.ademozalp.bileton.util.DBConstant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import static com.ademozalp.bileton.util.DBConstant.LOGO_URL;
import static com.ademozalp.bileton.util.DBConstant.TAX_NUMBER;


@Entity
@Table(name = DBConstant.COMPANY)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String phone;
    @Email
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String address;
    @Column(name = TAX_NUMBER, nullable = false)
    private String taxNumber;
    @Column(name = LOGO_URL, nullable = false)
    private String logoUrl;
}
