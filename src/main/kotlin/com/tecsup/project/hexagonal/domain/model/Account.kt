package com.tecsup.project.hexagonal.domain.model

import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.entity.ClientEntity
import java.math.BigDecimal
import java.time.LocalDateTime

data class Account(
    val id: Long?,
    val clientId: Long?,
    val accountNumber: String,
    val balance: BigDecimal,
    val status: String?,
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = LocalDateTime.now()
) {
    var clientEntity = ClientEntity()
}