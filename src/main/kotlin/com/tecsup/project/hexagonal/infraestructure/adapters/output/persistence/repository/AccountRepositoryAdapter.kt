package com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.repository

import com.tecsup.project.hexagonal.application.ports.output.AccountRepositoryPort
import com.tecsup.project.hexagonal.domain.model.Account
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.entity.AccountEntity
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper.AccountMapper
import org.springframework.stereotype.Repository
import kotlin.IllegalArgumentException

@Repository
class AccountRepositoryAdapter(
    private val accountJpaRepository: AccountJpaRepository,
    private val mapper: AccountMapper
): AccountRepositoryPort {
    override fun save(account: Account): Account {
        val entity = accountJpaRepository.save(mapper.toEntity(account))

        return mapper.toDomain(entity)
    }

    override fun update(account: AccountEntity) {
       accountJpaRepository.save(account)
    }

    override fun findById(id: Long): Account {
        val entityOptional = accountJpaRepository.findById(id)

        val entity = if(entityOptional.isPresent) {
            entityOptional.get()
        } else {
            throw IllegalArgumentException("Entity with ID [$id] not found")
        }

        return mapper.toDomain(entity)
    }
}