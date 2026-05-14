package com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "accounts")
class AccountEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    var clientEntity: ClientEntity = ClientEntity(),

    @Column(name = "account_number", nullable = false, unique = true)
    var accountNumber: String = "",

    @Column(name = "balance", nullable = false)
    var balance: BigDecimal = BigDecimal.ZERO,

    @Column(name = "status", nullable = false)
    var status: String = "ACTIVO",

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()
)