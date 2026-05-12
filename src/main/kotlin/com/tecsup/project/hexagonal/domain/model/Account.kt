package com.tecsup.project.hexagonal.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime

data class Account(
    val id: Long,
    val accountNumber: String,
    val balance: BigDecimal,
    val status: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)