package com.ms.finances.services;

import com.ms.finances.models.entities.Users;
import com.ms.finances.models.entities.Wallet;

import java.util.UUID;

public interface WalletService {
    Wallet saveUserWallet(Users user);
}
