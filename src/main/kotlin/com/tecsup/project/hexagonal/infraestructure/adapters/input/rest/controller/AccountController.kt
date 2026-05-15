package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.controller

import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.request.CreateAccountRequest
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response.CreateAccountResponse
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper.AccountMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.tecsup.project.hexagonal.application.ports.input.AccountService
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response.GetBalanceAccountResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("/api/bank/accounts")
class AccountController (
    private val accountService: AccountService,
    private val mapper: AccountMapper
){

    @PostMapping
    fun createAccount(@RequestBody request: CreateAccountRequest): CreateAccountResponse {
        val accountDomain = mapper.toDomain(request)

        val savedAccountDomain = accountService.save(accountDomain)

        return mapper.toResponse(savedAccountDomain)
    }

    @GetMapping("/get-balance/{id}")
    fun getBalance(@PathVariable id: Long): GetBalanceAccountResponse {
        return accountService.getBalanceById(id)
    }
}