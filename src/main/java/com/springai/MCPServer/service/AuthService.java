package com.springai.MCPServer.service;

import com.springai.MCPServer.dto.AuthResponseDto;
import com.springai.MCPServer.dto.LoginRequestDto;
import com.springai.MCPServer.entity.User;
import com.springai.MCPServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public AuthResponseDto login(
            LoginRequestDto dto) {

        User user = userRepository
                .findByEmail(dto.getEmail())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Invalid email"));

        if(!passwordEncoder.matches(
                dto.getPassword(),
                user.getPassword())) {

            throw new RuntimeException(
                    "Invalid password");
        }

        String token =
                jwtService.generateToken(
                        user.getEmail());

        return new AuthResponseDto(token);
    }
}
