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
@Table(name = "transactions")
class TransactionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @JoinColumn(name = "account_origin_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    var accountOrigin: AccountEntity = AccountEntity(),

    @JoinColumn(name = "account_destination_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    var accountDestination: AccountEntity = AccountEntity(),

    @Column(name = "amount")
    var amount: BigDecimal = BigDecimal.ZERO,

    @Column(name = "commission")
    var commission: BigDecimal = BigDecimal.ZERO,

    @Column(name = "type")
    var type: String = "",

    @Column(name = "status")
    var status: String = "",

    @Column(name = "description")
    var description: String = "",

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()
)