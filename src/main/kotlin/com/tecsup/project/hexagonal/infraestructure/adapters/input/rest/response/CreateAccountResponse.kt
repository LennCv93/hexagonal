package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response

import java.math.BigDecimal

class CreateAccountResponse {
    // Lo que responde al crearla
    data class CreateAccountResponse(
        val id: Long,
        val accountNumber: String,
        val balance: BigDecimal,
        val status: String
    )
}