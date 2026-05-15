package com.tecsup.project.hexagonal.domain.model

import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.entity.AccountEntity
import java.math.BigDecimal
import java.time.LocalDateTime

data class Transaction(
    val id: Long?,
    val accountOriginId: Long?,
    val accountDestinationId: Long?,
    val amount: BigDecimal,
    val commission: BigDecimal,
    val type: String,
    val status: String,
    val description: String,
    val createdAt: LocalDateTime? = LocalDateTime.now()
) {
    var accountOrigin = AccountEntity()
    var accountDestination = AccountEntity()
}