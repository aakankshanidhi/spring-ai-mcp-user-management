package com.springai.MCPServer.service;

import com.springai.MCPServer.dto.UserRequestDto;
import com.springai.MCPServer.dto.UserResponseDto;
import com.springai.MCPServer.entity.User;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto dto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserByName(String name);

    UserResponseDto getUserById(Long id);

    UserResponseDto updateUser(Long id, UserRequestDto dto);

    void deleteUser(Long id);

    UserResponseDto getUserByEmail(String email);

    List<UserResponseDto> getUsersByCity(String city);


}
