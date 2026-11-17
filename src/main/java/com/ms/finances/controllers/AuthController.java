package com.ms.finances.controllers;

import com.ms.finances.configs.TokenService;
import com.ms.finances.models.dtos.LoginDTO;
import com.ms.finances.models.entities.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody LoginDTO loginDTO){
        var authenticationToken = new UsernamePasswordAuthenticationToken( loginDTO.getEmail(), loginDTO.getPassword());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((Users) authentication.getPrincipal());
        return ResponseEntity.ok("Login Realizado com sucesso " + tokenJWT);
    }

}
