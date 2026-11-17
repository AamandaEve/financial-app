package com.ms.finances.models.mappers;

import com.ms.finances.models.dtos.WalletResponseDTO;
import com.ms.finances.models.entities.Wallet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    WalletResponseDTO toResponse(Wallet wallet);

}
