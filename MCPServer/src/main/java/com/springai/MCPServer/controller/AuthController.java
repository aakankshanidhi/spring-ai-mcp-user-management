package com.springai.MCPServer.controller;

import com.springai.MCPServer.dto.AuthResponseDto;
import com.springai.MCPServer.dto.LoginRequestDto;
import com.springai.MCPServer.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponseDto login(
            @RequestBody LoginRequestDto dto) {

        return authService.login(dto);
    }
}
