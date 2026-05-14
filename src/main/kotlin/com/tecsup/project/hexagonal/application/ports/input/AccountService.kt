package com.tecsup.project.hexagonal.application.ports.input

import com.tecsup.project.hexagonal.domain.model.Account
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response.GetBalanceAccountResponse
import java.math.BigDecimal

interface AccountService {
    fun save(account: Account): Account

    fun getBalanceById(id: Long): GetBalanceAccountResponse
}