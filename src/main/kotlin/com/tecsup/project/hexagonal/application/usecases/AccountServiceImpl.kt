package com.tecsup.project.hexagonal.application.usecases

import com.tecsup.project.hexagonal.application.ports.input.AccountService
import com.tecsup.project.hexagonal.application.ports.output.AccountRepositoryPort
import com.tecsup.project.hexagonal.application.ports.output.ClientRepositoryPort
import com.tecsup.project.hexagonal.domain.model.Account
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper.ClientMapper

class AccountServiceImpl(
    private val accountRepository: AccountRepositoryPort,
    private val clientRepositoryPort: ClientRepositoryPort,
    private val mapper: ClientMapper
) : AccountService {
    override fun save(account: Account): Account {
        if (account.clientId == null) throw IllegalArgumentException("Client Id cannot be null.")

        val client = clientRepositoryPort.findById(account.clientId)
        account.clientEntity = mapper.toFullEntity(client)

        return accountRepository.save(account)
    }
}