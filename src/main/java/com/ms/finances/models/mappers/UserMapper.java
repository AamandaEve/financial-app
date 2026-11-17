package com.ms.finances.models.mappers;

import com.ms.finances.models.dtos.UserResponseDTO;
import com.ms.finances.models.dtos.UserSaveDTO;
import com.ms.finances.models.entities.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Users toEntity(UserSaveDTO userSaveDTO);
    UserResponseDTO toResponse(Users user);
}
