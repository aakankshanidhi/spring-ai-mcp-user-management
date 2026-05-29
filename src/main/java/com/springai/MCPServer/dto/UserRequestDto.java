package com.springai.MCPServer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 4,
            message = "Password must be at least 4 characters")
    private String password;

    @Min(value = 1, message = "Age must be positive")
    private Integer age;

    @NotBlank(message = "City is required")
    private String city;
}
