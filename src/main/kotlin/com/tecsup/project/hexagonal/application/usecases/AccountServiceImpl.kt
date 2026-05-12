package com.tecsup.project.hexagonal.application.usecases

import com.tecsup.project.hexagonal.application.ports.input.AccountService
import com.tecsup.project.hexagonal.application.ports.output.AccountRepositoryPort
import com.tecsup.project.hexagonal.domain.model.Account
import java.math.BigDecimal

/*class AccountServiceImpl(
    private val accountRepository: AccountRepositoryPort// Para persistencia
  //  private val notificationPort: NotificationPort         // Para el Punto 3 (Consola)
) : AccountService {

    override fun save(account: Account): Account {
        return accountRepository.save(account)
    }

    override fun getBalance(accountId: Long): BigDecimal {
        val account = accountRepository.findById(accountId)
            ?: throw RuntimeException("Cuenta no encontrada")
        return account.balance
    }
}*/