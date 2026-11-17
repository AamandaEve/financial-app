package com.ms.finances.controllers;

import com.ms.finances.models.dtos.UserResponseDTO;
import com.ms.finances.models.dtos.UserSaveDTO;
import com.ms.finances.models.entities.Users;
import com.ms.finances.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@RequestBody @Valid UserSaveDTO userSaveDTO){
        return ResponseEntity.ok(userService.save(userSaveDTO));
    }

    @PostMapping("/edit")
    public ResponseEntity<UserResponseDTO> edit(@RequestBody UserSaveDTO userSaveDTO, @AuthenticationPrincipal Users loggedUser){
        return ResponseEntity.ok(userService.edit(loggedUser.getId(), userSaveDTO));
    }

}
