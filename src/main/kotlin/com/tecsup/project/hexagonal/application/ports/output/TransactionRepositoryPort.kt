package com.tecsup.project.hexagonal.application.ports.output

import com.tecsup.project.hexagonal.domain.model.Transaction

interface TransactionRepositoryPort {

    fun save(transaction: Transaction): Transaction
}