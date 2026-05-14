package com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.repository

import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountJpaRepository: JpaRepository<AccountEntity, Long>