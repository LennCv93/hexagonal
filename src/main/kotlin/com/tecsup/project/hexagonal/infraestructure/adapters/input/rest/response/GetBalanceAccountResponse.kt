package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response

import java.math.BigDecimal

data class GetBalanceAccountResponse(
    val balance: BigDecimal
)