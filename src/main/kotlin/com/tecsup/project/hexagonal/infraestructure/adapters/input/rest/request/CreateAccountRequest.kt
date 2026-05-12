package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.request

import java.math.BigDecimal

class CreateAccountRequest {
    data class CreateAccountRequest(
        val clientId: Long,
        val initialBalance: BigDecimal,
        val accountNumber: String
    )
}