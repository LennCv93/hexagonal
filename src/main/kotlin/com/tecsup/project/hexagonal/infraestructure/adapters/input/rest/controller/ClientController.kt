package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.controller

import com.tecsup.project.hexagonal.application.ports.input.ClientService
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.request.CreateClientRequest
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response.CreateClientResponse
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper.ClientMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/bank/clients")
class ClientController (
    private val clientService: ClientService,
    private val mapper: ClientMapper
){

    @PostMapping
    fun createClient(@RequestBody request: CreateClientRequest): CreateClientResponse {
        val requestDomain = mapper.toDomain(request)

        val responseDomain = clientService.save(requestDomain)

        return mapper.toResponse(responseDomain)
    }
}