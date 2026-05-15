package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.controller

import com.tecsup.project.hexagonal.application.ports.input.TransactionService
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.request.TransferRequest
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response.TransferResponse
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper.TransactionMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import kotlin.text.compareTo

@RestController
@RequestMapping("/api/bank/transactions")
class TransactionController(
    private val transactionService: TransactionService,
    private val mapper: TransactionMapper
) {
    @PostMapping("/transfer")
    fun transfer(@RequestBody transferRequest: TransferRequest): TransferResponse {

        if (transferRequest.amount.compareTo(transferRequest.commission) <= 0) {
            throw IllegalArgumentException("The amount must be greater than the commission")
        }

        val transactionDomain = mapper.toDomain(transferRequest)

        val savedTransactionDomain =  transactionService.save(transactionDomain)

        return mapper.toResponse(savedTransactionDomain)
    }
}