package com.tecsup.project.hexagonal.infraestructure.config

import com.tecsup.project.hexagonal.application.ports.input.ClientService
import com.tecsup.project.hexagonal.application.ports.output.ClientRepositoryPort
import com.tecsup.project.hexagonal.application.usecases.ClientServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HegaxonalConfig {

    @Bean
    fun clientService(clientRepositoryPort: ClientRepositoryPort): ClientService {
        return ClientServiceImpl(clientRepositoryPort)
    }
}