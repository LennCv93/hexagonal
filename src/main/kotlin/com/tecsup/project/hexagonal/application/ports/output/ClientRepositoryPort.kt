package com.tecsup.project.hexagonal.application.ports.output

import com.tecsup.project.hexagonal.domain.model.Client

interface ClientRepositoryPort {

    fun save(client: Client): Client

    fun findById(id: Long): Client
}