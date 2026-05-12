package com.tecsup.project.hexagonal.application.ports.output

import com.tecsup.project.hexagonal.domain.model.Account

interface AccountRepositoryPort {
    fun save(Account: Account): Account
    fun findById(id: Long): Account?
}