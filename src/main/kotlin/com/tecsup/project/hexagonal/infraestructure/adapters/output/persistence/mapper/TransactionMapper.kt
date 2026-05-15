package com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.mapper

import com.tecsup.project.hexagonal.domain.model.Transaction
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.request.TransferRequest
import com.tecsup.project.hexagonal.infraestructure.adapters.input.rest.response.TransferResponse
import com.tecsup.project.hexagonal.infraestructure.adapters.output.persistence.entity.TransactionEntity
import org.mapstruct.BeanMapping
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface TransactionMapper {

    fun toDomain(entity: TransactionEntity): Transaction

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    fun toEntity(transaction: Transaction): TransactionEntity

    fun toDomain(request: TransferRequest): Transaction

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "accountOriginName", source = "accountOrigin.clientEntity.name")
    @Mapping(target = "accountDestinationName", source = "accountDestination.clientEntity.name")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "commission", source = "commission")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "createdAt", source = "createdAt")
    fun toResponse(domain: Transaction): TransferResponse
}