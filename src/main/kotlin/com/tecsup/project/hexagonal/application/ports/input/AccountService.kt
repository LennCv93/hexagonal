package com.tecsup.project.hexagonal.application.ports.input

import com.tecsup.project.hexagonal.domain.model.Account
import java.math.BigDecimal

interface AccountService {
    fun save(account: Account): Account
}