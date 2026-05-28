package com.springai.MCPServer.service;

import com.springai.MCPServer.dto.UserRequestDto;
import com.springai.MCPServer.dto.UserResponseDto;
import com.springai.MCPServer.entity.User;
import com.springai.MCPServer.exception.ResourceNotFoundException;
import com.springai.MCPServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {

        User user = new User();

        user.setPassword(
                passwordEncoder.encode(
                        dto.getPassword()
                )
        );

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());
        user.setCity(dto.getCity());

        User savedUser = userRepository.save(user);

        return mapToDto(savedUser);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    @Cacheable(value = "usersByName", key = "#name")
    public UserResponseDto getUserByName(String name) {

        System.out.println("Fetching user by name from DB...");

        User user = userRepository.findByName(name)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"));

        return mapToDto(user);
    }

    @Override
    @Cacheable(value = "users", key = "#id")
    public UserResponseDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id " + id));

        return mapToDto(user);
    }

    @Override
    @CacheEvict(value = "users", key = "#id")
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
    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(Long id) {

        User existing = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id " + id));

        userRepository.delete(existing);
    }

    @Override
    @Cacheable(value = "users", key = "#email")
    public UserResponseDto getUserByEmail(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with email " + email));

        return mapToDto(user);
    }

    @Override
    @Cacheable(value = "usersByCity", key = "#city")
    public List<UserResponseDto> getUsersByCity(String city) {
        return userRepository.findByCity(city)
                .stream()
                .map(this::convertToDto)
                .toList();
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

    private UserResponseDto convertToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAge(user.getAge());
        dto.setCity(user.getCity());
        return dto;
    }
}
