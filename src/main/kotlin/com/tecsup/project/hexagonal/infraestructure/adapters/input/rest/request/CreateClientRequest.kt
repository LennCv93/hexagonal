package com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CreateClientRequest(
    val name: String,
    val email: String,
    val document: String
)