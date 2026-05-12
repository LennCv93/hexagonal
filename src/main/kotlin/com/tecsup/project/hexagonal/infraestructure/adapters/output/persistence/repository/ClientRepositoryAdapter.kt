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
}