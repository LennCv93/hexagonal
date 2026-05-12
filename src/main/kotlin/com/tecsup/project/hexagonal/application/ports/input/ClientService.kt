package com.tecsup.project.hexagonal.application.ports.input

import com.tecsup.project.hexagonal.domain.model.Client

interface ClientService {
    fun save(client: Client):  Client
}