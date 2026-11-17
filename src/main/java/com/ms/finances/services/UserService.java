package com.ms.finances.services;

import com.ms.finances.models.dtos.UserResponseDTO;
import com.ms.finances.models.dtos.UserSaveDTO;
import com.ms.finances.models.entities.Users;
import org.apache.catalina.User;
import org.hibernate.query.Page;

import java.awt.print.Pageable;
import java.util.UUID;

public interface UserService {
    UserResponseDTO save(UserSaveDTO userSaveDTO);
    UserResponseDTO edit(UUID userId, UserSaveDTO newUser);
    User findById(UUID userId);
    Page findAll(Pageable pageable);
}
