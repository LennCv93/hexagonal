package com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.repository

import com.tecsup.project.hexagonal.application.ports.output.TransactionRepositoryPort
import com.tecsup.project.hexagonal.domain.model.Transaction
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper.TransactionMapper
import org.springframework.stereotype.Repository

@Repository
class TransactionRepositoryAdapter(
    private val transactionJpaRepository: TransactionJpaRepository,
    private val mapper: TransactionMapper
): TransactionRepositoryPort {

    override fun save(transaction: Transaction): Transaction {
        val entity = transactionJpaRepository.save(mapper.toEntity(transaction))

        return mapper.toDomain(entity)
    }
}