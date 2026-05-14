package com.tecsup.project.hexagonal.infraestructure.config

import com.tecsup.project.hexagonal.application.ports.input.AccountService
import com.tecsup.project.hexagonal.application.ports.input.ClientService
import com.tecsup.project.hexagonal.application.ports.output.AccountRepositoryPort
import com.tecsup.project.hexagonal.application.ports.output.ClientRepositoryPort
import com.tecsup.project.hexagonal.application.usecases.AccountServiceImpl
import com.tecsup.project.hexagonal.application.usecases.ClientServiceImpl
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper.ClientMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HegaxonalConfig {

    @Bean
    fun clientService(clientRepositoryPort: ClientRepositoryPort): ClientService {
        return ClientServiceImpl(clientRepositoryPort)
    }

    @Bean
    fun accountService(accountRepositoryPort: AccountRepositoryPort, clientRepositoryPort: ClientRepositoryPort, clientMapper: ClientMapper): AccountService {
        return AccountServiceImpl(accountRepositoryPort, clientRepositoryPort, clientMapper)
    }
}