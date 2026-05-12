package com.tecsup.project.hexagonal.domain.model

import java.time.LocalDateTime

data class Client(
    val id: Long = 0,
    val name: String,
    val email: String,
    val document: String,
    val createdAt: LocalDateTime? = LocalDateTime.now()
)