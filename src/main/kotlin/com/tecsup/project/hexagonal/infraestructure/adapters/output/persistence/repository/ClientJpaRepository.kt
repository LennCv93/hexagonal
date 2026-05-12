package com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.repository

import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.entity.ClientEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ClientJpaRepository: JpaRepository<ClientEntity, Long>