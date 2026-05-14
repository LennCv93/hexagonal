package com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper

import com.tecsup.project.hexagonal.domain.model.Client
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.request.CreateClientRequest
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response.CreateClientResponse
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response.GetBalanceAccountResponse
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.entity.ClientEntity
import org.mapstruct.BeanMapping
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import java.math.BigDecimal

@Mapper(componentModel = "spring")
interface ClientMapper {

    // Entity -> Domain
    fun toDomain(entity: ClientEntity): Client

    // Domain -> Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    fun toEntity(domain: Client): ClientEntity

    fun toFullEntity(domain: Client): ClientEntity

    // Request -> Domain
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "document", source = "document")
    fun toDomain(request: CreateClientRequest): Client

    // Domain -> Response
    fun toResponse(domain: Client): CreateClientResponse

    fun toGetBalanceAccountResponse(balance: BigDecimal): GetBalanceAccountResponse {
        return GetBalanceAccountResponse(balance)
    }
}