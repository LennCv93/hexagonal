package com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.repository

import com.tecsup.project.hexagonal.application.ports.output.ClientRepositoryPort
import com.tecsup.project.hexagonal.domain.model.Client
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper.ClientMapper
import org.springframework.stereotype.Repository

@Repository
class ClientRepositoryAdapter(
    private val clientJpaRepository: ClientJpaRepository,
    private val mapper: ClientMapper
): ClientRepositoryPort{
    override fun save(client: Client): Client {
        val entity = clientJpaRepository.save(mapper.toEntity(client))

        return mapper.toDomain(entity)
    }

    @Throws(Exception::class)
    override fun findById(id: Long): Client {
        val entityOptional = clientJpaRepository.findById(id)

        val entity = if (entityOptional.isPresent) {
            entityOptional.get()
        }else {
            throw Exception("Entity with ID [$id] not found")
        }

        return mapper.toDomain(entity)
    }
}