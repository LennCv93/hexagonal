package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.math.BigDecimal
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CreateAccountResponse(
    val id: Long,
    val accountNumber: String,
    val balance: BigDecimal,
    val status: String,
    val createdAt: LocalDateTime
)