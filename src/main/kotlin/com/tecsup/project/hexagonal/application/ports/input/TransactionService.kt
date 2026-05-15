package com.tecsup.project.hexagonal.application.ports.input

import com.tecsup.project.hexagonal.domain.model.Transaction

interface TransactionService {
    fun save(transaction: Transaction): Transaction
}