package com.tecsup.project.hexagonal.application.usecases

import com.tecsup.project.hexagonal.application.ports.input.TransactionService
import com.tecsup.project.hexagonal.application.ports.output.AccountRepositoryPort
import com.tecsup.project.hexagonal.application.ports.output.NotificationPort
import com.tecsup.project.hexagonal.application.ports.output.TransactionRepositoryPort
import com.tecsup.project.hexagonal.domain.model.Transaction
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper.AccountMapper

class TransactionServiceImpl(
    private val transactionRepositoryPort: TransactionRepositoryPort,
    private val accountRepositoryPort: AccountRepositoryPort,
    private val mapper: AccountMapper,
    private val notificationPort: NotificationPort
): TransactionService{

    override fun save(transaction: Transaction): Transaction {
        if (transaction.accountOriginId == null || transaction.accountDestinationId == null)
            throw IllegalArgumentException("Account Origin and Account Destination cannot be null")

        if(transaction.accountOriginId == transaction.accountDestinationId)
            throw IllegalArgumentException("The destination account must not be the same as the origin account.")

        val accountOrigin = accountRepositoryPort.findById(transaction.accountOriginId)

        if(accountOrigin.balance < transaction.amount)
            throw IllegalArgumentException("You do not have sufficient funds for this transaction.")

        val accountDestination = accountRepositoryPort.findById(transaction.accountDestinationId)

        transaction.accountOrigin = mapper.toFullEntity(accountOrigin)
        transaction.accountDestination = mapper.toFullEntity(accountDestination)

        val transactionSuccess = transactionRepositoryPort.save(transaction)

        val accountOriginToSave = mapper.toFullEntity(accountOrigin)
        val accountDestinationToSave = mapper.toFullEntity(accountDestination)

        accountOriginToSave.balance = accountOriginToSave.balance.minus(transaction.amount)
        val netAmount = transaction.amount.minus(transaction.commission)
        accountDestinationToSave.balance = accountDestinationToSave.balance.plus(netAmount)

        accountRepositoryPort.update(accountOriginToSave)
        accountRepositoryPort.update(accountDestinationToSave)

        notificationPort.notifyTransfer(
            clientEmail = accountOrigin.clientEntity.email,
            clientName = accountOrigin.clientEntity.name,
            amount = netAmount,
            commission = transaction.commission,
            transactionId = transactionSuccess.id ?: 0L
        )

        return transactionSuccess
    }
}