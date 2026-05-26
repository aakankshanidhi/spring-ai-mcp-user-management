package com.springai.MCPServer.service;

import com.springai.MCPServer.dto.UserRequestDto;
import com.springai.MCPServer.dto.UserResponseDto;
import com.springai.MCPServer.entity.User;
import com.springai.MCPServer.exception.ResourceNotFoundException;
import com.springai.MCPServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());
        user.setCity(dto.getCity());

        User savedUser = userRepository.save(user);

        return mapToDto(savedUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponseDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id " + id));

        return mapToDto(user);
    }

    @Override
    public UserResponseDto updateUser(Long id,
                                      UserRequestDto dto) {

        User existing = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id " + id));

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setAge(dto.getAge());
        existing.setCity(dto.getCity());

        User savedUser = userRepository.save(existing);

        return mapToDto(savedUser);
    }

    @Override
    public void deleteUser(Long id) {

        User existing = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id " + id));

        userRepository.delete(existing);
    }

    private UserResponseDto mapToDto(User user) {

        UserResponseDto dto = new UserResponseDto();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAge(user.getAge());
        dto.setCity(user.getCity());

        return dto;
    }
}
