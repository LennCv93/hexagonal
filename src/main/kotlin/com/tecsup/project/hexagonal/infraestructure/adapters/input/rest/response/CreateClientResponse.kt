package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CreateClientResponse(
    val id: Long,
    val name: String,
    val email: String,
    val document: String,
    val createdAt: LocalDateTime
)