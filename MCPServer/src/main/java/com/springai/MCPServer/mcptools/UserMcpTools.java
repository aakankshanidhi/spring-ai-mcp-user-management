package com.springai.MCPServer.mcptools;

import com.springai.MCPServer.dto.UserRequestDto;
import com.springai.MCPServer.dto.UserResponseDto;
import com.springai.MCPServer.entity.User;
import com.springai.MCPServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMcpTools {

    private final UserService userService;

    @Tool(description = "Get user by id from database")
    public UserResponseDto getUserById(Long id) {

        return userService.getUserById(id);
    }

    @Tool(description = "Add a new user to database")
    public UserResponseDto createUser(String name,
                                      String email,
                                      Integer age,
                                      String city) {

        UserRequestDto dto = new UserRequestDto();

        dto.setName(name);
        dto.setEmail(email);
        dto.setAge(age);
        dto.setCity(city);

        return userService.createUser(dto);
    }

    @Tool(description = "Update user")
    public UserResponseDto updateUser(Long id,
                                      String name,
                                      String email,
                                      Integer age,
                                      String city) {

        UserRequestDto dto = new UserRequestDto();

        dto.setName(name);
        dto.setEmail(email);
        dto.setAge(age);
        dto.setCity(city);

        return userService.updateUser(id, dto);
    }

    @Tool(description = "Delete user by id")
    public String deleteUser(Long id) {

        userService.deleteUser(id);

        return "User deleted successfully";
    }
}
