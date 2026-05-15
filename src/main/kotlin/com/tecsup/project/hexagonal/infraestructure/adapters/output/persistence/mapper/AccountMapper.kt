package com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper

import com.tecsup.project.hexagonal.domain.model.Account
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.request.CreateAccountRequest
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response.CreateAccountResponse
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.entity.AccountEntity
import org.mapstruct.BeanMapping
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface AccountMapper {

    // Entity -> Domain (Para cuando consultas la cuenta)
    fun toDomain(entity: AccountEntity): Account

    // Domain -> Entity (Para guardar en la BD)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    fun toEntity(domain: Account): AccountEntity

    fun toFullEntity(domain: Account): AccountEntity

    // Request -> Domain (Lo que viene del post del controller)
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "clientId", source = "clientId")
    @Mapping(target = "accountNumber", source = "accountNumber")
    @Mapping(target = "balance", source = "balance")
    fun toDomain(request: CreateAccountRequest): Account

    // Domain -> Response (Lo que le devuelves al cliente en el JSON)
    fun toResponse(domain: Account): CreateAccountResponse


}