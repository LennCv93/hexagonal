package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.math.BigDecimal

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class TransferRequest(
    val accountOriginId: Long,
    val accountDestinationId: Long,
    val amount: BigDecimal,
    val description: String
) {
    var commission: BigDecimal = BigDecimal("2.00")
    var type: String = "TRANSFERENCIA"
    var status: String = "COMPLETADA"
}