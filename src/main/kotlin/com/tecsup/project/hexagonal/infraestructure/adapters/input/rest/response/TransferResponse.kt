package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.math.BigDecimal
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class TransferResponse(
    val id: Long,
    val accountOriginName: String,
    val accountDestinationName: String,
    val amount: BigDecimal,
    val commission: BigDecimal,
    val type: String,
    val status: String,
    val description: String,
    val createdAt: LocalDateTime
)