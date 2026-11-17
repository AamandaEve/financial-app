package com.ms.finances.models.dtos;

import com.ms.finances.models.entities.Wallet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private String name;
    private String email;
    private WalletResponseDTO walletResponseDTO;
}
