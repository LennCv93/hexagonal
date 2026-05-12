package com.tecsup.project.hexagonal.application.ports.input

import com.tecsup.project.hexagonal.domain.model.Account
import java.math.BigDecimal

interface AccountService {
    fun save(account: Account): Account

    fun getBalance(accountId: Long): BigDecimal

    fun transfer(fromAccountId: Long, toAccountId: Long, amount: BigDecimal)
}