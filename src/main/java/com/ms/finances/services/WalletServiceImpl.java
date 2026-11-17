package com.ms.finances.services;

import com.ms.finances.models.entities.Users;
import com.ms.finances.models.entities.Wallet;
import com.ms.finances.repositories.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Override
    @Transactional
    public Wallet saveUserWallet(Users user) {
        Wallet wallet = new Wallet();
        wallet.setBalance(BigDecimal.ZERO);
        wallet.setOwnerId(user.getId());
        wallet.setPixKey(user.getName().trim().toLowerCase() + "-chave-pix");
        return walletRepository.save(wallet);
    }
}
