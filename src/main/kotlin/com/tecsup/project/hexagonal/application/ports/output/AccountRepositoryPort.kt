package com.tecsup.project.hexagonal.application.ports.output

import com.tecsup.project.hexagonal.domain.model.Account
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.entity.AccountEntity

interface AccountRepositoryPort {
    fun save(account: Account): Account

    fun update(account: AccountEntity)

    fun findById(id: Long): Account
}