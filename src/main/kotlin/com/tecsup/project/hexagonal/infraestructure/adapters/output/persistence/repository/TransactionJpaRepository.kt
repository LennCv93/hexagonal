package com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.repository

import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.entity.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionJpaRepository: JpaRepository<TransactionEntity, Long>