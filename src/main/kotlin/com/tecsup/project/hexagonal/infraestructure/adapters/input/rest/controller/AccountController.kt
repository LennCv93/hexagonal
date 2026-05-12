package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.controller

import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.request.CreateAccountRequest
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response.CreateAccountResponse
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper.AccountMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.tecsup.project.hexagonal.application.ports.input.AccountService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/bank/accounts")
class AccountController (
    private val accountService: AccountService,
    private val mapper: AccountMapper
){

    @PostMapping
    fun createAccount(@RequestBody request: CreateAccountRequest): CreateAccountResponse {
        // 1. Convertimos el pedido del formulario (Request) a objeto de Negocio (Domain)
        val accountDomain = mapper.toDomain(request)

        // 2. Llamamos al servicio para que haga la lógica de guardado
        val savedAccountDomain = accountService.save(accountDomain)

        // 3. Convertimos el resultado de negocio a lo que el usuario debe ver (Response)
        return mapper.toResponse(savedAccountDomain)
    }
}