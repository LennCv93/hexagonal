package com.tecsup.project.hexagonal.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime

data class Transaction(
    val id: Long,
    val amount: BigDecimal,
    val commission: BigDecimal,
    val type: String,
    val status: String,
    val description: String,
    val createdAt: LocalDateTime
)