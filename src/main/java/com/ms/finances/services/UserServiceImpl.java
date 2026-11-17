package com.ms.finances.services;

import com.ms.finances.models.dtos.UserResponseDTO;
import com.ms.finances.models.dtos.UserSaveDTO;
import com.ms.finances.models.entities.Users;
import com.ms.finances.models.entities.Wallet;
import com.ms.finances.models.mappers.UserMapper;
import com.ms.finances.models.mappers.WalletMapper;
import com.ms.finances.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final WalletService walletService;
    private final WalletMapper walletMapper;

    @Override
    @Transactional
    public UserResponseDTO save(UserSaveDTO userSaveDTO) {
        Users user = userMapper.toEntity(userSaveDTO);

        userRepository.save(user);
        Wallet wallet = walletService.saveUserWallet(user);
        user.setWallet(wallet);

        userRepository.save(user);

        UserResponseDTO responseDTO = userMapper.toResponse(user);
        responseDTO.setWalletResponseDTO(walletMapper.toResponse(wallet));
        return responseDTO;
    }

    @Override
    @Transactional
    public UserResponseDTO edit(UUID userId, UserSaveDTO newUser) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Users user2 = userMapper.toEntity(newUser);
        user2.setId(user.getId());
        return userMapper.toResponse(userRepository.save(user2));
    }

    @Override
    public User findById(UUID userId) {
        return null;
    }

    @Override
    public Page findAll(Pageable pageable) {
        return null;
    }
}
