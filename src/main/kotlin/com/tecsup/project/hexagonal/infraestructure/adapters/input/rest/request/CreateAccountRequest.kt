package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.math.BigDecimal

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CreateAccountRequest (
    val clientId: Long,
    val balance: BigDecimal,
    val accountNumber: String
)