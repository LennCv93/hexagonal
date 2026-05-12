package com.tecsup.project.hexagonal.application.usecases

import com.tecsup.project.hexagonal.application.ports.input.ClientService
import com.tecsup.project.hexagonal.application.ports.output.ClientRepositoryPort
import com.tecsup.project.hexagonal.domain.model.Client

class ClientServiceImpl(
    private val clientRepositoryPort: ClientRepositoryPort
): ClientService {
    override fun save(client: Client): Client =
        clientRepositoryPort.save(client)
}