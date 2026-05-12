package com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "clients")
class ClientEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "name")
    var name: String = "",

    @Column(name = "email")
    var email: String = "",

    @Column(name = "document")
    var document: String = "",

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()
)